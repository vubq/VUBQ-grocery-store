FROM gradle:8.10.2-jdk17 AS builder
WORKDIR /workspace
COPY . .
RUN gradle bootWar --no-daemon

FROM tomcat:10.1-jdk17
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=builder /workspace/build/libs/vubq-grocery-store.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080

