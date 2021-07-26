# **Pasos para correr la aplicación:**

### Ramas
1. **main:** tiene la descripción sobre cómo correr la aplicación completa y el archivo con el script para hacer un **restore** a la base de datos desde **pgAdmin** de PostgreSQL. El archivo se llama **backup**.
2. **client:** tiene la aplicación del **cliente** hecha con **React** y **Redux**.
3. **server:** tiene la aplicación del **servidor** hecha con **Spring Boot**.

### Servidor (PostgreSQL - Spring Boot)

Primero que todo es necesario tener la API andando para que el cliente pueda hacer las solicitudes necesarias e interactuar con el servidor. Para esto es necesario configurar nuestra base de datos. Esto se puede hacer de dos maneras:

1. Hacer un **restore** de la base de datos mediante el uso del archivo ***backup***  (se encuentra en el repositorio) en el administrador de la base de datos de PostgreSQL, que es **pgAdmin**.

2. Simplemente levantar la aplicación hecha con Spring Boot, **configurar su archivo application.properties** y definir tanto el nombre de **usuario** en postgres, **contraseña** y **nombre de la base de datos**. Una vez configurado esto, al levantar la aplicación también se crearán automáticamente las entidades y/o relaciones en la base de datos.

### Cliente (React)

Para poder correr la aplicación del cliente son necesarios dos pasos en orden:
1. Abrir una consola o terminal dentro de la carpeta del proyecto y ejecutar el comando **npm install**.
2. En la misma consola o terminar anterior, ejecutar el comando **npm run start**.

### Test Unitarios

- En **Spring Boot** debes ejecutar el archivo **ApiApplicationTests.java** que se encuentra en la ruta *src/test/java/com/coopeuch/api*.

- En **React** debes abrir una consola o terminal dentro de la carpeta del proyecto, **tener la aplicacion de Spring Boot corriendo** y ejecutar el comando **npm run test** para correr los test por defecto, o puedes ejecutar **npm run test-cov** para ver los archivos que fueron involucrados en los tests ejecutados.

### Swagger

Para poder ver el Swagger es necesario tener la aplicación del servidor corriendo o ejecutándose.

**url:** http://localhost:8080/swagger-ui.html#/
