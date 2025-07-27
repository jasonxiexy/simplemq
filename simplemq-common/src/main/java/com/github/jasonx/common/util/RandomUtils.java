package com.github.jasonx.common.util;

import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.load.balance.api.ILoadBalance;
import com.github.houbb.load.balance.api.impl.LoadBalanceContext;
import com.github.houbb.load.balance.support.server.IServer;

import java.util.List;
import java.util.Objects;

public class RandomUtils {

    public static <T extends IServer> T loadBalance(final ILoadBalance<T> loadBalance, final List<T> list, String key) {
        if (CollectionUtil.isEmpty(list)) {
            return null;
        }

        if (StringUtil.isEmpty(key)) {
            LoadBalanceContext<T> loadBalanceContext = LoadBalanceContext.<T>newInstance().servers(list);
            return loadBalance.select(loadBalanceContext);
        }

        // get hash code
        int hasCode = Objects.hash(key);
        int index = hasCode % list.size();
        return list.get(index);
    }
}
