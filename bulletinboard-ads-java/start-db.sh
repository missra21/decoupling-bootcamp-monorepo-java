#!/bin/sh -e

set +e; existing_db_container_name=$(docker ps -a -f name=postgres-bulletinboard-ads | grep postgres-bulletinboard-ads); set -e
if [ -z "$existing_db_container_name" ]
then
    echo "DB container doesn't exist, creating"
    docker create -p 5432:5432 --name postgres-bulletinboard-ads -e POSTGRES_HOST_AUTH_METHOD=trust postgres:9.6-alpine
fi

is_db_container_running=`docker inspect -f '{{.State.Running}}' postgres-bulletinboard-ads`
if [ $is_db_container_running = "false" ]
then
    echo "Starting DB container"
    docker start postgres-bulletinboard-ads
else
    echo "DB container already running"
fi
