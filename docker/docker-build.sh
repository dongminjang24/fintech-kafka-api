#!/bin/zsh

# Setting versions
VERSION='1.0.2'

cd ..
./gradlew clean build -x test

ROOT_PATH=`pwd`
echo "Root path: $ROOT_PATH"

# Build docker image
echo 'api docker image building...'
cd $ROOT_PATH/api && docker build -t api:$VERSION .
echo 'api docker image building done'

echo 'consumer docker image building...'
cd $ROOT_PATH/consumer && docker build -t consumer:$VERSION .
echo 'consumer docker image building done'

echo 'css docker image building...'
cd $ROOT_PATH/css && docker build -t css:$VERSION .
echo 'css docker image building done'

echo 'nginx docker image building...'
cd $ROOT_PATH/nginx && docker build -t nginx:$VERSION .
echo 'nginx docker image building done'