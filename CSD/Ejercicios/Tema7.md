 
# Actividades Unidad 7 - Conceptos de Sistemas Distribuidos

## Actividad 1

### Objetivos: Caracterizar los principios de los sistemas distribuidos

Dadas las siguientes afirmaciones, idique si son Verdaderas (V) o Falsas (F).

|||
|--|--|
|Un sistema distribuido es también un sistema concurrente|V|
|*Justificación:* `Un sistema distribuido es una extensión natural de un sistema concurrente, cuando estos se ejecutan en más de un ordenador`||
|||
|||
|Es un sistema distribuido, sus nodos comparten memoria, así como la señal de reloj|F|
|*Justificación:* `Un ordenador no es ordenador del sistema distribuido, a nivel de hardware las máquinas son autónomas, no comparten, reloj, disco, etc.`||
|||
|||
|Un sistema distribuido está formado por máquinas autónomas que ofrece a sus usuarios la imagen de un sistema único, haciendo uso de algoritmos distribuidos.|V|
|*Justificación:* `Las máquinas son independientes una de la otra (punto de vista hardware), usuarios observan una imagen de un sistema único (punto de vista del usuario) y está formado por una colección de algoritmos distribuidos(punto de vista interno)`||
|||
|||
|En los sistemas distribuidos, al igual que en los sistemas en red, los usuarios acceden a los ordenadores de la red utilizando la dirección de red de la máquina o el nombre asignado a dicha máquina.|F|
|*Justificación* `Los usuarios observan el programa como si estuviese en un único ordenador, mientras que, en los sistemas de red, los usuarios acceden a cada uno de los diferentes ordenadores que forman la red, de forma individual, conociendo sus nombres o direcciones de red`||
|||
|||
|Un programa concurrente formado por varios hilos dentro de un único proceso es un ejemplo de sistema no distribuido.|V|
|*Justificación* `Para ser un sistema distribuido tendría que ser un programa formado por varios hilos los cuales se ejecuten en distintas máquinas a su vez, independientemente una de la otra.`||



## Actividad 2

### Objetivos: Distinguir las características principales de los sistemas distribuidos

Explique, con sus propias palabras, cómo se refleja las cuatro características principales de los sistemas distribuidos (i.e. transparencia, disponibilidad, escalabilidad, seguridad) para las siguientes aplicaciones:

1. **La aplicación distribuida PoliformatT.**

    - Transparencia: el usuario no puede notar que hay 12 ordenadores dándole soporte a la web
    - Disponibilidad: se intenta de que Poliformat esté siempre disponible 
    - Escalabilidad: pueden ingresar tantos usuarios como quieran y eso no afecta al redimiendo de Poliformat
    - Seguridad: cada usuario de Poliformat tiene su único usuario y clave asignada para poder acceder a la web

2. **Los servicios de mensajería en Internet (email).**
    - Transparencia: los usuarios no notarán que su bandeja de correo se encuentra en un ordenador u otro. 
    - Disponibilidad: en cualquier momento, cualquier usuario puede acceder a su correo electrónico
    - Escalabilidad: pueden haber N cantidad de usuarios haciendo uso de su correo electrónico
    - Seguridad: las cuentas se regulan por sus propias claves de acceso

## Actividad 3

### Objetivos: distinguir los diferentes ejes de la transparencia de distribución que debería facilitar cualquier aplicación distribuida

Indique con qué ejes de la transparencia de distribución se corresponden las siguientes características de un sistema.

1. Un usuario no percibe que el sistema esté siendo utilizado por múltiples usuarios al mismo tiempo.

 `Transparencia de concurrencia`

2. El sistema permite la movilidad de recursos sin afectar al sistema

`Transparencia de migración, reubicación`

3. Se permite acceder a los recursos sin conocer el dispositivo exacto en el que se encuentran.

`Transparencia de ubicación`

4. El fallo de un nodo no es percibido por los usuarios.

`Transparencia de fallos`

5. Se almacenan diversas copias de un mismo recurso,cada una en un nodo diferente, sin que el usuario lo perciba.

`Transparencia de replicación`

## Actividad

### Objetivos: distinguir los diferente ejes de la transparencia de los distribución que debería facilitar cualquier aplicación distribuida

Relaciones los ejes de la transparencia de distribución de la actividad anterior con los siguientes mecanismos para lograrlos. Hay mecanismos que podrían relacionarse con más de un eje de transparencia.

1. Servicios de nombres

`Transparencia de ubicación y de replicación.`

2. Replicación

`Transparencia de replicación y de fallos.`

3. Detectores de fallos

`Transparencia de fallos`

4. Identificación de los recursos con nombres simbólicos únicos

`Transparencia de ubicación y de replicación.`

5. Algoritmo tolerantes a fallos

`Transparencia de fallos`

6. Algoritmo de balanceo de carga

`Transparencia de fallos`

7. Algoritmo para ofrecer consistencia

`Transparencia de replicación`

## Actividad 5

### Objetivos: Caracterizar los principios de la replicación y consistencia

Responda brevemente a las siguientes preguntas (con un máximo de 50 palabras por pregunta):

1. ¿Qué diferencia existen entre replicaciones activa y replicación pasiva?

En la replicación pasiva un cliente hace una petición que la recibe la réplica primaria, si requiere algún cambio, se realiza en la réplica primaria y esta transmite dicho cambio a las réplicas secundarias para que la realicen, una vez recibida, se envía la respuesta al cliente.

En la replicación activa, el cliente al realizar una petición, se la hace a todas las réplicas por igual (ya que todas son iguales), todas  reciben, procesan y responden a la petición pero el cliente solo se queda con la respuesta que le llegue primero (en tolerancia a fallos bizantinos, se revisa todas las repuestas para poder detectar un fallo entre algunas de ellas).

2. ¿Qué es la "consistencia" entre réplicas? ¿Qué tipos de consistencia existen?

- Consistencia fuerte
Idealmente todas las réplicas son iguales entre sí en todo momento. Es imposible lograr esto, pero la menos se puede lograr sistemas con consistencia bastante fuerte, donde los usuarios del servicio obtienen la misma respuesta independiente de la réplica que les atienda.

- Consistencia débil
Las réplicas pueden divergir, de forma que cada una de ellas pueden dar repuestas diferentes, pero aceptables, en cierto instante.

## Actividad 6

### Objetivos: Caracterizar los principios de la replicación

Explique, para cada tipo de replicación visto en clase, cómo se produce la reconfiguración en caso de fallo:

**1. Si falla la réplica secundaria**

La réplica primaria pasa a ignorar la réplica que falla tanto en el envío como en la recepción de confirmación.

**2. Si falla la réplica primaria**

Las réplicas secundarias acuerdan promover una a primaria, donde se escoge una réplica con el estado más reciente y el cliente debe estar programado para saber a qué nueva réplica primaria debe dirigirse.

## Actividad 7

### Objetivos. Caracterizar los principios de la disponibilidad

Responda brevemente a las siguientes preguntas (con un máximo de 50 palabras por respuesta):

1. **¿Qué es la disponibilidad?¿Qué factores afectan a la disponibilidad?**

Las réplicas secundarias acuerdan promover una a primaria, donde se escoge una réplica con el estado más reciente y el cliente debe estar programado para saber a qué nueva réplica primaria debe dirigirse.

2. **¿Qué son los sistemas tolerantes a fallos?**

Sistemas que continúan ofreciendo servicio en presencia de fallos.

3. **¿Qué tareas típicas de mantenimiento requiere cualquier sistema**

Sustituir discos, alterar la configuración de los sistemas, realizar copias de seguridad, ampliar sistemas, o incluso cambiar el sistema por completo.

## Actividad 8

### OBJETIVOS: Caracterizar los principios de la disponibilidad

Dadas las siguientes afirmaciones, indique si son Verdaderas (V) o Falsas).

|||
|-|-|
|En general, en un sistema distribuido los usuarios no deberían poder acceder a los servicios del sistema mientras se realizan copias de seguridad del mismo.|F|
|*Justificación* `Tienen que acceder por la disponibilidad.`||
|||
|||
|Un ataque de denegación de servicio es un ataque malicioso al sistema.|V|
|*Justificación* `Un ataque malicioso puede ser desde intrusos que alteran, eliminan, interceptan o suplantan recursos hasta a ataques distribuidos de denegación de servicios.`||
|||
|||
|En un sistema con consistencia débil, los usuarios del servicio obtienen la misma respuesta independientemente de la réplica que les atienda.||
|*Justificación* `Las réplicas son todas distintas por lo que ofrecen distintas respuestas, pero que son aceptables, en cierto instante`||
|||
|||
|Los fallos compuestos,  al  afectar a  varios  nodos  y  canales  simultáneamente,  son indetectables ||
|*Justificación* `Depende de cómo sea el fallo, si son fallos simples son detectables o fallos bizantinos que son indetectables`||
|||
|||
|Los fallos de parada, de temporización y los fallos bizantinos son ejemplos de fallos simples detectables.||
|*Justificación* `Los fallos detectables son: parada, temporización y de respuesta detectable. Los fallos indetectables: fallos vizantinos`||
|||
|||
|Un fallo de respuesta detectable consiste en que un nodo tarda demasiado en responder y el nodo que espera su respuesta detecta, mediante un timeout, que la respuesta no llega.||
|*Justificación* `El nodo falla, proporcionando una respuesta equivocada, detectable como tal`||
|||
|||
|Los  fallos simples detectables se  tratan utilizando  replicación  y, en su caso, se ignora a la réplica que ha fallado.||
|*Justificación* `Se usa replicación y al obtener la réplica que ha fallado se expulsa`||
|||
|||
|En los fallos bizantinos los nodos proporcionan una respuesta errónea, por ejemplo, por un error en el software.|| 
|*Justificación* `Proporciona una respuesta que no puede detectarse como fallo.`||
|||
|||
|Para tratar los fallos bizantinos se utilizan algoritmos de quorum. ||
|*Justificación* `Se manda una petición a todos, se analizan las respuestas, la respuesta mayoritaria es la correcta.`||
|||
|||
|El  teorema  CAP  implica  que  se  debe  ofrecer  a  la  vez Consistencia  fuerte,  Disponibilidad elevada y permitir que ocurran Particiones.||
|*Justificación* `El teorema CAP lo que indica es que es imposible ofrecer Consistencia Fuerte, Disponibilidad elevada y permitir Particiones a la vez. Por lo que se pueden hacer sistemas CP, CA y AP`||
|||
|||
|El servicio de pertenencia a grupo se encarga de llegar a un consenso entre los nodos sobre qué nodos han fallado.||
|*Justificación* `Se comparan las replicas y de la que haya mayoría se considera la correcta, de esta forma se puede encontrar la que posee fallo y se expulsa, luego se le informa a los nodos vivos del fallo.`||
|||
|||
|Todos  los  fallos simples  detectables  se  tratan  como  fallos  de  parada,  de  modo  que  si  se detecta que un nodo ha fallado, se expulsa y el resto de nodos lo ignora.||
|*Justificación* `Se convierte en fallos de parada, se localiza y se expulsa, las otras continúan trabajando como si nada.`||
|||
|||

## Actividad 9

### OBJETIVOS: Caracterizar los tipos de fallos y los mecanismos para lograr tolerancia a fallos

Indique el orden de los pasos para lograr tolerancia a fallos, en el caso de fallos simples detectable que no causen particiones:
|Orden |Paso|
|--|--|
|5|La mayoría de los nodos del sistema acuerda que el nodo X ha fallado.|
|4|El servicio de pertenencia a grupo inicia una fase de acuerdo para determinar si el nodo X ha fallado.|
|9|Los nodos se reconfiguran para funcionar sin el nodo "X".|
|7| El servicio de pertenencia notifica al resto de nodos "vivos" que el nodo X ha sido expulsado.|
|1| El módulo "detector de fallos" monitoriza a varios nodos.El módulo "detector de fallos" indica que sospecha del fallo del nodo X.|
|2| El servicio de pertenencia expulsa alnodo X.|
|6|El módulo "detector de fallos" notifica su sospecha de fallo del nodo X al servicio de pertenencia a grupo.|
|3|Los nodos ignoran los mensajes del nodo "X"|

## Actividad 10

### OBJETIVOS: Caracterizar los tipos de fallos y los mecanismos para tratarlos.


| |||
| --- |---|---|
| Particiones|Fallo compuesto|Replicación, Teorema CAP |
| Fallo  de  respuesta  detectable|Fallo simple, detectable|Replicación |
| Fallo  de  temporización|Fallo simple, detectable|Replicación |
| Fallo  de  parada|Fallo simple, detectable|Replicación |
| Fallo  bizantino|Fallo simple, no detectable|Algoritmos de quorum |
