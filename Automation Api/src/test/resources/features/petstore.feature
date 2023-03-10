# author: Alexi Hernandez
# language: es

Característica: Pruebas de servicios Rest
  Como QA Automation
  Quiero hacer pruebas de servicios rest de petstore
  Para mejorar mis skills tecnicos

  @createPet
  Escenario: Crear mascotas en petstore
    Dado que QA Robot define la url https://petstore.swagger.io y path /v2/pet
    Y body request: requests/createPetRq.json
    Cuando ejecuta el metodo POST
    Entonces el puede ver status 200
    Y valida el schema segun el archivo: responses/createPetRsSchemaValidate.json

  @getPet
  Escenario: Consultar mascotas en petstore
    Dado que QA Robot define la url https://petstore.swagger.io y path /v2/pet
    Y en los queryParams agrega id creado en el create anterior
    Cuando ejecuta el metodo GET
    Entonces el puede ver status 200
    Y valida el schema segun el archivo: responses/getPetRsSchemaValidate.json

  @putPet
  Escenario: Actualiza datos de mascotas en petstore
    Dado que QA Robot define la url https://petstore.swagger.io y path /v2/pet
    Y body request update: requests/updatePetRq.json
    Y agrega el id anterior al request
    Cuando ejecuta el metodo PUT
    Entonces el puede ver status 200
    Y valida el schema segun el archivo: responses/putPetRsSchemaValidate.json

