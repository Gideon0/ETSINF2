# Unidad 5 - Otras herramientas de sincronización
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

||||
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
|Se ofrecen distintos tipos, con semántica diferente (orientados a exclusión mutua, orientados a resolver el problema de lectores-escritores|||
|Dispone de un método que no suspende al invocador si el “lock” ya ha sido cerrado por otro hilo|||
|Ofrece un método que sí suspende al invocador si el “lock” ya ha sido cerrado por otro hilo.|||
|Se puede establecer un plazo máximo de espera al solicitar la entrada al monitor|||
|Se puede preguntar por el estado del monitor antes de solicitar acceso al mismo.|||
|Se puede utilizar más de una variable condición asociada al monitor|||
|Se puede cerrar el monitor utilizando un método de la una clase A, y abrirlo en un método de la clase B|||
|Se puede cerrar el monitor utilizando un método de la una clase A, y abrirlo con otro método de la clase A|||
|Todos los métodos de la clase monitor deben llevar la etiqueta synchronized.|||
|Se pueden interrumpir las esperas de los hilos que desean adquirir el lock|||
|El programador no debe preocuparse del cierre y apertura de los locks. La gestión es implícita.|||
|Cuando se produce una excepción, se debe controlar que en el código asociado a la excepción se abra el lock.|||
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
## Actividad 6 
#### OBJETIVO:  Interpretar  el  uso  de  colecciones  concurrentes  thread-safe (ejemplo: BlockingQueue).

#### ENUNCIONDO:  Dado el siguiente ejemplo del utilización de la clase BlockingQueue...
```java

class Producer implements Runnable{
    private final BlockingQueue queue;
    Producer(BlockingQueueq){queue=q;}
    publicvoidrun(){
        try{
            while(true){
                queue.put(produce());}
        }catch(InterruptedExceptionex){...}
    }
    Objectproduce(){...}
}

class Consumer implements Runnable{p
    private final   BlockingQueue   queue;
    Consumer(BlockingQueueq){queue=q;}
    public void run(){
        try{
            while(true){consume(queue.take());}
            }catch(InterruptedExceptionex){...}
    }
    void consume(Objectx){...}
}
class Setup{
    voidmain(){
        BlockingQueueq=newSomeQueueImplementation();
        Producerp=newProducer(q);
        Consumerc1=newConsumer(q);
        Consumerc2=newConsumer(q);
        newThread(p).start();
        newThread(c1).start();
        newThread(c2).start();
    }
}
```
a) ¿Qué problema se pretende resolver en este ejemplo?¿Cuántos hilos hay? ¿Qué representan? ¿Qué información/recurso comparten esos hilos?

b) Si un hilo quiere extraer un ítem de una cola que está vacía, ¿tendrá que esperar? ¿Dónde se controla esto?

c) Si un hilo quiere insertar un ítem enuna cola que está llena, ¿tendrá que esperar? ¿Dónde se controla esto

d) ¿Podrían producirse condiciones de carrera? ¿Por qué?

e) ¿Podemos decir que la cola BlockingQueuees Thread-Safe? ¿Por qué?

## Actividad 7
#### OBJETIVOS: Describir el funcionamiento de las clases atómicas. Comparar las variables atómicas (ej. AtomicLong) con el uso de monitores.

#### Enuncioado: A  continuaciónse  muestra  un  ejemplo  de  uso  de  Variables  Atómicas  y  se compara con la creaciónde nuestras propias clases. En concreto:

```java
// Opción A: Usando nuestra propia clase 
class ID {
    private static long nextID = 0;

    public static synchronized longgetNext(){
            returnnextID++;
        }
    }


public class EjCounter extends Thread{
    IDcounter;

    public EjCounter(IDc){counter=c;}

    public void run(){
        System.out.println("counter value: "+
        (counter.getNext()));
    }

    public static void main(String[]args){
        IDcounter=newID();
        newEjCounter(counter).start();
        newEjCounter(counter).start();
        newEjCounter(counter).start();
    }
}
```
```java
//Opción B: Usando variables atómicas
public class EjCounter extends Thread{
    AtomicLongcounter;

    publicEjCounter(AtomicLongc){counter=c;}

    publicvoidrun(){
        System.out.println("counter value: "+
        (counter.getAndIncrement()));
    }
    
    public static void main(String[]args){
        AtomicLongcounter=newAtomicLong(0);
        newEjCounter(counter).start();
        newEjCounter(counter).start();
        newEjCounter(counter).start();
    }
}
```

a) Analicelas dosopciones.¿Qué es lo que hacen?¿Cuál será el valor de la variable counteren ambos casos?¿Se pueden producir condiciones de carrera en algún caso?

b) ¿Para qué creeque sirven los siguientes métodos de la clase AtomicLong? Indiquecuál sería su instrucción equivalente, haciendo uso de laclase IDdefinida con la opción A. Para ello, añadanuevos métodos que permitan implementar esa misma funcionalidad. 

|Método|Funcionamiento|Método equivalente en nuetra clase ID|
|--|--|--|
|`counter.addAndGet(5);`|||
|`counter.getAndDercrement();`|||
|`counter.incrementAndGet()`|||

## Actividad 8 
#### OBJETIVOS: Ilustrar  el  uso  de  semáforos  (Semaphore)  para  la sincronización.

#### ENUNCIADO: A  continuación  se  muestra  uncódigo  Java que  trata  de  resolver  el problema “Productor-Consumidor con buffer acotado

```java
class Buffer{ 
    private int head, tail, elems,size;
    private int[] data;
    private Semaphore item;
    private Semaphore slot;
    private Semaphore mutex;

    publicBuffer(int s) {
        head=tail=elems=0;  
        size=s;
        data=new int[size];
        item=new Semaphore(0,true);
        slot=new Semaphore(size,true);
        mutex=new Semaphore(1,true);
    }

    public int get(){
        try{
            item.acquire();
        }catch(InterruptedException e){}

        try{
            mutex.acquire();
        }catch(InterruptedException e){}
        
        intx=data[head];
        head=(head+1)%size;
        elems--;
        mutex.release();
        slot.release();
        return x;
    }
    
    public void put(intx){
        try{
            slot.acquire();
        }catch(InterruptedException e){}

        try{
            mutex.acquire();
        }catch(InterruptedException e){}

        data[tail]=x;
        tail=(tail+1)%size;
        elems++;
        mutex.release();
        item.release();
    }
}
```
Dadas las siguientes afirmaciones, indique si son VERDADERAS o FALSAS, justificando su respuesta.

||V/F|
|--|--|
|El código es incorrecto, pues cada objeto Buffer debería tener un ReentrantLockcomo atributo interno para poder generar semáforos dentro de él.||
|El semáforo slot proporciona sincronización condicional, suspendiendo al hilo productor cuando no haya huecos libres en el buffer||
|El semáforo item proporciona sincronización condicional, suspendiendo al hilo consumidor cuando no haya elementos en el buffer.||
|El código es incorrecto, pues los métodos put() y get() deberían estar calificados como “synchronized” para poder utilizar los semáforos.||


## Actividad 9 

#### OBJETIVOS: Ilustrar el funcionamiento de las barreras, distinguiendo entre CyclicBarriery CountDownLatch.

#### ENUNCIADO: Complete la siguiente tabla de comparación entre estas dos  clases. Indiquetambién qué método o métodos ofrecen la funcionalidad solicitada, en cada caso. Para ello, puede emplear la documentación de java.util.concurrentpara completar su respuesta

||CyclicBarrier|CountDownLatch|

|¿Lleva un contador(explícito o implícito)?|||
|¿Permite inicializar el contador en la creación?|||
|¿Se puede incrementar el contador?|||
| ¿Cómo?¿Se puede decrementar el contador? |||
|¿Cómo?Método que se emplea para que el hilo se quede esperando|||
|¿Permite ejecutar alguna acción cuando el último hilo llega al punto de sincronización?|||
|¿Se puede reutilizar?|||

## Actividad 10 
#### OBJETIVOS:  Hacer  uso  de  las  herramientas  proporcionadas  por  la biblioteca  java.util.concurrent.
#### ENUNCIADO: Dado el siguiente programa en Java, en el que la columna de la izquierda de cada  línea  de  código  proporciona  su  número  de  línea,  que  puede  ser  utilizado  para refenciarla.  

## ACTIVIDAD 11
#### OBJETIVOS:Describir  el  funcionamiento  de  las variablesatómicas  y compararlas con los monitores. Ilustrar la utilización de los locksy las condiciones. Ilustrar el uso de barreras. 
