package org.apache.rocketmq.example;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.example.quickstart.Consumer;

import java.io.File;
import java.io.IOException;

public class IdeaCustomFilterConsumer extends Consumer {

    static {
        LinuxEnv.setEnv("NAMESRV_ADDR", "localhost:9876");
    }

    public IdeaCustomFilterConsumer() throws MQClientException {
        super();
    }

    @Override
    protected void subscribe(DefaultMQPushConsumer consumer) throws MQClientException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File classFile = new File(classLoader.getResource("MessageFilterImpl.java").getFile());

        String filterCode = null;
        try {
            filterCode = MixAll.file2String(classFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        consumer.subscribe("TopicTest", "org.apache.rocketmq.example.filter.MessageFilterImpl",
                filterCode);
    }

    public static void main(String...args) throws InterruptedException, MQClientException {
        new IdeaCustomFilterConsumer().start();
    }

}
