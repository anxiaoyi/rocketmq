package org.apache.rocketmq.example;

import org.apache.rocketmq.broker.BrokerStartup;
import org.apache.rocketmq.common.MixAll;

public class IdeaBroker {

    static {
        System.setProperty(MixAll.ROCKETMQ_HOME_PROPERTY, "./distribution");
    }

    public static void main(String...args) {
        BrokerStartup.main(new String[]{ "-n", "localhost:9876" });
        System.out.println("The Broker Server boot success.");
    }

}
