FROM java:8
VOLUME /tmp
EXPOSE 8182
ADD target/accountapp.jar accountapp.jar
RUN bash -c 'touch accountapp.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","accountapp.jar"]
