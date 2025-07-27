package com.github.jasonx.common.support.invoke.impl;

import com.alibaba.fastjson2.JSON;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.log.integration.core.Log;
import com.github.houbb.log.integration.core.LogFactory;
import com.github.jasonx.common.rpc.RpcMessageDto;
import com.github.jasonx.common.support.invoke.IInvokeService;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InvokeService implements IInvokeService {

    private static final Log logger = LogFactory.getLog(InvokeService.class);

    private final ConcurrentHashMap<String, Long> requestMap;
    private final ConcurrentHashMap<String, RpcMessageDto> responseMap;

    public InvokeService() {
        requestMap = new ConcurrentHashMap<>();
        responseMap = new ConcurrentHashMap<>();

        final Runnable timeoutThread = new TimeoutCheckThread(requestMap, responseMap);
        Executors.newScheduledThreadPool(1)
                .scheduleAtFixedRate(timeoutThread, 60, 60, TimeUnit.SECONDS);
    }

    @Override
    public IInvokeService addRequest(String seqId, long timeoutMills) {
        logger.debug("[Invoke] start add request for seqId: {}, timeoutMills: {}", seqId, timeoutMills);

        final long expiry = System.currentTimeMillis() + timeoutMills;
        requestMap.putIfAbsent(seqId, expiry);

        return this;
    }

    @Override
    public IInvokeService addResponse(String seqId, RpcMessageDto rpcMessageDto) {
        // 1. check if it is valid
        Long expireTime = this.requestMap.get(seqId);
        // if null, probably it passed the expiry time, and this job has been removed, so just ignore
        if (ObjectUtil.isNull(expireTime)) {
            return this;
        }

        // 2. check if it passed the expiry time
        if (System.currentTimeMillis() > expireTime) {
            logger.debug("[Invoke] seqId: {} has already expired, return the expired results", seqId);
            rpcMessageDto = RpcMessageDto.timeout();
        }

        responseMap.putIfAbsent(seqId, rpcMessageDto);
        logger.debug("[Invoke] get response results, seqId: {}, rpcResponse: {}", seqId, JSON.toJSON(rpcMessageDto));
        logger.debug("[Invoke] seqId: {} has been added to responseMap, notify all the waiting jobs", seqId);

        requestMap.remove(seqId);
        logger.debug("[Invoke] seqId: {} remove from request map", seqId);

        synchronized (this) {
            this.notifyAll();
            logger.debug("[Invoke] seqId: {} notifyAll()", seqId);
        }

        return this;
    }

    @Override
    public RpcMessageDto getResponse(String seqId) {
        return null;
    }

    @Override
    public boolean remainsRequest() {
        return !this.requestMap.isEmpty();
    }
}
