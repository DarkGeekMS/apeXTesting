FROM maven:3.3-jdk-8

COPY . /usr/src/mymaven
WORKDIR /usr/src/mymaven

RUN chmod +x /usr/src/mymaven/driver/chromedriver.exe

ARG SERVER_URL
ENV SERVER_URL=${SERVER_URL}

#CMD mvn clean install
CMD mvn test
