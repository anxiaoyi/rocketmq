package org.apache.rocketmq.client.consumer;

import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueConsistentHash;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.Arrays;
import java.util.List;

public class AllocateMessageQueueStrategyAssert {

    private String consumerGroup = "consumerGroup";
    private String currentCID = "A";
    private List<MessageQueue> mqAll = Arrays.asList(
            new MessageQueue("topic", "broker-1", 1),
            new MessageQueue("topic", "broker-1", 2),
            new MessageQueue("topic", "broker-1", 3),
            new MessageQueue("topic", "broker-1", 4),
            new MessageQueue("topic", "broker-2", 1),
            new MessageQueue("topic", "broker-2", 2),
            new MessageQueue("topic", "broker-2", 3),
            new MessageQueue("topic", "broker-2", 4)
    );
    private List<String> cidAll = Arrays.asList(
            "A",
            "B",
            "C"
    );

    private final AllocateMessageQueueStrategy strategy;

    public AllocateMessageQueueStrategyAssert() {
        this(new AllocateMessageQueueAveragely());
    }

    public AllocateMessageQueueStrategyAssert(AllocateMessageQueueStrategy strategy) {
        this.strategy = strategy;
    }

    public void run() {
        List<MessageQueue> messageQueues = strategy.allocate(consumerGroup, currentCID, mqAll, cidAll);
        System.out.println("本客户端需要处理的消息队列:" + messageQueues);
    }

    public static void main(String...args) {
        new AllocateMessageQueueStrategyAssert(new AllocateMessageQueueConsistentHash(3)).run();
    }

}
