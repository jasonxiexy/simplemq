package com.github.jasonx.common.util;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.jasonx.common.rpc.RpcAddress;

import java.util.ArrayList;
import java.util.List;

public class InnerAddressUtils {

    private InnerAddressUtils() {}

    public static List<RpcAddress> initRpcAddresses(String address) {
        ArgUtil.notEmpty(address, "address");

        List<RpcAddress> addresses = new ArrayList<>();
        String[] strings = address.split(",");
        for (String string : strings) {
            String[] infos = string.split(":");

            RpcAddress rpcAddress = new RpcAddress();
            rpcAddress.setAddress(infos[0]);
            rpcAddress.setPort(Integer.parseInt(infos[1]));
            if (infos.length > 2) {
                rpcAddress.setWeight(Integer.parseInt(infos[2]));
            } else {
                rpcAddress.setWeight(1);
            }
            addresses.add(rpcAddress);
        }
        return addresses;
    }
}
