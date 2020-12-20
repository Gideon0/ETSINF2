model('ibiza', 'seat'). % ibiza es un modelo de la marca seat
model('cordoba', 'seat'). 
model('altea', 'seat').
model('golf', 'volkswagen').
model('touran', 'volkswagen').
model('clio', 'renault').
model('twingo', 'renault').
model('mégane', 'renault').
model('scénic', 'renault').
model('2008', 'peugeot').
model('3008', 'peugeot').
model('corsa', 'opel').

country('seat', 'españa'). % seat es una marca fabricada en españa
country('renault', 'francia').
country('peugeot', 'francia').
country('volkswagen', 'alemania').
country('opel', 'alemania').

since('ibiza', 1984). % ibiza es un modelo fabricado desde 1984
since('cordoba', 1993).
since('altea', 2004).
since('golf', 1974).
since('touran', 2003).
since('clio', 1990).
since('twingo', 1993).
since('mégane', 1995).
since('scénic', 1995).
since('2008', 2013).
since('3008', 2008).
since('corsa', 1982).

segment('ibiza', 'b'). % ibiza es un modelo del Segmento B
segment('cordoba', 'b').
segment('altea', 'c'). 
segment('golf', 'c').
segment('touran', 'c').
segment('clio', 'b').
segment('twingo', 'a').
segment('mégane', 'c').
segment('scénic', 'c').
segment('2008', 'b').
segment('3008', 'c').
segment('corsa', 'b').

% A es marca de B si B es modelo de A
brand(A,B) :- model(B,A).

% A es modelo del país B si A es modelo de C y C es del país B
isModelFrom(A,B) :- model(A,C), country(C,B).

% A y B son modelos de la misma marca C si ...
isSameBrand(A,B) :- model(A,C), model(B,C), A \== B.        

% A y B son modelos del mismo año si ...
isSameYear(A,B) :- since(A,C), since(B,C), A \== B.

% A y B estan relacionados si ...
isRelated(A,B) :- isSameBrand(A,B).
isRelated(A,B) :- isSameYear(A,B).
isRelated(A,B) :- segment(A,C), segment(B,C), A \== B. 

% Ejercicio 8
isRelated(A,B) :- isClasic(A), isClasic(B), A\==B.

% Ejercicio 7
isCountryOf(C,A) :- isModelFrom(A,C).
isClasic(M) :- since(M,Y), Y=<1995.