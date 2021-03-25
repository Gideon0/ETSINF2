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

## Actividad 5 
####  Dado el siguiente estado de un sistema y suponiendo que los procesos ya no realizarán más peticiones durante el resto de su ejecución y no liberarán los recursos hasta su terminación:
![enter image description here](https://media.discordapp.net/attachments/705068953315311717/824768320666075161/unknown.png)Indique si hay o no intebloqueo.Si lo hay, diga qué procesos están interbloqueados y si no lo hay, dé una secuencia de terminación. 

## Actividad 6 
#### Dado el siguiente grafo de asignación de recursos, indique si las siguientes afirmaciones son Verdaderas (V) o Falsas (F). En su caso, justifique su respuesta.
| | | | 
|--|--|--|
| 1 | Existe más de un ciclo | | 
| 2 | Podemos encontrar una secuencia segura| | 
| 3 | El proceso P1 forma parte de un interbloqueo (o más de uno)| | 
| 4 | Es un grafo incorrecto, pues tenemos dos recursos de instancia doble, pero hay un recurso con 3 instancias | | 
| 5 | El proceso P4 no puede tener dos instancias de un mismo recurso asignadas a la vez| | 

## Actividad 7 
#### OBJETIVOS: Identificar el problema de interbloqueo. Caracterizar las situaciones de interbloqueo. Describir ejemplos de solución de estrategias de prevención de interbloqueos.ENUNCIADO: En un sistema se encuentran en ejecución cinco procesos: P0, P1, P2, P3 y P4 que utilizan los recursos R0, R1, R2, R3, R4 y RC. Inicialmente la cantidad de instanciasde cada tipo es la indicada en la siguiente tabla
| | | | | | | |
| --| -- |-- | --| --|-- |--|
|Recurso  |R0 | R1 | R2 |R3 | R4  |RC|
|Cantidad | 1| 1| 1|1|1|5|
El perfil de ejecución de un proceso Pi es distinto para los procesos pares e impares y es el indicado en la tabla siguiente:
##### Perfil de los procesos pares
```java
while(TRUE) {
	    Petición(RC);
	    Petición(Ri);
	    Petición(R((i+1) %5)));
	    UsoDeLosRecursos();
	    Libera(Ri);Libera(R((i+1) % 5));
	    Libera(RC);SecciónRestante();
    };
```
##### Perfil de los procesos impares
```java
while(TRUE) {
	    Petición(RC);
	    Petición(R((i+1) %5)));
	    Petición(Ri);
	    UsoDeLosRecursos();
	    Libera(Ri);Libera(R((i+1) % 5));
	    Libera(RC);SecciónRestante();
    };
```
Nota: Cada petición de recursos solicita un solo ejemplar del recurso en concreto y bloquea al proceso solicitante si el recurso no está disponible. 

a) ¿Es posible que en el sistema se produzca un interbloqueo? Razone la respuestay muestre una traza (o varias) para justificarlo. 

b) ¿Y si RC=4, pero todos ellos tienen el mismo perfil (sin distinguir entre pares e impares)

## Actividad 8 
#### Sea el siguiente monitor (que sigue la variante de Lampson/Redell):
```java
monitor ResourceController{
	private int availableItems;
	private condition c;
	private int k, retrying,toBeNotified;

	public ResourceController(int N) {
		vailableItems= N;k = retrying = toBeNotified = 0;
	}
	entry void request(int p) {
		if (p < availableItems) {
			availableItems -­‐= p;
		} else {
		retrying++;retry(p);
		}
	}
	entry void release(int p) {
		availableItems += p;
		toBeNotified = retrying;
		c.notify();
	}
	private void retry(int p) {
		c.wait();
		toBeNotified-­‐-­‐;
		if (toBeNotified>0)
			c.notify();
		k++;
		if (p < availableItems) {
			retrying-­‐-­‐;
			availableItems -­‐= p;
		} else{
			retry(p);
		}
	}
}
```
A) Diga cuál será el valor final de los atributos `k` y  `availableItems`  suponiendo que en el constructor se ha utilizado N=15 y que los hilos H1, H2 y H3 realizan las siguientes invocaciones secuenciales:
|  |  
|--|
| H1 invoca request(8) | 
| H2 invoca request(6) |
| H3 invoca request(8) |
| H1 invoca request(6) |
| H2 invoca request(4) |

VALOR FINAL  K  =
VALOR FINAL availableItems =

## Actividad 9
#### Indique si las siguientes afirmaciones son verdaderas o falsas. Justificarlo 
||||
|--|--|--|
| 1 |Las situaciones de interbloqueo pueden evitarse si el sistema monitoriza las peticiones de recursos, denegando las que generen peligro de interbloqueo||
| 2 |Las situaciones de interbloqueo pueden prevenirse asignando los recursos de manera que nunca se genere una espera circular.||
| 3 |En muchossistemas operativos, como Unix o Windows, se utilizan grafos de asignación de recursos para evitar los interbloqueos.||
| 4 |Las condiciones de Coffman permiten diseñar sistemas que cumplan con todas ellas, para así garantizar que no se producirán interbloqueos.||
| 5 |Las condiciones de Coffman se utilizan para diseñar algoritmos de detección de interbloqueos.||
