package org.apache.rocketmq.filtersrv;

import org.apache.rocketmq.common.MixAll;

public class IdeaFilterSrv {

    static {
        System.setProperty(MixAll.ROCKETMQ_HOME_PROPERTY, "./distribution");
    }

    public static void main(String...args) {
        FiltersrvStartup.main(new String[]{ "-n", "localhost:9876" });
    }

}
