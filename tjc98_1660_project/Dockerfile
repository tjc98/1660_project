FROM maven:3.5.0-jdk-8
WORKDIR root/tjc98_hw1
RUN apt-get install libxrender1 libxtst6 libxi6
COPY gui.java .
COPY api-common-1.10.1.jar .
COPY commons-cli-1.2.jar .
COPY commons-logging-1.2.jar .
COPY gax-1.63.0.jar .
COPY gax-grpc-1.63.0.jar .
COPY google-auth-library-credentials-0.25.3.jar .
COPY google-cloud-0.8.0.jar .
COPY google-cloud-dataproc-1.4.0.jar .
COPY google-cloud-datastore-1.106.1.jar .
COPY google-cloud-storage-1.113.15.jar .
COPY grpc-all-1.37.0.jar .
COPY grpc-context-1.37.0.jar .
COPY grpc-core-1.37.0.jar .
COPY grpc-netty-1.37.0.jar .
COPY grpc-protobuf-1.37.0.jar .
COPY guava-30.1.1-jre.jar .
COPY hadoop-common-2.6.0-cdh5.15.1.jar .
COPY hadoop-mapreduce-client-core-2.6.0-cdh5.15.1.jar .
COPY netty-all-5.0.0.Alpha2.jar .
COPY protobuf-java-4.0.0-rc-2.jar .
COPY proto-google-cloud-dataproc-v1-1.4.0.jar .
COPY threetenbp-1.5.0.jar .
COPY toolkit-0.0.5.jar .
RUN javac gui.java
CMD ["java", "gui"]