# Tema 3: Diseño conceptual 
## Introducción 
Esta unidad describe algunas técnicas para pasar del análisis de requisistos al diseño físico de un interfaz de usuario. 
#### Reingeniería del trabajo 
-  A menudo se desarrollará una nueva versión de un sistema existente 
- Quizás los usuarios tengan que empezar a trabajar de forma diferente 
	-  Gestión sensible: involucrar a los usuarios en el proceso de desarrollo
#### Objetivos 
- Concienciarse de la potencia y eficiencia que hace posible la automatización
- Rediseñar el trabajo para dar un apoyo más efectivo a los objetivos del negocio
- Minimizar el reentrenamiento: aprovechar el conocimiento actual del usuario y tener en cuenta las limitaciones cognitivas y las capacidades del usuario al diseñar nuevas tareas

## Diseño conceptual 
El diseño conceptual es el proceso de establecer la organización y estructura subyacentes a la interfaz de usuario, decidiendo qué funcionalidad debe soportar cada pantalla.

Es el proceso que nos llevará desde los casos de uso hasta el diseño de nuestra interfaz, es decir, el proceso que, a partir del resultado de la fase de análisis, ayudará a decidir el diseño de la interfaz.

#### Diagrama de contenidos 
Un diagrama de contenidos es un prototipo de baja fidelidad que representa la organización y la estructura de una interfaz desde el punto de vista del diseñador 
![enter image description here](https://media.discordapp.net/attachments/705068953315311717/828659413682094120/unknown.png?width=1433&height=366)
En estos encontramos dos componentes: 
- Contenedor: representación abstracta de parte del trabajo del usuario y las funciones que soportan
	- Ejemplo: introducir los criterios de búsqueda de un libro 
- Enlaces: representan la navegación del usuario entre las distintas áreas funcionales dentro la interfaz. 

El diagrama de contenidos se crea a partir de información obtenida durante la recopilación de requisitos y a partir de los casos de uso concretos. Será probablemente incompleto, pero es útil para identificar las áreas funcionales principales y las relaciones entre ellas.
### Procedimiento
Pasos para crear un diagrama de contenidos 

 1. Identificar los objetos de tarea primarios, los atributos y las acciones
 2. Identificar los contenedores y los objetos de tarea que van en cada uno de ellos
 3. Conectar los contenedores para mostrar el flujo de la navegación
 
 Es un proceso creativo y debe mejorarse iterativamente 
 
#### Paso 1: Identificar los objetos de tarea primarios, los atributos y las acciones
Los objetos se usan para decidir qué va en cada contenedor y para establecer los enlaces entre contenedores. Pueden ser clasificados entre Primarios y Secundarios. Los objetos de tarea primarios son los objetos con los que se trabaja directamente para el desempeño de la tarea. Los secundarios explican o describen los objetos primarios. 

Son similares al diseño orientado a objetos:
- **Objetos de tarea primarios:** entidades con información o datos con las que interactúa el usuario para llevar a cabo sus tareas
	- Objetos de alto nivel: suele haber unos pocos
		- *Ejemplos: libro, CD-ROM, vídeo, revista, profesor, investigador, estudiante*
	- Dónde buscar objetos de tarea: en la documentación de los requisitos y en los casos de uso concretos
		- *Consejo: encontrar unidades de información que se buscan o modifican de alguna manera; también artefactos como formularios, documentos, papeles, listas, etc*
- **Atributos:** las propiedades de los objetos de tarea o enlaces a otros objetos
	- Un objeto de tarea tiene que tener atributos (si no es un atributo de otro objeto)
	- Dos tipos de atributos: 
		- Propiedades: datos que pertenecen exclusivamente al objeto
		- Objetos hijo: son objetos de tarea por sí mismos, pero a su vez atributos de otro u otros objetos
			- En una interfaz el objeto hijo aparece cuando se muestra el padre, normalmente dentro de él con todos sus atributos o con una parte de ellos
	- En la interfaz, los objetos de tarea y sus atributos se traducen en una combinación de elementos como listas, combo boxes, botones de radio, cajas de texto, etc.
- **Acciones:** funciones que puede realizar el usuario sobre los objetos de tarea
	- Los usuarios realizan acciones sobre los objetos de tarea (reservar un vuelo, hacer un pedido, buscar un libro, etc.)
	- Además de las acciones específicas de los objetos de tarea, se deben considerar acciones estándar como ver, crear, borrar, copiar, guardar, editar, imprimir, etc.
	- En la interfaz, las acciones se representan mediante opciones de menú, botones en la barra de herramientas, un hiperenlace en una página web, etc.

¿Cómo usar casos de uso concretos para identificar los objetos de tarea y sus atributos?
- Subrayado simple para nombres que pueden corresponder a objetos de tarea 
- Subrayado doble para los atributos de esos objetos de tarea

Normalmente los verbos corresponden a acciones, pero no los marcamos porque las relaciones entre ellos y los objetos suelen menos directas. 

Tras identificar los objetos de tarea  y los atributos, se agrupan en una tabla por objeto de tarea. 

Como es difícil capturar todos los objetos de tarea, atributos y acciones de los casos de uso concretos, se debe utilizar una estrategia iterativa. 
- Buscar información en los casos concretos de uso, pero también en el conocimiento  del usuario del dominio y en nuestro propio análisis del dominio
- Prototipa tus ideas y evalúalas con los usuarios

#### Paso 2: Identifica los contenedores y los objetos de tarea que van en cada uno de ellos
Cada contenedor ayuda al usuario a realizar un cierto trabajo agrupando las funciones y los objetos de tarea necesarios. Más adelante se convertirán en pantallas, ventanas o cuadros de diálogo y en el paso 3 conectaremos los contenedores con enlaces
Elementos en un contenedor:
- **Nombre:** el nombre del contenedor
- **Propósito:** una frase indicando cómo va a soportar la tarea del usuario
- **Funciones:** (circulo) invocadas por el usuario, (cuadrado) invocadas por el sistema
- **Enlaces:** nombres de contenedores con los que está conectado: (flecha) el nuevo contenedor sustituye al actual, (flecha doble) los dos contenedores trabajan en paralelo
- **Objetos:** los objetos de tarea cuyos atributos y acciones son necesarios para el contenedor
- **Restricciones:** cualquier restricción para el contenedor, como velocidad, fiabilidad y disponibilidad

Plantilla para contenedores:

![enter image description here](https://media.discordapp.net/attachments/705068953315311717/828948939133681684/unknown.png)

##### Contenedor principal
El contenedor principal representa la primera pantalla que se encuentra el usuario que tendrá enlaces a:
- Tareas vitales: el usuario tendrá que realizar estas tareas rápidamente, aun en condiciones de estrés
- Tareas frecuentes: tareas en las que el usuario emplea la mayor parte del tiempo: debe ser rápido acceder a ellas
- Ayudas de navegación: facilitan al usuario encontrar aquello que es capaz de hacer la aplicación

El contenedor principal no realiza ninguna de esas acciones, sólo proporciona enlaces a los contenedores que las realizarán
##### Otros contenedores 
Derivan de los casos de uso concretos (cada caso de uso muestra la secuencia de pasos necesarios para realizar una tarea particular)

La funcionalidad de la tarea puede dividirse entre uno o más contenedores
#### Paso 3: Conectar los contenedores para mostrar el flujo de la navegación
Los enlaces reflejan el orden de las acciones que sigue el usuario para realizar una tarea determinada. Normalmente la identificación y los enlaces de los contenedores se hacen en paralelo

Recuerda, los enlaces pueden ser: 
- `>` con una flecha (el nuevo contenedor sustituye al actual)
- `>>` con dos flechas (los dos contenedores trabajan en paralelo)

Los enlaces se pueden etiquetar mediante condiciones de interacción, que indican condiciones en que el flujo puede atravesar el enlace.

Crear un diagrama de contenidos para una aplicación compleja es difícil, por lo tanto se deben hacer varias iteraciones sobre los prototipos correspondientes.

Para evaluar el diagrama de contenidos, se deben hacer varias pasadas por los casos de uso concreto, de este modo se garantiza que los contenedores soportan la funcionalidad necesaria y que los enlaces permiten al usuario acceder a ellos.
