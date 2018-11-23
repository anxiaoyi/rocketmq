package org.apache.rocketmq.example;

import org.apache.rocketmq.broker.BrokerStartup;
import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.store.config.BrokerRole;

import java.io.File;

/**
 * @author zk
 *
 * {@link IdeaBroker} 的 Slave
 */
public class IdeaBrokerSlave {

    static {
        System.setProperty(MixAll.ROCKETMQ_HOME_PROPERTY, "./distribution");
    }

    public static void main(String...args) {
        BrokerStartup.setBrokerRole(BrokerRole.SLAVE);
        BrokerStartup.setNettyListenPort(10920);
        BrokerStartup.setBrokerId(1);
        BrokerStartup.setStorePathRootDir(System.getProperty("user.home") + File.separator + "slave-store");
        BrokerStartup.setHaMasterAddress("10.108.114.17:10912");
        BrokerStartup.setStartHAAccept(false);

        BrokerStartup.main(new String[]{ "-n", "localhost:9876" });
        System.out.println("The Slave Broker Server boot success.");
    }

}
