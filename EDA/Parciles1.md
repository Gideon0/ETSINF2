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
|A|Pila||1| B-C
|B|ArrayPila||2|J
|C|LEGPila||3|F
|D|p.apilar||4|L
|E|p.esVacia||5|G
|F|l.inicio||6|I
|G|l.siguiente||7|L
|H|l.esFin||8|N
|I|!l.esFin||9|D
|J|l.esVacia||10|M
|K|!l.esVacia||11|I
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
		/** 2 **/( /** 7 **/());
		/** 4 **/();
	}
	while (!lpi.esVacia()){
		/** 1 **/(/** 8 **/());
		/** 3 **/();
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

b) Infica si hay instancias significativas para una talla dada y por qué. En casa afirmativo, descríbelas.

Sí	hay	instancias	significativas:
- Mejor	caso: todos	los	elementos	de	v son	menores	que	a (o	mayores	que	b)
- Peor	caso: todos	los	elementos	de	v están	en	el	intervalo	[a,	b]
  
c) En	base	a	tu	apartado	b),	escribe la(s)	Relación(es) de	Recurrencia	que	expresa(n) el	coste	del	método

TmetodoM(x)	 =	 1 * TmetodoM(x/2)	+	k
TmetodoP(x)	 =	 2 * TmetodoP(x/2)  +	k

d) Resuelve la(s) Relación(es) de Recurrencia del apartado c), indicando el(los) Teoremas de Coste que usas y escribiendo el coste Temporal del método en notación asintótica (O y Ω o bien Θ).

Por Teorema 3 con a = 1 y c = 2, Tmetodo(x) ∈ Ω(log2x). 

Por Teorema 3 con a = 2 y c = 2, Tmetodo(x) ∈ O(x).

### 3.- Sea una aplicación de gestión de notas en la que se usa un Map `<Alumno, Double>` cada una de cuyas Entradas representa a un alumno y la nota que este ha obtenido en una asignatura.

a) Implementa un método cuyo perfil sea el mostrado en el siguiente recuadro, donde el parámetro m es el Map de las notas de todos los alumnos de una asignatura. El método debe realizar las siguientes acciones:
- Devolver un (nuevo) Map que contenga únicamente las Entradas de m que corresponden a alumnos aprobados (con nota mayor o igual que 5.0).
- Eliminar del Map m todas las Entradas que corresponden a alumnos aprobados. Es decir, al terminar la ejecución del método, m debe contener únicamente las Entradas correspondientes a alumnos suspendidos.
```java
public static Map <Alumno, Double> obtenerAprovados(Map <Alumnos,Double> m){
	Map<Alumno, Double> aprovado = new TablaHash<Almuno, Double>(m.tall());
	ListaConPI<Alumno> l = m.claves();
	for (l.inicio(); !l.esFin(); l.siguiente()){
		Alumno alumno = l.recuperar();
		Double nota = n.recuperar(alumno);
		if (nota >= 5.0){
			aprobados.insertar(alumno,nota);
			m.elimiar(alumno);
		}
	}
	return aprovados;
}
``` 
b) Suponiendo que el Map m se ha implementado eficientemente mediante una TablaHash, indica para el método diseñado: la talla del problema x que resuelve, en función de sus parámetros; las instancias significativas que presenta, si las hubiera; su coste Temporal en notación asintótica (O y Ω o bien Θ).

- Talla del problema, en función de los parámetros del método: `x = m.talla().`
- Instancias significativas: no hay, pues se trata de un método de Recorrido.
- Utilizando la notación asintótica, `T (x) ∈ Θ(x).`

### Junio de 2019  

### 2.- ) Escribe un método estático Divide y Vencerás que, dados un array v de int ordenado ascendentemente y sin elementos repetidos y un int x, devuelva el elemento de v con valor más cercano al de x. Para ello...

- Puedes suponer que v tiene como mínimo tres elementos y que, de ellos, el elemento de valor más cercano al de x no está NI en la primera posición de v NI en la última.
- Puedes usar en tu código un método comparar que, como su nombre indica y en el orden de una constante, compara con x dos elementos eV1 y eV2 de v y devuelve aquel de ellos con valor más cercano al de x. Su perfil es: int comparar(int[] v, int eV1, int eV2, int x).

```java
public static int buscarMasCercano (int[] v, int x){
	return buscarMasCercano(v, x, 0, v.length - 1);
}

public static int buscarMasCercano (int[] v, int x, int ini, int fin){
	int m = (ini + fin) / 2;
	if (v[m]== x) {return v[m];}
	if (v[m] < x) {
		if (v[m + 1] > x) {return comparar(v, v[m],v[m + 1], x);}
		else {return buscarMasCercano(v, x, m + 1, fin);}
	}
	else if(v[m - 1] < x){ return comparar (v, v[m - 1], v[m], x);}
	else{return buscarMasCercano(v, x, ini, m - 1);}
		
}
```
#### Una vez diseñado el método, estudia su coste temporal del método recursivo que lanza. En concreto:

##### a) expresa la talla del problema x en función de sus parametos
`x = fin - ini - 1`

##### b) Escribe la(s) relaciones de recurencia que expresa(n) su coste

Mejor caso => TbuscarMasCercanoM(x)	= k (contante) 

Peor caso  => TbuscarMasCercanoP (x) = 1 * TbuscarMasCercanoP (x / 2) + k’ 

##### c)Resuelve  la(s) relacion(es) de recurrencia del apartado b), indicando el(los)  Teoremos de Coste que usas y escribiendo el conste Temporal del método en la notacioón asintótica (O y Ω o bien Θ).

Mejor caso => TbuscarMasCercano(x)	∈ Ω(1)

Peor  caso => TbuscarMasCercano(x)	∈ O(log2 x)  [Por teorema 3 de costes]

### 3.-Dado el siguiente histograma de ocupación de una Tabla Hash (con Hashing Enlazado):

![](https://media.discordapp.net/attachments/705068953315311717/826502914012610610/unknown.png?width=767&height=190) 


##### a) Indica el número de cubetas y el de elementos que tiene la Tabla, dejando indicadas las operaciones que has realizado para calcular dichos valores

Numero de cubetas, o elArray.length = `20 + 35 + 15 + 5 + 5=80`

Numero de elementos de la Tabla, o talla = `20*0 + 35*1 + 15*2 + 5*3 + 5*4 = 120`

##### b) Calcula el Factor de Carga de la Tabla y la desviación típica de las longitudes de sus cubetas, dejando indicadas las operaciones que has realizado para calcular dichos valores.

Factor_carga = talla / elArray.length = cubetas / elementos = 120/80 = 1.5

σ(desviación típica) = `sqrt((20 * (0-1.5)² + 35 * (1-1.5)² + 15 * (2-1.5)² + 5 * (3-1.5)² + 5 * (8-1.5)² ) / 80). `

##### c) Supón que se insertan cuatro elementos distintos y que no estaban en la Tabla. Indica cuál de los siguientes es el histograma de ocupación de la Tabla tras estas inserciones. Es imprescindible que razones tu respuesta.

![](https://media.discordapp.net/attachments/705068953315311717/826505367638114334/unknown.png?width=782&height=233)

El histograma de ocupación resultante es el A porque en él hay dos cubetas más de 2 elementos que en el anterior (tras insertar 2 nuevos elementos en 2 de sus cubetas de longitud uno) y, consecuentemente, dos cubetas menos de 1 elemento que en la anterior. Además, también hay en él dos cubetas más de 4 elementos que en el anterior (tras insertar 2 nuevos elementos en 2 de sus cubetas de longitud tres). Por otra parte, el histograma resultante no puede ser el B porque tras insertar nuevos elementos en la Tabla no puede aumentar el número de cubetas de 1 elemento SIN disminuir el número de las que tienen 0 o 1.

### 4.-  El siguiente método de la clase `ArrayColaExtque<E extends<E>>` extiende de ArrayCola, ordena ascendentemente los elementos de una Cola usando una ListaConPI como estructura auxiliar. Escribe en cada recuadro el número de la opción (ver listado a la derecha) que le corresponde.

```java
public void ordenar () {
	/** 6 **/ lpi = new /** 5 **/ ();
	while (!this.esVacia()){
		E e = /** 2 **/();
		for (lpi.inicio();/** 3  **/&&/** 1 **/;/** 8 **/);
		/** 7 **/ (e);
	}
	lpi.inicio();
	while(!lpi.esVacia()){
		/** 10 **/(/** 9 **/());
		/** 4 **/();
	}
	
}

```

|||
|--|--|
|1| `lpi.recuperar().compareTo(e)	<=	0`|
|2| `this.desencolar`|
|3| `!lpi.esFin()`|
|4| `lpi.eliminar`|
|5| `LEGListaConPI<E>`|
|6| `ListaConPI<E>`|
|7| `lpi.insertar`|
|8| `lpi.siguiente()`|
|9| `lpi.recuperar`|
|10| `this.encolar`|
