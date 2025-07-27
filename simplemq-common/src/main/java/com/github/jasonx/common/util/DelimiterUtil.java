package com.github.jasonx.common.util;

import com.alibaba.fastjson2.JSON;
import com.github.jasonx.common.rpc.RpcMessageDto;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DelimiterUtil {

    private DelimiterUtil() {}

    public static final String DELIMITER = "~!@#$%^&*";

    /**
     * avoid buffer area is full
     */
    public static final int LENGTH = 65535;

    public static final ByteBuf DELIMITER_BUF = Unpooled.copiedBuffer(DELIMITER.getBytes());

    /**
     * get corresponding text byte buf
     * @param text
     * @return
     */
    public static ByteBuf getByteBuf(String text) {
        return Unpooled.copiedBuffer(text.getBytes());
    }

    public static ByteBuf getMessageDelimiterBuffer(RpcMessageDto rpcMessageDto) {
        String json = JSON.toJSONString(rpcMessageDto);
        String jsonDelimiter = json + DELIMITER;
        return Unpooled.copiedBuffer(jsonDelimiter.getBytes());
    }


}
