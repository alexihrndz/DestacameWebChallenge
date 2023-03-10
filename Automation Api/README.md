# Challenge Apis Destacame

Descripción del reto:

Tomando como referencia lo documentado en este swagger: https://petstore.swagger.io .
Agregar una mascota realizando un post al path /v2/pet.
Realizar un get /v2/pet{petId}´para obtener una mascota existente
Modificar una mascota existente Mediante un put al path /v2/pet.

En todos los casos Validar :
Status code esperado
Schema del Response.

# Automatización de pruebas de integracion 🤖 consumo de servicios rest

## Contenido ##

- [Estructura de Directorios](#estructura-de-directorios) 🌐
- [Pre-requisitos](#pre-requisitos-) 📄
- [Configuracion](#configuracion-) ⚙️
- [Ejecucion](#ejecucion-) 🚀
- [Reportes](#reportes-) 📊
    - [Evidencias](https://alexihrndz.github.io/destacame.cl/api-report/index.html)
- [Recursos de interés](#recursos-de-interés--) 👩‍💻 👨‍💻

# Estructura de Directorios

```
project-automation-web
|-- pom.xml
|-- serenity.properties
`-- src
    |-- main
    |   `-- java
    |       `-- com.petstore
    |           `-- models
    |           `-- utils
    |
    `-- test
        `-- java
        |   `-- com.petstore
        |       `-- questions
        |       `-- runners
        |       `-- stepdefinitions
        |       `-- tasks
        |
        `-- resources
            `-- features 
            `-- serenity.conf
```            

# Pre requisitos 📄

- SDK Java 11
- Serenity BDD 3.6.12
- Apache Maven 3.8.4

# Configuracion ⚙️
# Ejecucion 🚀

mvn clean test serenity:aggregate

# Recursos de interés 👩‍💻 👨‍💻
- [Selenium](https://www.selenium.dev/documentation/)
    - [Screenplay](https://medium.com/testvagrant/screenplay-pattern-3490c7f0c23c)
    - [Serenity BDD](https://youtube.com/playlist?list=PLeo6Q1inqlOcct4kW0L3HQJubwZqJVLd7)
    - [Serenity BDD Rest](https://github.com/serenity-bdd/serenity-rest-starter)
    - [Json Schema Validator](https://www.liquid-technologies.com/online-json-to-schema-converter)

Autor:
- Alexi Hernandez   🤖
  
