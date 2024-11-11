## Spring Boot

1. Se incluye código fuente
2. Se incluye archivo Postman para pruebas y generación de token de autenticación

# How to build and deploy
1. Bajar codigo fuente
2. Ejecutar mvn spring-boot:run
3. Importar archivo Postman incluido
4. Logearse (/auth/login) para obtener token
5. Llamar a "crear usuario" y "listado usuario" usuando el token generado, se incluyen json request para hacer pruebas

Swagger disponible en http://localhost:8005/swagger-ui.html
