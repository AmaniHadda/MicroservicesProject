FROM openjdk:11
EXPOSE 8099
COPY target/Evenement-0.0.1-SNAPSHOT.jar Evenement-0.0.1-SNAPSHOT.jar
RUN chmod +x Evenement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Evenement-0.0.1-SNAPSHOT.jar"]