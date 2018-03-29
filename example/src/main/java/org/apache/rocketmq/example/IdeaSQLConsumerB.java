package org.apache.rocketmq.example;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.exception.MQClientException;

public class IdeaSQLConsumerB extends IdeaSQLConsumer {

    public IdeaSQLConsumerB() throws MQClientException {
        super();
    }

    @Override
    protected String getConsumerGroup() {
        return "consumer_group_zk";
    }

    @Override
    protected void init(DefaultMQPushConsumer consumer) throws MQClientException {
        consumer.setUnitName("B");
        super.init(consumer);
    }

    @Override
    protected void subscribe(DefaultMQPushConsumer consumer) throws MQClientException {
        consumer.subscribe("TopicTest", MessageSelector.bySql("(TAGS is not null and TAGS in ('TagA', 'TagB'))" +
                "and (a is not null and a between 4 AND 7)"));
    }

    public static void main(String...args) throws InterruptedException, MQClientException {
        new IdeaSQLConsumerB().start();
    }

}
