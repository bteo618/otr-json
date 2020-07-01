FROM ubuntu:latest

LABEL "Maintainer"="BJlearn"

RUN apt-get update && apt-get install -y openjdk-8-jdk
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
ENV PATH $PATH:$JAVA_HOME/bin

ADD . /usr/local/docker-git-otr-json

RUN cd /usr/local/docker-git-otr-json && sh gradlew fatJar

CMD ["java", "-cp", "/usr/local/docker-git-otr-json/build/libs/otr-json-fat.jar", "com.daimler.otr.ConvertInvoice"]