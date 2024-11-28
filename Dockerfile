#Java version
FROM openjdk:11-jdk

#ADMIN ADDRESS
LABEL maintainer="kodh10@gmail.com"

#JAR_FILE 변수지정
ARG JAR_FILE=build/libs/activity-project-0.0.1-SNAPSHOT.jar

#Docker 내 실행명
ADD ${JAR_FILE} activity-springboot.jar

#SpringBoot ENV(local/dev)
#local 전용
ENV SPRING_PROFILES_ACTIVE=local
ENV SPRING_DATASOURCE_URL=jdbc:log4jdbc:mysql://host.docker.internal:3306/KORMAP?useLocalSessionState=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull

#EC2(dev) 전용
#ENV SPRING_PROFILES_ACTIVE=dev
#ENV SPRING_DATASOURCE_URL=jdbc:log4jdbc:mysql://kormap-database.cpouy2c2sy1w.ap-northeast-2.rds.amazonaws.com:3306/KORMAP?useLocalSessionState=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull


#Docker 컨테이너 실행 시 실행될 명령어
ENTRYPOINT ["java", "-jar", "activity-springboot.jar"]