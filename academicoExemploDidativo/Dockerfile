# Estágio 1: Compilação com Maven e Java 25
FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /app

# Copia primeiro o pom.xml para aproveitar o cache de dependências do Docker
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte e gera o .jar executável
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Imagem final enxuta apenas com JRE 25
FROM eclipse-temurin:25-jre
WORKDIR /app

# Copia apenas o .jar gerado no estágio anterior
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]