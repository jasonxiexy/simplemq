package com.github.jasonx.common.support.invoke;

import com.github.jasonx.common.rpc.RpcMessageDto;

public interface IInvokeService {

    IInvokeService addRequest(final String seqId, final long timeoutMills);

    IInvokeService addResponse(final String seqId, final RpcMessageDto rpcMessageDto);

    RpcMessageDto getResponse(final String seqId);

    boolean remainsRequest();
}
