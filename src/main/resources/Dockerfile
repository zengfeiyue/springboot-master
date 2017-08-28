FROM java
RUN mkdir /home/test/
ADD target/*.jar /home/test/
RUN  java -jar shareniu.jar &
EXPOSE 8081