# ebookme
[![Stories in Ready](https://badge.waffle.io/poolebu/ebookme.png?label=ready&title=Ready)](http://waffle.io/poolebu/ebookme)

### Instrucciones Heroku Generales

https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku


Para crearlo con heroku

1- En tu compu, desde heroku client, hacer
    spring init --dependencies=web name-app

2- Intellij - > create from existing sources -> create from maven -> next,next,next

Debe servir de una packet desde maven en intellij y darle a play desde heroku

3- Cambiar los meta-tags con maven: groupId, artifactId, name, description, etc...

4- Crear el Procfile, debes usar el mismo nombre usado en la concatenacion de lo tags de maven:
    name-version, eg:
    web: java -Dserver.port=$PORT -jar  target/ebookme-0.0.1-SNAPSHOT.jar

5- Crear un git, un .gitignore con los archivos a ignorar y hacer commit, 
    Si ya creaste unos archivos y le hiciste commit y ahora los quieres ignorar, entonces debes hacer `git rm --cached  file-name` por cada archivo, si es una carpeta usar `-r`, luego hacer commit de eso, git los tomara como que si los borraste 

6 - Crear app con 
    heroku create
    Creating salty-refuge-1539... done, stack is cedar-14

    This also creates a remote repository called heroku in your local git repo. Heroku generates a random name

7- push al master de heroku:
    git push heroku master
 
8 - heroku logs --tail para ver el log, si tienes mas de una app, o el heroku se confunde, especificar app para el tail con: 
`heroku logs --tail --app NOMBRE_DE_APP_EN_HOROKU`

9 - `heroku open` es un shortcut para abrir en el browser

10- para renombrar la app: `heroku apps:rename NUEVO_NOMBRE`

### Integracion con github

1- Crear al github el proyecto vacio con el mismo nombre

2- desde la consola, agregar el nuevo origin
    git remote add origin https://github.com/poolebu/ebookme.git

3- En heroku meter la info del proyecto en la pestaña de deploy, y cuando se quiera poner online, se va a ´Manual´ y se levanta el proyecto.

