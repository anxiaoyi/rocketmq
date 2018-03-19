package org.apache.rocketmq.example;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.example.quickstart.Consumer;

public class IdeaConsumerB {

    static {
        LinuxEnv.setEnv("NAMESRV_ADDR", "localhost:9876");
    }

    static class ConsumerB extends Consumer {

        public ConsumerB() throws MQClientException {
            super();
        }

        @Override
        protected void init(DefaultMQPushConsumer consumer) throws MQClientException {
            super.init(consumer);

            consumer.setUnitName("consumerB");
        }

    }

    public static void main(String[] args) throws MQClientException, InterruptedException {
        new ConsumerB().start();
    }

}
