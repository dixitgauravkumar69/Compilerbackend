# 1. Base image: Isme Java 17 pehle se hai
FROM eclipse-temurin:17-jdk-jammy

# 2. C++ (g++) aur Python install karein
RUN apt-get update && apt-get install -y \
    build-essential \
    python3 \
    && rm -rf /var/lib/apt/lists/*

# 3. Work directory set karein
WORKDIR /app

# 4. Apni JAR file ko container mein copy karein
# Humne '*' isliye lagaya taaki agar version name ho (like POD-Demo-1.0.jar), toh bhi utha le
COPY target/POD-Demo.jar app.jar

# 5. Ek folder banayein jisme user ka code execute hoga
RUN mkdir /app/codes

# 6. Spring Boot app start karne ki command
ENTRYPOINT ["java", "-jar", "app.jar"]