# 基础镜像
FROM openjdk:11.0-jre-buster

# 设定时区
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 设置语言环境
ENV LANG=zh_CN.UTF-8
ENV LANGUAGE=zh_CN:zh
ENV LC_ALL=zh_CN.UTF-8

# 拷贝jar包
COPY cart-service-10002-1.0-SNAPSHOT.jar /app.jar

# 入口
ENTRYPOINT ["java", "-jar", "/app.jar"]
