# Resumen IPC

## Tema 4 Diseño Físico

**Estándares:** Incluyen  principios  de  diseño  y  buenas  prácticas  y  reglas  ampliamente  aceptados.

### Estándares  para  HCI  y  usabilidad:

#### ISO  9241:  Ergonomic  requirements  for  office  work  with  visual  display  terminals  (VDTs)

#### ISO  14915:  Software  ergonomics  for  multimedia  user  interfaces.

#### ISO  13407:  Human-centered  design  processes  for  interactive  systems.

#### ISO/CD  20282:  Ease  of  operation  of  everyday  products.

### Reglas  de  diseño  a  partir  de  principios  de  diseño:

#### Los  principios  son  abstractos  y se  tienen que interpretar

#### Las  reglas  de  diseño  son  más  específicas  y  están  diseñadas  para  una  plataforma.

- Bajo  nivel,  no necesitan  interpretación  del  diseñador.

- Guías  de estilo  comerciales  son  un  conjunto  de  reglas  de diseño.

### Guías  de  estilo:

#### Dan las convenciones básicas para productos específicos o una familia de productos.  Incluyen:

- Descripción e ilustración de los estilos de interacción necesarios y de los  controles  de  la interfaz  de  usuario.

- Guía  de  cómo  y  cuando  utilizarlos.

- Plantillas  que  muestran  cómo  debería  ser  el  aspecto  de las  pantallas.

#### Tipos  de  guías de  estilo:

- Comerciales.

- Personalizadas.

### Guías  de  estilo  comerciales:

#### Publicadas  por  una  compañía.

#### Reglas  de  diseño  muy  específicas.

#### Solo  aplicables a  una plataforma  concreta.

#### Incluye  principios  y  directrices.

#### Especifica,  por  ejemplo:

- Cómo  elegir un  control.

- Cómo  asignar  el  tamaño  y  separación  de los controles.

- Cómo  asignar  el  color,  tamaño y  fuentes  para  el  texto.

- Cómo  organizar  las  ventanas:  posición,  tamaño,  etc.

- Cómo  elegir  y construir  los  diálogos  de  mensaje.

- Cómo  usar  los  mensajes:  error,  aviso,  confirmación,  etc.

### Guías  de  estilo  personalizadas:


#### Construir  una  guía  de  estilo  específica  para  un  proyecto.

#### Se define en los primeros momentos del proceso de desarrollo y puede ayudar  durante  la captura  de requisitos  y la  toma  de decisiones.

#### Promueven  la  consistencia  a  través de  la  interfaz  de  usuario.

#### Si  se utiliza en  toda la  organización,  ayuda a  crear una  imagen  corporativa.

#### Se  pueden  hacer  a  medida  dependiendo de  las  circunstancias  del proyecto.

### Principios  de  una  buena  composición:

### Principios  de  una  buena  composición:


1\. Crear  grupos  naturales.

- Tener  en  cuenta  la  estructura  de  la  información  para  crear  grupos  lógicos.

- Diferentes colores de fondo, líneas de separación, espacio en blanco, fuentes  diferentes.

- Agrupar  los controles relacionados  en la interfaz.

2\. Separar  los  componentes de la  actividad  actual.

- Enfatizar/resaltar  lo que  el  usuario  está  haciendo  o donde  lo  está  haciendo.

3\. Resaltar  los  componentes importantes.

- Subrayar los componentes mas importantes con color, tipo, tamaño, posición  de  pantalla,  animación.  Utilizar  efectos  (alarmas  sonaras,  luces  intermitentes).

4\. Utilizar  un  espacio en  blanco de  forma  efectiva.

- Espacio  en  blanco  más  efectivo  que líneas.

5\. Hacer  que  los  controles  sean  visibles.

- Los  controles  en  pantalla  deberían  sugerir  cuáles  son  sus funciones.

6\. Equilibrar  la  estética  y  la  usabilidad.

- Equilibrio  entre  el  diseño  atractivo  y  la  usabilidad.

### Diseñando  una  interfaz  gráfica  de  usuario  (IGU):

Componentes de  una IGU:

#### Ventanas,  cuadros  de  diálogo,  pestañas...

#### Menús,  barras  de  herramientas,  botones...

#### Radio  buttons,  list  boxes,  cajas  de  texto...

Hay que traducir el diagrama de contenidos construido durante la fase de diseño conceptual (y  los  otros  elementos recopilados  durante  la  fase de  análisis  de requisitos)  a  una interfaz.

Pasos:

1\. Elegir  los  controles para  estructurar  la interacción.

2\. Elegir  los  controles  para  controlar  la  interacción.

3\. Elegir  los  controles  para  introducir  la información.

### Elegir  los  controles  para estructurar  la  interacción:


#### Ventana  principal:

- Contiene  un  marco, una  barra  de título,  menús,  barras  de  scroll,  etc.

- Representan  objetos  principales  de  tarea.

- Pocas  ventanas  principales  a  las  que  vuelve  el usuario  constantemente.

- Puede  haber  una  ventana  principal  que actúe  como lanzadera.

#### Ventanas  secundarias:

- Proporciona  funcionalidad  adicional  y  apoyo  al usuario.

- Cuadros  de  mensaje:

  - Muestran  mensajes  sobre  problemas.

  - Suelen  ser  modales  (se  bloquea  la  interacción  hasta  que  se  cierran).

  - Si son no modales, permiten al usuario interactuar con otras ventanas  de la aplicación.

- Cuadros  de  diálogo:

  - Invocados  por el  usuario.

  - Se  utilizan  para  pedir  información  adicional.

  - Pueden  ser  pantallas  completas  con  campos  de  texto,  botones,  etc.

  - Un asistente, es una serie de cuadros de diálogo en un orden  determinado,  que guía  al  usuario  en  la  realización  de  tareas  complejas.

- Pestañas:

  - Útiles para clasificar las propiedades de los objetos de tarea  representados  en una ventana.

  - La  información  en cada  pestaña debería  ser  independiente.

  - Retos: utilizar demasiadas pestañas. Los usuarios pueden olvidar  completar  o  pasar  por  alto  información  de alguna de  ellas.

### Elegir  los  controles  para  controlar  la  interacción:

#### Permiten  al usuario  controlar la interacción.

#### Menús.

#### Barras  de herramientas.

- Complementan  la  jerarquía  de  menús.

- Contienen  comandos  usados  frecuentemente.

- Barias  barras  de  herramientas  clasificadas  en  grupos  lógicos.

- Complicado  seleccionar  los  iconos adecuados.

- Las  cintas combinan  menús  y  barras  de herramientas.

#### Botones.

- Controlan  la  operación  de  los  cuadros de  diálogo.

- Usar  etiquetas  comprensibles  (Aceptar,  Cancelar).

- Tamaño: si se agrupan deben poseer misma forma y tamaño, si se encuentran  en  la  misma fila  la  anchura  puede cambiar.

### Elegir  los  controles  para  introducir  la  información:

#### Radio  Buttons  and  Check  Boxes.

- ¿Cuántas opciones son aceptables para que puedan ser utilizadas? ¿Cómo  deberían agruparse y disponer en la pantalla? ¿Cómo se deberían ordenar en  la  pantalla?  ¿Cómo  se  deberían  etiquetar  las  opciones?

#### List  Boxes.

- Permiten  al usuario  elegir  entre  un  gran  número  de  opciones.

- Selección  simple/múltiple.

- Desplegable/permanente,  dependiendo  del  espacio  disponible.

- Son  más  flexibles  que  check  boxes/radio  buttons.

- Se deberían utilizar valores por defecto adecuados para acelerar el uso del  programa.

- Se pueden combinar con cajas de texto, que pueden actuar como filtro (combo  box).

#### Cajas  de  texto.

- Es  el  control  más  flexible  para  introducir información.

- No es  adecuado para  introducir  información  con  formato  (fechas,  códigos

postales,  opciones  de  una  lista  predefinida...).

- Pautas.

  - El tamaño de la caja de texto debería indicar la cantidad de  información esperada (tanto número de líneas como longitud de la  línea).

  - Si el usuario puede introducir una gran cantidad de texto, utilizar una  caja  de  texto  multilínea con  barras de  scroll.

## Tema 5 Aspectos Humanos

### Cuatro  principios  psicológicos:

1\. Los  usuarios  ven  lo  que  esperan  ver.

2\. Los  usuarios  tienen  dificultades  para  centrarse en  más  de  una  actividad  a  la  vez.

3\. Es  más  fácil  reconocer  algo  que recordarlo.

4\. Es  más  fácil  percibir  un  diseño  estructurado.

### Los  usuarios  ven  lo  que  esperan  ver:


Desde  el  punto de  vista  del  diseñador:

#### Principio de consistencia. Mantén en toda la interfaz el mismo esquema de color,  orden  de  los  botones,  nombres de  los conceptos, etc.

#### Principio de aprovechamiento del conocimiento previo. Usa conceptos familiares para  los  usuarios.

### Los  usuarios  tienen  dificultades  para  centrarse  en  más  de  una  actividad  a  la  vez:


#### Los  usuarios  de  ordenador  suelen  dividir  su  atención  en  varias  actividades, por lo  que  se pueden olvidar de lo que iban a hacer. La interfaz debería recordarles el siguiente  paso.

#### Efecto  "cocktail party".

#### Para  centrar la  atención  del usuario:

- Principio  de  la  organización  perceptual:  agrupa  cosas  que  van  juntas.

- Principio de importancia. La información más importante debería situarse en  un  lugar prominente (avisos y  alarmas  en  el centro  de  la pantalla).

### Es  más  fácil  reconocer  algo  que  recordarlo:

#### La interfaz debería ofrecer la información necesaria, y no confiar en la memoria del  usuario.

- Usar menús, iconos, metáforas en pantalla, en vez de línea de comandos o  combinación de teclas (aunque el usuario avanzado prefiere velocidad a  facilidad  de uso).

### Es  más  fácil  percibir  un  diseño  estructurado:

#### Gestalt  trata  de  explicar la  percepción  humana  mediante una serie  de  leyes.

#### La base de dicha psicología asume que somos capaces de darle sentido al mundo a  partir  de  cómo  se  organizan  sus componentes.

### Leyes  Gestalt:

#### Gestalt  ->  figura  o forma.

#### La Gestalt fue una escuela psicológica alemana de principios del siglo XX que estudió la  percepción y elaboró una serie de principios sobre la percepción muy útiles a la hora  de  diseñar.

#### Explica como el cerebro humano es capaz de adquirir y mantener percepciones con  significado a partir  de un  mundo  aparentemente  caótico.

#### Escenas  complejas  pueden  reducirse  a  figuras  más  simples.

### Leyes  y aplicas  a interfaces  de  usuario:


#### **Proximidad:** objetos cercanos parece que forman grupos, en vez de una colección  aleatoria  de individuos.

- Agrupa  información  similar  y  organiza  el  contenido.

#### **Similitud:** elementos  del  mismo  color  o  forma  parecen  formar  grupos.

- Ayuda a organizar y clasificar objetos dentro de un grupo y asociarlos con un  signficado específico  o  función.

- La  similitud  puede  ser  por  color,  forma,  tamaño,  textura...

- Se  puede  enfatizar  en  un  objeto  haciendo  que se  diferencie  del  resto.

#### **Cierre:** rellenamos los huecos de una figura incompleta y áreas cerradas parece que  forman  un  objeto.

- Disminuye  el  número  de  elementos  necesarios  para  comunicar  información.

- Reduce la  complejidad  y hace los  diseños  más  atractivos.

#### **Continuidad:** elementos  alineados  parecen  formar  líneas.

- Los  elementos  que siguen  una  línea continua  se  perciben  agrupados.

- La alineación de elementos nos puede ayudar a movernos a través de una  página  ayudando  a la  legibilidad.

- Crea  orden  y  guía  al usuario.

#### **Simetría:** elementos simétricos tienden a ser percibidos como pertenecientes a lo  mismo,  no importa  su distancia, dándonos  sensación  de  orden  y  solidez.

- Da  sensación  de  orden  y estabilidad.

- Es  útil  para  mostrar  la  información  de  forma  rápida  y  eficiente.

#### **Separación figura-fondo:** cuando hay bordes o diferencias en el color, textura o brillo,  separamos  un  objeto  y  su  fondo.

- Ciertos  elementos  se ven  como figuras,  con  formas  y  bordes,  y  otros  como

fondo.  ◦

- Hay figuras que, aunque ocupen el mismo porcentaje de lugar dentro de una  imagen,  se  perciben como  figura y  no  como  fondo.

- Los seres humanos tenemos tendencia a separar las figuras del fondo según su  color,  su forma, su  tamaño,  etc.

### Organización  de  objetos:

#### Las "unidades de entrada" se transforman mediante procesos de división y agrupación  para  configurar  la  organización  perceptual definitiva de la imagen.

#### Procesos  de  división:                Principios  de  agrupación:

- Diferencian  las  diversas  partes  de  una  figura.

#### Procesos  de  agrupación:

- Hacen que varios elementos de la escena se  perciban  conjuntamente.

### Trabajo  del  usuario:


#### La  organización  de  los  elementos  puede  facilitar  o entorpecer  el  trabajo  del  usuario.

#### En un buen diseño: la organización perceptual de la información debe estar supeditada  a  cómo  el  usuario lleve  a  cabo la tarea sobre  la  misma  (Wickens,  1990).

### Percepción  visual:  Color

#### Podemos  distinguir  unos  7  millones de  colores,  pero  se identifican  muchos  menos.

#### El  ojo percibe  el  color  a  través de  los  conos,  sensibles  a  diferentes longitudes  de  onda.

#### Existen ciertos fenómenos visuales relacionados con el mecanismo de percepción del  color.

### Consejos:

#### Evitar  la  combinación  rojo-verde,  amarillo-azul,  rojo-azul.

#### Usar  altos  contrastes  de  color  entre  la  letra  y  el  fondo.

#### Limitar  el  número de  colores.

#### Azul  claro solo  para  los  fondos.

#### Usar blanco,  cian  o  verde  sobre  fondos  oscuros.

#### Evitar  colores  muy  saturados.

**Problemas  de  visión:**

| **Tipo** | **Descripción** |
| - |  - |
| Tricrómata | Visión  cromática  normal |
| Dicromático  Protanopa | Insensible  al  rojo |
| Dicromático  Deuterópata | Insensible  al  verde |
| Tritanopa | Insensible  al  azul  y  amarillo |
| Monocrómata | Sin  visión  del color |

### Percepción  visual:  Contraste

Podemos aprovechar las leyes Gestalt de separación de un objeto y su fondo para dirigir la  atención  del usuario  a  algún  punto  de la  interfaz.

#### Se  diluye  el  efecto si  hay  demasiados  elementos  resaltados.

#### El  contraste  se  debería  utilizar  con  cuidado.

- Especialmente  los  colores.

- No  utilizar  demasiados  colores  en  las  interfaces.

- No  hacer  depender  un  mensaje  únicamente  de  un  color.

### Percepción  visual:  Brillo

Luminancia:  Reacción  a la  cantidad  de luz  emitida por  un  objeto  ◦

#### A mayor  luminancia,  mayor  agudeza visual.

#### Una  luminancia  excesiva  incrementa  el parpadeo.

#### Debe  ser  inversamente proporcional  a  la  duración  del  estímulo.

El  ambiente luminoso del  entorno  de  trabajo influye  en  cómo  vemos  la  pantalla:

#### Alinear  las  pantallas  en  relación  correcta  con  las  fuentes  de luz.

#### Nunca  colocar  una pantalla  contra  una  pared  o un  espejo.

#### Usar  vídeo inverso  (fondos  oscuros,  texto  claro)  para  minimizar  los  destellos.

### Actividades  automáticas  y  actividades  controladas:

#### Hay  muchas  cosas  que  podemos  percibir  automáticamente:

- Posición  en el  espacio, tamaño, color, forma, sonido,  olor.

- Se  pueden  usar  para  proporcionar  información  sin requerir  atención  completa.

#### Hay algunas  actividades  que se pueden realizar  en  paralelo  con  otras:

- Oír música mientras se lee, conducir mientras se habla con un acompañante,  etc.

- Esta  son  actividades  automáticas.

#### Por  otro  lado, hay  actividades  que  necesitan  atención  completa:

- No  se  puede  leer  y  mantener  una  conversación  al  mismo  tiempo.

- Esta  son  actividades  controladas.

- Sólo  se puede  realizar  una  actividad  controlada  a  la  vez.

- Sobre todo, las actividades relacionadas con el lenguaje (leer y hablar)  necesitan  atención  completa.

- Si se pone una música de fondo, el habla de la canción provoca interferencias  con los procesos en los que sea necesario trabajar con información verbal  (p.ej.  una  búsqueda)  aunque no  se le preste  atención  conscientemente.

## Tema 6 Estilos de interacción

### Interfaces  de  línea  de  comando:

#### Primer  estilo  de  interacción  utilizado,  mediante  líneas  de  comando.

- Permiten  dar  instrucciones  directas al  sistema.

- Son  flexibles:  permiten  que  las  órdenes  tengan  opciones.

- Se  pueden aplicar  a  múltiples argumentos a la  vez.

- Los usuarios expertos sienten que tienen el control, y pueden expresar  acciones  complejas  rápida  y concisamente.

#### Desventajas  de la  línea de  comando:

- Difíciles  de aprender.

- Recordar  los  comandos.

- No  muestran  ayuda.

- Ordenes  cripticas  o sintaxis  compleja.

- Poca  tolerancia  a errores.

- Retención  a  largo  plazo  baja.

#### Estos problemas se pueden reducir usando nombres de órdenes y abreviaturas  consistentes.

#### Los lenguajes de órdenes aparecieron como medios de comunicación con el sistema  operativo.

- Filosofía  Unix:

  - Pequeños  programas  que hacen  solamente  una  cosa  (cat,  grep,  ls  ...)  .

  - Estos programas se pueden encadenar: la salida de una orden puede  ser  la  entrada para la  orden  siguiente.

  - Una  ejecución  correcta  no  proporciona  realimentación,  los  errores sí

  - Interacción  rápida.

  - Las macros son combinaciones de órdenes que se pueden ejecutar de  una vez.

#### Hoy  las  interfaces  de  línea  de comando  se  siguen  utilizando  para:

- Interacción  con  el  sistema  operativo:  MS-DOS,  UNIX:  sh,  csh, bash.

- Administración  de  sistemas,  lenguajes  de  script.

- Aplicaciones  de  consola: ftp,  mail,  ed,  vi, Lynx.

#### Útiles para interacción de bajo nivel, como primera interfaz de una aplicación o para la  administración  avanzada.

#### Guías  de diseño para  interfaces de  línea de  comando.

- Elegir  nombres  de  órdenes  significativos  y  representativos.

- Seguir  una  sintaxis  consistente  para  todas  las  órdenes.

- Usar  reglas  consistentes  para abreviar  los  comandos  y  respuestas.

- Usar  nombres  de  comando  tan  cortos  como  sea  posible.

- Si se pueden abreviar los comandos o las respuestas a comandos, usar  abreviaturas  comunes (S/N).

- Limitar  el  número de  formas  de  realizar  una  tarea  ◦  Permitir  que los  usuarios

definan  macros.

### Selección  de  menús:

#### Un  menú  es  un  conjunto  de opciones  entre  las  que  tiene que  elegir el  usuario.

#### Evita muchos de los problemas de las interfaces por línea de comando, porque ofrecen  pistas  al  usuario, en  vez de  obligarles a  recordar  nombres y  sintaxis  de comandos.

#### Los  elementos  del  menú  deben  ser  auto  explicativos  y  distinguibles.

#### Los menús están indicados para usuarios con poco  entrenamiento, usuarios intermitentes, usuarios que  no conocen la terminología, o que necesiten ayuda en  la  toma de  decisiones.

- Por otra parte, los usuarios expertos pueden  sentirse  limitados  o ralentizados.

### Menús  aislados:

#### Varios  tipos:

- Menú  binario  ->  Si  es repetitivo,  ofrecer atajos  y  valores por  defecto.

- Radio  buttons  ->  Opciones  excluyentes.

- Check  boxes  ->  Múltiples  opciones  binarias.

#### Menús  desplegables  ->  Mostrar  teclas  de  aceleración.

#### Menús  emergentes  ->  Suelen  depender  del  contexto  (posición  del  ratón).

#### En  ambos  casos:

- Posible organización de  submenús en  cascada.

- Opciones desactivadas en  color gris.

- Opciones con teclas de  acceso.

### Otros  menús:

#### Barra  de  herramientas  ->  Usan  iconos  en  vez de  texto.

#### Cintas  ->  Introducidas  en  Office  2007:  solapas.

#### Menús de  tarta.

#### Menús  con  muchos  elementos:

- Menús  con  scroll.

- Combo  boxes.

- Menús  de  ojo de  pez.

- Barras  de desplazamiento.

- Menús  bidimensionales.

#### Menús  embebidos:

- Alternativa  a los  menús  explícitos.

- Permiten  ver  opciones  dentro de  su contexto.

- Precursores  de  hiperenlaces  en  [www.](http://www/)

### Combinación  de  menús:

Técnicas  para  organizar  elementos  en  diversos  menús:

#### Secuencias  de  menús:

####   El  usuario  hace  una  elección  cada  vez    Facilitan  la  selección:  para  usuarios  noveles y  tareas  sencillas   Ejemplo:  asistentes  de  instalación,  venta de pizzas  on-line...

#### Menús  simultáneos:

#### Presentan a la vez varios menús en pantalla   Los usuarios realizan la selección en  cualquier  orden   Para usuarios  experimentados

#### Menús  con  estructura  de  árbol:

- Agrupan  opciones  en  categorías  elegidas  de  forma natural  y fácil  de  entender.

- Usan  terminología del  dominio de  la  aplicación.

- Recomendaciones:  4-8  elementos por  menú,  3-4  niveles.

#### Mapas  de  menús:

- Se  usan  cuando  un  menú  con  estructura  de  árbol  es demasiado grande.

- Permiten  una  visión  global,  manteniendo  el  sentido  de  la  posición.

- Ejemplos:  Site  maps  y  mapa  de  atajos  de programas.

#### Redes  cíclicas  y  acíclicas de  menús:

- Permiten  a  los usuarios  llegar  a  un  elemento  desde  distintos  puntos  de inicio.

- Se  utilizan  para:

  - Relaciones  sociales.

  - Rutas  de  transporte.

  - Citas  bibliográficas.

  - [www.](http://www/)

- Pueden  confundir  al  usuario.

### Organización  del  contenido:

### Agrupación  por  tareas  en  menús  con  estructura  de  árbol:

#### Crear  grupos  de  opciones lógicamente  similares.

Ejemplo:  menú  multi-nivel:  países (nivel  1),  provincias  (nivel  2)  y  ciudades  (nivel  3)  

#### Formar grupos que cubran todas las posibilidades.  Ejemplo:  menú  con  rango  de edades: 0-18,  19-35,  >35

#### Asegurarse de que las opciones son disjuntas (no se superponen)  Ejemplo: usar "Conciertos" y "Deportes" en lugar de "Entretenimiento" y  "Acontecimientos".

#### Usar terminología familiar, pero que se diferencien los elemento.  Ejemplo:  en  lugar de  "Día"  y "Noche" usar  "de  8  a 20  h."  y  "de  20  a  8  h."

### Ordenación  de  los  elementos:

#### Cómo  ordenar  los  elementos  de  cada  menú  ◦ Orden  natural  (tiempo,  numérico...)

- Ejemplos:  días  de  la  semana,  edades,  tamaño

- o  bien,  según  un  orden  estándar.

- Ejemplos: alfabético, por frecuencia de uso, por orden de importancia, por  categorías  (separadas por líneas  en blanco).

#### Los  elementos  se  pueden  ordenar  de  forma  adaptativa.

- Ejemplo:  selección  de  fuente  de  Office.

### Diseño  de  menús:


#### Títulos:  deben  ser  sencillos  y  descriptivos.

#### Nombres  y  formato:  ◦

- Usar  términos  familiares  y  consistentes.

- Asegurar  que los  términos  son  distintos  unos  de  otros.

- Usar frases cortas y concisas ◦ Empezar cada opción por una palabra clave  Ejemplo: "Tamaño de la fuente" en lugar de "Seleccionar el tamaño de la  fuente"

### Diseño  gráfico  de  menús:

#### Definir  guías  consistentes  para  el  diseño  de  menús:

- Títulos  (centrados  o justificados  a  la  izquierda).

- Colocación  de  elementos  (justificados  a  la  izquierda,  líneas  en  blanco).

- Instrucciones.

- Mensajes de  error.

### Uso  rápido  de  menús:

#### Atajos de  teclado.

- Para  usuarios  expertos.

- Pueden cambiar  en la  traducción  de  la aplicación.

#### Menús de  tarta.

- Si el usuario recuerda la posición del elemento a seleccionar, puede  adelantarse.

#### Menús  Tear-off.

### Menús  de  audio:

#### Se  usan  cuando las  manos  y  los  ojos  están  ocupados  ◦  Ejemplos:  GPS,  ordenadores  a

bordo,  interfaces telefónicas.

#### Proponen  las  opciones  y  preguntan  al usuario.

#### El  usuario responde  por  teclado o  por  voz.

#### Interfaz  no  persistente:  el  usuario debe  memorizar  las opciones disponibles.

#### El  sistema  debe  dar  realimentación  auditiva.

#### Recomendaciones:

- En  una interfaz  telefónica,  se  deberían  dar  como  mucho  3  o  4  opciones.

- El sistema debería permitir al usuario seleccionar la opción antes de acabar la  presentación  del resto.

### Menús  para  pantallas  pequeñas:

#### Aplicaciones:  entretenimiento,  teléfonos  móviles,  PDA,  etc.

#### Objetivos  de  diseño:

- Aprendizaje:  deben  ser  fáciles  de  aprender.

- Deben  ser  apropiados  al dominio  de la  aplicación.

- Organizar  opciones por  importancia  y  frecuencia  de  uso.

- Simples:  concentrarse  en  funciones importantes.

- Proporcionar realimentación: planificación frente a las interrupciones y  proporcionar  realimentación  continua.

#### Elementos  ◦

- Botones hardware  para  opciones  especiales.

- Ejemplos: botones dedicados (llamar, colgar); teclas de movimiento; teclas  blandas.

- Pantallas  táctiles  para  la  interacción  basada en  gestos.

- Iconos  grandes,  sencillos y  en color.

### Menús  en interfaces  de  línea  de  comando:

#### Menús de  órdenes:

- Muestran  las  opciones  disponibles.

- Útiles  para  usuarios  noveles  e  intermedios.

- Ejemplo:  menú  de  órdenes  de Lynx.

#### Los  menús de  órdenes  muestran  las teclas  de aceleración.

#### Ejemplo:  en  lynx  teclear  P  en  lugar de  Print.

### Formularios:

#### Se  usan  cuando hay  que  introducir  muchos  datos  de  distintos  tipos.

#### Permiten  a  los  usuarios

- Moverse  fácilmente  entre  los  campos.

- Dejar  algunos campos  en  blanco.

- Corregir  campos  ya rellenados.

- Introducir  información  textual  y  numérica.

#### Son  una  metáfora  de los  formularios  de  papel.

#### Guías de  diseño:

- Título  significativo  (identificar  el  tema  sin  términos  técnicos).

- Instrucciones  comprensibles.

- Agrupación  y  secuencia  de  campos con  sentido.

- Aspecto  atractivo  para  el  usuario.

- Las etiquetas de campo justificadas a la derecha, cajas de entrada alineadas  verticalmente.

- Nombres  familiares  para  los  campos.

- Terminología  consistente  y  abreviaturas.

- Espacio visible y límites en los campos de entrada (da una pista sobre el  espacio  de entrada  máximo).

- Movimiento  del  cursor  adecuado (tabulador  y  cursor).

- Corrección  de errores  de  caracteres individuales  y  campos  enteros.

- Prevención  de  errores  cuando  sea  posible  (Ejemplo:  permitir  sólo dígitos).

- Mensajes de  error para  valores  incorrectos.

- Proporcionar  realimentación  inmediata

  - Mejor  que la  realimentación  después del  envió  del  formulario.

- Resaltar  claramente los  campos  obligatorios.

- Incluir  mensajes  explicativos  para  los  campos.

- Indicar  que  se  ha  completado  el  formulario  para  facilitar  el  control  del  usuario.

  - Permite  al  usuario revisar  el  formulario  antes  de  enviarlo.

### Campos  con  formato  específico:


#### Algunos  campos  requieren  un  formato  especial  o específico:

- Texto  (justificado  a  la  izquierda).

- Números (justificados a la izquierda en la entrada, justificados a la derecha en  pantalla,  alineación  de la  coma decimal).

- Números  de  teléfono.

- Números  de identificación,  fechas, horas,  monedas.

### Formularios  y  menús:

### Cuadros  de  diálogo:


#### Combinan  menús  y  formularios.

- Usar  un  título adecuado  y  un  estilo  consistente.

- Recorrido  de  arriba-izquierda  /  abajo-derecha.

- Opciones  agrupadas por  tema  y  énfasis.

- Diseño  consistente  (márgenes,  cuadrículas,  espacios  en  blanco,  líneas,  cajas).

- Terminología  consistente,  fuentes,  mayúsculas  y  justificación.

- Botones  estándar  (Ejemplo: OK  y  Cancelar).

#### Relación  con  otros  elementos.

- Deben  aparecer  y desaparecer  suavemente.

- Tendrán  un  marco  diferenciable  pero  no  muy  ancho.

- Serán  lo bastante  pequeñas  para  evitar  tapar  otros  elementos.

- Mostrar  junto a  elementos  relacionados.

- No  deben  ocultar  otros  elementos  necesarios.

- Será  fácil  hacerlas  desaparecer.

  - Intro/Escape.

- Estará  claro  como completarlos  o cancelarlos.

### Manipulación  directa:

#### La manipulación directa permite al usuario interactuar directamente con los objetos  del interfaz.

- Se utiliza un dispositivo de entrada continuo, como un ratón, un puntero, un  joystick  o  una pantalla táctil.

- Ejemplo:  arrastrar un  fichero de  una  carpeta  a  otra.

#### Existen  muchas  aplicaciones  que usan  interfaces  de  manipulación  directa:

- Procesadores  de  texto,  CAD,  simuladores  de  vuelo,  videojuegos...

#### Características:

- Representaciones visuales continuas de los objetos y acciones de interés (no  hace  falta  recordar una sintaxis).

- Los objetos de la tarea se manipulan directamente, en vez de a través de  comandos.

- Acciones rápidas, incrementales y reversibles cuyos efectos en los objetos de  interés  son  inmediatamente  visibles.

- El usuario siente que está manipulando los objetos del dominio y no los de la  interfaz.

- Los  usuarios  noveles  pueden  aprender  rápido  la  funcionalidad  básica.

#### Ventajas  de  los  procesadores de  texto  WYSIWYG:

- Muestran  una página completa  de  texto.

- Muestran  el documento en  el formato  que  aparecerá  cuando  se  imprima.

- Muestran  claramente  el  punto  de  edición  mediante  el  cursor.

- Control  natural  del  movimiento del  cursor.

- Uso de  iconos  en  pantalla  para  las acciones  más  comunes.

- Muestran  el  resultado  de  una acción  de forma inmediata.

- Respuesta  rápida.

- Ofrecen  acciones  fácilmente  reversibles.

- Fácil  de aprender  a  usar

### Problemas  de  la  manipulación  directa:

#### Es  un  problema  para  las  personas  con  problemas  de  visión.

#### Las representaciones visuales son generalmente grandes ocupando mucho espacio en  pantalla  y  puede  ser  necesario  usar  scroll.

#### Los  usuarios  deben  aprender el  significado de  las  representaciones  visuales.

#### La  representación  visual  puede  ser  engañosa.

#### Escribir  comandos  con  el  teclado puede  ser  más  rápido para  los  usuarios  expertos.

#### Problema  con  las pantallas  pequeñas.

#### Difícil  en  algunas  aplicaciones  (bases  de  datos,  navegación  web...).

### Interfaces  avanzadas:

### Interfaces  por  lenguaje  natural:

#### Interfaces  por  lenguaje natural:

- El usuario interactúa con el ordenador por medio de un lenguaje natural y  familiar (por ejemplo, castellano) para dar instrucciones y recibir respuestas ◦  El  usuario  puede  escribir el  texto  o  hablar.

- No hay  sintaxis u  ordenes que  aprender.

- Con  éxito  en  aplicaciones  de dominio  específico.

- Los avances en manipulación directa y la baja tasa de reconocimiento han  reducido el interés en este tipo de interfaces, pero hoy en día están  recuperando  atención.

#### No  está  claro cuando  es  deseable:

- Los ordenadores pueden mostrar información 1000x más rápido que el usuario  introduciendo  órdenes.

- Los usuarios principiantes e intermedios prefieren elegir entre un conjunto  visible de  opciones.

- Los  expertos  prefieren  un  lenguaje  de  ordenes  preciso y  conciso.

- Falta de contexto: para los usuarios es difícil determinar qué objetos y  acciones son  apropiadas.

- Requiere  aclaraciones  que  ralentizan  la  interacción

#### Juegos  de  aventura ->  Populares  en  los años  70-80.

### Realidad  virtual:


#### Sistema interactivo que ofrece una percepción sensorial de un mundo sintético que  sustituye  completamente  al real en  el canal  sensorial elegido.

#### Rompe las limitaciones físicas del espacio y permite a los usuarios actuar como si  estuvieran  en  otro lugar.

### Realidad  aumentada:


#### Una  combinación  de una  escena real  y  elementos  virtuales.

#### Los elementos virtuales se generan por ordenador e incluyen en la escena real  información  adicional.

#### Los movimientos del usuario deben capturarse y deben reflejarse en la nueva  información  a  visualizar.

### Realidad  aumentada  y  virtual:


#### El  éxito de  entornos  virtuales y  aumentados  depende  de  la  integración  de:

#### Pantallas.

#### Localización  de  la cabeza.

#### Localización  de  las  manos.

#### Realimentación  de  fuerzas.

#### Entrada  y  salida  de  sonido.

#### Otras  sensaciones.

#### Realidad  virtual  y  aumentada  cooperativa  y competitiva.

### Teleoperación:


#### Dos  "padres":  manipulación  directa  en  ordenadores  personales y  control  de procesos

en  entornos  complejos.

#### La  operación  física  es  remota.

#### Factores que  complican  la  teleoperación:

#### Retrasos

- En  la  transmisión.

- En  la  operación.

#### Realimentación  incompleta.

#### Interferencias  imprevistas.

#### Recuperación  de  errores  complejos.

#### Aplicaciones  ◦

- Telecirujía

- Militar

- Aeroespacial

- Seguridad

## Tema 7 Usabilidad

### Propiedades  de  una  interfaz  usable:

#### Adecuación  al  uso  (o  funcionalidad).  El  sistema  permite realizar  las  tareas del  usuario.

#### Facilidad  de  aprendizaje  (para  distintos  usuarios).

#### Eficiencia  en  la  tarea.  Para  usuarios  frecuentes.

#### Facilidad  de recordar.

#### Satisfacción  subjetiva.

#### Reducción  errores.

### Estándar  ISO  9241:

#### Usabilidad: grado en que un producto puede ser utilizado por usuarios especificados  para lograr objetivos concretos con eficacia, eficiencia y satisfacción, en un  determinado  contexto  de  uso.

- eficacia:  precisión  y  completitud.

- eficiencia:  recursos  consumidos.

- satisfacción:  ausencia  de  incomodidad,  actitud  positiva  del  usuario.

### Medidas  de  usabilidad  en  general:

| **Medidas  de  efectividad** | **Medidas  de  eficiencia** | **Medidas  de  satisfacción** |
| - |  - |  - |
| Porcentaje  de  objetivosalcanzados | Tiempo  para  completar  unatarea | Escala  de  evaluación  de lasatisfacción |
| Porcentaje  de  usuarios  quecompletan una tarea con  éxito | Tareas completadas por  unidad  de tiempo | Frecuencia de uso  discrecional |
| Precisión  media de  las  tareascompletadas | Coste  económico  decompletar  una  tarea | Frecuencia  de  quejas |

**Objetivos  y  medidas  de  la  usabilidad:**

#### Especificar claramente los objetivos del proyecto, para poder explicar las decisiones  tomadas.

#### Es más fácil medir la usabilidad del sistema una vez que se ha construido, pero para  entonces puede  ser demasiado  tarde.

#### Los  usuarios  y los  diseñadores  pueden probar  la  interfaz  mediante prototipos.

#### Los  prototipos pueden  ser  ◦  de baja  fidelidad:

- mock-ups  en  papel,  o

- de  alta  fidelidad:  prototipos  interactivos

#### Las  pruebas  de validación  certifican  que  el  sistema  cumple  con  los  requisitos.

#### En general, todo sistema informático se beneficia de un interfaz usable, pero en las  siguientes  áreas  es  más importante  si cabe:

- Sistemas  críticos.

- Usos  industriales  y  comerciales.

- Aplicaciones  de  entretenimiento.

- Interfaces  exploratorios,  creativos  y  colaborativos.

- Sistemas  socio-técnicos.

### Áreas  de  aplicación:

### Sistemas  críticos


| **Medidas  de  usabilidad** | **Importancia** |
| - |  - |
| Tiempo de  aprendizaje | POCA |
| Rapidez  de ejecución | MUCHA |
| Tasa  de  errores | MUCHA |
| Retención  a  lo largo del  tiempo | POR  REPETICIÓN |
| Satisfacción  subjetiva | POCA |

**Usos  industriales  y  comerciales**

| **Medidas  de  usabilidad** | **Importancia** |
| - |  - |
| Tiempo de  aprendizaje | MUCHA |
| Rapidez  de ejecución | MUCHA |
| Tasa  de  errores | MODERADA |
| Retención  a  lo largo del  tiempo | POR  REPETICIÓN |
| Satisfacción  subjetiva | MODESTA |

**Aplicaciones  de  entretenimiento**


| **Medidas  de  usabilidad** | **Importancia** |
| - |  - |
| Tiempo de  aprendizaje | MUCHA |
| Rapidez  de ejecución | MODERAD |
| Tasa  de  errores | MUCHA |
| Retención  a  lo largo del  tiempo | MODERADA |
| Satisfacción  subjetiva | MUCHA |

**Interfaces  exploratorios,  creativos  y  colaborativos**

| **Medidas  de  usabilidad** | **Importancia** |
| - |  - |
| Tiempo de  aprendizaje | MODERADA |
| Rapidez  de ejecución | MODERADA |
| Tasa  de  errores | MODERADA |
| Retención  a  lo largo del  tiempo | MODERADA |
| Satisfacción  subjetiva | MUCHA |

**Sistemas  socio-técnicos**

| **Medidas  de  usabilidad** | **Importancia** |
| - |  - |
| Tiempo de  aprendizaje | MUCHA |
| Rapidez  de ejecución | MUCHA |
| Tasa  de  errores | MUCHA |
| Retención  a  lo largo del  tiempo | POCA |
| Satisfacción  subjetiva | POCA |

### Usabilidad  universal:

#### Proceso de crear productos usables por las personas con el mayor rango posible de  capacidades,  usarse  en  variedad  de  situaciones,  siendo comercialmente  crítico.

#### Los  diseñadores de  interfaces deben  tener  en  cuenta  la  diversidad  de usuarios:

- Habilidades físicas  y  entornos  de  trabajo.

- Diferentes  personalidades.

- Diversidad  cultural  e  internacional.

- Discapacidad.

- Mayores.

- Niños.

- Diversidad  de  hardware  y  software.

### Habilidades  físicas  y  entornos  de  trabajo:
-

#### La  ergonomía  se  encarga  de acomodar  los  entornos  de trabajo a  las  personas.

#### Principios  de  diseño  ergonómico  (UNE-EN-614-1)

a) La altura de utilización, u otras dimensiones funcionales de la máquina, deben  estar adaptadas al operador y al tipo de trabajo a realizar, por ejemplo, siendo  ajustables;

b) el tipo, la situación y las posibilidades de regulación de los asientos deben ser  los adecuados para las dimensiones corporales del operador y para las tareas  que éste  lleve  a  cabo;

c) debe preverse espacio suficiente para todas las partes del cuerpo, de forma  que se pueda realizar la tarea con buenas posturas y movimientos de trabajo y  se facilite  el  acceso y los  cambios  de postura;

d) las empuñaduras y pedales de las máquinas deben estar adaptados a la  anatomía funcional de la mano o del pie y a las dimensiones de la población de  operadores

e) los mandos, empuñaduras y pedales de uso frecuente, estarán situados al  alcance inmediato de las manos o de los pies del operador, cuando éste ocupe  las  posiciones  de trabajo  apropiadas.

#### Antropometría ->  ciencia  que trata  de  medir  las  dimensiones  del  cuerpo humano.

- Antropometría estática: dan medidas estándar de personas, población,  típicamente de  pie  o  sentada.

#### Antropometría dinámica -> Describe rangos de movimientos, alcances, trayectorias:  distancia máxima para alcanzar un objeto sentado, velocidad de pulsación de teclas,  fuerza  para  levantar  objetos...

### Diferentes  personalidades:
-

#### Hay una gran variedad de preferencias personales: tecnofilia/tecnofobia, gráficos vs  tablas,  interfaces  minimalistas o  densos,  etc.

### Diversidad  cultural  e  internacional:
-

#### Los diseñadores deben ser capaces de adaptar sus interfaces a diferencias culturales,  étnicas,  raciales  o  lingüísticas.

#### Dependiendo del tipo de cultura, un usuario puede preferir interfaces sencillas,  estáticas,  mientras que  otro  puede preferir  interfaces dinámicas.

#### Además,  los  gustos  cambian  rápidamente.

#### La necesidad de adaptar las aplicaciones a distintas lenguas hace que las arquitecturas  software deban  ser  flexibles:

#### caracteres,  números,  caracteres  especiales  y  signos  de  puntuación.

#### dirección  de  lectura  y  escritura.

#### formatos  de  fecha  y  hora.

#### pesos  y  medidas.

#### números  de  teléfono y  direcciones.

#### títulos  y  nombre  (Sr.,  D.,  Sra...).

#### números  de  pasaporte,  carnet  de  identidad,  etc.

#### uso  de  mayúsculas  y  puntuación.

### Accesibilidad:


#### Distintas  capacidades:

- visión  reducida.

- audición  reducida.

- movilidad  reducida.

#### Principios  de  diseño universal  (Center  for  Universal  Design,  NCSU):

- Uso  equitativo.

- Flexibilidad  de uso.

- Uso sencillo  e intuitivo.

- Información  perceptible.

- Tolerancia  a los  errores.

- Bajo  esfuerzo  físico.

- Tamaño  y  espacio  para  aprox.  y  uso.

#### Herramientas  de  accesibilidad:

- Lupas  de pantalla.

- Texto a  voz.

- Reconocimiento  de voz.

- Advertencias  visuales.

- Punteros  controlados  con  los  ojos.

#### Diversos países han legislado la obligación de que los servicios públicos ofrezcan  servicios  informáticos accesibles.

#### Tener  en  cuenta  desde  el  primer  momento las  necesidades de  estos  usuarios.

- no  aumenta  demasiado  el  coste.

- aumenta  la  usabilidad  para  todos  los  usuarios.

#### Usuarios  sin  discapacidad  también  se benefician  de  estas características  en  ocasiones

->  Subtítulos  en  TV  y  Texto  alternativo  en imágenes.

### Mayores:


#### Los interfaces permiten adaptar el tamaño de las fuentes, el contraste de las pantallas  y  el  volumen de los sonidos.

#### También pueden usar punteros más fáciles de usar, rutas de navegación más claras,  organización  consistente  de  los  interfaces  y comandos más  sencillos.

### Niños:


#### La motivación principal para esta clase de usuarios es el entretenimiento y la  educación.  Varias etapas:

- juguetes controlados por ordenador, instrumentos musicales, herramientas  artísticas.

- una vez aprenden a leer, pueden usar el teclado y usar aplicaciones de  escritorio,  web o  móviles.

- en  la  adolescencia, pueden  ser usuarios  avanzados.

#### Los  objetivos  de sistemas  orientados  a  los  niños  son:

- acelerar  el proceso  educativo,

- facilitar  la  socialización  con  otros  niños,

- y  reforzar la  confianza  en uno  mismo.

#### En general, aceptan algo de frustración, no aceptan un humor inapropiado y les gustan  el  entorno  que pueden  explorar,  con  personajes  conocidos  y  les  gusta  la  repetición.

#### Evitar  doble  click,  arrastre  del  ratón,  textos  complejos  y  secuencia  de comandos.

#### Poca capacidad de concentración y poca habilidad de trabajo con conceptos  simultáneos.

#### En  sistemas  de  niños  conectados  a  internet,  hay  que asegurar  la  seguridad.

### Diversidad  de  hardware  y  software:


#### Los  sistemas  se  deben  adaptar a  un  rango  grande  de  hardware

- hardware  antiguo,  con  p.e.,  baja  resolución  y  poca  memoria,

- hardware moderno, con gran capacidad de almacenamiento y procesamiento,  o

- dispositivos  móviles,  con  pantallas reducidas  y  memoria  limitada.

#### ...y  de software

- nuevas  versiones  del S.O.,  navegadores  web  y  otros programas.

## Tema 8. Prototipado

Un prototipo es un primer o temprano ejemplo que se utiliza como modelo de lo que vendrá  más  tarde.

### Motivación:
-

#### Anima a la creación de múltiples opciones y permite a los diseñadores avanzar,  demostrar  y  evaluar  diseños.

#### Desarrolladores  se concentran  en  el  diseño,  no  en  la  implementación.

#### Prototipos suelen ser incompletos, fáciles de cambiar y se descartan cuando no se  necesitan.

#### Prototipos  según  el  nivel  de  fidelidad.

### Prototipos  de  baja  fidelidad:


Storyboards:  se  concentran  en  tareas  y  son  utilizados  en  el análisis  de  requisitos.

Prototipos en papel se utilizan en el análisis de requisitos, definir objetos de tarea, propiedad,  acciones  y  objetos hijos.

Prototipos  en  papel  también  son  utilizados  en  el  diseño  visual.

#### Se  diseña  la interfaz  de  usuario.

#### Se  dibuja una  maqueta de  la  interfaz  en  papel.

#### Utilizando papel,  marcadores, etc;  se  evita  un  diseño  bonito  y  exacto.

#### Los usuarios se pueden involucrar en la evaluación y evolución del diseño.  Directrices  para  los prototipos en  papel:

#### Todo el material en un lugar y de varios tipos (papel, cartón, transparencias,  marcadores,  etc).

#### Trabajar  rápido  y  componentes  reutilizables.

#### Lo  que  sea  difícil  de  simular,  describir  la  interacción  de palabra.

#### Posters  grandes para  dibujar  el  prototipo  y darle  contexto al  usuario.

#### Mezclar  hardware,  software  y  diferentes  fidelidades.

#### De  ser  apropiado,  añade  contexto  y  elementos  familiares  del  sistema  operativo.

### Prototipos  de  baja  a  media  fidelidad:


Wireframe  (plano de  pantallas):

#### Usado  en  diseño  web,  móvil  y de  escritorio.

#### Organización  de  la  pantalla,  no  colores  o gráficos.

#### Importa  la  funcionalidad,  comportamiento  y  prioridad  de  contenidos.


- Mostrar  éxito  o fracaso.

- No  editar,  mucho  tiempo.

### Evaluación  de  prototipos:
-

**El mago  de  Oz:**

#### Permite  evaluar  la  interacción  del  usuario  con  los  primeros  prototipos##### Conecta  la  estructura  conceptual  subyacente  con  el diseño  visual.

### Prototipos  de  alta  fidelidad:


Maquetas  digitales:  se  aproximan  al  diseño  final  y  permiten  una  evaluación  más  formal.

### Prototipado  en  vídeo:

#### Barato  y rápido de  hacer.

#### Excelente  herramienta  de comunicación  (muestra  contexto,  portable,  auto  explicativa)

#### Conecta decisiones de la interfaz con tareas (pensar en una interfaz completa y  detectar  elementos innecesarios).

#### Puede  utilizarse en  cualquier  fase  del  proceso.

#### ¿Qué  debe  mostrar  el  vídeo?

- Toda  la  tarea,  motivación  y  éxito.

- Tareas  más  importantes.

#### ¿Cómo se debe  hacer  el  video?

- Empezar  con un  esquema.

- Empezar  a grabar  a  ver qué  pasa.

- La  cámara  no importa.

- Encontrar  gente  y una localización  realista.

- Importa  el  mensaje,  no la  calidad  del vídeo.

#### Consideraciones:

- Audio  o  mudo  con  subtítulos.

- Interfaz  de papel,  maqueta, código  o  invisible.

- Mostrar  éxito  o fracaso.

- No  editar,  mucho  tiempo.

### Evaluación  de  prototipos:
-

**El mago  de  Oz:**

#### Permite  evaluar  la  interacción  del  usuario  con  los  primeros  prototipos.

#### Operador  humano  que  mueve  los  elementos  interactivos  como si  fuera  la  aplicación.

#### Probar  interacción  del  usuario  con  una  tecnología  no  existente.

#### Tiene sentido si es más rápido que desarrollar la aplicación real.  

Retos:

#### Interfaces  de  alta fidelidad  pueden hacer  pensar  al usuario que  está lista.

#### Interfaces  de alta fidelidad  dificultan que  haya  críticas.

#### Fácil prototipar algo que no se puede construir (hay que ser realista e incluir  corrección  de  errores).

#### Si quieres que tus usuarios crean que es un sistema real, tendrás que construir algún  tipo de  control  remoto,  que  permita al  mago  estar  escondido

#### Una  evaluación  externa  de  nuestras  interfaces  es  imprescindible.

#### Hay  que realizar  pruebas  de  usabilidad  a  lo  largo  del  proyecto,  no  únicamente  al  final.

#### En sistemas de alta disponibilidad, hay que probar situaciones de alta carga de trabajo,  e incluso  fallos  parciales.


## Tema 9. Evaluación de la interfaz

#### La evaluación debería medir el nivel en el que un producto se ajusta a los requisitos de  usabilidad.

- Requisitos  de usabilidad  cualitativos.

  - Características deseables. Pueden ser subjetivas y a veces difíciles de  medir. "Los usuarios deberían poder comprar un artículo fácilmente y  sin  ayuda".

- Requisitos  de  usabilidad  cuantitativos/Métricas  de  usabilidad.

  - Los requisitos se expresan numéricamente. "Cualquier página del sitio  debería cargar en menos de 10s en una conexión 3G", "4 de cada 5  usuarios noveles deben evaluar el producto como 'fácil de usar' o 'muy  fácil  de usar'  en  una escala  de 5 niveles".

#### Niveles  para evaluar  las  métricas  de  usabilidad:

- Actual

- Caso  mejor

- Planeado

- Caso peor

### Tipos  de  evaluación:

#### Qué:

- Encontrar tantos problemas de usabilidad como sea posible: evaluación  diagnóstica.

- Medir  el  nivel  de  cumplimiento  de los  requisitos:  evaluación  por  medidas.

#### Cuando:

- Durante  el  desarrollo:  evaluación  formativa.

- Al  final:  evaluación  sumativa.

#### Cómo:

- Temprana,  con  prototipos  de baja  fidelidad, informal:  evaluación  exploratoria.

- Al final, verificando el cumplimiento de los requisitos, experimento formal:  evaluación  de  validación.

- Elegir  una  entre  varias  opciones,  análisis  estadístico:  evaluación  competitiva.

#### Quién:

- Usuarios:  Estudios  con  usuarios.

- Expertos:  evaluación  experta.

- Otros.

### Estudios  con  usuarios:

#### Selección  de  usuarios

- ¿Cuántos?  Normalmente  5  son  suficientes

- ¿Quiénes? Idealmente usuarios reales, un representante de un perfil de  usuarios,  un  experto  de  usabilidad  o un  experto del dominio.

#### Dependiendo  de  dónde se  realiza  el  estudio:

- En  el  entorno  del  usuario:  estudios  de  campo.

- En  otros  entornos:  estudios  controlados.

### Laboratorios  de  usabilidad:

### Tipos  de  pruebas  de  usabilidad:
-

#### Pruebas  de  campo  y  laboratorios  portátiles

- Se  lleva  el  laboratorio de  usabilidad  al  lugar  donde  se  usará  el  sistema  final.

- Se deberá intentar capturar la mayor cantidad de información de cada  ejecución.

- Otra  opción  es  liberar  versiones beta a  un  gran  número de usuarios.

#### Pruebas  de  usabilidad  remotas

- Un gran número de usuarios prueban el sistema desde el lugar donde usarán  la aplicación

- Se puede buscar a los participantes en las bases de datos de clientes o en foros  on-line

- Las  pruebas  pueden  ser  síncronas  o asíncronas

- Ventajas: se puede acceder a un gran número de participantes, es barato, se  prueban  en  el hardware  del usuario

- Desventajas:  el  control  sobre  el  usuario  es  menor  y  se  pierden  sus  reacciones

- Algunos estudios dicen que este tipo de pruebas encuentran más problemas  que las técnicas  tradicionales

#### Prueba-a-romperlo

- Originario  de  las  pruebas  de  videojuegos,  se le  pide al  usuario que  intente

"romper"  el  sistema

- Este  tipo de  pruebas  de estrés  permite robustecer  las  aplicaciones

#### Pruebas  de  usabilidad  competitivas

- Compara la nueva interfaz con una versión anterior, o con una interfaz de la  competencia

- Se compara el tiempo en realizar una tarea o la tasa de fallos en un sistema y  en otro

### Preparando  el  experimento:

#### Se  debe  realizar  un  plan  detallado del  experimento,  incluyendo:

- Qué se  desea  medir.

- Cantidad,  tipos  y fuentes  de  los  participantes.

- Duración  (30-90  min)  y tareas  que deben realizar los  participantes.

- El contenido de los cuestionarios y entrevistas que se realizarán a los  participantes.

#### Realizar  una  prueba  piloto  con  un  número  reducido de participantes  (1-3)

- Nos  aseguramos de  que todos  los  detalles de  la  evaluación  funcionan.

- Realizar la prueba en el mismo lugar y tan parecido a como se realizará el  estudio  real como  sea  posible.

- Analizar e interpretar los datos, para asegurarnos de que se ha recogido toda  la  información  necesaria.

### Estructura  de  una  sesión:

#### Bienvenida.

- Objeto de estudio, procedimiento, duración, compromiso de confidencialidad  y  anonimato, aviso  de  los  peligros,  etc.

#### Firma  del  consentimiento  y  quizá  un  acuerdo  de confidencialidad.

#### Encuesta  filtro  de  selección.

- Experiencia con los ordenadores, o con la tarea a realizar, motivación, nivel  educativo,  capacidad  de  comprensión.

- Agudez  visual,  su  mano  dominante,  edad, género.

#### Usar los escenarios de tarea (adaptados al lenguaje de los usuarios) para describir los  pasos  que  debe seguir el usuario.

- Seleccionar  los  más  importantes.

#### Entrevista  después  de  la  sesión.

- Revisar las grabaciones y preguntar al usuario sobre sus intenciones y  acciones.

- Encuestas.

#### Incentivo.

### Durante  la  prueba:

### Midiendo  tiempos:


#### Usa un  cronómetro.

#### Acompaña  cada  comentario escrito durante  la  sesión  con  una  marca  de  tiempo.

- O usar un programa que capture las pulsaciones de teclado, pero no se puede  relacionar  los  comentarios  escritos con  cada  evento.

- O  usar  programas  especializados  en  evaluaciones  de  usabilidad.

#### Una técnica de prueba de usabilidad consiste en pedir al participante que exprese en  voz  alta su  opinión.

- El personal debe facilitar esta comunicación y pedir pistas sobre qué está  pensando el  participante.  No  debe  ayudarlo

- Ventajas.

  - Realimentación inmediata de las opiniones de los participantes sobre  la  interfaz  y sobre cualquier problema  o  sorpresa.

  - Puede ayudar a los usuarios a concentrarse durante la sesión de  evaluación.

  - Útil  para  recoger  datos  cualitativos.

- Desventajas.

  - Algunos  participantes  lo  encuentran  forzado  y  les  distrae.

  - Pensar en voz alta puede frenar los procesos mentales del  participante,  y reducir  artificialmente su  desempeño  y  tasas de  error.

  - Puede  ser  extenuante  para  el  usuario  si  dura demasiado.

#### Protocolo retrospectivo: preguntar a los usuarios sobre sus intenciones al realizar cada  acción  después  de  la prueba.

- Ventajas

  - No interfiere  con  las  medidas  de  desempeño

  - Útil  para  recoger  datos cuantitativos  ◦

- Inconvenientes:

  - El participante puede haber olvidado la razón por la que hizo cierta  acción

  - Algunos  participantes  pueden  sentirse  intimidados  por  las  cámaras

### Grabaciones:

#### Normalmente se graba a los participantes, para poder revisar posteriormente sus  reacciones,  errores, forma  de  trabajar,  etc.

#### Los métodos de tracking visual permiten calcular las zonas de la ventana que más  atención  atraen.

### Encuestas:

#### Son  un  método  familiar  y  barato para  capturar  la opinión  de un  usuario  o  un  experto.

#### Permite  sondear la  opinión  de  miles  de  usuarios  de una forma  estructurada.

#### Las claves para realizar encuestas útiles es tener claro sus objetivos y diseñar  preguntas  directas.

#### Pueden  ser en  papel  u  on-line.

#### Ventajas  ◦

- No  olvidar  hacer  alguna  pregunta.

- Comparar  las  respuestas  de  distintos  participantes.

- Recoger  datos  cuantitativos.

- Demostrar el progreso durante el desarrollo cuando el resultado de las  encuestas  mejora.

#### Inconvenientes

- Es  difícil  diseñar una  buena encuesta.

- Las preguntas cerradas son más fáciles de analizar, pero no dan la razón por la  que el usuario  eligió  la respuesta.

### Tipos  de  preguntas:
-

#### Escala Likert. El usuario debe mostrar su nivel de acuerdo con una afirmación:  totalmente de acuerdo, de acuerdo, neutral, en desacuerdo, totalmente en  desacuerdo.

- Preguntas:

  - Mejora  mi rendimiento  en  la búsqueda  y compra de  libros

  - Me permite  buscar  y  comprar  libros  más  rápido

  - Hace  más fácil  la compra y  búsqueda de libros

  - Aumenta  mi  productividad  buscando  y  comprando  libros

- Normalmente usa 5 niveles, pero 7 o 9 también son posibles (la escala siempre  es simétrica).

#### Encuesta  binaria  sobre  las reacciones del  usuario  al usar  un  procesador  de texto:

- Agradable  o  irritante

- Simple  o  complejo

- Conciso  o  redundante...

#### Otra  opción,  que gradúa  las  reacciones:

- Hostil  1  2 3  4  5  6  7  Amigable

- Ambiguo  1 2  3  4  5  6  7 Específico

- Induce a error  1 2  3  4  5  6  7  Beneficioso

- Desalentador  1 2  3  4 5 6 7  Alentador

### Cuestionarios  tipo:


#### Quiz:

- Diseñado para evaluar la satisfacción subjetiva del usuario con respecto a  aspectos específicos de  la interfaz.

- Estudia  nueve factores  específicos  de la  interfaz:

  - factores de pantalla, terminología y feedback del sistema, factores de  aprendizaje, capacidades del sistema, manuales técnicos, tutoriales  on-line,  multimedia,  teleconferencia  e  instalación  del  software.

- Escala  de  nueve puntos.

- El  cuestionario se  debe  ajustar  a  las  particularidades  de  cada  interfaz.

#### System  Usability  Scale  (SUS)

- Más  sencillo  que el  anterior.

- 10  afirmaciones, en  las que  el usuario  debe  valorar  en  una  escala de  5  puntos.

- La mitad de las preguntas están formuladas afirmativamente, y la otra mitad  negativamente.

#### Computer  System  Usability  Questionnaire  (CSUQ)

- 19 afirmaciones, en las que el usuario debe valorar su coincidencia en una  escala  de  7.

#### Website  Analysis  and  MeasureMent  Inventory (WAMMI)

- Servicio  comercial  de  realización  de  cuestionarios  on-line.

- 20 afirmaciones, en las que el usuario debe evaluar su coincidencia en una  escala  de  5  puntos.

- Dan el soporte web para la realización de los cuestionarios y luego generan un  informe de  los  resultados.

### Análisis  de  resultados:

#### Después de la sesión, habrás recogido: ◦ Datos personales sobre los participantes,  notas de los observadores, grabaciones de audio o vídeo, formularios de captura de  datos, datos cuantitativos sobre tiempos, errores y otras métricas de usabilidad, datos  cuantitativos (y cualitativos) de las encuestas realizadas antes y después de la prueba,  protocolos  retrospectivos,  una lista  de  problemas de  usabilidad  encontrados...

### Resumiendo  datos  cuantitativos:

#### Tablas,  gráficas  y  rankings.

#### Estadísticas  descriptivas.

#### Estadísticas  inferenciales  (pruebas  de  significancia  estadística).

### Recomendaciones:

#### Después de interpretar los resultados, se pueden realizar una serie de  recomendaciones  como:

- Puntos  fuertes de  la  interfaz.

- Defectos  a  solucionar.

- Posibles defectos o puntos fuertes, pero sin pruebas suficientes (hacen falta  más  pruebas).

- Áreas de  la  interfaz  que  no  se  han  probado.

- Cambios  a  los  requisitos  de  usabilidad  u otros  requisitos.

### Evaluación  experta:

#### Normalmente se realizan evaluaciones informales pidiendo opinión a colegas o  clientes.

#### Aunque  una  técnica  más  efectiva  consiste  en  consultar  a  evaluadores  expertos.

- internos  o externos.

#### El  resultado  de  una  evaluación  experta puede  ser:

- un  informe  formal  con  los  problemas  encontrados  y recomendaciones.

- una  presentación  y  discusión  con  los  responsables  o  los  diseñadores.

#### Ventajas:  ◦

- Resultados  disponibles  rápidamente.

- Más  económicos  que los  estudios  con  usuario.

- Expertos  sugieren  soluciones a  los  problemas  encontrados.

- Encontrar los errores obvios más fácilmente, para que no lleguen a las pruebas  con  usuarios.

#### Inconvenientes

- Los expertos no son usuarios reales, y sus predicciones sobre lo que harán los  usuarios con la interfaz o sobre la importancia de un defecto pueden ser  incorrectas.

- Los expertos tienen sus propias preferencias sobre el diseño de interfaces de  usuario, lo  que  puede  sesgar la evaluación.

- La  evaluación  experta  depende mucho  de  la  experiencia  del evaluador.

#### El  evaluador  debería:

- Replicar  las  condiciones  del  usuario  final.

- Tener  tacto  en  sus recomendaciones,

- Comprender que es difícil en tan poco tiempo comprender todas las  decisiones  de diseño  y la  historia  del desarrollo.

- Tener  experiencia en  el  tipo  de  aplicación  evaluada.

- Dejar  el  desarrollo de  las  soluciones a  los  diseñadores.

- Ser  exhaustivo en  el  informe.

- Revisar  la consistencia en  todas las  ventanas de  la aplicación.

### Tipos  de  evaluación:


#### Evaluación  heurística

- El experto evalúa si la interfaz sigue la lista de heurísticas de diseño (p.e., los  principios  de Nielsen).

#### Revisión  de  las guías de  diseño

- El  experto  revisa  que  se hayan  seguido  las  indicaciones  de las  guías  de  diseño.

#### Revisión  de  estándares

- El  experto  comprueba  que  el diseño  sigue un  estándar  (p.e.,  ISO  9241).

#### Inspección  de  consistencia

- Comprueba la terminología, fuentes, paletas, formatos de E/S, etc. tanto en las  interfaces  como  en la documentación.

### Informe:


#### Con  respecto al  informe,  se  debería:

- Usar  guías  de diseño  para  estructurar  el  informe,

- Separar  los  problemas  en  función  del tipo de  usuario  al que afecta

- Ordenar  las  recomendaciones por  importancia

- Describir  cada recomendación  a nivel  conceptual

- Ser  consciente de las  restricciones  técnicas  o de  negocio.

- Resolver  el  problema  completo,  no  sólo  un  caso  especial.

- Dar  recomendaciones  específicas y  claras,  con  ejemplos.

- Incluir pequeños detalles como faltas ortográficas, fallos de alineamiento de  controles,  inconsistencia  en  la posición  de los  controles,  etc.

### Otros  tipos  de  evaluación:

#### Entrevistas  de  grupos:

- 8  personas  y  1  moderador,  discuten sobre  algo.

- Usado  en marketing

- Útil  cuando no  existe la  interfaz.

#### Ordenación  de  tarjetas:

- Los  usuarios  agrupan  elementos.

- Identificar  categorías  y  estructuras  subyacentes.

- Imprimir cada elemento en una tarjeta y pedir a los usuarios que las agrupen,  y  posiblemente  que  le den  un  nombre  al grupo.

- Estudiar  los  resultados,  tanto:

  - donde hay  acuerdo  general,

  - donde no hay acuerdo, y estudiar cómo resolverlo (quizá renombrar el  elemento,  o  poner el  elemento  en  varias categorías).

### Pruebas  de  aceptación:

#### Son pruebas que realiza un cliente sobre el sistema para comprobar que cumple los  requisitos

- Por ejemplo, estableciendo unos casos de uso, y el tiempo medio de respuesta  del  conjunto  hardware-software.

#### Para  establecer  requisitos  de las  interfaces  de  usuario,  hay  que usar  criterios  medibles.

- Tiempo  necesario  para  aprender  a  usar  ciertas  funciones.

- Velocidad  de  completado  de una  tarea.

- Tasa  de  error  de los  usuarios.

- Retención  de  las  órdenes  a  lo  largo  del  tiempo.

- Satisfacción  subjetiva  del  usuario.

#### Otros  elementos  medibles:

- Comprensión de la salida del sistema, tiempo de respuesta del sistema,  procedimiento  de  instalación,  documentación  impresa,  atractivo  visual,  etc.

#### Unos criterios de aceptación precisos ahorra posteriores discusiones y ofrece una  prueba  objetiva de  cumplimiento  de  contrato.

#### Se  deberían  realizar  por  una  parte  neutral.

#### Después de las pruebas de validación, aún se deberán realizar pruebas de campo antes  de publicar el sistema.

### Evaluación  durante  el  uso:

#### Una vez que se ha publicado el sistema se debe hacer un seguimiento del mismo para  mejorarlo.

#### Hay que  minimizar  los  cambios  en  la  interfaz  para  evitar molestar a los usuarios.

#### Herramientas

- Entrevistas  y  discusiones  en  grupo.

- Captura  continua  de  datos  de rendimiento  del  usuario.

- Consultas  online  o  telefónicas,  buzones  de  sugerencias.

- Grupos  de discusión,  wikis  y grupos de  noticias.

- Herramientas  de  evaluación  automática.
