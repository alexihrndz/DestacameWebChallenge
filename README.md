# Challenge Web Destacame

Descripción del reto:

Prueba Automatización Front
Entrar en pc Factory: www.pcfactory.cl
Ingresar en el buscador "Notebook Gamer Nitro 5 Intel i5-11400H NVIDIA GTX 1650 15.6" FHD 144Hz 16GB RAM 512GB SSD Windows 11"
Seleccionar un elemento de los listados y agrégalos al carro de compras
Comprobar el mensaje de "¡Felicidades! Agregaste" cuando se ingresa un producto
Volver a buscar otro producto a elección (p.e. Placa madre, monitor)
Agregar otro producto al carro de compras
Comprobar el mensaje de "¡Felicidades! Agregaste" cuando se ingresa un producto
Clicar en "mi carro"
Verificar que el total precio normal sea menor a 1.000.000 (un millón)


Si no se cumple la condición
Desplegar mensaje por consola monto mayor al presupuesto
Eliminar el producto "Notebook Gamer Nitro 5 Intel i5-11400H NVIDIA GTX 1650 15.6" FHD 144Hz 16GB RAM 512GB SSD Windows 11"
Clicar en botón Comprar
seleccionar la opción seguir como invitado
Opción retiro inmediato en tienda
Seleccionar tienda la Serena
Validar dirección "Arturo Prat 620, LA SERENA, La Serena" (si está bloqueado cambiar sucursal a la que exista producto)
Clicar continuar con el pago y desplegar un mensaje por consola indicando "se realiza la compra"


Si se cumple la condición clicar en botón Comprar
Seleccionar la opción seguir como invitado
Opción retiro inmediato en tienda
Seleccionar tienda la Serena
Validar dirección "Arturo Prat 620, LA SERENA, La Serena" (si está bloqueado cambiar sucursal a la que exista producto)
Clicar continuar con el pago y desplegar un mensaje por consola indicando " se realiza la compra"

Pistas: los botones tienen ID ( privilegiar el uso de Id o Name por sobre generar Xpath)
Generar los 2 casos de prueba (el de éxito de compra y el no exitoso)



# Automatización de pruebas UI 🤖 en entornos web

## Contenido ##

- [Estructura de Directorios](#estructura-de-directorios) 🌐
- [Pre-requisitos](#pre-requisitos-) 📄
- [Configuracion](#configuracion-) ⚙️
- [Ejecucion](#ejecucion-) 🚀
- [Reportes](#reportes-) 📊 
  - [Evidencias](https://alexihrndz.github.io/destacame.cl/web-report/index.html)
- [Recursos de interés](#recursos-de-interés--) 👩‍💻 👨‍💻
  
# Estructura de Directorios

```
project-automation-web
|-- pom.xml
|-- serenity.properties
`-- src
    |-- main
    |   `-- java
    |       `-- cl.pcfactory
    |           `-- models
    |           `-- utils
    |
    `-- test
        `-- java
        |   `-- cl.pcfactory
        |       `-- interactions
        |       `-- questions
        |       `-- runners
        |       `-- stepdefinitions
        |       `-- tasks
        |       `-- userinterfaces
        |
        `-- resources
            `-- features 
            `-- serenity.conf
```            

# Pre requisitos 📄

- SDK Java 11 
- Serenity BDD 3.2.0 
- Apache Maven 3.8.4

# Configuracion ⚙️
# Ejecucion 🚀

mvn clean test serenity:aggregate

# Reportes 📊

# Recursos de interés 👩‍💻 👨‍💻
- [Selenium](https://www.selenium.dev/documentation/)
  - [Screenplay](https://medium.com/testvagrant/screenplay-pattern-3490c7f0c23c)
  - [Serenity BDD](https://youtube.com/playlist?list=PLeo6Q1inqlOcct4kW0L3HQJubwZqJVLd7)

Autor: 
  - Alexi Hernandez   🤖
  
