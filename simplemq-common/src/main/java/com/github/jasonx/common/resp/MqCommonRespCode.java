package com.github.jasonx.common.resp;

import com.github.houbb.heaven.response.respcode.RespCode;

public enum MqCommonRespCode implements RespCode {

    SUCCESS("0000", "Success"),
    FAIL("9999", "Failure"),
    TIMEOUT("8888", "Timeout"),

    RPC_GET_RESPONSE_FAILED("10001", "Failed to get RPC response"),
    REGISTER_TO_BROKER_FAILED("10002", "Failed to register with Broker"),

    PRODUCER_REGISTER_FAILED("P00001", "Producer registration to Broker failed"),
    PRODUCER_INIT_FAILED("P00002", "Producer initialization failed"),

    CONSUMER_REGISTER_FAILED("C00001", "Consumer registration to Broker failed"),
    CONSUMER_INIT_FAILED("C00002", "Consumer initialization failed");

    private final String code;
    private final String msg;

    MqCommonRespCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
