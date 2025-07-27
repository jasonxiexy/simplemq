package com.github.jasonx.common.resp;

import com.github.jasonx.common.constant.MessageStatusConst;

public enum ConsumerStatus {
    SUCCESS(MessageStatusConst.CONSUMED_SUCCESS, "Successfully Consumed"),
    FAILED(MessageStatusConst.CONSUMED_FAILED, "Consumed Failed"),
    CONSUMER_LATER(MessageStatusConst.CONSUME_LATER, "Consume Later"),
    ;

    private final String code;
    private final String desc;

    ConsumerStatus(String code, String description) {
        this.code = code;
        this.desc = description;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
