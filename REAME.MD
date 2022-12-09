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

# Ejecución

## Arrancar proyecto
Botón derecho sobre clase StartApp > Run as Java Application

## Test
Botón derecho sobre proyecto  > Run as Maven Test

# Tarea
Hay unos test comentados para la entidad City. Nos interesa ponerlos en marcha y exponer su API correspondiente.

* Descomenta los test
* Crear las clases o lo que sea necesario para que estos funcionen




    