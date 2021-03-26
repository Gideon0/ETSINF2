## Actividad 1
#### Enumere los distintos inconvenientes que ofrecen las primitivas básicas de Java (i.e. monitores) para la sincronización de tareas

Limitaciones de las primitivas básicas de Java relacionadas con la exclusión mutua:
```

``` 
Limitaciones  de  las  primitivas  básicas  de  Java  relacionadas  con  la sincronización condicion
```

``` 

## Actividad 2 
#### A fin de mostrar las principales características de los Locks, que lo diferencian de los monitores clásicos de Java, indique brevemente qué realiza cada unode los siguientes métodos de la clase ReentrantLock(puede consultar la documentación de la librería java.util.concurrent)

|||
|--|--|--| 
|`ReentrantLock(boolean fair)`| Para qué sirve el parámetro “fair”?|
|`tryLock()`| ¿Podemos usar este método para romper la condición de  “retención y espera”? ¿Cómo?|
|`tryLock(long timeout, TimeUnit unit)`| ¿Para qué sirve el timeout?|
|`newCondition`| ¿Cuántas  veces  podríamos  utilizareste métododentro de un lock?|

## Actividad 3 
#### OBJETIVO: Ilustrar la utilización de Locksy Conditions. Compararlos con los monitores clásicos.
#### ENUNCIADO: Para cada una de las siguientes afirmaciones, indiquesi se corresponden con características de los Locks de la biblioteca java.util.concurrent, de los monitores básicos de Java, o bien de ambos. 
||RenntrantLock|Monitores básicos de Java|
|--|--|--|
|Se  ofrecen  distintos  tipos,  con  semántica  diferente (orientados a exclusión mutua, orientados a resolver el problema de lectores-escritores|||
|Dispone de un método que no suspende al invocador si el “lock” ya ha sido cerrado por otro hilo|||
|Ofrece  un  método  que  sí  suspende  al  invocador  si  el “lock” ya ha sido cerrado por otro hilo.|||
|Se  puede  establecer  un  plazo  máximo  de  espera  al solicitar la entrada al monitor|||
|Se puede preguntar por el estado del monitor antes de solicitar acceso al mismo.|||
|Se  puede  utilizar  más  de  una  variable  condición asociada al monitor|||
|Se puede cerrar el monitor utilizando un método de la una clase A, y abrirlo en un método de la clase B|||
|Se puede cerrar el monitor utilizando un método de la una clase A, y abrirlo con otro método de la clase A|||
|Todos los métodos de la clase monitor deben llevar la etiqueta synchronized.|||
|Se  pueden  interrumpir  las  esperas  de  los  hilos  que desean adquirir el lock|||
|El  programador  no  debe  preocuparse  del  cierre  y apertura de los locks. La gestión es implícita.|||
|Cuando  se  produce  una  excepción,  se  debe  controlar que en el código asociado a la excepción se abra el lock.|||
|Todos los hilos que se suspenden en alguna condición van a parar a una única cola (la misma para todos).|||

## Actividad 4 
#### Dado el siguiente ejemplo de utilización de las clases Locks y Conditions
```java
class BufferOK implements Buffer {
    private int elems, cabeza, cola, N;
    private int[] datos; 
    Condition noLleno, noVacio;
    ReentrantLock lock;

    public BufferOk(int N){
        datos = new int[N]; 
        this.N = N;
        cabeza = cola = elems = 0; 
        lock = new ReentrantLock();
        noLleno = lock.newCondition();
        noVacio = lock.newCondition();
    }

    public int get() {
        int x;
        try{
            lock.lock();
            while(elem == 0){
                System.out.println("consumidor esperando...");
                try{noVacio.await();}
                catch(InterruptedException e){}
            }
            x = datos[cabeza]; 
            cabeza = (cabeza + 1) % N;
            elemns--;
            noLleno.signal(); 
        } finally {lock.unlock();}
        return x; 
    }

    public void put(int x){
        try{
            lock.lock();
            while (elems == N){
                System.out.println("productor esperando...");
                try{noLleno.await();}
                catch(InterruptedException e){}
            }
            datos[cola] = x; 
            cola = (cola + 1)%N;
            elems++;
        } finally {lock.unlock();}
    }
}

```

## Actividad 5 
#### OBJETIVOS: Ilustrar la utilización de Locksy Conditions. Compararlos con los monitores clásicos.

#### ENUNCIADO: En el siguiente código se desea implementar una solución en Java al monitor para el Crosswalkvisto en las actividades de la Unidad 3. En dicha solución se desea hacer uso  de  las  construcciones Locky Conditionque  se  ofrecen  en  la  biblioteca java.util.concurrent

#### Completedicho  código  con  las  instrucciones  necesarias  que  faltan  (atendiendo  a  los comentarios que se indican), para permitir la utilización adecuada de dichas construcciones.

```java 
public class Crosswalk{
    private int c, c_waiting, p, p_waiting;
    private Condition OKcars, OKpedestrians;
    private ReentrantLock lock;

    public Crosswalk() {
        c = c_waiting = p = p_waiting = 0;
        lock=new ReentrantLock();
        OKcars=lock.newCondition();
        OKpedestrians=lock.newCondition();
        }
        
    public void enterC() {
            //cerrar lock    
            
            
        c_waiting++;
            while (p >0)
            //esperar a que los coches puedan pasar
        c_waiting--;
        c++;
            //notificar que los coches podrían pasar
            
            
            //abrir lock
    }
            
    public void leaveC() { 
        //cerrar lock
        c--;
        //notificar que los coches ya pueden pasar
        
        
        
        
        //notificar que los peatones ya pueden pasar
        
    //abrir lock
    }
    public void enterP() {
        //cerrar lock
        p_waiting++;
        while ((c>0)||(c_waiting >0))
        //esperar a que los peatones puedan pasar
        p_waiting--;
        p++;
        //notificar que los peatones ya pueden pasar
        
        //abrir lock
    }
    public void leaveP() { 
        //cerrar lock
        p--;
        //notificar que los coches ya pueden pasar
        //notificar que los peatones ya pueden pasar  
        //abrir lock
    }
}

```
