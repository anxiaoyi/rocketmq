package org.apache.rocketmq.example;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.example.quickstart.Consumer;

public class IdeaConsumer {

    static {
        LinuxEnv.setEnv("NAMESRV_ADDR", "localhost:9876");
    }

    public static void main(String[] args) throws MQClientException, InterruptedException {
        Consumer.main(args);
    }

}
