package org.apache.rocketmq.example;

import org.apache.rocketmq.example.transaction.TransactionProducer;

public class IdeaTransactionProducer {

    static {
        LinuxEnv.setEnv("NAMESRV_ADDR", "localhost:9876");
    }

    public static void main(String...args) throws Exception {
        TransactionProducer.main(args);
    }

}
