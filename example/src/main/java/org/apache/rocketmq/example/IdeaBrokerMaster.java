package org.apache.rocketmq.example;

import org.apache.rocketmq.broker.BrokerStartup;
import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.store.config.BrokerRole;

/**
 * @author zk
 */
public class IdeaBrokerMaster {

    static {
        System.setProperty(MixAll.ROCKETMQ_HOME_PROPERTY, "./distribution");
    }

    public static void main(String...args) {
        BrokerStartup.setBrokerRole(BrokerRole.SYNC_MASTER);

        BrokerStartup.main(new String[]{ "-n", "localhost:9876" });
        System.out.println("The Broker Server boot success.");
    }

}
