FROM alpine:edge
MAINTAINER vajirawke@gmail.com
VOLUME ["/data/db"]

RUN apk add openjdk8
RUN apt-get update 
RUN apt-get  install -y mongodb-org 

CMD ["mongod"]
EXPOSE 27017
RUN mkdir /apps
COPY ./target/RestaurantGeoSearch-0.0.1-SNAPSHOT.jar /apps/restaurant.jar
CMD [java -jar restaurant.jar]
EXPOSE 8080

