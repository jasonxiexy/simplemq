package com.github.jasonx.common.util;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

public class ChannelUtil {

    private ChannelUtil() {}

    public static String getChannelId(Channel channel) {
        return channel.id().asLongText();
    }

    public static String getChannelId(ChannelHandlerContext ctx) {
        return getChannelId(ctx.channel());
    }
}
