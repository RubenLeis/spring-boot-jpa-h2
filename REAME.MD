# Estructura del proyecto

* src/main/java
   *  controllers: clases encargadas de recibir la petición HTTP del cliente y derivar el flujo hacía la capa de 	servicio
   * entities: entidades persistentes de JPA. Mapean una tabla de BBDD y sus respectivos campos.
   * model: paquete donde guardamos nuestro POJOs que utilizaremos en nuestro Controller
   * repositories: aquí tendremos nuestras clases de acceso a base de datos. Por defecto Spring nos proporciona un 	montón de funcionalidad ya implementada (findall, find,...)
   * service: capa encargada de hacer nuestrá logica, la algoritmia de negocio.
   CountriesApp.
   * StartApp: clase de arranque de nuestra app
* src/main/resources
   * application.properties: contiene la configuración de nuestra app
   * logback.xml: fichero con la configuración de log de nuestra app.
* src/test/java: contiene los test dividos por capas
* src/test/resources: contiene la configuración de la BBDD para test y un script para dar de alta datos de prueba
* pom.xml. Fichero con todas las dependencias de Spring requeridas para nuestro proyecto

# Configuración

Las siguientes instrucciones son validas para IntelliJ

## JDK 11

Es necesario que descarguemos la JDK 11 (zip) en nuestro equipo, en la ubicación que gustemos y lo descomprimamos.

https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_windows-x64_bin.zip
https://jdk.java.net/archive/

Debemos añadir esta JDK en Intellij y establecerse a nuestro proyecto

https://www.baeldung.com/intellij-change-java-version


# Ejecución

Las siguientes instrucciones son validas para el IDE IntelliJ

## Arrancar proyecto
Botón derecho sobre clase StartApp > Run as Java Application

¿Problemas con las versiones en ejecución?
https://stackoverflow.com/questions/59601077/intellij-errorjava-error-release-version-5-not-supported

## Test
Botón derecho sobre proyecto  > Run All Test

# Tarea
Hasta ahora teníamos un API para la entidad Country.
El objetivo es crear un nuevo API muy semejante a la anterior, pero para la entidad City

Hay unos test comentados para comprobar que funciona todo los relacionado con City 
Nos interesa ponerlos en marcha, para asegurarnos que el flujo de nuestra 
aplicación funciona bien desde el Controlador, hasta el repositorio pasando
por el Servicio.

Los test son estos:
* CityRestControllerTest
* CityRepositoryTest
* CityServiceMockAnnotationTest
* CityServiceTest

Pasos:
* Descomenta los test. Fallará la aplicación por númerosos errores de compilaciones. 
Debemos crear las clases necesarias para nuestras diversas capas: entitiy, repositorio, modelo, service y controller.
* Estas clases serán muy parecidas a las ya existentes para Country, solo que utilizarán City en su lugar.
* Los atributos de la clase City serán los que nos indique la BBDD: test-h2-cities.sql 


Como resultado final tendremos un nuevo API disponible para ser invocado

## Rúbrica
Como hay 4 test, cada test vale un 25% de la nota final de este ejercicio. Si falla el test recibirás un 0 y si funciona el 25%.

Este ejercicio tiene un peso de un 15% en la nota final de prácticas.






    