# udp-services
[![Build Status](https://travis-ci.org/zeab/udp-service.svg?branch=master)](https://travis-ci.org/zeab/udp-service)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a30a2c6b592a4e199d8e1b4d8aa0b543)](https://www.codacy.com/app/zeab/udp-service?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=zeab/udp-service&amp;utm_campaign=Badge_Grade)
A stand alone udp service which listens and prints out the received datagrams and a udp client which sends messages every few seconds

## udp-service
### Env Variables
|Env Key|Description|Default|
|------------|-------------|-------------|
|ROOT_LOG_LEVEL|Changes base log level (does not override other logger levels if explicitly set)|INFO|
|UDP_HOST|What address the service listens on|0.0.0.0|
|UDP_PORT|What port the service listens on|8125|

### Docker
```docker run rm -p 8125:8125/udp zeab/udpservice```

### K8
[K8 Deployment](https://github.com/zeab/udp-services/blob/master/k8/udp-service-deployment.yaml)

## udp-client
### Env Variables
|Env Key|Description|Default|
|------------|-------------|-------------|
|ROOT_LOG_LEVEL|Changes base log level (does not override other logger levels if explicitly set)|INFO|
|UDP_HOST|What address the client posts too|0.0.0.0|
|UDP_PORT|What port the client posts too|8125|
|PULSE_INTERVAL|How often a message gets posted|3 seconds|
|DATAGRAM|The message to be sent|"Ahoy! - {UUID}"|

### Docker
```docker run rm zeab/udpclient```

### K8
[K8 Deployment](https://github.com/zeab/udp-services/blob/master/k8/udp-client-deployment.yaml)