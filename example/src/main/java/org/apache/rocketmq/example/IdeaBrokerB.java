package org.apache.rocketmq.example;

import org.apache.rocketmq.broker.BrokerStartup;
import org.apache.rocketmq.common.MixAll;

public class IdeaBrokerB {

    static {
        System.setProperty(MixAll.ROCKETMQ_HOME_PROPERTY, "./distribution");
        System.setProperty("user.home", System.getProperty("user.home") + "/brokerB");
    }

    public static void main(String...args) {
        BrokerStartup.setNettyListenPort(10920);
        BrokerStartup.setBrokerName("zk-pc-B");

        BrokerStartup.main(new String[]{ "-n", "localhost:9876" });
        System.out.println("The Broker Server boot success.");
    }

}
