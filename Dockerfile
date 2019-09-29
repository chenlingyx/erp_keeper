FROM openjdk:8-jdk-alpine
USER root
#中文乱码问题
ENV LC_ALL en_US.UTF-8
ENV LANG en_US.UTF-8

unzip hello.zip
COPY  target/erp_keeper.jar  /root/erp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:+PrintGCDetails   -XX:+HeapDumpOnOutOfMemoryError ","-jar","/root/erp.jar"]
