#Pull base image
FROM tomcat:8.5.30-jre8
#maven:3.6.1-jdk-8

# Maintainer
MAINTAINER "aman.saxena2898@gmail.com"

COPY "restapi.war" "/usr/local/tomcat/webapps/restapi.war"

EXPOSE 8080

CMD ["catalina.sh", "run"]
