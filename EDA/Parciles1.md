# Parciales de EDA 
## Junio de 2020
### Pregunta 1 
Se tiene una ListaConPI genérica cuyos elementos están ordenados ascendentemente. En dicha lista, algunos elementos pueden aparecer repetidos dos veces. Se pide diseñar un método que elimine los elementos repetidos de la ListaConPI y los guarde en una Pila.
Por ejemplo, si el contenido de la ListaConPI es:   [1]-[2]-[2]-[3]-[4]-[4]-[5]
Tras la llamada al método la ListaConPI quedará: [1]-[2]-[3]-[4]-[5] y los guarde en una Pila

Completa los huecos del siguiente método con una de las opciones (indicando la letra de la opción) que figuran a la derecha. Una opción puede aparecer en más de un hueco. 
```java
public static <E> Pila <E> eliminarRepetidos(ListaConPI<E> l){
	Pila <E> p = new /* Hueco 1 */ <E> (); 
	if (/* Hueco 2 */()) 
		return p:
	/* Hueco 1 */(); 
	E e1 = /* Hueco 4 */();
	do{
		/* Hueco 5 */();
		if (/* Hueco 6 */()){
			E e2 = /* Hueco 7 */();
			if (/* Hueco 8 */) {
				/* Hueco 9 */(e2);
				/* Hueco 10 */();
			}
			e1 = e2;
		}
	}while (/* Hueco 11 */());
	return p;
}
```
||Opciones| |Huecos| |
|-|-|-|-|-|
|A|Pila||1|
|B|ArrayPila||2|
|C|LEGPila||3|
|D|p.apilar||4|
|E|p.esVacia||5|
|F|l.inicio||6|
|G|l.siguiente||7|
|H|l.esFin||8|
|I|!l.esFin||9|
|J|l.esVacia||10|
|K|!l.esVacia||11|
|L|l.recuperar|||
|M|l.eliminar|||
|N|e1.equals(e2)|||
|O|e1.compareTO(e2) ==0|||

### Pregunta 2
#### 1. Completa la implementación del siguiente método
El método devuelve el número de Strings de una longitud dada, x, en un array de Strings, v, ordenado ascendentemente por longitud de String. Se pide completar los huecos, de modo que la implementación sea la más eficiente posible.
```java
public static int deLongitud(String[] v, int x){
	return deLongitud(v, x, 0, v.length -1);
}

public static int deLongitud (String[] v, int x, int i, int j){
	if(i > j) return 0;
	int m = /** hueco 1 **/;
	int l = v[m].length();
	if(l == x) {
		return 1 = /** hueco 2 **/;
	} else if (l < x){
		return /** hueco 3 **/;
	}else {
		return /** hueco 4 **/;
	}
}
```

|Huecos|Codigo|
|--|--|
|Hueco 1|(i + j) / 2|
|Hueco 2|deLongitudX(v, x, i, m - 1) + deLongitud(v, x, m + 1, j) |
|Hueco 3|deLongitudX(v, x, m + 1, j)|
|Hueco 4|deLongitudX(v, x, i, m - 1)|

#### 2.- Obtener el conste Temporal Asintótico del método
Sea x la talla del problema que indica el tamaño del subarray de cada llamada.
Completa los huecos con aquellas de las siguientes opciones que consideres adecuadas:**Theta, Omega, O, (1), (logx), (x), (x*x), (x*logx)**
Se debe respetar la notación, incluidos los paréntesis que aparecen en algunas de la opciones. 

**Como mínimo (cota inferior), T(x) ε Omega(log x)**

**Como máximo (cota superior), T(x) ε O(x)**
### Pregunta 3
#### Cuestión 1. Dado el histograma de ocupación de un table hash, contesta a las siguientes preguntas:
![enter image description here](https://media.discordapp.net/attachments/705068953315311717/826186187357421668/unknown.png?width=1433&height=382)
a) ¿Cuántas cubetas tiene la tabla? 
`10`

b) ¿Cuántos elementos tiene la tabla? 
`14`

c) ¿Cuál es su factor de carga? 
`1,4`
#### Cuestión 2. Dibuja una tabla hash que pueda haber producido el histograma anterior. Dicha tabla hash almacenará enteros en el rango [10..99] (elige los enteros que desees para crearla, pero que estén dentro de ese rango). La función de dispersión usada es H(x) = x % elArray.length. Para dibujar la tabla, usa el siguiente formato: cada una de las filas representa una cubeta de la tabla hash, la primera columna será el índice de cubeta, y, a continuación, los elementos almacenados en esa cubeta, separados por comas. Usa tantas filas como necesites.
|Cubetas|Elementos|
|--|--|
|0||
|1|11|
|2|12|
|3|13|
|4|14|
|5|15,25|
|6|16,26|
|7|17,27|
|8|18,28|
|9|19,29|
#### Cuestión 3. Si se insertan 5 elementos distintos que no estaban en la tabla, ¿qué histograma(s) podría(n) corresponder al resultado? Marca con verdadero ("V") o falso ("F") las siguientes afirmaciones
![enter image description here](https://media.discordapp.net/attachments/705068953315311717/826187866081853480/unknown.png?width=1433&height=401)

El histograma de la izquierda -> num. de cubetas =  5 + 5 + 1 = 11 ≠ 10   => **F**

El histograma de la derecha   -> num. de cubetas = 1 + 3 + 4 + 1 + 1 = 10 => **V**

##  Marzo 2019 
### 1.- El siguiente método de la clase ArrayCola invierte el orden de los elementos de una Cola, usando una ListaConPI auxiliar. Escribe en cada recuedro el número de la opción (ver listado a la derecha) que le corresponde. 
```java 
public void invertir(){
	ListaConPI<E> lpi = /** 6 **/();
	while (!this.esVacia()){
		/** 2 **/( /** 2 **/());
		/** 2 **/();
	}
	while (!lpi.esVacia()){
		/** 2 **/(/** 2 **/());
		/** 2 **/();
	}
}
```
|||
|--|--|
|1|this.encolar|
|2|lpi.insertar|
|3|lpi.eliminar|
|4|lpi.inicio|
|5| new ListaConPI<E>|
|6|new LEGListaConPI|
|7| this.desencolar|
|8|lpi.recuperar|

### 2. Estudia el coste Temporal del siguinte método:

***Precondición: v*** *v ordenado ascedentemente AND a < b*
```java
private static int metodo(int[] v, int ini, int fin, int a, int b){
	if (ini > fin) {
		return 0;
	}
	int mitad = (ini + fin) / 2, res = 0;
	if(v[mitad] >= a){
		res += metodo (v, mitad + 1, fin, a, b);
	}
	if (v[mitad] <= b){
		res += metodo (v, ini, mitad -1, a, b);
	}
	if(v[mitad] >= a && v[mitad] <= b){
		res++;
	}
	return res;
}
```
a)  Expresa la talla del problema x en función de los parámetros del método 
Talla ` x = fin - ini - 1`
