package com.github.jasonx.consumer.handler;

import com.github.jasonx.common.support.invoke.IInvokeService;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.logging.Logger;

public class MqConsumerHandler extends SimpleChannelInboundHandler{

    private static final Logger logger = Logger.getLogger(MqConsumerHandler.class.getName());

    private IInvokeService invokeService;

    private IMqListenerService mqListenerService;


}
