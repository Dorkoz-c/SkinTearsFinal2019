# Skin Tears App 1.5

**Proyecto mejorado y actualizado en 2022 por equipo de estudiantes del MCC de la Universidad Andrés Bello.

## Integraciones de la nueva versión de la Aplicación.
>* Se actualizaron las librerias y versiones del proyecto en AndroidStudio para su uso correspondiente.
>* Se modificó la sección de Compartir Imagen para poder subir una imagen junto con un comentario del usuario a una página web.
>* Se creó una página web en base a PHP que permite mostrar las imágenes y comentarios realizados por usuarios para luego ser respondidas estos últimos por parte de un experto con acceso a la pagina en cuestión.
>* Se integró el classifier de heridas en la sección de Compartir Imagen para realizar un análisis de las imágenes subidas por el usuario y así enviar la "opinion" del modelo sobre la herida.
>* Se deja a dispisición para uso futuro una carpeta que contiene los archivos necesarios para correr la página PHP.
>* Se actualizó el archivo apk.
>* Se crearon distintos diagramas que explican el modelo actual de la página, se encuentra en la carpeta Diagramas
>* Se mantiene una versión de la aplicación denominada "v1.5 SkinTearsApp-login", versión en la que se intentó integrar un login mediante SQLite y FIrebase Auth pero sin resultados positivos.

**Pasos para levantar la página web. 
>* Ir al sitio o VM escogido para el levantamiento de la aplicación.
>* Subir los archivos encontrados en la carpeta "codigo pagina/public_html"
>* Rescatar la nueva dirección de la página en cuestrión y pegar esta la clase "SubirImagenActivity" en las primeras líneas de código, reemplazando la página ahí puesta.
>* Listo para usar.

**Integrantes de la nueva versión de la App.
>* Javier Cordero
>* Vincent Depassier
>* Rodolfo Valentín

# Skin Tears App

Proyecto de Titulo para la Carrera de Ingeniería en Computación e Informatica Universidad Andrés Bello.

**Sistema educativo con capacidad de reconocimiento de heridas, como método de apoyo a su clasificación (S.E.R.H.).**


## Requerimientos mínimos de la Aplicación para su instalación.

Para que la aplicación funcione adecuadamente, el SmartPhone debe tener como mínimo las siguientes caracteristicas:

>* Sistema Operativo: Android 5.0 o Lollipop
>* Espacio libre: 95 MB
>* Procesador: 1,2 Quadcore
>* Memoria: 1 GB
>* Camara fotográfica
>* Acceso a Internet

La aplicación fue instalada en los siguientes dispositivos:
>* Motorola moto G 6 Play
>* Samsung Galaxy Note 9
>* LG K10 v2017
>* Samsung Galaxy S 7
>* Samsung Galaxy J 7 Neo
>* Samsung Galaxy J 3 v2016


## Software de desarrollo de la Aplicación.

Los requerimientos mínimos de Software que aseguran una exitosa instalación del proyecto en el equipo para su correcto desarrollo.

>* Android Studio versión 3.5
>* Python versión 2.7
>* GitHub Desktop versión 2.1.2
>* Sistema Operativo no afecta la instalación debido a que el Software puede ser instalado en Linux, Windows o Mac.


## Funcionamiento de la Aplicación.

Se debe iniciar la aplicación desde su icono, al iniciar la aplicación se accede al menú quien presenta las siguientes opciones:

>* MóduloEducativo.
>* MóduloTratamientos.
>* Módulo Evaluaciones.
>* MóduloReconocimiento.
>* MóduloCompartirImagen.

#### A. Módulo Educativo:
Desde aquí puede acceder a la activity que contiene los accesos mediante opciones a la documentación relacionada a heridas Skin Tears o información que sea interesante de aprender por parte de los usuarios.

#### B. Módulo Tratamientos:
Desde aquí puede acceder a la activity que contiene los accesos mediante opciones a la documentación relacionada a tratamientos de heridas Skin Tears.

#### C. Módulo Evaluaciones:
Desde esta opción el usuario va a poder poner a prueba sus conocimientos midiéndolos a través de 10 preguntas, si la respuesta seleccionada es correcta se escucha un sonido de acierto y pasa a la pregunta siguiente, si se equivoca se escucha un sonido de error y la aplicación pregunta se desea salir de la evaluación o continuar pero pierde un punto, luego de responder 10 preguntas, se muestra el resultado obtenido al usuario.

#### D. Módulo Reconocimiento:
Este módulo está entrenado para reconocer heridas, esta acción la realiza en tiempo real y va indicando el porcentaje de exactitud con el que reconoce una herida, la acción de reconocimiento se inicia al hacer click en el botón que está en la activity de este módulo, luego de que el usuario lea las instrucciones de uso, que principalmente aconsejan, que exista una buena iluminación y que se logre un buen enfoque de la zona donde está ubicada la herida.

#### E. Módulo compartir imagen:
Este módulo permite al usuario, compartir una imagen, esta puede estar alojada en la galería de imágenes del teléfono o puede ser tomada por la cámara, luego de una de estas opciones se puede subir a un servidor web, junto a un comentario que indique el tipo de herida que se está subiendo, el propósito de este módulo es que los usuarios compartan imágenes para que en un futuro se reentrene un nuevo clasificador de heridas y se actualice la aplicación con un nueva versión.

Cuando el usuario llega al menú principal de cada módulo, si desea salir debe presionar el botón atrás de la barra inferior del Smartphone y confirmar que desea salir.

En las imágenes siguientes se puede apreciar el flujo de la aplicación, el cual es de arriba hacia abajo, siguiendo el orden de las distintas opciones.


![Flujo1](https://github.com/claudiocu81/SkinTearsFinal2019/blob/master/imagenes/FlujoApp1.JPG)
![Flujo2](https://github.com/claudiocu81/SkinTearsFinal2019/blob/master/imagenes/FlujoApp2.JPG)


## Instalación de la Aplicación.

La instalación de la aplicación en su dispositivo, la puede realizar mediante 2 métodos:

#### A.	Instalación mediante archivo .apk.:
Descargar archivo desde el siguiente link:

>* https://drive.google.com/open?id=1Uqan6MGM82INTJlcp1xgdqh7f9DJjxFk
>* Luego instálelo en su dispositivo.
>* En caso de que no deje instalar la aplicación por no hacerlo desde PlayStore, se debe activar la instalación de aplicaciones de orígenes desconocidas.

#### B.	Instalación mediante GitHub:
Descargar el proyecto desde el siguiente Link:

>* git clone https://github.com/claudiocu81/SkinTearsFinal2019.git
>* Luego debe instalar Android Studio
>* Importar el proyecto en Android Studio
>* Instalarlo en el emulador o en su dispositivo, seleccionando la opción deseada desde el menú, o el botón al lado izquierdo de Run.
>* Puede que le solicite instalar dependencias adicionales, verifique el archivo Gradle(App) y sincronize luego de realizar cambios.


## Autores del Proyecto Original.

>* Autor: **Claudio Cabrera**
>* Profesor Guía: **Diego Mellado**


