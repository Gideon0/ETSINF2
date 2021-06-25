# Parcial 2

## Tema 4. Árboles Binarios de Búsqueda (ABB)

- Raíz: primer nodo
- Nodo sin hijos: hoja
- Nodo que no es hoja: nodo interno
- Grado de un nodo: número de hijos
- Longitud de un camino: número de aristas
- Profundidad: longitud del camino desde la raíz al nodo
- Altura: longitud camino desde el nodo hasta la hoja más baja
- ABB completo si tiene todo los neveles llenos o al menos que en el último estén todas las hojas a la izquierda
- Árbol equilibrado: altura del subárbol izquierdo difiere del subárbol derecho máximo en 1
- Recorrido en Anchura: por niveles de izquierda a derecha
- Recorrido en Profundidad: nodos se visitan bajando por las ramos del árbol
  - Pre-orden: raíz, izquierda, derecha
  - In-orden: izquierda, raíz, derecha (ordenado ascendente)
  - Post-orden: izquierda, derecha, raíz

```java
class NodoABB <E> {
    E valor;
    NodoABB izq;
    NodoABB der;
    public NodoABB(E valor){// hoja}
    public NodoABB(E valor, NodoABB<E> izq, NodoABB<E> der){// nodo interno}
}
```

```java
public class ABB<E extends Comaprable<E>>{
    public E recuperar(E x)
    public int talla;
    protected int talla(NodoABB <E> nodo)
    public boolean esVacio()
    public void insertar(E x)
    protected NodoABB<E> insertar(E x, NodoABB<E> nodo)
    public E recuperarMin()
    public E eliminarMin()
    public void eliminar(E x)
    public String preOrder()
    public String porNiverles()
    public E sucesor(E e)
}
```

### Map Ordenado

```java 
public class EntradaMap<C extends Comparable<C>,V> implements Comprable<EntradaMap<C,V>>{

  public EntradaMap(C c, V v)
  public C getClave()
  public V getValor()
  public void setClave(C nueva)
  public void setValor(V nueva)
  public boolean equals(Object otro)
  public int compareTo(EntradaMap<C,V>  otro)
  public String toString()

}
```

```java
public interface MapOrdenado <C extends Comparable<C>, V> extends Map<C,V> {
  EntradaMap<C,V> recuperarEntradaMin()
  C recuperarMin()
  EntradaMap<C,V> recuperarEntradaMax()
  C recuperarMax()
  EntradaMap<C,V> sucesorEntrada(C c)
  C sucesor(C c)
  EntradaMap<C,V> predecesorEntrada(C c)
  C predecesor(C c)
  EntradaMap<C,V> eliminarMin()
  C eliminarMin()

  ListaConPI<C> claves();
  
}
```

## Tema 5. Cola de prioridad y Montículo binario

```java
public interface ColoPrioridad<E extends Comparable<E>> implements ColaPrioridad<E>{
  void insertar(E x)
  E recuperarMin()
  E eliminarMin()
  boolean esVacia()
}
```

### Montículo binario

- Almacena en un array según su recorrido por niveles

|El nodo raíz|Posición 1|Posición 0|
|--|--|--|
|Hijo izquierdo     |2 * i       | (2 * i) + 1|
|Hijo derecho       |(2 * 1) + 1 | (2 * i) + 2|
|Padre              | i/2        | (i-1)/2    |
|Último nodo interno|talla/2     |talla/2 - 1 |
|Primera hoja       |talla/2 +1  | talla/2|

```
