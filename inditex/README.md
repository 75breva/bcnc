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
1. Relacion sobre la creacion de las tablas PRICES, PRODUCT y BRAND
   + Tenemos relacion de 1:N entre la tabla Prices con Product y la tabla Prices con Brand el cual indicamos que a la
   hora de crear un nuevo atributo Prices, previamete debe de existir el producto y brand que asociemos.
   + En los archivos schemas.sql y data.sql se puede observar la structura de la base de datos y los tados de prueba intoduccidos.

### Archivo collecion [ Postman ] 
En el proyecto dento de la carpeta Resource / postman , esta definido en el archivo el endpoint para su correcta llamada a la api una vez arrancada.



