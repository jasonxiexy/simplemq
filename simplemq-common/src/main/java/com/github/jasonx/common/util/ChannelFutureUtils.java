package com.github.jasonx.common.util;

import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.log.integration.core.Log;
import com.github.houbb.log.integration.core.LogFactory;
import com.github.jasonx.common.resp.MqCommonRespCode;
import com.github.jasonx.common.resp.MqException;
import com.github.jasonx.common.rpc.RpcAddress;
import com.github.jasonx.common.rpc.RpcChannelFuture;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.ArrayList;
import java.util.List;

public class ChannelFutureUtils {

    private static final Log log = LogFactory.getLog(ChannelFutureUtils.class);

    /**
     * init the channel list
     * @param brokerAddress
     * @param channelHandler
     * @param check
     * @return
     */
    public static List<RpcChannelFuture> initChannelFutureList(final String brokerAddress, final ChannelHandler channelHandler, final boolean check) {
        List<RpcAddress> addressList = InnerAddressUtils.initRpcAddresses(brokerAddress);

        List<RpcChannelFuture> list = new ArrayList<>();
        for (RpcAddress rpcAddress : addressList) {
            try {
                final String address = rpcAddress.getAddress();
                final int port = rpcAddress.getPort();

                EventLoopGroup workerGroup = new NioEventLoopGroup();
                Bootstrap bootstrap = new Bootstrap();
                ChannelFuture channelFuture = bootstrap.group(workerGroup)
                        .channel(NioSocketChannel.class)
                        .option(ChannelOption.SO_KEEPALIVE, true)
                        .handler(new ChannelInitializer<Channel>() {
                            @Override
                            protected void initChannel(Channel channel) throws Exception {
                                channel.pipeline().addLast(new LoggingHandler(LogLevel.INFO))
                                        .addLast(channelHandler);
                            }
                        })
                        .connect(address, port)
                        .syncUninterruptibly(); // if an interruption was thrown in the thread executing the future related operation, it will just redo an interruption on the caller thread

                log.info("Successfully init the client server, listen on address: {}, port: {}", address, port);

                RpcChannelFuture rpcChannelFuture = new RpcChannelFuture();
                rpcChannelFuture.setChannelFuture(channelFuture);
                rpcChannelFuture.setAddress(address);
                rpcChannelFuture.setPort(port);
                rpcChannelFuture.setWeight(rpcAddress.getWeight());
                list.add(rpcChannelFuture);
            } catch (Exception e) {
                log.error("Fail to register the server to broker", e);
                if (check) {
                    throw new MqException(MqCommonRespCode.REGISTER_TO_BROKER_FAILED);
                }
            }
        }

        if (check && CollectionUtil.isEmpty(list)) {
            log.error("Check=true and the list is empty, fail to init server");
            throw new MqException(MqCommonRespCode.REGISTER_TO_BROKER_FAILED);
        }
        return list;
    }
}
