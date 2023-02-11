# 1. node 설치
#FROM    ubuntu:20.04
#RUN     apt-get update
#RUN     DEBIAN_FRONTEND=noninteractive apt-get install -y curl
#RUN     curl -sL https://deb.nodesource.com/setup_16.x | bash -
#RUN     DEBIAN_FRONTEND=noninteractive apt-get install -y nodejs

## node 따로 설치, 설정하지 않고 node12 기본이미지 사용
#FROM    node:16
#
## 2. 소스 복사
#COPY    . /usr/src/app
#
## 3. Nodejs 패키지 설치
#WORKDIR /usr/src/app
#RUN     npm install
#
## 4. WEB 서버 실행 (Listen 포트 정의)
#EXPOSE  3000
#CMD     node app.js

# 최적화 : npm install 전에 패키지를 우선 복사하여 build시간 감축
#FROM    node:16
# Nodejs 경량화
FROM    node:16-alpine

COPY    ./package* /usr/src/app/
WORKDIR /usr/src/app
RUN     npm install

COPY    . /usr/src/app

EXPOSE  3000
CMD     node app.js