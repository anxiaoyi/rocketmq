package org.apache.rocketmq.example;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.example.quickstart.Consumer;

public class IdeaSQLConsumer extends Consumer {

    static {
        LinuxEnv.setEnv("NAMESRV_ADDR", "localhost:9876");
    }

    public IdeaSQLConsumer() throws MQClientException {
        super();
    }

    @Override
    protected void subscribe(DefaultMQPushConsumer consumer) throws MQClientException {
        consumer.subscribe("TopicTest", MessageSelector.bySql("(TAGS is not null and TAGS in ('TagA', 'TagB'))" +
                "and (a is not null and a between 0 AND 3)"));
    }

    public static void main(String...args) throws InterruptedException, MQClientException {
        new IdeaSQLConsumer().start();
    }

}
