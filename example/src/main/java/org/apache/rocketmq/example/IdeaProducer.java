package org.apache.rocketmq.example;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.example.quickstart.Producer;

public class IdeaProducer {

    static {
        LinuxEnv.setEnv("NAMESRV_ADDR", "localhost:9876");
    }

    public static void main(String[] args) throws MQClientException, InterruptedException {
        Producer.main(args);
    }

//    SendResult [sendStatus=SEND_OK, msgId=0A6C73D9696D18B4AAC20D82316E0000,
//    SendResult [sendStatus=SEND_OK, msgId=0A6C73D9696D18B4AAC20D8232090001,
//    SendResult [sendStatus=SEND_OK, msgId=0A6C73D9696D18B4AAC20D8232710002,
//    SendResult [sendStatus=SEND_OK, msgId=0A6C73D9696D18B4AAC20D8232D80003,
//    SendResult [sendStatus=SEND_OK, msgId=0A6C73D9696D18B4AAC20D8233400004,
//    SendResult [sendStatus=SEND_OK, msgId=0A6C73D9696D18B4AAC20D8233A70005,
//    SendResult [sendStatus=SEND_OK, msgId=0A6C73D9696D18B4AAC20D82340F0006,
//    SendResult [sendStatus=SEND_OK, msgId=0A6C73D9696D18B4AAC20D8234760007,
//    SendResult [sendStatus=SEND_OK, msgId=0A6C73D9696D18B4AAC20D8234DC0008,
//    SendResult [sendStatus=SEND_OK, msgId=0A6C73D9696D18B4AAC20D8235430009,

}
