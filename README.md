# Proyecto: Prueba técnica BCNC Group
El proyecto desarrollado implementa un servicio API REST con el objetivo de obtener el precio final y la tarifa aplicada a determinados productos en función de la fecha en la que se efectúe la consulta. Para el desarrollo de la solución, se han aplicado técnicas de Clean Code para garantizar la calidad y comprensión del código generado y principios SOLID para asegurar la mantenabilidad y escalabilidad del proyecto.

Las tecnología seleccionada para el desarrollo es el lenguaje Java, concretamente el framework de SpringBoot, utilizando una base de datos en memoria H2 para almacenar datos y todo ello con una arquitectura hexagonal.

## Acerca de la gestión del repositorio

En la gestión de tareas del repositorio, se ha decidido desarrollar una tarea por cada capa implementada en la solución debido a la simplicidad del código que ha sido desarrollado. En un proyecto real, se realizaría una tarea por funcionalidad implementada, no por capa desarrollada, pero dado que la intencionalidad de la prueba es demostrar la gestión del trabajo realizado y al ser implementada una única funcionalidad, se decidió dividir las tareas por cada capa de la funcionalidad para demostrar cómo se trabaja dentro de un repositorio real.

Sobre la gestión de ramas, se ha desarrollado una rama **main** a partir de la cuál se desplegarán las diferentes releases del proyecto, siendo esta rama la que alberga las versiones finales del producto.

A partir de **main** se ha creado una rama **develop** en la que se han integrado cada uno de los desarrollos realizados tras haber sido analizados y verificados en la pull request.

Por último, de la rama **develop** se han creado diferentes ramas **feature**, en las que se han realizado cada uno de los desarrollos planteados en las tareas del repositorio.

La forma de actuar ha sido:

1. Crear rama a partir de **develop** para cada uno de los desarrollos abordados.
2. Clonar la rama creada en el anterior punto y realización del desarrollo.
3. Subida de la rama con los cambios desarrollados al repositorio remoto y creación de pull request para mezclar la rama desarrollada de nuevo con **develop**
4. Análisis del código generado en la rama y verificación del correcto desarrollo implementado.
5. Confirmación del merge request, uniendo los cambios a la rama **develop**

En este caso, al igual que en la gestión de tareas, se ha decidido crear una rama por cada capa, para simplificar la revisión de los cambios realizados en cada una de las tareas y para demostrar la forma de actuar en un proyecto real. Por ello, se ha decidido no eliminar las ramas **feature** al unir los cambios con **develop**, para que puedan ser revisados los cambios implementados en cada una de ellas.

En un repositorio real, se crearía una rama por funcionalidad y cada una de estas ramas serían eliminadas al unir los cambios con **develop**.

## Tecnologías utilizadas

Para el desarrollo de la solución se ha seleccionado la versión de **Java 17**, pues, tras analizar las herramientas externas que iban a ser utilizadas para garantizar la calidad del código desarrollado, se encontró que es la versión más reciente de Java compatible con estas herramientas.

El framework seleccionado se trata de **SpringBoot 3.4.1** que aporta la infraestructura necesaria para desarrollar una aplicación de forma simple y eficaz, añadiendo el módulo **Spring Data JPA** para las consultas a base de datos y empleando **Maven** como herramienta de gestión y automatización de las dependencias del proyecto.

Respecto a la base de datos, se ha seleccionado una base de datos en memoria **H2**, que permita almacenar toda la información que va a ser consultada en el proyecto y que se cargue al ejecutar el mismo.

Por último, la herramienta seleccionada para el análisis de código ha sido **SonarCloud**, aportando seguridad sobre el código desarrollado.

## Arquitectura y patrones de diseño

Para el desarrollo del proyecto se ha decidido implementar una arquitectura hexagonal, al ser la arquitectura propuesta para el desarrollo de la solución y ser una arquitectura conocida por el desarrollador.

Esta arquitectura se basa en el concepto de **puertos** y **adaptadores** y consiste en organizar el código de forma que se desarrolle un núcleo de la aplicación, desacoplado totalmente de la implementación del código y sin ningún tipo de dependencias, donde se definen interfaces abstractas (puertos) y una serie de capas externas (adaptadores) que dependen directamente del núcleo y donde se va a implementar las diferentes funcionalidades definidas en la lógica de negocio y las interacciones con aplicaciones externas (APIs, base de datos...).

De esta forma, se consigue una aplicación donde la lógica de negocio fundamental está altamente desacoplada, otorgando una gran escalabilidad y flexibilidad ante cambios en el alcance.

El patrón de diseño seleccionado para el desarrollo ha sido el patrón **Adapter**, dado que es un tipo de patrón de diseño estructural que permite la colaboración entre objetos e interfaces que no son directamente compatibles.

En el caso de la arquitectura hexagonal, sería el mecanismo encargado de conectar el núcleo de dominio con las implementaciones externas, siendo el medio que garantiza el desacople de este núcleo de negocio y resultando en la opción ideal para la arquitectura seleccionada.

## Instalación y ejecución del proyecto

## EndPoints del proyecto

## Acceso a la base de datos

La base de datos se inicializa automáticamente con los datos de ejemplo aportados en la definición de la prueba al iniciar la aplicación. Es posible acceder a la consola de H2 para inspeccionar los datos de la siguiente forma:

1. Inicia la aplicación.

2. Accede a la consola de H2 en: http://localhost:9080/h2-console

3. Usa las siguientes credenciales:

    - JDBC URL: jdbc:h2:mem:testdb
    - Usuario: sa
    - Contraseña: (vacío)

## Ejecución de tests y linter seleccionado