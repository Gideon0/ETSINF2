#### TEORÍA
Respecto	a	las	diferencias	entre	la	programación	concurrente	y	la	programación	secuencial:
|||
|--|--|
|1. Los	programas	secuenciales	pueden	generar	condiciones	de	carrera,	al	igual	que	 los	programas	concurrentes.| F
|2. Un	proceso	con	varios	hilos	de	ejecución,	ejecutado	con	un	procesador	con	un	único	núcleo	que	ofrece	multiprogramación,	es	un	ejemplo	de	aplicación concurrente.| V

Respecto	a	la	programación	concurrente	en	Java:
|||
|--|--|
|3. Si	un	método	se	etiqueta	con	synchronized y	se	invoca	desde	otro	método	de	la	misma	instancia	etiquetado	también	con	synchronized,	provoca	que	el	hilo	se	espere	a	sí	mismo	(interbloqueo).|F

Sobre	el	problema	de	la	sección	crítica:	
|||
|--|--|
|4. Una	solución	correcta	para	el	problema	de	la	sección	crítica		debe	cumplir	las	propiedades	de	exclusión	mutua,	retención	y	espera,	no	expulsión	y	espera	circular |F
|5. El	problema	de	la	sección	crítica	aparece	cuando	varios	hilos	comparten	un	objeto	inmutable	(constante)	al	que	todos	los	hilos	necesitan	acceder	de	forma	simultánea.|F
|6. El	problema	de	la	sección	crítica	se	soluciona	empleando	correctamente	mecanismos	de	sincronización,	como	por	ejemplo	monitores,	semáforos	y	cerrojos.| V
|7. Si	empleamos	un	único	cerrojo	para	proteger	las	secciones	críticas	de	cierto	objeto,	se	permitirá	como	máximo	un	hilo	ejecutando	dichas secciones	críticas |V
|8. En	una	sección	crítica	protegida	por	un	lock,	el	protocolo	de	salida	libera	el	lock,	permitiendo	que	todos	los	hilos	bloqueados	en	la	entrada	accedan	al	objeto|F

Sobre	el	concepto	de	monitor	y	sus	variantes:
|||
|--|--|
|9. Suponiendo	que	haya	algún	hilo	suspendido	en	la	variable	condición		c ,	un	monitor	que	siga	el	modelo	de	Hoare	suspende	al	hilo	que	ha	invocado	a	c.notify() y	activa	a	uno	de	los	hilos	que	llamó	antes	a	c.wait().|V
|10. El	lenguaje	Java	proporciona	por	defecto	monitores	de	tipo	"Lampson/Redell".	| V
|11. El	monitor	Lampson-Redell	garantiza	que	tras	una	operación	notify(),		el	hilo	reactivado	encuentra	el	estado	del	monitor	exactamente	igual	que	estaba	cuando	se	ejecutó	dicho	notify.	| F
