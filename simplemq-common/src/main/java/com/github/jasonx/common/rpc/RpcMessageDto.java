package com.github.jasonx.common.rpc;

import com.github.jasonx.common.resp.MqCommonRespCode;

import java.io.Serializable;

public class RpcMessageDto implements Serializable {

    private long requestTime;

    private String traceId;

    private String methodType;

    private boolean isRequest;

    private String respCode;

    private String respMsg;

    private String json;

    public long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public boolean isRequest() {
        return isRequest;
    }

    public void setRequest(boolean request) {
        isRequest = request;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        respMsg = respMsg;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public static RpcMessageDto timeout() {
        RpcMessageDto dto = new RpcMessageDto();
        dto.setRespCode(MqCommonRespCode.TIMEOUT.getCode());
        dto.setRespMsg(MqCommonRespCode.TIMEOUT.getMsg());

        return dto;
    }

    public String toString() {
        return "RpcMessageDto{" +
                "requestTime=" + requestTime +
                ", traceId='" + traceId + '\'' +
                ", methodType='" + methodType + '\'' +
                ", isRequest=" + isRequest +
                ", respCode='" + respCode + '\'' +
                ", respMsg='" + respMsg + '\'' +
                ", json='" + json + '\'' +
                '}';
    }
}
