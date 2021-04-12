# Tema 2: Analisis de requisitos 

#### Introducción:
los análisis de requisitos se encuentran en la cima del ciclo de desarrollo de software.

#### Diseño centrado en el usuario (DCU):

Involucra a los usuarios durante el proceso de diseño y desarrollo. Se centra en entender a los usuarios, las tareas que realizan con el sistema, y los entornos en los que se usará el sistema.

Los usuarios son clientes (que pagan y dan las especificaciones del sistema), otras personas en la organización con intereses en el desarrollo, usuarios finales (que son los que realmente interactúan directamente con el sistema), etc. A todos ellos se los conoce como interesados (stakeholders). Hay usuarios primarios (p.e., el bibliotecario o el agente de viajes) y usuarios secundarios (la persona que se lleva prestado un libro de la biblioteca, o que reserva un vuelo).

Principios del DCU
-  Implicación activa de los usuarios 
-	Asignación apropiada de funciones entre usuario y sistema 
-	La iteración de soluciones de diseño 
-	Equipos de diseño multidisciplinar 

Actividades en el DCU 

-	Entender y especificar el contexto de uso 
-	Especificar los requisitos del usuario y de la organización 
-	Producir soluciones (prototipos) 
-	Evaluar diseños con los usuarios a partir de los requisitos

Ciclo de vida en estrella:

![](https://media.discordapp.net/attachments/705068953315311717/830437997450362920/unknown.png?width=695&height=408)

¿Cuándo y cómo implicar a los usuarios?
-	Pronto: durante la especificación de requisitos 
-	Durante el prototipado, para probar diseños y opciones 
-	Justo antes de publicar el sistema 
-	Durante la formación, después de publicar el sistema

Cuanto más tarde en el proceso, menos cambios se podrán realizar


#### Analisis de requisitos

Un requisito es una declaración sobre un futuro producto que especifica qué debería hacer o cómo debería comportarse. Se pueden definir con distintos niveles de abstracción y normalmente se obtienen mediante observación, entrevistas o encuestas. Suelen describir lo que debería hacer el sistema, y no cómo. Ejemplo: “El usuario deberá poder obtener la factura de su compra. La factura estará disponible en formato pdf.”

Dos tipos de  requisitos:
- **Funcionales:** qué debe hacer el sistema.
	-  “El procesador de texto debería permitir establecer el formato a nivel de documento, página, palabra y letra”.
	- “Debería haber al menos 20 fuentes, cada una con las variantes normal, negrita y cursiva”
- **No funcionales:** restricciones sobre el sistema y su desarrollo.
	- “Debería poder ejecutarse en Windows, Mac y Linux”. 
	- “La página web debería cargarse en menos de 5 s”.
	- “El desarrollo del sistema debería durar menos de 6 meses”.
	-  Ajustarse a estándares de calidad, diseño, seguridad, accesibilidad, usabilidad…


La Especificación de Requisitos Software es el resultado de la fase de análisis de requisitos. Es un documento que recoge todos los requisitos de una forma estructurada. Distintos estándares: 
- IEEE 29148-2011 - Systems and software engineering — Life cycle processes — Requirements engineering. 2011 
	- Este estándar reemplaza a IEEE 830-1998, IEEE 1233-1998, IEEE 1362-1998 
- Volere


#### Recoger información para el análisis:
se pueden realizar distintos estudios al hacer un análisis de requisitos
##### Estudios etnográficos:
observar a los usuarios mientras que hacen trabajo real en su lugar real de trabajo, o usando un sistema en sus casas. Saber qué hacen los usuarios, pero también qué les gusta o no

Tipos de observación:
- **Directa:** Estudios de campo: el observador toma notas sobre comportamientos interesantes en el lugar de trabajo/hogar 
	-  Estudios controlados: el usuario interacciona con el sistema en un entorno controlado (normalmente un laboratorio de usabilidad) 
	- Ventajas: fácil, genera resultados interesantes 
    - Desventajas: sólo una oportunidad para capturar la información, difícil anotar todos los aspectos de la actividad, lo que no se anota, se pierde, es intrusivo y puede alterar el comportamiento y el rendimiento de los usuarios
 -  **Indirecta** 
	 -  Grabar en vídeo, captura de pulsaciones de teclado/ratón, etc. 
	 -  Ventajas: se captura toda la interacción, más objetivo 
	 - Desventajas: el análisis de los datos es costoso, algunos usuarios pueden sentirse intimidados

Resultado: descripción actividades, puestos de trabajo, reglas, grabaciones y fotografías, entrevistas informales a los participantes explicando las actividades, diagramas y flujos de trabajo, catalogo de artefactos relevantes en el lugar de trabajo.

##### Estudios de usuarios
Estudiando a los usuarios y el dominio: describe y clasifica a los usuarios según sus características (edad, genero, habilidades y discapacidades, educación, etc). Entrevista usuarios reales o expertos del domino.

Extraer grupos de usuario, y centrar el diseño en esos grupos: una persona de un grupo interacciona con el sistema de forma diferente a otra de otro grupo.

-  Usuarios noveles o primerizos: carencia de experiencia produce ansiedad. Ayuda online, caja de diálogos, mensajes de error constructivos. 
-  Usuarios ocasionales expertos: dificultad retener estructura de los menús. Menús ordenados, enfatizar en el reconocimiento mas que en la memoria. 
-  Usuarios frecuentes expertos: respuestas rápidas, realimentación breve. Instrucciones cortas y concisas, uso de marcos y aceleradores.

Diseñar una interfaz para un tipo de usuario es fácil. Diseñar una interfaz para diferentes niveles de experiencia es complicado (multi-capa). 

-  Usuarios noveles -> interfaz simple y reducida. 
-  Mayor progreso del usuario -> herramientas de mayor nivel. 
-  Diseño multi-capa a la ayuda online, tutoriales. 
-  Permitir al usuario configurar el entorno.

Entrevista: muy importantes, saber a quien entrevistar, que preguntar, duración.

-  Estructuradas: preguntas predefinidas -> fácil realizar y analizar. 
-  Flexibles: temas predefinidos -> menos formal, más información y opiniones. 
-  Entrevistado cómodo, realizar pequeño estudio piloto y luego grabar las entrevistas, empezar con preguntas abiertas. 
-  No hacer preguntas dirigidas, no preguntas que les gustaría en casos hipotéticos, frecuencia de hacer las cosas, cuanto les gusta algo, preguntas binarias. 
-  Prestar atención a lo que responden y hacen. 
-  La gente intenta no parecer torpe, responder lo que cree que el entrevistador quiere oír y no es consciente de su comportamiento.

Cuestionarios y encuestas: conjunto predefinido de preguntas.

-  Preguntas cerradas: Si/No, escala numérica. 
-  Preguntas abiertas: usuario responde libremente, más información y más difícil de analizar. 
-  Cuestionario: corto, capture la información buscada, opción de añadir comentarios.

##### Análisis de la competencia:

Un análisis competitivo permite establecer un punto de partida en el diseño. Hay que realizar una lista de la competencia, una tabla comparativa evaluando cada una, realizar una presentación para revisar los resultados. Revisar las versiones previas de la aplicación y compararlas con la competencia

##### Describiendo a los usuarios:
Personas: 
-  Modelo de una persona: motivación, gustos, intenciones, comportamientos, objetivos de la persona, actitud frente nuevas tecnologías y cómo usa el sistema actualmente. 
-  Dibujo de la persona o foto: nombre, edad, ocupación, antecedentes, situación social, objetivos, etc. Historia de la persona. 
-  Saber lo que piensa, hace y siente ayuda con la empatía: entender estado ánimo, emociones, creencias. 
-  Se construyen a partir de resultados de las entrevistas con usuarios reales.

Después de identificar a los usuarios, debemos entender los objetivos que tienen al usar el sistema
El Análisis de tareas es una actividad que estudia que debe hacer un sistema y la funcionalidad que debe ofrecer a los usuarios.

Objetivo: resultado final a obtener.

Tarea: conjunto estructurado de actividades realizadas en algún orden.

Acción: operación o paso individual de una tarea.

##### Obteniendo información
Se obtiene información sobre las tareas de usuario mediante entrevistas, observación, estudio de documentación, errores comunes, formas que el usuario realiza tareas que la interfaz no soporta, notas, post-it. 

Características de las tareas: cuanto cambian de una ocasión a otra, frecuencia, conocimiento necesario para su realización, como afecta al entorno, restricciones temporales, peligros de seguridad, tarea individual o colectiva, el usuario esta centrado en una tarea o varias. 

La secuencia de tareas para alcanzar un objetivo puede cambiar de usuario a usuario, la interfaz no debería imponer un orden en las tareas a menos que haya una razón de peso.

#### Describiendo las tareas 
##### Escenario de tarea 
Descripción narrativa de una tarea, tal y como se realiza en la actualidad. Cuenta una historia sobre el uso del sistema, son personalizadas (describen instancia y situación específica), detallada (procedimiento seguido por el usuario), problemas y dificultades. Se deben evaluar por los usuarios para comprobar que describen la tarea adecuadamente.
##### Escenario de uso 
similares al escenario de tarea, pero describen el uso previsto del sistema.

---
Los casos de uso se centran en los objetivos de los usuarios, pero haciendo hincapié en la interacción entre el usuario y el sistema, en vez de la tarea de usuario en sí
##### Casos de uso concretos 
Parecidos a los escenarios de tarea, pero no están personalizados. Se pueden escribir en dos columnas, una para las acciones de usuario y otra para las respuestas del sistema.
##### Análisis Jerárquico de tareas:
- Dividir tareas en subtareas, y estas en sub-subtareas, etc. 
-  Las subtareas se agrupan como planes que especifican cómo se realiza cierta tarea en una situación real. 
-  Se centra en las acciones físicas y observables realizadas (incluyendo acciones no relacionadas con software o sistema). 
-  Punto de partida es un objetivo del usuario.
##### Entorno de las tareas:
-  Físico: temperatura, ruido, diseño físico y distribución. 
-  Seguridad: ropa especial, contaminación, peligros. 
-  Social: estrés, coopera/trabaja solo, dependencias, jerarquía social. 
-  Organización: misión y objetivos, factores de trabajo (horario, grupos, gerencia, flexibilidad, control del rendimiento). 
-  Soporte de usuario:
##### Storyboards:
Secuencia ilustraciones, bocetos de eventos, tal y como se verían desde el lente de una cámara, explican una escena compleja, con personas y acciones.
-  Describen tareas. 
-  Hechos a mano. 
-  Muestra el flujo de la interacción y personas haciendo tareas para conseguir un objetivo.  
- No mucho tiempo a dibujar.

Deben transmitir:
-  Situación: gente, entorno, tarea a realizar. 
-  Secuencia: pasos a seguir, que hace que se vaya a utilizar la aplicación. 
-  Satisfacción: que motiva a usar el sistema, que permite que la gente consiga su objetivo, necesidad que resuelve la aplicación.

Ventajas: muestran como una interfaz realiza una tarea, no implica el uso de una interfaz particular, hace que diseñadores y usuarios se pongan de acuerdo en un objetivo.

