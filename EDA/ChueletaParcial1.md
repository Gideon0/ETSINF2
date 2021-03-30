# Tema1 

##  Estructuras de datos 

### ArrayCola
- Metodos
  - `public void encolar(E e);`
  - `publuc T desencolar();`
  - `public T primero();`
  - `public boolean esVacia;`
- Atributos
  - `T[] elArray;`
  - `int final;`
  - `int principio;`
  - `int talla;`
### ArrayPila
- Metodos
  - `public void apilar(E e);`
  - `public E desapilar();`
  - `public E tope();`
  - `public boolean esVacia();`
- Atributos
  - `T[] elArray`
  - `int tope`
 
 ---
 
### NodeLEG
```java
  public class NodoLEG<E> {
      E dato;
      NodoLEG<E> siguiente;

      public NodoLEG() {
          this.dato = null;
          this.siguiente = null;
      }

      public NodoLEG(E e, NodoLEG<E> s) {
          this.dato = e;
          this.siguiente = s;
      }

      public NodoLEG(E e) {
          this.dato = e;
          this.siguiente = null;
      }
  }
```


### LEGCola
- Metodos
  - `public void encolar(E e);`
  - `publuc T desencolar();`
  - `public T primero();`
  - `public boolean esVacia`
- Atributos
  - `private NodoLEG<E> primero;`
  - `private NodoLEG<E> ultimo;`
  - `private int talla;`



### LEGListaPI
- Metodos 
  - `void insertar(E e);`
  - `void eliminar();`
  - `E recuperar();`
  - `void irInicio();`
  - `void irFinal();`
  - `void siguiente();`
  - `boolean esFinal();`
  - `boolean esVacia();`
  - `int talla();`
- Atributos
  - `NodoLEG<E> primero;`
  - `NodoLEG<E> ultimo;`
  - `NodoLEG<E> PI_ant;`
  - `int talla;`
# Tema 2 
### Notación asintótica 
- Con estancias significativa

![equation](https://latex.codecogs.com/gif.latex?%5Clarge%20T%28x%29%20%5C%2C%20%5Cepsilon%20%5C%2C%20%5COmega%20%5C%3A%20%5Crightarrow%20Mejor%5C%2C%20caso)

![equation](https://latex.codecogs.com/gif.latex?%5Clarge%20T%28x%29%20%5C%2C%20%5Cepsilon%20%5C%2C%20%5Ctextup%7BO%7D%20%5C%3A%20%5Crightarrow%20Peor%5C%2C%20caso)


- Sin estancias significativas 

![equation](https://latex.codecogs.com/gif.latex?%5Clarge%20T%28x%29%20%5C%2C%20%5Cepsilon%20%5C%2C%20%5CTheta)

# Tema 3

### NodeHash
```java
public class NodeHash<C,V> {
    C clave;
    V valor;
    NodeHash<C,V> sig;

    public NodeHash(C clave, V valor, NodeHash<C,V> sig) {
        this.clave = clave;
        this.valor = valor;
        this.sig = sig;
    }
}
```
### TablaHash
- Metodos 
  - `V insertar(C clave, V valor);`
  - `V eliminar(C clave);`
  - `V recuperar(C clave);`
  - `boolean esVacia();`
  - `int talla();`
  - `ListaPI<C> claves();`  
- Atributos
  - `public NodeHash<C,V> elArray []; //CUBETAS`
  - `protected int talla;`