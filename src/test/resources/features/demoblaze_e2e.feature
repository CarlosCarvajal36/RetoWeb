# language: es
Característica: Gestión de registro e inicio de sesión en Demoblaze
  Como un usuario de la plataforma Demoblaze
  Quiero registrarme dinámicamente e iniciar sesión
  Para validar la autenticación exitosa en el sistema

  Escenario: Registro dinámico y autenticación exitosa
    Dado que el usuario genera un nuevo registro dinámico en Demoblaze
    Y el usuario inicia sesión con la cuenta recién creada
    Entonces debería visualizar el mensaje de bienvenida con su usuario