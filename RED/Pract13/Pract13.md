# Practica 13 RED: NAT

## Ejercicio 1 

### Se pretende configurar manualmente la interfaz que tiene la IP pública de un dispositivo NAT con los siguientes valores 

|||
|--|--|
|Dirección IP pública:| 158.42.180.1|
|Máscara de subred: |255.255.255.0|
|Puerta de enlace: |158.42.181.250|
|Servidor de nombres 1:| 158.42.249.8|
|Servidor de nombres 2:| 158.42.1.8|

#### a) Una vez introducidos esos valores, el dispositivo NAT nos dice que la dirección IP de la puerta de enlace es incorrecta. Sin embargo, tras comprobar los valores, tanto la dirección IP de la puerta de enlace como la dirección IP pública asignada al NAT son correctas. 

- ¿Por qué nos dice el NAT que la dirección IP de la puerta de enlace es incorrecta?

Porque según la mascara de red su up y la de la puerta de enlace no está en la misma red

#### b) Si ambas direcciones IP son correctas, 
- ¿qué parámetro habría que cambiarpara que la configuración fuera correcta?¿Qué valor haría correcta la configuración?

Hay que cabiar la mascara de red a 255.255.254.0

#### c) ¿Pueden estar los DNS en una red distinta a la nuestra? Justifica la respuesta.

Sí, porque mientras tengas acceso a el, no hace falta que esté en la misma red

## Ejercicio 2

### Abre desde el wireshark el fichero HTTP_LAN_1 y responde a las siguientes cuestiones. 

1. ¿Cuál es la dirección IP del cliente? ¿Cuál es la dirección IP del servidor web?

2. ¿Cuántas conexiones TCP se realizan?

3. Localiza el datagrama que contiene la petición web “GET / HTTP/1.1”. ¿Cuáles son los puertos TCP fuente y destino? 

4. ¿En qué momento exacto se recibe la correspondiente respuesta HTTP 200 OK desde el servidor web? ¿Cuáles son las direcciones IP fuente y destino del datagrama correspondiente? ¿Y los puertos fuente y destino?

5. ¿Qué puertos se usan en la segunda conexión TCP

## Ejercicio 3

### Una vez realizado el ejercicio 2, vamos a centrarnos ahora en los mensajes HTTP que salen del router NAT hacia el servidor web. Para ello, desde el programa Wireshark abre el fichero de captura HTTP_ISP_1, que se corresponde con el tráfico del ejercicio 2 anterior, pero en la parte externa del NAT. Cuando estudies esta nueva captura, ten en cuenta que los tiempos de las tramas no se corresponden con precisión a los del fichero anterior, dado que ambas capturas no están sincronizadas.

1. En este nuevo fichero de captura, localiza el primer mensaje HTTP GET que se envió, en la captura anterior del ejercicio2, desde el cliente al servidor web en el instante 1.338012. 
   - **¿En qué momento aparece este mensaje en el fichero HTTP_ISP_1?**

     - En el instante 3

   - **¿Cuáles son las direcciones IP fuente y destino y los puertos que se usan?** 

      - src: 158.42.180.22:52467
      - dst: 158.42.4.2:80

   - **¿Cuáles de estos campos son los mismos y cuales diferentes que en el caso del fichero anterior?** 
    
     - La ip funte es diferente

2. ¿Cuál es la direccion IP pública del router NAT?

      - 158.42.180.22

3. ¿Se ha cambiado algún campo del mensaje HTTP GET? ¿Y del datagrama IP que contiene dicho mensaje? Para aquellos campos que se han modificado ¿cuál es el motivo?

      - Se ha cambiado la ip fuente ahora es la de NAT para poder utilizar un ip pública

4. En el fichero HTTP_ISP_1, 
    - **¿en qué momento se recibe desde el servidor web el mensaje HTTP 200 OK?** 
    
      - En en intante 4
    
    - **¿Cuáles son las direcciones IP fuente y destino del datagrama?** 
    
      - src: 158.42.42.23
      - dst: 158.42.180.22

    - **¿Son iguales a las que has analizado en el ejercicio anterior?**

      - No son iguales

## Ejercicio 4

### Basándote en la información que has recogido, rellena la tabla de traducciones siguiente: 

|Lado red local||Lado ISP||
|--|--|--|--|
|Dirección IP origen|Puerto origen| Dirección IP origen |Puerto origen|
|192.168.1.181|52467|158.42.180.22|52467|
|192.168.1.181|39137|158.42.180.22|39137|

## Ejercicio 5

### Abre con el Wireshark el fichero HTTP_LAN_2, que corresponde al tráfico generado por uno de los ordenadores de la red privada donde se ha ejecutado el programa anterior

1. ¿Cuál es la dirección IP del cliente? ¿Cuál es la dirección IP del servidor web?
2. ¿Cuáles son los puertos TCP fuente y destino

# Abre el fichero HTTP_ISP_2. Este fichero contiene el tráfico generado en la red pública por los dos ordenadores de la red privada. La primera conexión al servidor web usa el mismo número de puerto origen que en el lado LAN, pero en la segunda conexión TCP ...

1. ¿Qué número de puerto origen asigna el router NAT?
2. ¿Cómo se puede saber cuál de la dos conexiones TCP corresponde a la contenida en el 
fichero HTTP_LAN_2? Sugerencia: revisa identificador del paquete IP.

|Lado red local     |             |Lado ISP             |             |
|--|--|--|--|
|Dirección IP origen|Puerto origen| Dirección IP origen |Puerto origen|
|192.168.1.2        |40000        |158.42.180.22        |40016        |

## Ejercicio 6

### Hasta ahora hemos visto que el router NAT modifica los campos de la cabecera IP y de la cabecera TCP (o UDP). Pero en ocasiones también se ve obligado a modificar el contenido del mensaje que viaja en el segmento TCP. Estudia los ficheros FTP_LAN_1 y FTP_ISP_1

1. ¿Cuál es la dirección IP del cliente? ¿Cuál es la dirección IP del servidor ftp?

   - 192.168.1.2
   - 158.42.180.62

2. ¿Cuántas conexiones TCP aparecen? ¿Cuáles son los puertos TCP fuente y destino de cada una de ellas? ¿Por qué hay varias conexiones TCP?

   - 2
   - src1: 40831 dst1: 21
   - src2:20     dst2: 45162
   - La primera conexión es de control y la segunda la crea el servidor para enviar los datos que pide el cliente

3. Fíjate en el datagrama que se genera en la red privada en el instante 4.307125. Comparalo con el correspondiente de la red externa. Analiza también los segmentos de fin de la conexión que hay al final de las capturas, tanto en la parte LAN como en la parte del ISP. ¿Qué está sucediendo? En caso de duda, pregunta a tu profesor de prácticas
  
   - Que en el protocolo FTP es necesario cambiar el campo de datos ya que aparece la ip del cliente

## Ejercicio 7

### En esta práctica no vamos a configurar un router NAT para que realice port forwarding, pero vamos a analizar los paquetes que llegan a un dispositivo NAT desde el exterior y que van destinados a un servidor ssh que está ejecutándose en un ordenador de la intranet. Para ello vamos a utilizar los ficheros de captura SSH_LAN_1 y SSH_ISP_1

1. ¿Cuál es la dirección IP del cliente? ¿Cuál es la dirección IP del servidor ssh?

   - 158.42.180.21
   - 192.168.1.2

2. ¿Cuáles son los puertos TCP fuente y destino?

   - src:44628 dst:22

3. ¿Qué diferencias observas en los datagramas y segmentos capturados dentro y fuera de la intranet? ¿Se está modificando el contenido de los mensajes, como en el caso de FTP?

   - Solo cambia la ip destino, no se modifica el contenido del mensaje 
