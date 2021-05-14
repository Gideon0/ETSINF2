# Actividad 2

## Objetivos: Ilustrar el algoritmo de sincronización de Berkeley

En un sistema distribuido con 4 nodos se emplea el algoritmo de Berkeley para sincronizar sus relojes. Uno de los nodos (nodo A) actúa como servidor del algoritmo, mientras que los otros nodos (nodos B, C y D) actúan como clientes. Supongamos que cada nodo tiene un reloj que indica el número de tics transcurridos desde la misma base temporal; y que en un momento determinado tienen el siguiente valor para sus relojes: CA=10000, CB=10005, CC=10005 y CD=10010 (siendo Cn el reloj de cada nodo n). En dicho momento el servidor (nodo A) inicia el algoritmo de Berkeley. 

Si asumimos que han transcurrido 30 ticks de reloj durante todos esos pasos, ¿cuál será el valor final del reloj de cada nodo?

---- 

- 30 ticks entre todas las fases => cada fase será de 10 ticks (3 fases)

- Asumimos que todos los nodos están a misma distacia y que el tiempo de ida y vuelta es el mismo

#### Paso 1

El nodo A difunde su reloj inicial T0

| Instante inicial |           |
| ---------------- | --------- |
| **T0**           | **10000** |

<img title="" src="attachment/2021-05-13-19-45-39.png" alt="1" width="432" data-align="center">

#### Paso 2

Los nodos cliente notifica la diferencia

| D1(B)     | 10015 - 10000 = 15     |
| --------- |:---------------------- |
| **D2(C)** | **10015 - 10000 = 15** |
| **D3(D)** | **10020 - 10000 = 20** |

<img title="" src="attachment/2021-05-13-19-47-57.png" alt="2" width="429" data-align="center">

#### Paso 3

El nodo A ajusta la diferencia notificada y la notifica al resto

| T1      | 10020                           |
| ------- | ------------------------------- |
| **D1'** | **15 - (10020 - 10000)/2 = 5**  |
| **D2'** | **15 - (10020 - 10000)/2 = 5**  |
| **D3'** | **20 - (10020 - 10000)/2 = 10** |

| D         | (5 + 5 + 10 + 0)/4 = 5 |
| --------- | ---------------------- |
| **A1(B)** | **5 - 5 = 0**          |
| **A2(C)** | **5 - 5 = 0**          |
| **A3(D)** | **5 - 10 = -5**        |

<img title="" src="attachment/2021-05-13-19-49-12.png" alt="3" width="445" data-align="center">

### Paso 4

<img title="" src="attachment/2021-05-13-19-50-21.png" alt="" data-align="center" width="453">

Valor final será de **10.035** en cada nodo (a expeción del nodo D ya que no se puede retrasar, sino que irá más despecio)

![](attachment/2021-05-13-19-50-55.png)

## Activodad 4

![](attachment/2021-05-14-12-48-01.png)

B) Cuncurrentes con I 

C y D

![](attachment/2021-05-14-12-51-55.png)

C) Concurrente con el evento E

K y L 

![](attachment/2021-05-14-12-54-00.png)

D
