# ebookme
[![Stories in Ready](https://badge.waffle.io/poolebu/ebookme.png?label=ready&title=Ready)](http://waffle.io/poolebu/ebookme)

### Para probar desde la compu

#### Correr App
Desde
`src/main/ionic`
Correr
`ionic serve`

#### El backend 

Se inicia desde heroku, desplegano el master de este proyecto github.

` java -Dserver.port=$PORT -jar target/ebookme-0.0.1-SNAPSHOT.jar $EMAIL_LOGIN $EMAIL_PASSWORD $EGLUE_API_KEY `

Para ver o modificar estas variables, ir a heroku , cuenta de laslorma, y en settings, darle a reveal vars :)

#### Servidor que convierte ebooks

Ver proyecto https://github.com/poolebu/calibreServer
