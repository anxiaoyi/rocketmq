package org.apache.rocketmq.example;

import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.tools.command.MQAdminStartup;

public class IdeaMQAdmin {

    static {
        System.setProperty(MixAll.ROCKETMQ_HOME_PROPERTY, "./distribution");
    }

    public static void main(String...args) {
//        MQAdminStartup.main(new String[] {
//                "queryMsgByKey",
//                "-n",
//                "localhost:9876",
//                "-t",
//                "TopicTest",
//                "-k",
//                "OrderID009"
//        });

//        MQAdminStartup.main(new String[] {
//                "queryMsgById",
//                "-n",
//                "localhost:9876",
//                "-i",
//                "0A6C73D900002A9F0000000000004010"
//        });
//
        MQAdminStartup.main(new String[] {
                "queryMsgByUniqueKey",
                "-n",
                "localhost:9876",
                "-i",
                "0A6C73D9696D18B4AAC20D82316E0000",
                "-t",
                "TopicTest"
        });

//        MQAdminStartup.main(new String[] {
//                "queryMsgByOffset",
//                "-n",
//                "localhost:9876",
//                "-t",
//                "TopicTest",
//                "-b",
//                "zk-pc",
//                "-i",
//                "3",
//                "-o",
//                "24"
//        });
    }

}
