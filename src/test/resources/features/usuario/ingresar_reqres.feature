#language: es
Característica: Ingresar usuario en el sistema
  Yo como usuario logueado en el sistema
  Quiero crear un usuario
  Para consultarlo en el sistema

  Escenario: ingresar usuario
    Dado que se ingresa en el sistema con email 'eve.holt@reqres.in' y contraseña cityslicka
    Cuando creo el usuario con nombre defex y trabajo ingeniero
    Entonces valido que la lista de usuarios se encuentre poblada