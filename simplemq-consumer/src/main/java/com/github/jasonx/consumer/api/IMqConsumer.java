package com.github.jasonx.consumer.api;

/**
 *
 */
public interface IMqConsumer {

    /**
     *
     * @param topicName
     * @param tagRegex
     */
    void subscribe(String topicName, String tagRegex);

    /**
     *
     * @param topicName
     * @param tagRegex
     */
    void unSubscribe(String topicName, String tagRegex);

    /**
     *
     * @param listener
     */
    void registerListener(final IMqConsumerListener listener);
}
