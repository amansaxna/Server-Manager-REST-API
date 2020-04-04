# fetch basic image
FROM maven:3.3.9-jdk-8 as build

# application placed into /opt/app
WORKDIR /app

# selectively add the POM file and
# install dependencies
COPY pom.xml .
COPY src src
# rest of the project
RUN mvn install -DskipTests

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:8-jdk-alpine
WORKDIR /app
VOLUME /tmp
ARG TARGET=/app/target/
COPY --from=build ${TARGET}/lib /app/lib
COPY --from=build ${TARGET}/classes .


EXPOSE 8080
ENTRYPOINT ["java","-cp","/app:/app/lib/*","com.kaiburr.restapi"]


#---------------------------------
#FROM tomcat:8.0-jre8
#ADD /my-web-app.war /usr/local/tomcat/webapps/
#CMD ["catalina.sh", "run"]

#--------------------------------------------------

#FROM tomcat:8.5.38
#ADD ./target/npmanager.war /usr/local/tomcat/webapps/
#CMD chmod +x /usr/local/tomcat/bin/catalina.sh
#CMD ["catalina.sh", "run"]

#-----------------------------------------------
# fetch basic image
#FROM maven:3.3.9-jdk-8 as build

#application placed into  /opt/app
#RUN mkdir -p /opt/app

#selectively add pom file
#install dependencies
#COPY pom.xml /opt/app
#RUN mvn install

#rest of the project
#COPY src /opt/app/src
#RUN mvn package

#local application port
#EXPOSE 8080

#execute it
#CMD["mvn","exec:java"]