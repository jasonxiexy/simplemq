package com.github.jasonx.common.constant;

/**
 * Message Status Constants used in the messaging lifecycle.
 */
public final class MessageStatusConst {

    private MessageStatusConst() {}

    /**
     * Waiting to be consumed.
     * Initial state after being published by the producer to the broker.
     */
    public static final String WAITING = "WAITING";

    /**
     * Delivery to consumer in progress.
     * Broker is attempting to push to consumer.
     */
    public static final String DELIVERY_IN_PROGRESS = "DELIVERY_IN_PROGRESS";

    /**
     * Successfully delivered to consumer.
     */
    public static final String DELIVERED_SUCCESS = "DELIVERED_SUCCESS";

    /**
     * Delivery to consumer failed.
     */
    public static final String DELIVERED_FAILED = "DELIVERED_FAILED";

    /**
     * Successfully consumed by consumer.
     */
    public static final String CONSUMED_SUCCESS = "CONSUMED_SUCCESS";

    /**
     * Failed to consume by consumer.
     */
    public static final String CONSUMED_FAILED = "CONSUMED_FAILED";

    /**
     * Deferred for later consumption.
     */
    public static final String CONSUME_LATER = "CONSUME_LATER";}
