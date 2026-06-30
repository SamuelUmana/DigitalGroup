# 🔹 Paso 1: Usar una imagen oficial de Maven con Java 21 para compilar
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar el archivo de configuración del proyecto
COPY pom.xml .

# Descargar las dependencias (se quedan en caché en Render)
RUN mvn dependency:go-offline -B

# Copiar el código fuente y empaquetar el .jar sin tests
COPY src ./src
RUN mvn clean package -DskipTests

# 🔹 Paso 2: Crear la imagen final de ejecución con Java 21 JRE
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copiar el .jar compilado del paso anterior
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto por defecto de Spring Boot
EXPOSE 8080

# Comando para arrancar el backend
ENTRYPOINT ["java", "-jar", "app.jar"]