FROM openjdk:21-jdk-slim
 RUN apt-get update && apt-get install -y curl \
   && curl -sL https://deb.nodesource.com/setup_20.x | bash - \  
   && apt-get install -y nodejs \  
   && curl -L https://www.npmjs.com/install.sh | npm_install="10.2.3" | sh
WORKDIR /usr/src/app 
COPY . .
RUN cd bauersteine-frontend && npm install 
RUN cd bauersteine-frontend && npm run build 
RUN rm -r bauersteine-frontend

RUN sed -i 's/\r$//' mvnw 
RUN chmod +x mvnw 
RUN ./mvnw package


EXPOSE 8080
CMD ["java", "-jar", "/usr/src/app/target/bauersteine-0.0.1-SNAPSHOT.jar"]
