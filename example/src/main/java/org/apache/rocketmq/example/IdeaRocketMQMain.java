package org.apache.rocketmq.example;

import org.apache.rocketmq.broker.BrokerStartup;
import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.namesrv.NamesrvStartup;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class IdeaRocketMQMain {

    static {
        System.setProperty(MixAll.ROCKETMQ_HOME_PROPERTY, "./distribution");
    }

    // Avoid Block Main Thread
    final static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

    public static void main(final String...args) {

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        // StartUp Namesrv
        executor.execute(new Runnable() {
            @Override
            public void run() {
                NamesrvStartup.main(args);

                countDownLatch.countDown();
            }
        });

        // StartUp Broker
        executor.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("The Broker Server boot success.");
                BrokerStartup.main(new String[]{
                        "-n", "localhost:9876"
                });
            }
        });

    }

}
