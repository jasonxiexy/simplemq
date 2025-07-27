package com.github.jasonx.common.support.invoke.impl;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.jasonx.common.rpc.RpcMessageDto;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TimeoutCheckThread implements Runnable {

    private final ConcurrentHashMap<String, Long> requestMap;
    private final ConcurrentHashMap<String, RpcMessageDto> responseMap;

    public TimeoutCheckThread(ConcurrentHashMap<String, Long> requestMap, ConcurrentHashMap<String, RpcMessageDto> responseMap) {
        ArgUtil.notNull(requestMap, "requestMap");

        this.requestMap = requestMap;
        this.responseMap = responseMap;
    }

    @Override
    public void run() {
        for (Map.Entry<String, Long> entry : requestMap.entrySet()) {
            long expireTime = entry.getValue();
            long currentTime = System.currentTimeMillis();

            // if passed the expire time, which means invalid
            if (expireTime < currentTime) {
                final String key = entry.getKey();
                responseMap.putIfAbsent(key, RpcMessageDto.timeout());
                // set the result as timeout, and remove it from requestMap;
                requestMap.remove(key);
            }
        }
    }
}
