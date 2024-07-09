FROM eclipse-temurin:17

EXPOSE 8080

COPY . /AirTicketManager
WORKDIR /AirTicketManager
RUN sed -i 's/\r$//' mvnw
RUN chmod +x mvnw && ./mvnw clean package -Dmaven.test.skip=true
ENTRYPOINT ["/bin/sh", "-c", "java -jar target/Air-Ticket-Management-0.0.1-SNAPSHOT.jar"]
