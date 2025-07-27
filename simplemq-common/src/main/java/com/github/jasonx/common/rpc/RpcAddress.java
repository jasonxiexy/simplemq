package com.github.jasonx.common.rpc;

import com.github.houbb.load.balance.support.server.IServer;

public class RpcAddress implements IServer {

    private String address;

    private int port;

    private int weight;



    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String url() {
        return this.address + ":" + this.port;
    }

    @Override
    public String host() {
        return "";
    }

    @Override
    public Integer port() {
        return 0;
    }

    @Override
    public int weight() {
        return this.weight;
    }

}
