# Práctica 11
## Ejercicio 1. 

Abre una ventana de DOS y ejecuta la orden ipconfig /all. De toda la información que se te muestra, 
- ¿qué parámetros están relacionados con el diálogo DHCP inicial que se ha producido en el arranque del sistema?

![](https://i.imgur.com/FHF3JP6.png)

- ¿Cuándo se ha obtenido la concesión de la dirección IP? 

`21 de abril 14:55`

- ¿Cuándo caduca?

`22 de abril 17:17`

## Ejercicio 2.
Ponemos en marcha el analizador de protocolos Wireshark e iniciamos una captura filtrando el tráfico UDP que utilice el puerto 67. A continuación, utilizamos el comando ipconfig /release para liberar la información IP que tiene nuestro ordenador y después el comando ipconfig /renew para volver a obtener dirección IP, mientras está en marcha la captura con el Wireshark. Una vez finalizado este proceso paramos la captura.

Los comandos equivalentes en Linux serían:
 - sudo dhclient –r para liberar la dirección IP asociada a nuestro ordenador. 
 - sudo dhclient para solicitar nueva dirección IP

**Captura:**
![](https://i.imgur.com/UshF50o.png)


## Ejercicio 3. 
Descárgate del Poliformat la captura Captura1Practica3.pcap y ábrela con el programa Wireshark. 
1. Nos centramos en primer lugar en el primer mensaje DHCP que interviene en el proceso de obtención de dirección IP: DHCPDISCOVER. Basándote en la información obtenida, 
    - ¿qué servicio utiliza DHCP, TCP o UDP? 

    `DHCP`
    - Mirando las direcciones IP origen y destino del datagrama de este primer mensaje DHCP que te aparece, ¿podrías justificar la elección de DHCP por un servicio sin conexión? 

    `Direción ip origen: 0.0.0.0`
    
    `Dirección ip destino: 255.255.255.255 (difusión)`
    
    ` Es un servicio sin conexión para poder realizar la difusión dado que los protocolos orientados a la conexión (como TCP) necesitan mantener información del estado de la comunicación y la máquina destino puede variar sin previo aviso.`
2.  Slecciona el mensaje DHCPDiscover y b u s c a la información para rellenar los siguientes campos (se trata de información que corresponde a distintos niveles de la arquitectura y está en diferentes cabeceras):

|||
|--|--|
|Tipo de Mensaje (en el campo de opciones DHCP)|Boot Request (1)|
|Dir. IP origen del datagrama (en cab. IP)|0.0.0.0|
| Dir. IP destino del datagrama (en cab. IP)|255.255.255.255|
| Puertos origen y destino (en cab. UDP)|68, 67|
| Id. Transacción (en cabecera DHCP)|0x3ca63f58|
| Campo dir. IP Cliente (en cabecera DHCP)|0.0.0.0|
| Campo Tu dirección IP (en cabecera DHCP)|0.0.0.0|
|Campo Dir. IP del Agente Retransmisor (cab. DHCP)|0.0.0.0|

3. En este mensaje el nodo no solicita una dirección IP cualquiera, sino que pide una dirección concreta que está asociada a su dirección física. ¿En qué campo del mensaje se hace esta solicitud?

    `DHCP`

4. Entre las distintas opciones aparece la lista de parámetros que el cliente solicita al servidor. Cita las cuatro primeras.
     - (53) DHCP Message Type (Discover) 
     - (61) Client identifier 
     - (50) Request IP Address (158.42.180.1)
     - (12) Host Name
## Ejercicio 4
A continuación podemos ver los mensajes de ofrecimiento de los servidores: DHCPOFFER.
1. ¿Cuántos mensajes de este tipo hay?

    `3 Mensajes`
 - ¿Qué conclusiones podemos sacar acerca del número de servidores DHCP disponibles en la red de la UPV?

    `Que hay tres servidores DHCP disponibles en la UPV`
2. Busca en el primer mensaje DHCPOffer la información para rellenar los siguientes campos:

|||
|--|--|
|Tipo de Mensaje (en el campo de opciones DHCP)|Boot Request (2)|
|Dir. IP origen del datagrama (en cab. IP)|158.42.181.250|
| Dir. IP destino del datagrama (en cab. IP)|255.255.255.255|
| Puertos origen y destino (en cab. UDP)|67, 68|
| Id. Transacción (en cabecera DHCP)|0x3ca63f58|
| Campo dir. IP Cliente (en cabecera DHCP)|0.0.0.0|
| Campo Tu dirección IP (en cabecera DHCP)|158.42.180.1|
|Campo Dir. IP del Agente Retransmisor (cab. DHCP)|158.42.181.250|

3. ¿En qué campo de los mensajes DHCPOffer aparece la mayor parte de la información de configuración IP que el Servidor ofrece al Cliente?

    `El campo de opciones`

- Comprueba todo lo que ofrecen los servidores DHCP. En particular, fíjate en el valor del campo “DHCP Server Identifier”. ¿Coincide con alguno de los que has anotado en la tabla?
    ```
    Option: (54) DHCP Server Identifier (158.42.250.5)
        Length: 4
        DHCP Server Identifier: 158.42.250.5
    ```

5. Busca y anota en cualquiera de los mensajes DHCPOffer la siguiente información IP que los servidores DHCP están ofreciendo al equipo que ha solicitado la configuración IP: dirección IP ofrecida, máscara de subred, router asignado y nombre de dominio .
    - Direción IP ofrecida: 158.42.180.1
    - Mascara de subred: 255.255.254.0
    - Router asginado:158.42.181.250
    - Nombre del domino: upv.es
6. A quién pertenece la dirección IP origen de estos datagramas (DHCPOFFER). ¿Qué conclusiones puedes sacar acerca de la localización de los servidores DHCP de la UPV con respecto a la subred en la que está el cliente?

    `Los servidores DHCP no se encuetran en la misma subred   que el cliete`

7. Compara los valores del campo “DHCP Server Identifier” de los mensajes DHCPOffer restantes que aparecen en la captura. ¿Cuántos servidores DHCP distintos están contestando?

    `3 servidores distintos`

## Ejercicio 5. 
Analizamos ahora el mensaje DHCPREQUEST con el que contesta el cliente a uno de los servidores que le ha realizado una oferta.

1. Completa la siguiente tabla con la información sobre este mensaje:

|||
|--|--|
|Tipo de Mensaje (en el campo de opciones DHCP)|Boot Request (1)|
|Dir. IP origen del datagrama (en cab. IP)|0.0.0.0|
| Dir. IP destino del datagrama (en cab. IP)|255.255.255.255|
| Puertos origen y destino (en cab. UDP)|68, 67|
| Id. Transacción (en cabecera DHCP)|0x3ca63f58|
| Campo dir. IP Cliente (en cabecera DHCP)|0.0.0.0|
| Campo Tu dirección IP (en cabecera DHCP)|0.0.0.0|
|Campo Dir. IP del Agente Retransmisor (cab. DHCP)|0.0.0.0|

2. Busca entre las distintas opciones del mensaje la dirección IP del servidor DHCP al que el cliente está contestando.

    `158.42.250.5`

## Ejercicio 6
Por último, tenemos los mensajes DHCPACK de los servidores de la UPV que confirman la obtención de la dirección IP por parte del cliente. Busca en estos mensajes las direcciones IP de los diferentes servidores DHCP de la UPV.

     158.42.250.5
     158.42.1.8
     158.42.1.81
     
## Ejercicio 7 
Y para terminar, vamos a analizar una nueva captura con el Wireshark con el fin de estudiar el tráfico DHCP que se genera cuando un nodo libera su dirección IP. Para ello abrimos la captura Captura2Practica3.pcap (la hemos obtenido ejecutando el comando: ipconfig /release).

1. ¿Qué tipo de mensaje DHCP interviene en este proceso? 

    `Boot Request (1)`

2. ¿Quién es el origen y el destino de este mensaje? 

    `Origen: 158.42.180.1
     Destino: 158.42.250.5`

3. ¿Hay contestación a este mensaje?

    `No. Es un release`
