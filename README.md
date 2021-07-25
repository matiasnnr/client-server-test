# **Pasos para correr la aplicación:**

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
