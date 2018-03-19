# netease-store
网易实习生作业，一个简单的商城系统。spring boot + spring cloud + docker



数据库文件在store.sql中。数据库名为store,配置文件中使用账号root，密码123456，三个表： user,cart,product


启动：
先启动项目:eureka,作为注册中心。
再启动，user,cart,product 三个项目为服务提供者
最后启动， store 作为消费者，前端代码和jsp就在这个项目中，其监听端口8090.

访问localhost:8090，进入首页。
访问localhost:8761可看到各应用注册状态。

如果通过docker启动，需要在各项目pom.xml所在文件夹下 mvn clean package docker:build,并下载mysql镜像，然后在neteaseWork目录下docker-compose up,可以在localhost:8761看到各项目注册信息,访问http://localhost:9001/product/2 可以看到product正常提供服务。