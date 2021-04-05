# Tema 3:Diseño conceptual 
## Introducción 
Esta unidad describe alguna técnicas para pasar del análisis de requisistos al diseño físico de un interfaz de usuario. 
#### Reingeniería del trabajo 
-  A menudo se desarrollará una nueva versión de un sistema existente 
- Quizá los usuarios tengan que empezar a trabajar de forma diferente 
	-  Gestión sensible: involucrar a los usuarios en el proceso de desarrollo
#### Objetivos 
- Concienciarse de la potencia y eficiencia que hace posible la automatización
- Rediseñar el trabajo para dar un apoyo más efectivo a los objetivos del negocio
- Minimizar el reentrenamiento: aprovechar el conocimiento actual del usuario y tener en cuenta las limitaciones cognitivas y las capacidades del usuario al diseñar nuevas tarea

## Diseño conceptual 
El diseño conceptual es el proceso de establecer la organización y estructura subyacentes a la interfaz de usuario, decidiendo que funcionalidad debe soportar cada pantalla.

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
Los objetos pueden ser clasificados entre Primarios y Secundarios. Los objetos de tarea primarios son los objetos con los que se trabaja directamente para el desempeño de la tarea. Los secundarios explican o describen los objetos primarios. 

Se usan para decidir qué va en cada contenedor y para establecer los enlaces entre contenedores

Similar al diseño orientado a objetos:
- **Objetos de tarea primarios:** entidades con información o datos con las que interactúa el usuario para llevar a cabo sus tareas
	- Objetos de alto nivel; suele haber unos pocos
		- *Ejemplos: libro, CD-ROM, vídeo, revista, profesor, investigador, estudiante*
	- Dónde buscar objetos de tarea: en la documentación de los requisitos y en los casos de uso concretos
		- *Consejo: encontrar unidades de información que se buscan o modifican de alguna manera; también artefactos como formularios, documentos, papeles, listas, etc*
- **Atributos:** las propiedades de los objetos de tarea o enlaces a otros objetos
	- Un objeto de tarea tiene que tener atributos, si no es un atributo de otro objeto
	- Dos tipos de atributos: 
		- Propiedades: datos que pertenecen exclusivamente al objeto
		- Objetos hijo: son objetos de tarea por sí mismos, pero a su vez atributos de otro u otros objetos
			- En una interfaz el objeto hijo aparece cuando se muestra el padre, normalmente dentro de él con todos sus atributos o con una parte de ello
	- En la interfaz los objetos de tarea y sus atributos se traducen en una combinación de elementos como listas, combo boxes, botones de radio, cajas de texto, etc.
- **Acciones:** funciones que puede realizar el usuario sobre los objetos de tarea
	- Los usuarios realizan acciones sobre los objetos de tarea (reservar un vuelo, hacer un pedido, buscar un libro, etc.)
	- Además de las acciones específicas de los objetos de tarea, se deben considerar acciones estándar como ver, crear, borrar, copiar, guardar, editar, imprimir, etc.
	- En la interfaz, las acciones se representan mediante opciones de menú, botones en la barra de herramientas, un hiperenlace en una página web, etc.

¿Cómo usar casos de uso concretos para identificar los objetos de tarea y sus atributos?
- Subrayado simple para nombres que pueden corresponder a objetos de tarea 
- Subrayado doble para los atributos de esos objetos de tarea

Normalmente los verbos corresponden a acciones, pero no los marcamos porque las relaciones entre ellos y los objetos suelen menos directas. 

Tras identificar los objetos de tarea  y los atributos, se agrupan en una tabla por objeto de tarea. 

Como es difícil captura todos los objetos de tarea, atributos y acciones de los casos de uso concretos, se debe utilizar una estrategia iterativa. 
- Buscar información en los casos concretos de uso, pero también en el conocimiento  del usuario del dominio y en nuestro propio análisis del dominio
- Prototipa tus ideas y evalúalas con los usuarios

#### Paso 2: Identifica los contenedores y los objetos de tarea que van en cada uno de ellos
#### Paso 3: Conectar los contenedores para mostrar el flujo de la navegación
