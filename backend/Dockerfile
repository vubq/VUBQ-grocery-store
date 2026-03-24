FROM node:24-alpine AS frontend-builder
WORKDIR /workspace/frontend
COPY frontend/package*.json ./
RUN npm ci
COPY frontend ./
RUN npm run build

FROM gradle:8.10.2-jdk17 AS backend-builder
WORKDIR /workspace
COPY backend ./backend
COPY --from=frontend-builder /workspace/frontend/dist ./frontend-dist
WORKDIR /workspace/backend
RUN gradle bootWar --no-daemon -PskipFrontendBuild=true -PfrontendDistDir=/workspace/frontend-dist

FROM tomcat:10.1-jdk17
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=backend-builder /workspace/backend/build/libs/vubq-grocery-store.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
