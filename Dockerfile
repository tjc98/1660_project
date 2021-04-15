FROM maven:3.5.0-jdk-8
WORKDIR root/tjc98_hw1
RUN apt-get install libxrender1 libxtst6 libxi6
COPY gui.java .
RUN javac gui.java
CMD ["java", "gui"]