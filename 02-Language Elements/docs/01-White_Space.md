# Espacios en blanco
Los espacios en blanco (y los comentarios) cumplen la función de separar los tokens.

(Igual que en un idioma escrito los espacios separan el texto en palabras. Una palabra sería
el equivalente a un token en el código fuente escrito para un lenguaje de programación)

Ejemplos:

- 1 5 --> Serían dos tokens: el literal 1 y el literal 5 separados por un espacio en blanco.

- 15 --> Dos carácteres que se reconocerán como un solo token: el literal 15

- var x --> Son dos tokens: la keyword contextual var y el identificador x

- int y=10 --> son 4 tokens: int, y, =, 10 (a veces no es necesario espacio para delimitar tokens)

Se considera un espacio en blanco no solo el caracter espacio, además de este:
- el tabulador
- el final de línea (salto de línea)