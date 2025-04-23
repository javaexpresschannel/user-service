FROM openjdk:17-oracle

ENV SPRING_PROFILES_ACTIVE cloud

COPY target/user-service-0.0.1-SNAPSHOT.jar user-service.jar 

EXPOSE 8085

ENTRYPOINT [ "java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}","-jar","user-service.jar" ]

#	java -Dspring.profiles.active=dev -jar <jar-Name>

