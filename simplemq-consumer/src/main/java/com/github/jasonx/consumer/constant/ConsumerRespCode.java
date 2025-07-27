package com.github.jasonx.consumer.constant;

public enum ConsumerRespCode {

    RPC_INIT_FAILED("C00001", "Consumer startup failed"),
    SUBSCRIBE_FAILED("C00002", "Consumer subscription failed"),
    UN_SUBSCRIBE_FAILED("C00003", "Consumer unsubscription failed"),
    CONSUMER_STATUS_ACK_FAILED("C00004", "Consumer status acknowledgment failed"),
    CONSUMER_STATUS_ACK_BATCH_FAILED("C00005", "Batch consumer status acknowledgment failed");

    private final String code;
    private final String msg;

    ConsumerRespCode(String code, String msg) {
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
