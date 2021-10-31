## 现在控制台jar包
https://github.com/alibaba/Sentinel/tree/master/sentinel-dashboard

## 控制台启动脚本
java -Dserver.port=8088 -Dcsp.sentinel.dashboard.server=localhost:8088 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar

## 如何查看效果
- 启动控制台程序sentinel-dashboard.jar
- 启动本程序
- 配置限流或熔断规则
- 最终实践效果见 doc