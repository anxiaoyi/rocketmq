package org.apache.rocketmq.example;

import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.namesrv.NamesrvStartup;

public class IdeaNameSrv {

    static {
        System.setProperty(MixAll.ROCKETMQ_HOME_PROPERTY, "./distribution");
    }

    public static void main(final String...args) {
        NamesrvStartup.main(args);
    }

}