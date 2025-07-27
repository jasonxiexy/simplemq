package com.github.jasonx.common.constant;

/**
 * Represents method types used in communication between producer, consumer, and broker.
 * Each constant indicates an operation invoked via RPC or internal handling.
 *
 */
public class MethodType {

    // ---------- Producer Methods ----------

    /** Producer sends a message (standard send) */
    public static final String PRODUCER_SEND_MESSAGE = "PRODUCER_SEND_MESSAGE";

    /** Producer sends a message (one-way, no response expected) */
    public static final String PRODUCER_SEND_ONE_WAY = "PRODUCER_SEND_ONE_WAY";

    /** Producer registers with the broker */
    public static final String PRODUCER_REGISTER = "PRODUCER_REGISTER";

    /** Producer unregisters from the broker */
    public static final String PRODUCER_UNREGISTER = "PRODUCER_UNREGISTER";

    /** Producer sends messages in batch */
    public static final String PRODUCER_SEND_BATCH = "PRODUCER_SEND_BATCH";

    /** Producer sends messages in batch (one-way) */
    public static final String PRODUCER_SEND_ONE_WAY_BATCH = "PRODUCER_SEND_ONE_WAY_BATCH";

    // ---------- Consumer Methods ----------

    /** Consumer registers with the broker */
    public static final String CONSUMER_REGISTER = "CONSUMER_REGISTER";

    /** Consumer unregisters from the broker */
    public static final String CONSUMER_UNREGISTER = "CONSUMER_UNREGISTER";

    /** Consumer subscribes to a topic */
    public static final String CONSUMER_SUBSCRIBE = "CONSUMER_SUBSCRIBE";

    /** Consumer unsubscribes from a topic */
    public static final String CONSUMER_UNSUBSCRIBE = "CONSUMER_UNSUBSCRIBE";

    /** Consumer pulls messages manually (pull mode) */
    public static final String CONSUMER_PULL_MESSAGE = "CONSUMER_PULL_MESSAGE";

    /** Consumer sends heartbeat to broker */
    public static final String CONSUMER_HEARTBEAT = "CONSUMER_HEARTBEAT";

    /** Consumer reports message consumption status */
    public static final String CONSUMER_STATUS_REPORT = "CONSUMER_STATUS_REPORT";

    /** Consumer reports batch message consumption status */
    public static final String CONSUMER_STATUS_REPORT_BATCH = "CONSUMER_STATUS_REPORT_BATCH";

    // ---------- Broker Methods ----------

    /** Broker pushes message to the consumer */
    public static final String BROKER_PUSH_MESSAGE = "BROKER_PUSH_MESSAGE";
}
