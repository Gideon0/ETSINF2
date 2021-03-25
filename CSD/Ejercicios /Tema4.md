## Actividad 1 
#### Indique si las siguientes afirmaciones son verdaderas o falsa. Justificarlo

| |Las condiciones de Coffman... | V/F|
|--|--|--|
| 1 | ...son 4 exclusión mutua, progreso, espera limitada y "no expulsión            | **F**
| - | `exclusión mutua, retención y espera, no expropiación y espera circular`| |
| 2 | ... son solamente cuatro, que incluyen “retención y espera” y “determinismo”. |
| 3 | ... son condiciones suficientes; es decir, si se cumplen todas simultáneamente se puede garantizar que ha ocurrido un interbloqueo. | 
| 4 | ... son condiciones necesarias. Basta con evitar una de ellas para que no pueda generarse un interbloqueo| 
| 5 | ... son necesarias y suficientes. Si se cumplen todas, entonces hay interbloqueo. Si hay interbloqueo, entonces seguro que se cumplen todas.|
| 6 | ... proporcionan la base para el diseño de estrategias de prevención de interbloqueos.|
| 7 | Una de las condiciones implica que “mientras un recurso está asignado a un hilo, otros no pueden usarlo”. |
| 8 | Una de las condiciones implica que “un recurso asignado sólo lo puede liberar su dueño” |  

## Actividad 2
En una determinada empresa dedicada a la edición y maquetación de documentos existen algunas impresoras, equipos multifunción y plotters, con las siguientes características: 
 - 2 impresoras láser monocromas, que manejan papel de formato A4. 
 - 3 equipos multifunción (impresora + escáner) de chorro de tinta (negro / color) que manejan papel de formato A4. 
 - 1 plotter monocromo para trazado de documentos capaz de utilizar papel de formato A2. Este dispositivo no se llegará a utilizar para impresión de documentos de texto y/o gráficos que puedan ser manejados por el resto de equipos

Las peticiones que podrán generar las aplicaciones son de los siguientes tipos:
 - Imprimir documentos en monocromo en un formato de papel A4. 
 - Imprimir documentos en color en un formato de papel A4. 
 - Escanear documentos en color en un formato A4. 
 - Trazar planos/mapas en formato A2.

#### Discuta qué recursos tendrán que considerarse y cuántas instancias de cada uno de ellos habrá a la hora de modelar este sistema mediante de Grafo de Asignación de Recursos (GAR)

## Actividad 3 
#### Dado el siguiente estado de un sistema y suponiendo que tras esto ningún proceso realiza ninguna petición más y no liberan los recursos hasta su terminación
![](https://media.discordapp.net/attachments/705068953315311717/824756954701627443/unknown.png)
a) Indique si hay o no interbloqueo. Si lo hay, diga qué procesos están interbloqueados y si no lo hay, de al menos una secuencia de terminación. 

b) Redibuje el estado del sistema anterior, par a que presente un estado del sistema totalmente contrario al indicado en el apartado anterior.  Es decir, si en el apartado "a" el sistema presenta interbloqueo, ahora añada/elimine las flechas necesarias para que el sistema no presente interbloqueo. 

## Actividad 4 
#### Dado el siguiente estado de un sistema y suponiendo que a los procesos P1 y P4 lesqueda pendiente todavía realizar una petición cada uno de una instancia de R2 (se desconoce el orden en que efectúan tales peticiones) y que tras esto ningún proceso realiza ninguna petición más y no liberan los recursos hasta su terminación:
![enter image description here](https://media.discordapp.net/attachments/705068953315311717/824760295560839229/unknown.png)Indique si hay o no interbloqueo. Si lo hay, diga qué procesos están interbloqueados y si no lo hay, dé al menos una secuencia de terminación. 
***Nota:*** *El proceso P4 realizará la petición a la instancia de R2 una vez haya obtenido la instancia de R1 previamente solicitada (según se  muestra en el GAR)*  
