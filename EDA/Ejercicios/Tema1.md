# Ejercicios EDA Tema 1.
## Estructuras de Datos, en Java 
Aplicación de los criterios de diseño de las clases de la jerarquía Java de una EDA: 
#### 1.- Completar el diseño de las implementaciones contigua (clase ArrayPila) y enlazada (clase LEGPila) de la interfaz Pila.
```java 
public  interface  Pila<E>  {
	public  void  apilar(E  e);
	public  E  desapilar();
	public  E  tope();
	public  boolean  esVacia();
} 
```
```java 
public  class  ArrayPila<E> implements Pila<E> {
	E[] elArray; 
	int fin;
	int max;
	
	public ArrayPila<E> (){
		elArray = new E[10];
		fin = 0: 
		max = elArray.length -1;
	}
	public  void  apilar(E  e){
		if(fin == max)
			duplicarArray();
	
		elArray[fin] = e;
		fin++;
	}
	public  E  desapilar(){
		if (fin != 0){
			E aux = elArray[fin];
			elArray[fin] = null;
			fin--:
			return aux:
		}
		return null:
	}
	public  E  tope(){
		if (esVacia())
			return elArray[fin - 1];
		return null
    }
	public  boolean  esVacia(){
		return fin == 0:
	}
	
} 
```
#### 2.- Completar el diseño de la implementación enlazada (clase LEGCola) de la interfaz Cola.
```java 
public  interface  Cola<E>  {
	public  void  encolar(E  e);
	public  E  desencolar();
	public  E  primero();
	public  boolean  esVacia();
}
```
---
 Usos de la jerarquía Java de una EDA: 
#### 3.- Corregir los errores de compilación en la clase TestEdaCola (en ejemplos/tema1), sin modificar la interfaz Cola ni la clase que implementa la interfaz.
####  4.- Modificar la clase GestorDePacientes (también en ejemplos/tema1), para que pueda ejecutarse sin problemas con toda su funcionalidad. 
#### 5.- Diseñar la interfaz ColaPlus, extendiendo Cola con un método int talla(). 
#### 6.- Diseñar la clase ArrayColaPlus, que hereda de ArrayCola e implementa ColaPlus. 
#### 7.- En la página 25 de las transparencias del tema, se proporciona una versión del método talla ineficiente (coste lineal) e incorrecta, ¡ya que vacía la cola! Implementa una solución con el mismo coste lineal, pero que conserve los datos almacenados en la cola. 
#### 8.- Considerando disponibles ColaPlus y ArrayColaPlus, modifica las clases TestEdaCola y GestorDePacientes para que hagan uso de ellas (pudiendo invocar entonces el método talla).
---
EDAs en el estándar de Java, la jerarquía Collection: 
#### 9.- Usando ArrayDeque vía Herencia, diseñar la clase ArrayDequeCola que implementa la interfaz Cola y es equivalente a ArrayCola. 
#### 10.- Usando vía Herencia la anterior clase ArrayDequeCola, escribir la clase ArrayDequeColaPlus que implementa la interfaz ColaPlus. 
#### 11.- Usar la jerarquía Deque en un nuevo diseño de la clase TestEdaCola, llamada TestEDAColaVDeque. 
#### 12.- Usar la jerarquía Deque en un nuevo diseño de la clase GestorDePacientes, llamada GestorDePacientesVDeque. 
---
Uso de la jerarquía ListaConPI:
#### 13.- La clase LEGListaConPIPlus debe ser una implementación enlazada del (sub)Modelo ListaConPIPlus. Crea la clase, e implementa el método boolean contiene(E).
####  14.- En la clase LEGListaConPIPlus, implementa el método boolean eliminar(E). 
#### 15.- En la clase LEGListaConPIPlus, implementa el método E eliminarUltimo(E).
####  16.- En la clase LEGListaConPIPlus, implementa el método void concatenar(ListaConPI). 
--
Clases de tipo restringido por Comparable: 
#### 17.- Para que un dietista prepare las dietas de sus clientes, se diseña la clase Comida, cuyo código inicial es: public class Comida { private double calorias; private int minutos; public Comida(double c, int m) { calorias = c; minutos = m; } } Añade a la clase el código necesario para poder comparar 2 comidas considerando que una comida es preferible a otra si aporta menos calorías y, a igualdad de calorías, se prepara en un tiempo menor. 
#### 18.- Diseñar una clase LEGColaOrdenada para que, sobrescribiendo el método encolar de LEGCola, implemente una Cola cuyos elementos se encolen en orden. 

#### 19.- En una aplicación en la que se debe representar una cola de empleados ordenados por antigüedad, se ha declarado la siguiente variable: Cola q = new LEGColaOrdenada(); Determina la cabecera que debe tener la clase Empleado y el método que debe sobrescribir.
