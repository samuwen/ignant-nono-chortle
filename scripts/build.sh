#!/bin/bash

docker-compose down
mvn clean install
docker-compose build
docker-compose up