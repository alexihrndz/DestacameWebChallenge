# author: Alexi Hernandez
# language: es

@comprasPCfactory
Característica: Compra de articulos en PC Factory
  Como gamer
  Quiero comprar un computador
  Para poder jugar en línea

  @compra1
  Escenario: Compra en PC Factory
    Dado que Gamer ingreso a la pagina http://www.pcfactory.cl/
    Cuando el busca el producto por descripcion y lo agrega al carrito
      | descripcion                                                                                          |
      | Notebook Gamer Nitro 5 Intel i5-11400H NVIDIA GTX 1650 15.6" FHD 144Hz 16GB RAM 512GB SSD Windows 11 |
      | iPhone 11 128GB - Blanco                                                                             |
    Cuando el continua la compra con la opcion de recoger en la tienda: La Serena
    Entonces verifica que la direccion de la tienda es: Arturo Prat 620, LA SERENA, La Serena
    Y termina la compra


  @compra2
  Escenario: Compra en PC Factory validacion monto total
    Dado que Gamer ingreso a la pagina http://www.pcfactory.cl/
    Cuando el busca el producto por descripcion y lo agrega al carrito
      | descripcion                                                                                          |
      | Notebook Gamer Nitro 5 Intel i5-11400H NVIDIA GTX 1650 15.6" FHD 144Hz 16GB RAM 512GB SSD Windows 11 |
      | iPhone 11 128GB - Blanco                                                                             |
    Pero verifica si el monto total de la compra es mayor a 1000000 y elimina:
      | descripcion                                                                                          |
      | Notebook Gamer Nitro 5 Intel i5-11400H NVIDIA GTX 1650 15.6" FHD 144Hz 16GB RAM 512GB SSD Windows 11 |
    Cuando el continua la compra con la opcion de recoger en la tienda: La Serena
    Entonces verifica que la direccion de la tienda es: Arturo Prat 620, LA SERENA, La Serena
    Y termina la compra

