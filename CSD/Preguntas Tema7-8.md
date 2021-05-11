# Preguntas Tema7-8

## Sobre los sistemas distribuidos

|||
| --- | --- |
| La transparencia de acceso oculta las diferencias en la representación de los datos y encómo se accede a los recursos. | V |
| Cuando un sistema distribuido es abierto facilita que uno de sus módulos o componentes pueda utilizarse en otro sistema distribuido. | V |
| Para conseguir escalabilidad de distancia debe asumirse que se está utilizando una red de área local. | F |
|JUSTIFICACIÓN: *La escalabilidad de distancia permite extender el sistema por redes de área amplia* *(WAN), por lo que si se usan algoritmos basados en redes de área local, se debe considerar que no se* *está* *usando* *una* *red* *local,* *sino una* *red* *WAN,* *por* *lo* *que hay* *que* *tener* *en* *cuenta* *los efectos* *de* *los* *retardos en la transmisión de los datos y la menor fiabilidad de las comunicaciones.* ||
|||
| Los algoritmos descentralizados facilitan distribuir la carga computacional entre diferentes ordenadores. | V |
| Se requiere utilizar algoritmos descentralizados para conseguir escalabilidad administrativa, de modo que los cómputos se distribuyen entre diferentes áreas administrativas del sistema| F |
|JUSTIFICACIÓN:*Para* *conseguir* *escalabilidad* *administrativa* *se* *deben* *utilizar* *protocolos* *y* *mecanismos estándar de autenticación y autorización; así como implementar mecanismos para proteger a cada organización del resto y del propio sistema.* |
|||
| Para mejorar la escalabilidad de tamaño, los clientes deben delegar en el servidor tantas responsabilidades como sea posible.JUSTIFICACIÓN: *Al* *contrario,* *contra* *menos* *se* *centralicen* *las* *tareas* *en* *los* *servidores,* *mayor* *escalabilidad de tamaño se podrá conseguir.* | F |
| La *capa* *de* *middleware*, que se ubica bajo el nivel de aplicación, puede integrar algunosmecanismos de comunicación que faciliten la programación de aplicaciones distribuidas; por ejemplo: JMS. | V |
| Un sistema distribuido es un conjunto de ordenadores independientes que ofrecen asus usuarios la imagen de un sistema coherente único. | V |
| De forma general, los fallos compuestos se tratan de igual forma a la aparición de varios fallos simples de forma consecutiva. | V |
| En un sistema distribuido, a nivel hardware las máquinas comparten entre sí los recursos (memoria, reloj, disco, etc...). | F |
| Los fallos, las tareas de mantenimiento y los ataques maliciosos son tres factores que afectan a la escalabilidad del sistema. | F |
| Para lograr transparencia de ubicación, los recursos requieren estar identificados con nombres simbólicos únicos. | V |
| La disponibilidad, una de las características de los sistemas distribuidos, sirve para ocultar las diferencias de los mecanismos de comunicación.*JUSTIFICACIÓN: La disponibilidad implica que los servicios deben estar siempre disponibles**(está directamente relacionada con el fallo del sistema, no con la transparencia de acceso).* | F |
| La transparencia de replicación oculta la coordinación entre las actividades que gestionan un conjunto de recursos para mantener su consistencia.*JUSTIFICACIÓN: La definición dada se corresponde con la transparencia de transacción.* | F |
| Los sistemas distribuidos basados en Active Directory proporcionan escalabilidad administrativa. | V |
| La capa de middleware ayuda a conseguir los cuatro objetivos principales de los sistemas distribuidos: descentralización, replicación, transparencia de acceso y escalabilidad.*JUSTIFICACIÓN: Los objetivos indicados son incorrectos. Los cuatro objetivos son: facilitar acceso a los recursos remotos, transparencia de distribución, sistema abierto y escalabilidad.* | F |
| Todos los sistemas de tiempo real son ejemplos de sistemas distribuidos. |F |
| Algunos tipos de transparencia pueden comprometer la eficiencia del sistema, por ejemplointroduciendo retardos en las interacciones entre componentes de un sistema distribuido. |V |
| Un sistema distribuido ofrece la imagen de un sistema coherente y único. |V |
| Los sistemas distribuidos proporcionan diferentes tipos de transparencia. Entre ellos:transparencia en el rendimiento, en la escalabilidad, en su disponibilidad, en la seguridad... |F |
| Si se desea que un sistema distribuido ofrezca escalabilidad de tamaño, no se debe hacer uso de técnicas de replicación, ya que al actualizar el estado de un componente tendremos que propagartal actualización a todas las réplicas. |F |

## Sobre el mecanismo de comunicación ROI

|||
| --- | --- |
| El componente denominado ORB se encarga, entre otras cosas, de identificar y localizar a los objetos remotos. | V |
| El middleware de un sistema con comunicación basada en ROI emplea generalmente comunicación sincrónica no persistente y direccionamiento directo. | V |
| Cuando se pasa un objeto por valor, se copia una referencia al mismo.JUSTIFICACIÓN: *Cuando se pasa un objeto por valor, el estado del objeto se empaqueta, mediante un* *proceso denominado* *serialización.* | F |
| El proxy empaqueta los argumentos una vez recibe la contestación del esqueleto.JUSTIFICACIÓN: *El proxy desempaqueta los argumentos al recibir la contestación, para así devolverlos* *al proceso* *cliente.* | F |
| Se considera que una invocación a un objeto es una invocación local cuando los objetos invocador e invocado residen en procesos diferentes del mismo nodo. | F |
| En ROI, para el paso de objetos como argumentos por valor, se utiliza la técnica deserialización de objetos para así transmitirlos al nodo destino de la invocación. | V |
| Se pueden pasar objetos remotos por referencia. | V |
| Cuando un cliente referencia por vez primera a un objeto remoto, obtiene el esqueleto para dicho objeto.*JUSTIFICACIÓN: Obtiene el proxy.* | F |
| El esqueleto ofrece la misma interfaz que el objeto remoto.*JUSTIFICACIÓN: El proxy es quien ofrece la misma interfaz que el objeto remoto.* | F |
| Es el utilizado en Java RMI. | V|
| Proporciona transparencia de ubicación. | V|
| Admite paso de parámetros por referencia en sus invocaciones. | V|
| Proporciona transparencia de fallos. | F|
| El cliente obtiene un proxy para invocar al objeto remoto. |V|
| El proxy incluye una referencia al objeto remoto | V|
| El mecanismo de ROI permite el paso de objetos como argumentos en las invocaciones,utilizando "paso por valor". El paso de los objetos por referencia se simula mediante el paso por valor, de forma similar a como se emplea en el mecanismo RPC. |F|
| En Java RMI, se requiere emplear un lenguaje especial de definición de interfaces, denominadoIDL (Interface Definition Language), para describir los interfaces de los objetos remotos |F|
| El programador debe escribir el código del proxy y esqueleto para cada objeto remoto |F|

## Sobre el mecanismo de comunicación Java RMI:

|||
| --- | --- |
| El proxy correspondiente a un objeto remoto se crea en tiempo de ejecución cuando se accede por primera vez al objeto remoto. | V |
| Se considera objeto local todo objeto que sólo puede invocarse desde la computadora en que se define (aunque sea desde otras máquinas virtuales Java), y objeto remoto a todo objeto que puede invocarse desde otras computadoras.*JUSTIFICACIÓN: Si un objeto se invoca desde otras máquinas virtuales Java de la misma computadora,* *también se considera como objeto remoto.* | F |
| No proporciona transparencia de ubicación, porque la sintaxis de invocación del método es distinta dependiendo de si el objeto es local o remoto.*JUSTIFICACIÓN: La sintaxis de invocación es la misma. En la interfaz del objeto definimos los métodos* *del objeto (con independencia de que vaya a ser remoto o local). Si el objeto es remoto, la interfaz debe extender java.rmi.Remote.* | F |
| La clase de un objeto remoto debe implementar un interfaz que extienda java.rmi.Remote | V |
| Si un objeto que se pasa como argumento implementa la interfaz *Remote*, entonces dicho objeto se pasa por referencia. | V |
| Para implementar un objeto remoto en Java RMI, la clase de los objetos remotos debe implementar la interfaz remota y extender *java.rmi.server.UnicastRemoteObject*, para así poder registrar los objetos en el ORB de Java. | V |
| El servidor de nombres de Java RMI guarda, para cada objeto remoto, su nombre simbólico y la dirección (host, puerto) de su proxy.*JUSTIFICACIÓN: El servidor de nombre guarda el nombre simbólico y la referencia.* | F |
| El servidor de nombres de Java RMI puede residir en cualquier nodo (incluso en el nodo cliente) y es accedido usando la interfaz Registry. | V |
| Java RMI es un ejemplo de middleware de mensajería, donde cliente y servidor deben suscribirse al middleware para así poder enviarse mensajes entre sí.*JUSTIFICACIÓN: Cliente y servidor no requieren subscripción al middleware. Esto se realiza en* *Java JMS.* | F |
| En JMS, los mensajes no son estructurados y se envían en texto plano en XML.*JUSTIFICACIÓN: Sí son estructurados, con cabecera, contenido y campos predefinidos.* | F |
| JMS generalmente utiliza comunicación indirecta. | V |
| Los objetos que implementan la interfaz JMSContext se crean a partir de una factoría de conexiones. | V |

## Respecto a los servicios Web RESTful

|||
| --- | --- |
| En un servicio Web RESTFul, los mensajes constan de una cabecera formada por varios campos fijos definidos por el estándar RESTful, un conjunto de propiedades que pueden ser definidas por la aplicación y de un contenido (normalmente, en XML o JSON).*JUSTIFICACIÓN: El estilo arquitectónico REST no especifica ninguna cabecera, ni campos fijos* *definidos. Por tanto, los mensajes tienen estructura libre.* | F |
| GET https:/weatherapp.com/zipcodes es un ejemplo de llamada a un servicio WebRESTFul. | V |
| Un sistema distribuido con comunicación basada en servicios web REST empleageneralmente comunicación sincrónica no persistente y direccionamiento directo. | V |
| Son atendidos por servidores que mantienen el estado de las peticiones de los clientes.*JUSTIFICACIÓN: Los servicios son "sin estado", de modo que los servicios no mantienen ninguna sesión* *respecto a* *las* *peticiones* *de los* *clientes.* | F |
| Resulta interesante utilizar servicios Web RESTful cuando no es necesario que todos los componentes de la aplicación estén simultáneamente en ejecución.*JUSTIFICACIÓN: La comunicación no es persistente, por lo que los componentes deben estar simultáneamente en ejecución.* | F |
| Los servicios Web RESTful utilizan métodos del protocolo http para indicar el tipo de operación. | V |

## Respecto al mecanismo de comunicación Java Message Service

|||
| --- | --- |
| JMS utiliza direccionamiento directo, pues en la cabecera del mensaje se especifica claramente el destino del mensaje.*JUSTIFICACIÓN: JMS emplea direccionamiento indirecto, ya que el cliente envía el mensaje a un destino (Destination), que puede ser una cola (Queue) o un tema (Topic). Y no tiene por qué conocer quién será* *el consumidor del mensaje.* | F |
| Java Message Service ofrece una comunicación fuertemente acoplada, pues tanto el productor como el consumidor de un mensaje se crean utilizando la misma factoría de conexión.*JUSTIFICACIÓN: JMS ofrece una comunicación débilmente acoplada, ya que al emplear destinos, el productor y el consumidor del mensaje no necesitan conocerse. Solamente requieren conocer el destino* *(y estar de acuerdo en el formato del mensaje).* | F |
| Existen dos tipos de destinos: Colas (Queues), utilizadas para enviar mensajes a un únicocliente; y Temas (Topics), que permiten la publicitación/suscripción. | V |
| Las factorías de conexiones y los destinos se crean utilizando una herramienta administrativa ofrecida por el Proveedor de JMS. | V |
| Java JMS es una API Java que permite a las aplicaciones invocar a objetos remotos mediante el envío y recepción de mensajes. | F |
| Los componentes de JMS son los proveedores, los clientes, los mensajes y los objetosadministrados. | V |
| Cuando se quiere que los componentes de una aplicación distribuida no dependan de conocer las interfaces de otros componentes es preferible usar Java RMI frente aJMS. | F |
| En JMS un mismo mensaje puede ser entregado a varios clientes. | V |
| En JMS, en general, para que un cliente A pueda enviar un mensaje a otro cliente B, el cliente B debe estar activo. | F |

## Sobre la escalabilidad y disponibilidad de los sistemas distribuidos

|||
| --- | --- |
| En general, la técnica de replicación permite aumentar tanto la escalabilidad delsistema como su disponibilidad. | V |
| La técnica de *caching* es un caso particular de la replicación donde el cliente mantiene una réplica exacta, con consistencia fuerte, de los datos que mantiene elservidor. | F |
| La distribución del procesamiento entre diferentes nodos y el particionado de los datos permite aumentar la escalabilidad del sistema. | V |
| El teorema CAP nos indica que, en un sistema a gran escala, donde las particiones ocurren, se debe sacrificar disponibilidad del sistema, o bien su consistencia. | V |
|  En la replicación activa, en caso de fallo de una réplica, el trabajo de reconfiguraciónconsiste en que la réplica primaria enviará un mensaje menos de *checkpoint*. | F |
El servicio de pertenencia a grupo permite determinar quiénes son los nodos queestán activos, y utiliza para ello el algoritmo de elección de líder en anillo. | F |
| Los detectores de fallos, el servicio de pertenencia a grupo y la replicación sonmecanismos que permiten aumentar la disponibilidad y lograr tolerancia a fallos. | V |
| 19. Se produce una partición en un sistema distribuido cuando se producen varios fallos en nodos o canales de comunicación que dejan al sistema dividido en dos o mássubgrupos. | V |
| Tenemos un sistema con varios nodos que miden la temperatura ambiente y se la transmiten a un nodo coordinador. El coordinador puede determinar como fallosimple detectable la situación en la que un nodo tarda mucho tiempo en contestar. | V |
| Tenemos un sistema con varios nodos que miden la temperatura ambiente y se la transmiten a un nodo coordinador. El coordinador puede utilizar la replicación (con varios nodos midiendo la temperatura de la misma zona) para poder detectar losfallos bizantinos. | V |
| 22. Los fallos de parada no pueden detectarse directamente por otros nodos. Serequiere de algoritmos de consenso o de quórum para poder tratar este tipo de fallos. | F |

## Sobre los mecanismos de comunicación en los sistemas distribuidos

|||
| --- | --- |
| Por comunicación directa se entiende que un proceso se envía un mensaje a sí mismo directamente, y por comunicación indirecta que se lo envía a otro proceso diferente. | F |
| En el envío de un mensaje en un sistema con comunicación sincrónica en la respuesta, el emisor esperará hasta que el receptor haya procesado el mensaje y devuelva la respuesta. | V |

---

## Un sistema distribuido

|||
| --- | --- |
| Es una clase de sistema concurrente; aunque no todos los sistemas concurrentes son distribuidos. |V |
| Ofrece la imagen de un sistema coherente y único. |V |
| Proporcionará diferentes tipos de transparencia. Entre ellos: transparencia en el rendimiento, en la escalabilidad, en su disponibilidad, en la seguridad... |F |
| Es un sistema de tiempo real que necesitará un análisis de planificabilidad. |F |

## La comunicación basada en mensajes

|||
| --- | --- |
| Es un tipo particular de memoria compartida y requiere acceso en exclusión mutua. |F |
| Será sincrónica cuando el canal pueda mantener los mensajes durante un intervalo indefinido. |F |
| Se utiliza en su variante asincrónica para implantar el servicio de correo electrónico. |V |
| Se utiliza en su variante sincrónica no persistente para implantar las llamadas a procedimiento remoto. |V |

## Sobre los servicios de nombres en un sistema distribuido

|||
|--|--|
| Se necesitan para asegurar la exclusión mutua. |F |
| Suelen utilizar una estructura jerárquica para facilitar su escalabilidad. |V |
| Pueden retornar identificadores para facilitar la gestión de entidades móviles. |V |
| LDAP es un ejemplo de servicio de directorio basado en atributos. |V |

## Sobre el mecanismo de comunicación RPC

|||
| --- | --- |
| Al igual que ROI, siempre requiere que se utilice un servidor de nombres. | F |
| El stub cliente sirve para poder invocar procedimientos remotos como si fuesen locales | V |
| Sólo podemos definir como procedimientos remotos aquellos que no utilicen paso deparámetros por referencia. | F |
| Se basa en un modelo de invocación/respuesta con asincronía y persistencia | F |
| El programador debe escribir el código de los stubs cliente y servidor para cada procedimientoque pueda invocarse de forma remota | F |
