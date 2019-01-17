FROM openjdk:8-jre-alpine

EXPOSE 8080 5005

WORKDIR /home
COPY target/webapp-*.jar ./webapp.jar

CMD ["java","-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n","-Djava.security.egd=file:/dev/./urandom", "-jar", "webapp.jar"]