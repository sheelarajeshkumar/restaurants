FROM alpine:edge
MAINTAINER vajirawke@gmail.com
RUN apk add openjdk8
ENTRYPOINT ["/usr/bin/java"]




RUN apk  add mongodb
VOLUME ["/data/db"]
EXPOSE 27017:27017
EXPOSE 28017:28017

CMD [ "mongod", "--bind_ip", "127.0.0.1" ]
RUN mkdir /apps
COPY ./target/RestaurantGeoSearch-0.0.1-SNAPSHOT.jar /apps/restaurant.jar
CMD ["-jar", "/apps/restaurant.jar"]

EXPOSE 8080

