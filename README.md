# Back-end Supplies Communications

Microservicio de comunicaciones para el sistema de suministros que se encarga de recibir eventos de RabbitMQ y enviar notificaciones por correo electrónico.

## Funcionalidades

- Recibe eventos de pedidos creados desde el tópico `pedidos.creados` de RabbitMQ
- Envía notificaciones por correo electrónico cuando se crea un nuevo pedido
- Configuración flexible para diferentes proveedores de correo

## Configuración de Gmail

Para usar Gmail como proveedor de correo:

1. Habilitar la autenticación de dos factores en tu cuenta de Gmail
2. Generar una contraseña de aplicación [aquí](https://myaccount.google.com/apppasswords)
3. Configurar las variables de entorno:
   - `EMAIL_USERNAME`: tu-email@gmail.com
   - `EMAIL_PASSWORD`: tu-contraseña-de-aplicacion
   - Ajusta también `email.notification.to` y `email.notification.from` en `application.yml` con los valores que consideres.
