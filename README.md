## 现在控制台jar包
https://github.com/alibaba/Sentinel/tree/master/sentinel-dashboard

## 控制台启动脚本
java -Dserver.port=8088 -Dcsp.sentinel.dashboard.server=localhost:8088 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar

## 如何查看效果
- 启动控制台程序sentinel-dashboard.jar
- 启动本程序
- 配置限流或熔断规则
- 最终实践效果见 doc



## 应用程序参数配置说明
- 显示在控制台的应用名称
spring.application.name=sentinelDemo
spring.cloud.sentinel.eager=true
- 控制台启动地址
spring.cloud.sentinel.transport.dashboard=127.0.0.1:8088


## 如何将控制台配置规则持久化
Sentinel Dashboard统一管理配置（有良好的UI界面，为什么不能统一管理呢，明显比Nacos编写json要专业），然后将规则统一推送到Nacos并持久化（生成配置文件），最后客户端监听Nacos（这一部了解使用过Nacos的话应该很熟，采用ConfigService.getConfg()方法获取配置文件），下发配置生成Rule

具体可参考：apollo:https://kelovp.tech/nostring/blog/javaee/1508/   
nacos: https://www.cnblogs.com/jian0110/p/14139044.html


## 原理分析
- 官方原理概述
https://github.com/alibaba/Sentinel/wiki/Sentinel%E5%B7%A5%E4%BD%9C%E4%B8%BB%E6%B5%81%E7%A8%8B
- 核心类解析
https://github.com/alibaba/Sentinel/wiki/Sentinel-%E6%A0%B8%E5%BF%83%E7%B1%BB%E8%A7%A3%E6%9E%90
https://zhuanlan.zhihu.com/p/64786381
