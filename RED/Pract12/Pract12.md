# Practica 4 
## Ejercicio 1
El computador B ha recibido los datagramas IP mostrados en la tabla, que han sido enviados por el computador A. Durante la recepción de los datagramas los únicos puertos abiertos en B eran los puertos TCP 22 y 30.000.

|Nº| Identificador| MF|OFFSET |Long. Total| Protocolo |Tipo (si ICMP)/ Puerto si UDP o TCP|
|--|--|--|--|--|--|--|
|1 |1340| 1| 185| 1500| ICMP| 8|
|2|1341| 0 |0 |877 |UDP |8.000|
|3|1342 |1 |0| 1500 |TCP |22|
|4 |1340 |0 |370 |78 |ICMP| 8
|5 |1342| 0 |185 |1340|TCP |22

- ¿Qué datos recibirá el nivel de transporte? Justifica la respuesta.
    - Datagrama 1340:
        - Paquete 1: Llega un fragmento
            - No es el primero (offset > 0) -> Hay 185 x 8 = 1480 bytes en paquetes anteriores
            - No es el último (MF = 1)
        - Paquete 4: Llega un fragmento
            - No es el primero (offset > 0) -> Hay 370 x 8 = 2960 bytes en paquetes anteriores
            - Es el último (MF = 1)
        - Si no llega ninguno más, no se consigue reensablar -> NO SE ENTREGA 
    - Datagrama 1341:
        - Paquete 2: 
            - No es fragmento: (offset = 0 y MF = 0)
        - Es un Datagrama UDP destinado al puerto 8000, que está cerrado -> NO SE ENTREGA
    - Datagrama 1342 
        - Paquete 3: Llega un fragmento 
            - Es el primero (offset = 0) 
            - No es el último
        - Paquete 5: Llega un fragmento 
            - No es el primero -> Hay 185 x 8 = 1480 bytes en paquetes anteriores
            - Es el último
        - SE ENTREGA
- ¿Se generarán mensajes ICMP? Justifique la respuesta. En caso afirmativo indica qué datagrama(s) lo(s) generará(n).

## Ejercicio 2: 
Inicia el analizador de protocolos Wireshark. Captura los paquetes que se generan al cargar en el navegador la página www.uv.es. Utiliza un filtro de captura para eliminar el resto del tráfico. Recuerda que los protocolos de aplicación se filtran indicando el puerto del servidor (port 80 para http o port 443 en el caso de https). Detén la captura, analiza los primeros 4 paquetes generados, y responde a las siguientes cuestiones referidas a la cabecera IP de dichos paquetes:
||Identificador| TTL| Dirección IP fte. | Dir, IP destino|
|--|--|--|--|--|
|Paquete 1|0x473a|64|10.0.2.15|147.156.200.249|
|Paquete 2|0xba4f|64|147.156.200.249|10.0.2.15|
|Paquete 3|0x473b|64|10.0.2.15| 147.156.200.249
|Paquete 4|0x473c|64|10.0.2.15|147.156.200.249

Con respecto al campo TTL (Time To Live) de la cabecera IP de los paquetes capturados:
- ¿Tiene siempre el mismo valor?

    `Sí`
- En general, todos los paquetes que envía un ordenador, ¿tienen siempre el mismo TTL inicial? 

    `Sí`
- ¿Cuál es el valor inicial del TTL en el paquete 2 (el primero que ha enviado el servidor)?

    `64`

Observa cómo varia el campo identificador en el cliente y en servidor. Describe lo que observas. Anota el valor del campo protocolo. En este caso, ¿a qué protocolo se refiere?

## Ejercicio 3: 
Haz un ping -n 3 ( en Linux: ping -c 3 ) a las direcciones siguientes: www.uv.es (servidor web de la Universidad de Valencia), www.uvigo.gal (servidor web de la Universidad de Vigo), www.uq.edu.au (servidor web de la Universidad de Queensland en Australia) y www.berkeley.edu (servidor web de la Universidad de California en Berkeley). La opción -n 3/ -c 3 configura la orden ping para que realice únicamente tres intentos. Anota los resultados en la tabla siguiente:

|Tiempo de ida y vuelta (ms)|Mínimo| Medio| Máximo|
|--|--|--|--|
|www.uv.es |21.729|25.927|31.209|
|www.uvigo.gal |26.912|49.863|95.609|
|www.uq.edu.au |279.259|280.843|283.224|
|www.berkeley.edu |181.819|199.132|233.350|

Analiza a qué se debe la disparidad de los resultados entre los distintos destinos.

## Ejercicio 4: 
Antes de iniciar la captura lee el ejercicio hasta llegar a las cuestiones.
 
Aplica un filtro de captura (no de visualización) que capture únicamente los paquetes ICMP generados tras la ejecución de la orden ping -n 3 www.uv.es (en Linux: ping -c 3 www.uv.es). Ejecuta la orden dos veces.

Detén la captura cuando terminen los seis intentos y observa cuántos mensajes ICMP se producen, prestando especial atención a los campos de la cabecera ICMP: tipo, código, y bytes de datos. Observa la diferencia entre los mensajes ICMP de petición y de respuesta de eco. Asimismo, analiza las cabeceras IP de cada uno de ellos, y en concreto los campos longitud de la cabecera, longitud total y bytes de datos. Compara el valor del campo protocolo con el que observaste en el ejercicio 2. 

![](https://i.imgur.com/LRGsZ32.png)

Respecto a los mensajes ICMP:
 - ¿Por qué los mensajes ICMP no llevan números de puerto fuente y destino? 

    `Porque los números de puerto fuente y destino se generan a nivel de IP y no a nivel de transporte`

 - ¿Para qué se utiliza el número de secuencia de la cabera ICMP?

    `Son usados por el emisor del eco para emparejar las respuestas con las peticiones de eco`

## Ejercicio 5: 
Ejecuta la orden tracert (traceroute en Linux) para los siguientes destinos y anota el número de saltos. 
||Saltos|
|--|--|
| www.uv.es|9|
| www.ua.es|12|
| www.uq.edu.au|16|
 Observa que si se alcanza el destino, la última línea mostrada corresponde a dicho destino (en nuestro caso un servidor web) y no a un router.
 
Analiza cuáles pueden ser las causas de la respuesta obtenida al ejecutar la orden tracert
www.ua.es.

En el tracert a www.uq.edu.au, aparecen diferencias importantes en el retardo de los enlaces que se observa, ¿cuál crees que es el motivo?

 
## Ejercicio 6:
Desde el navegador accede a la página http://www.telstra.net/cgi-bin/trace. En esta página puedes indicar una dirección ip destino. El servidor de telstra que está en Melbourne hará un tracert desde su máquina al destino que le hayas indicado. En nuestro caso le vamos a poner la dirección IP de nuestra máquina de trabajo. 

Tenemos que tener en cuenta que para que el servidor de telstra pueda hacer un tracert hasta nuestra máquina es necesario proporcionarle la dirección IP pública y no la privada que es la que nos proporciona nuestro router doméstico y la que vemos mediante el comando ipconfig. Para obtener nuestra IP pública hay muchas páginas web especializadas en ello. Una de ellas es www.cualesmiip.es. 

Así obtendremos todos los routers por los que pasa un datagrama desde el servidor de Telstra hasta llegar a nuestra red. A continuación, realiza un tracert/traceroute al servidor www.telstra.net, para obtener la ruta inversa Compara ambos resultados. ¿Se sigue el mismo recorrido desde tu máquina hasta www.telstra.net y viceversa? Observarás que algunos routers tienen nombres similares en los dos casos pero con direcciones IP distintas, ¿a qué crees que es debido?

```
PC -> telstra 
 1  _gateway (192.168.1.1)  2.331 ms  2.206 ms  2.175 ms
 2  10.0.0.1 (10.0.0.1)  9.028 ms  9.012 ms  8.996 ms
 3  172.24.1.1 (172.24.1.1)  17.049 ms  17.035 ms  17.020 ms
 4  10.220.98.134 (10.220.98.134)  10.172 ms  10.155 ms 10.220.101.200 (10.220.101.200)  10.139 ms
 5  static-194-55-169-198.digimobil.es (194.55.169.198)  10.124 ms static-194-55-169-196.digimobil.es (194.55.169.196)  16.934 ms static-194-55-169-198.digimobil.es (194.55.169.198)  16.912 ms
 6  ae56.bar2.Barcelona1.Level3.net (213.242.114.213)  16.896 ms  14.400 ms  14.354 ms
 7  ae-1-8.edge1.SanJose3.Level3.net (4.69.209.165)  192.618 ms  191.953 ms  191.908 ms
 8  i-0-5-0-13-peer.eqnx03.pr.telstraglobal.net (134.159.61.105)  177.615 ms  179.546 ms  178.579 ms
 9  i-92.eqnx-core02.telstraglobal.net (202.84.247.18)  178.567 ms  178.558 ms  179.490 ms
10  i-92.eqnx-core02.telstraglobal.net (202.84.247.18)  318.268 ms  318.259 ms  318.250 ms
11  i-20208.sydp-core04.telstraglobal.net (202.84.141.26)  325.153 ms  325.145 ms  325.136 ms
12  i-10102.sydp-core03.telstraglobal.net (202.84.222.133)  325.128 ms  324.758 ms  329.289 ms
13  bundle-ether3.pad-gw10.sydney.telstra.net (203.50.13.85)  312.777 ms  312.758 ms  312.741 ms
14  bundle-ether3.chw-core10.sydney.telstra.net (203.50.6.56)  319.986 ms  324.069 ms  329.169 ms
15  bundle-ether8.exi-core10.melbourne.telstra.net (203.50.11.125)  341.669 ms  341.654 ms  341.638 ms
16  203.50.11.209 (203.50.11.209)  329.104 ms  325.766 ms  325.741 ms
17  www.telstra.net (203.50.5.178)  325.730 ms  325.722 ms  325.714 ms
```
```
telstra -> PC 

 1  gigabitethernet3-3.exi1.melbourne.telstra.net (203.50.77.49)  0.268 ms  0.307 ms  0.204 ms
 2  bundle-ether3-100.exi-core10.melbourne.telstra.net (203.50.80.1)  2.864 ms  1.667 ms  2.116 ms
 3  bundle-ether12.chw-core10.sydney.telstra.net (203.50.11.124)  13.736 ms  14.535 ms  15.108 ms
 4  bundle-ether1.oxf-gw11.sydney.telstra.net (203.50.6.93)  13.984 ms  14.661 ms  13.109 ms
 5  203.50.13.98 (203.50.13.98)  15.484 ms  14.662 ms  14.985 ms
 6  i-10403.sydo-core04.telstraglobal.net (202.84.222.130)  14.982 ms  14.413 ms  15.106 ms
 7  i-10604.1wlt-core02.telstraglobal.net (202.84.141.225)  155.151 ms  155.453 ms  154.655 ms
 8  i-10604.1wlt-core02.telstraglobal.net (202.84.141.225)  156.899 ms  155.078 ms  155.404 ms
 9  i-93.tlot02.bi.telstraglobal.net (202.84.253.86)  154.405 ms  154.443 ms  154.900 ms
10  l3-peer.tlot02.pr.telstraglobal.net (134.159.61.18)  152.155 ms
11  ae1.3103.edge1.Madrid2.level3.net (4.69.141.18)  307.366 ms  307.238 ms  307.442 ms
12  213.249.120.154 (213.249.120.154)  272.958 ms  271.137 ms  292.820 ms
13  91.232.81.17 (91.232.81.17)  270.084 ms

```
## Ejercicio 7: 
Captura los paquetes IP derivados de la ejecución de la orden tracert -d www.uv.es.(en Linux: tracert -n www.uv.es). Para capturar también los paquetes del protocolo involucrados en este comando tendrás que utilizar el filtro de captura “icmp” (en Linux: “icmp or (udp and host X.X.X.X”, donde X.X.X.X representa la dirección IP de tu ordenador) .
Para los paquetes que envía tu ordenador:
- ¿Qué tipo de mensajes envía tu máquina? 
    `UDP`
- ¿Cuál es la dirección destino de estos mensajes? 
    `147.157.200.249`
- ¿Es siempre la misma? 
    `Sí`
- ¿A quién pertenece esta dirección?
    `www.uv.es`
-  En la cabecera IP: ¿cómo varía el TTL? 
    `Aumenta progresivamente`
-  ¿Cuántos paquetes envía tu máquina con el mismo TTL? 
    `3`
-  ¿Cuál es el TTL del último mensaje que envía tu ordenador? 
    `14`
-  ¿Cuál es el número de saltos que obtuviste en la ejecución del tracert?
    `12`

Para los paquetes de respuesta: 
- ¿Qué tipos diferentes de mensajes ICMP recibe tu máquina?
    `11 y 3` 
-  Observa la dirección IP origen de cada uno de los mensajes ICMP que recibe tu máquina. Relaciona estas direcciones con el resultado obtenido en la ejecución del tracert. 

**IPs obtenidas a traves de Wireshark**

`192.168.1.1`

`10.0.0.1`

`172.24.0.1`

`10.220.101.198`

`91.232.81.20`

`62.115.182.97`

`62.115.139.184`

`62.115.151.151`

`130.206.245.89`

`130.206.211.202`

`147.156.200.249`

`147.115.200.154`

**Ejecución del traceroute**
    
```
traceroute -n www.uv.es                               
traceroute to www.uv.es (147.156.200.249), 30 hops max, 60 byte packets
 1  192.168.1.1  1.623 ms  1.579 ms  2.189 ms
 2  10.0.0.1  8.685 ms  8.666 ms  8.649 ms
 3  172.24.0.1  10.912 ms  10.895 ms  10.879 ms
 4  10.220.101.198  10.864 ms  10.848 ms 10.220.96.119  12.783 ms
 5  91.232.81.20  10.815 ms 91.232.81.22  12.750 ms  12.734 ms
 6  62.115.182.97  12.716 ms  11.248 ms  11.204 ms
 7  62.115.139.184  18.591 ms  16.801 ms  16.749 ms
 8  62.115.151.151  19.770 ms  21.572 ms  22.926 ms
 9  130.206.245.89  28.348 ms  28.331 ms  28.312 ms
10  130.206.211.202  24.958 ms  23.693 ms  23.649 ms
11  147.156.200.154  53.452 ms  53.435 ms  53.419 ms
12  147.156.200.249  23.579 ms  21.504 ms  21.965 ms
```
-  Indica por qué se envía información sobre las cabeceras IP e ICMP en los paquetes ICMP de error.

    `Enviar mensajes UDP a un puerto arbitrariamente grande (en principio es el33434) y muy probablemente cerrado (es la opción que se usa en Linux/Unix). El sistemaresponderá con un mensaje ICMP de puerto inalcanzable  si el puerto está cerrado en eldestino, pero si estuviera abierto no se recibiría respuesta y no se detectaría que ya se haalcanzado el destino.`
