#language: es
Característica: Comprar productos
  Yo como usuario de demoblaze
  Quiero agregar productos en mi carrito
  Para comprarlos

  Escenario: comprar laptop
    Dado que me encuentro en la pagina de demoblaze
    Y en la seccion de Laptops
    Cuando selecciono el producto 'Dell i7 8gb'
    Entonces se comprara el producto seleccionado con los siguientes datos de la tarjeta de credito
      | Nombre | País     | Cíudad   | TarjetaCredito | Mes | Año  |
      | Test   | Colombia | Medellin | 1234567        | 07  | 1996 |
    Y se vera el mensaje de confirmacion de la compra 'Thank'