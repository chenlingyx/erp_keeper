#!/usr/bin/env bash


mkdir -p  /root/logs
chmod 777 /root/logs


git pull
mvn clean package
docker stop erp_keeper

docker build -t erp_keeper .

docker run  -d  --rm   \
    --privileged=true  \
    --net=host \
    -v /root/logs:/root/logs \
    --dns 114.114.114.114 \
    --env 'TZ=Asia/Shanghai' \
    --name erp_keeper   erp_keeper  \
     -p 8081:8081



