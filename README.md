# Full micro service sample using Spring, docker-compose and docker-compose UI

Sample provided by okta

* https://developer.okta.com/blog/2019/02/28/spring-microservices-docker

Original source code can be found here

* https://github.com/oktadeveloper/okta-spring-microservices-docker-example/tree/master/config-data

## Requirements

* Maven 3.5.X
* Docker version 18.09.0
* docker-compose version 1.24.0

## Building docker images

```shell
$ cd ./okta-spring-microservices-docker-example
$ mvn clean install
```

After that available images list can be found using :

```shell
$ sudo docker image ls

REPOSITORY                                           TAG                 IMAGE ID            CREATED              SIZE
jpdacunha/microservice-docker-school-shared-config   0.0.1-SNAPSHOT      6714380e0e02        20 seconds ago       149MB
jpdacunha/microservice-docker-school-discovery       0.0.1-SNAPSHOT      301daae1527b        42 seconds ago       149MB
jpdacunha/microservice-docker-school-ui              0.0.1-SNAPSHOT      cb0245ffee4b        About a minute ago   152MB
jpdacunha/microservice-docker-school-service         0.0.1-SNAPSHOT      97d1279c9fc0        About a minute ago   162MB
openjdk                                              8-jdk-alpine        3675b9f543c5        2 weeks ago          105MB

```

## Starting all setup

### 1. Using docker-compose

All setup ca be started using docker-compose

```shell
$ cd ./okta-spring-microservices-docker-example
$ docker-compose up -d
```
THIS MAY TAKE TIME TO STARTUP : be nice and wait ;-)

### 2. Using docker-compose UI

docker-compose UI automatically search for a docker-compose.yml file in current directory

#### 1. building and start container

```shell
$ cd ./okta-spring-microservices-docker-example
$ docker container run --name docker-compose-ui -v $(pwd):$(pwd) -w $(dirname $(pwd)) -p 5000:5000 -v /var/run/docker.sock:/var/run/docker.sock francescou/docker-compose-ui:1.13.0
```

#### 2. starting existing container

```shell
$ cd ./okta-spring-microservices-docker-example
$ docker container start docker-compose-ui
```
It is possible to accse docker-compose UI console and start container using GUI. You can access docker-compose UI using http://localhost:5000

## Accessing / testing applications

* Dicovery EUREKA :      http://localhost:8761
* Configuration server : http://localhost:8888/school-ui.properties
* Sample Web Service :   http://localhost:8081
* UI :                   http://localhost:8080
* docker-compose UI :    http://localhost:5000






