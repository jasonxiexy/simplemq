package com.github.jasonx.consumer.api;

import com.github.jasonx.common.resp.ConsumerStatus;

public interface IMqConsumerListener {

    ConsumerStatus consumer(final MqMessage mqMessage, final IMqConsumerListenerContext context);
}
