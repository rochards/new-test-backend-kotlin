#!/bin/bash

echo "Building application and running tests..."
./gradlew build

echo "Building docker image..."
docker-compose build --no-cache product-catalog

echo "Starting all services ..."
docker-compose up -d

docker-compose logs -f product-catalog

echo "Application is running at http://localhost:8080!"
