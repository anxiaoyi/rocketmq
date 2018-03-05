## 打包

``` bash
mvn -Prelease-all -DskipTests clean install -U
```

## 打包之后运行

``` bash
cd distribution/target/apache-rocketmq
sh bin/mqnamesrv
sh bin/mqbroker -n localhost:9876

# 发送消息
export NAMESRV_ADDR=localhost:9876
sh bin/tools.sh org.apache.rocketmq.example.quickstart.Producer

# 接受消息
sh bin/tools.sh org.apache.rocketmq.example.quickstart.Consumer
```

## 打包之后关闭

``` bash
sh bin/mqshutdown broker
sh bin/mqshutdown namesrv
```

## 对源码做过的主要调整

- 删除 `runserver.sh`、`runbroker.sh`、`tools.sh` 脚本默认需要的内存大小
- 删除 `pom.xml` 中的 `checkstyle` 的插件
- 在 `example` 子模块下面添加适合在 `idea` 开发环境中直接运行的类 `IdeaRocketMQMain`
- 调整 `BrokerController.java` 中默认每隔 30 秒注册 Broker 到 NameServer 的时间为 1 小时，主要是为了减少 DEBUG 影响
- 调整 `Producer.java` 的默认发送测试消息条数 (原来为 1000 条)
- RocketMQ 的默认 log 信息位于 `~/logs/rocketmqlogs`
- 添加 `AllocateMessageQueueStrategyAssert` 类来查看消息队列分配策略是如何工作的

---

## Apache RocketMQ [![Build Status](https://travis-ci.org/apache/rocketmq.svg?branch=master)](https://travis-ci.org/apache/rocketmq) [![Coverage Status](https://coveralls.io/repos/github/apache/rocketmq/badge.svg?branch=master)](https://coveralls.io/github/apache/rocketmq?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.apache.rocketmq/rocketmq-all/badge.svg)](http://search.maven.org/#search%7Cga%7C1%7Corg.apache.rocketmq)
[![GitHub release](https://img.shields.io/badge/release-download-orange.svg)](https://rocketmq.apache.org/dowloading/releases)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

**[Apache RocketMQ](https://rocketmq.apache.org) is a distributed messaging and streaming platform with low latency, high performance and reliability, trillion-level capacity and flexible scalability.**

It offers a variety of features:

* Pub/Sub messaging model
* Scheduled message delivery
* Message retroactivity by time or offset
* Log hub for streaming
* Big data integration
* Reliable FIFO and strict ordered messaging in the same queue
* Efficient pull&push consumption model
* Million-level message accumulation capacity in a single queue
* Multiple messaging protocols like JMS and OpenMessaging
* Flexible distributed scale-out deployment architecture
* Lightning-fast batch message exchange system
* Various message filter mechanics such as SQL and Tag
* Docker images for isolated testing and cloud isolated clusters
* Feature-rich administrative dashboard for configuration, metrics and monitoring


----------

## Learn it & Contact us
* Mailing Lists: <https://rocketmq.apache.org/about/contact/>
* Home: <https://rocketmq.apache.org>
* Docs: <https://rocketmq.apache.org/docs/quick-start/>
* Issues: <https://issues.apache.org/jira/browse/RocketMQ>
* Ask: <https://stackoverflow.com/questions/tagged/rocketmq>
 

----------

## Apache RocketMQ Community
* [RocketMQ Community Projects](https://github.com/apache/rocketmq-externals)

----------

## Contributing
We always welcome new contributions, whether for trivial cleanups, big new features or other material rewards, more details see [here](http://rocketmq.apache.org/docs/how-to-contribute/) 
 
----------
## License
[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html) Copyright (C) Apache Software Foundation
