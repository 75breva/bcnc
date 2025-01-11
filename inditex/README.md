# BCNC - Inditex
Aplicacion Backend para comercio electronio de INDITEX.

## Overview
La aplicacion BcncInditex proporciona los precios almacenado en base de datos
segun los requerimientos deseados a buscar.

1. Parametros de entrada:
   - applicationDate : Fecha requerida para buscar
   - producto : Identificador del producto
   - brand : Intentificador de la cadena.
2. Casos de uso:
   - Devolver resultados encontrados
   - Avisar posibles parametros enviados incorrectos
   - Avisar de resultados no encontrados


## Introduccion
Para este desarrollo de la aplicacion he utilizado las siguientes tecnologias .
+ Sprinboot V3.3.2
+ Java 17
+ OpenApi para la autogeneracionde de los Dto del empoint en el archivo api.yml
+ Framework Hibernate con JPA para el manejo de la persistencia
+ H2 DataBase en memoria
+ Junit para realizar los test unitarios
+ lombok para la facilitacion y simplicidad de la implementacion del desarrollo de las entidades JAVA
+ Sonar para mejorar la calidad del codigo



## Getting started

1. Clone this project `git clone https://github.com/75breva/bcnc.git`
2. `mvn clean install`
3. `mvn spring-boot:run`
4. Open your console H2   `http://localhost:8081/h2-console/`
   + Url: jdbc:h2:mem:bcnc
   + User Name: sa
   + Pass: N/A
5. Importante configurar:
   + En el IDE de desarrollo elegido (Intellij) la ruta del OpenJdK 17 `C:~\jdk-17.0.0.1` para inciarlo en local
   + Configurar Variable de entorno-> Variables de sistema -> Path como primera opcion la url de la versionde java. C:\NOVA\inditex> si queremos generar codigo con openApi

## Ejecutar el Servidor de Spring Boot

Limpieza de la aplicacion
```
mvc clean install
```
Ejecucion de la aplicacion con run o modo debug
```
mvc run or mvc debug 
```



## Ejecutar Tests

Tests unitarios
```
mvn clean test
```

## Base de datos  H2
Para acceder a la configuracion de la base de datos (url, puertos etc) tenemos el archivo
+ application.yml donde habilitamos la consola h2, indicamos url puertos , configuracion de la bbdd
   + url : jdbc:h2:mem:bcnc
   + user : sa
   + pass : en blanco
1. Relacion sobre la creacion de las tablas PRICES, PRODUCT y BRAND
   + Tenemos relacion de 1:N entre la tabla Prices con Product y la tabla Prices con Brand el cual indicamos que a la
     hora de crear un nuevo atributo Prices, previamete debe de existir el producto y brand que asociemos.
   + En los archivos schemas.sql y data.sql se puede observar la structura de la base de datos y los tados de prueba intoduccidos.

### Archivo collecion [ Postman ]
En el proyecto dento de la carpeta Resource / postman , esta definido en el archivo el endpoint para su correcta llamada a la api una vez arrancada.


## Añadir ejemplo Kafka
En este video, tenemos la posibilidad de bajarse el proyecto usando dos microservicios.
- https://www.youtube.com/watch?v=1dvCwFgHZCk
- https://github.com/yoandypv/spring-boot-kafka-basics

En mi caso lo voy hacer en el mismo microservicio.

### Opcion 1  [ Kafka y Zookeeper ]
Seguir la Guia: https://sacavix.com/2022/03/iniciando-apache-kafka-en-windows-offset-explorer/
+ Me descargo kafka en este caso la verison :Binary downloads: Scala 2.12  - kafka_2.12-3.8.0.tgz (asc, sha512)
+ Segui las indicaciones de poner la carpeta descargada en la raiz de C:.
+ Cree una carpeta C:/kafka/bitacora para los LOGS tanto de zookeeper como kafka (Se puede cambgiar la ruta como se quiera)
+ Abrit terminal e Importante ir a la ruta que indica la guia: C:\kafka_2.12-3.8.0\bin\windows
   + Lanzamos el siguiente comando para arrancar zookeeper:
      - .\zookeeper-server-start.bat ..\..\config\zookeeper.properties
   + Lanzamo el siguiente comando para arrancar Kafka:
      - .\kafka-server-start.bat ..\..\config\server.properties.

Listo ya podemos arrancar nuestra aplicacion y atacar con el endpoint creado, donde se producira y de forma
automatica se consumira.

### Descargar Offset Explorer para monitorear los mensajes que pasan, crear topicos etc.
- Propiedades de la conexión (Kafka):
   - Cluster name: el que quieras.
   - Boostrap servers localhost:9092
   - Kafka cluster version: 3.7 aunque tenga descargado la 3.8 (no tiene mas nuevas)
- Propiedades de la conexión (zookeeper):
   - Host: localhost
   - Port: 2181 (lo que hemos configurado en los archivos de config)



### Opcion 2  [ Kafka y Zookeeper DOCKERIZADO]
Seguir la Guia: https://sacavix.com/2022/02/iniciando-kafka-con-docker/
- Importante para el tema del instalacion del portainer seguir la doc oficial.
   - https://docs.portainer.io/start/install-ce/server/docker/linux
   - https://www.ionos.es/digitalguide/servidores/configuracion/instalar-portainer-en-docker/  (Esta vale para simplemente ver que es una copia de la 1º url)
1. Descargar Docker Desktop y te registras (yo con la cuenta de google mismo),
2. Desde cmd creas el volumen:
``` 
docker volume create portainer_data  
``` 
Puedes visualizarlo desde docker desktop
3. Cuando accedes al portainer https://localhost:9443  crear un usuario
   - admin , pass de 12 caracteres. Miarca_..... y compruebo que tengo docker-compose:
      -  cmd :
        ``` 
         docker-compose --version 
        ```
      - Info interesante al respecto:
         - https://anderfernandez.com/blog/tutorial-docker-compose/
         - https://imaginaformacion.com/tutoriales/que-es-docker-compose
         - Me voy a la ruta de mi docker-compose.yml y lanzo en el terminal:
        ``` 
         docker-compose down          -> para parar
         docker-compose up -d         -> para arrancar
        ```
         + Me debe de generar los dos contenedero/imagenes de kafka y zookeeper.
         + En total 6 volumenes, 3 imagenes/contenedores (con la del portainer), 1 stack, 4 network
         - Necesito verificar que hay acceso a los 2 servidores.
            - Instalo netcat-Nmap siguiendo esta guia: https://serverspace.io/es/support/help/how-to-install-ncat-tool-on_windows-and-linux/
               + Cierro terminal y compruebo en el nuevo terminal: ncat -v
               + realizo las comprobaciones que indica en la guia pero con NCAT en vez de nc -zv ---
                  * ```  ncat -zv localhost 29092 ```  (debo de tener conexion)
                  * ``` ncat -zv localhost 22181 ```  (debo de tener conexion)
         - cuando he lanzo el comando porque he cambiado puertos, añadidos cosas
            ```
            docker-compose up -d 
            ```
           No es necesario eliminar los contenedores, ya que se reinstalan los cambios
           si he añadido cosas nuevas o modificaciones etc en el docker-compose.yml
### Opcion 3  [ Kafka con AVRO]
En el ultimo commit explico lo que he realizado.
- Modifico depentencias del pom. He tenido problemas con las versiones debido al springdoc-openapi a la hora de RUN.
- docker-compose: añado la imagen confluent etc, me crea la clase main/java/inditex/avro/Customer cuando hago en el terminal.
```
docker-compose up -d 
```
+ Entonces ahora tanto para el productor como consumidor modifico en las clases java para que use la clase Customer.
+ application.yml Tengo que indicar que no serialize/Deserialize un json si no que un kafkaAvro.

Ahora simplemten lanzas el comando para lanzar el doncker-compose.yml, (Se visualiza todo muy bien en docker-desktop)
PARA que te cree las imagenes de zookeeper, kafka  , schema-registry y ya puedes arrancar la aplicacion.

### [ Rama SIN-KAFKA_POSTGRESQL ] 
Aqui lo que he echo es añadir simplementen la conexion con la bbdd postgresql.
1. En primero añado al docker-compose las imagenes:
   + postgres 
   + adminer -> servidor:postgres , usuario:admin , pass:admin , bbdd:bcnc

2. Desde el http://localhost:9090/ , ejecuto la parte comentada de schema.sql y data.sql .
   1. Vereis que no tiene el AUTO_INCREMENT , si no que tiene el SERIAL. Eso es para postgresql.

3. He tenido problemas con intentar añadir ```schema:bcnc``` ya que por defecto tiene ```schema:public ``` 
   + La solucion poner en ```url:.......currentSchema=bcnc```