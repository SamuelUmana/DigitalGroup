# 🔹 Paso 1: Usar una imagen oficial de Java para compilar
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app

# Copiar los archivos de configuración de Maven
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Descargar las dependencias (se quedan en caché para que los siguientes despliegues sean rápidos)
RUN ./mvnw dependency:go-offline

# Copiar el código fuente y compilar el .jar saltándose los tests
COPY src ./src
RUN ./mvnw clean package -DskipTests

# 🔹 Paso 2: Crear la imagen final de ejecución (más ligera)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copiar el .jar que se compiló en el paso anterior
# (Asegúrate de que el nombre coincida o usa el comodín *.jar como aquí abajo)
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto por defecto de Spring Boot
EXPOSE 8080

# Comando para arrancar tu backend en la nube
ENTRYPOINT ["java", "-jar", "app.jar"]