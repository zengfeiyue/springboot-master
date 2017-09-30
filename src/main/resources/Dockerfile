#FROM java
#RUN mkdir /home/test/
#ADD springboot.jar /home/test/
#WORKDIR /home/test/
#CMD  ["java", "-jar", "springboot.jar"]
#EXPOSE 8081

#FROM docker.io/jenkins:latest
#USER root
#RUN wget http://apache-mirror.rbc.ru/pub/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
#RUN tar xzvf apache-maven-3.3.9-bin.tar.gz
#RUN cp -R apache-maven-3.3.9 /usr/local/bin
#RUN export PATH=apache-maven-3.3.9/bin:$PATH
#RUN export PATH=/usr/local/bin/apache-maven-3.3.9/bin:$PATH
#RUN ln -s /usr/local/bin/apache-maven-3.3.9/bin/mvn /usr/local/bin/mvn
#RUN ls -l /usr/local/bin
#RUN echo $PATH


#FROM redis
#COPY redis.conf /usr/local/etc/redis/redis.conf
#CMD [ "redis-server", "/usr/local/etc/redis/redis.conf" ]

FROM tomcat
COPY iber-portal.war /usr/local/tomcat/webapps