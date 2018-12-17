FROM tomcat:8.5-jre8

MAINTAINER Ítalo O Costa <italo.de.oliveira01@gmail.com>

RUN echo "export JAVA_OPTS=\"-Dapp.env=staging\"" > /usr/local/tomcat/bin/setenv.sh
COPY ./Portaria-1.0.war /usr/local/tomcat/webapps/Portaria.war