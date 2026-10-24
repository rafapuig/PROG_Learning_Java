# Ejercicios de Java: expresiones booleanas

**Objetivos:**
- Construir expresiones booleanas utilizando operadores relacionales.
- Combinar condiciones con `&&`, `||` y `!`.
- Comprender el funcionamiento de las expresiones booleanas.
- Aplicar las expresiones a situaciones prácticas.

**Restricciones:** no se permite utilizar arrays ni colecciones. En estos ejercicios se debe trabajar principalmente con variables, expresiones booleanas y operadores.

## Nivel 1. Operadores relacionales

### Ejercicio 1. Comparar números

Declara dos variables enteras, `firstNumber` y `secondNumber`, con valores elegidos por ti.

Crea expresiones booleanas que permitan determinar:

1. Si el primer número es mayor que el segundo.
2. Si el primer número es menor que el segundo.
3. Si ambos números son iguales.
4. Si ambos números son diferentes.
5. Si el primer número es mayor o igual que el segundo.

Muestra el resultado de cada expresión por pantalla.

### Ejercicio 2. Edad para votar

Declara una variable entera `age`.

Crea una expresión booleana que sea verdadera cuando la persona tenga 18 años o más.

Prueba el programa con las edades 15, 18 y 25.

### Ejercicio 3. Número comprendido entre dos valores

Declara una variable entera `number`.

Construye una expresión booleana que sea verdadera cuando el número esté comprendido entre 10 y 20, ambos incluidos.

Prueba con los valores 9, 10, 15, 20 y 21.

### Ejercicio 4. Número fuera de un intervalo

Declara una variable entera `number`.

Construye una expresión booleana que sea verdadera cuando el número sea menor que 10 o mayor que 20.

Comprueba que los valores 10 y 20 no cumplen la condición.

### Ejercicio 5. Aprobado

Declara una variable de tipo `double` llamada `grade`.

Construye expresiones booleanas que indiquen:

1. Si la nota es mayor o igual que 5.
2. Si la nota es inferior a 5.
3. Si la nota está comprendida entre 5 y 10, ambos incluidos.
4. Si la nota está fuera del intervalo de 0 a 10.

## Nivel 2. Operadores lógicos

### Ejercicio 6. Acceso a una instalación

Declara las variables booleanas `hasTicket` y `isAdult`.

El acceso está permitido únicamente si la persona tiene entrada y es mayor de edad.

Construye una expresión booleana que represente esta condición.

Prueba las cuatro combinaciones posibles de los valores de las dos variables.

### Ejercicio 7. Descuento para clientes

Una tienda concede un descuento si el cliente es socio o si su compra supera los 100 euros.

Declara las variables `isMember` y `purchaseAmount`.

Construye una expresión booleana que indique si el cliente tiene derecho al descuento.

### Ejercicio 8. Requisitos para matricularse

Para matricularse en un curso es necesario tener al menos 18 años y disponer de un título de acceso.

Declara las variables `age` y `hasQualification`.

Construye una expresión booleana que indique si se cumplen ambos requisitos.

### Ejercicio 9. Acceso denegado

Declara una variable booleana `isBlocked`.

Construye una expresión booleana que sea verdadera cuando el usuario no esté bloqueado.

A continuación, construye otra expresión equivalente utilizando el operador `!`.

### Ejercicio 10. Horario de apertura

Un establecimiento abre de 9:00 a 14:00 y de 16:00 a 20:00.

Declara una variable entera `hour` que representa una hora en formato de 24 horas.

Construye una expresión booleana que indique si el establecimiento está abierto, considerando los intervalos desde las 9 hasta antes de las 14 y desde las 16 hasta antes de las 20.

Prueba con las horas 8, 9, 13, 14, 16, 19 y 20.

## Nivel 3. Condiciones compuestas

### Ejercicio 11. Número válido

Un número entero es válido si está comprendido entre 1 y 100, ambos incluidos, y además es par.

Declara una variable `number` y construye una única expresión booleana que compruebe ambas condiciones.

### Ejercicio 12. Acceso a una cuenta

Para acceder a una cuenta, el usuario debe introducir correctamente su nombre de usuario y su contraseña.

Declara dos variables booleanas, `correctUsername` y `correctPassword`.

Construye una expresión que indique si puede acceder y otra que indique si debe rechazarse el acceso.

### Ejercicio 13. Becas

Un estudiante puede optar a una beca si cumple al menos una de estas condiciones:

- Tiene una nota media igual o superior a 8,5.
- Tiene una nota media igual o superior a 7 y la renta familiar es inferior a 15.000 euros.

Declara las variables necesarias y construye una única expresión booleana que determine si puede optar a la beca.

### Ejercicio 14. Año bisiesto

Declara una variable entera `year`.

Construye una expresión booleana que determine si el año es bisiesto según estas reglas:

- Es bisiesto si es divisible por 400.
- También es bisiesto si es divisible por 4, pero no por 100.

No utilices estructuras `if` para calcular el resultado: toda la condición debe estar expresada en una única expresión booleana.

### Ejercicio 15. Triángulo válido

Declara tres variables enteras `sideA`, `sideB` y `sideC`.

Construye una expresión booleana que indique si las tres longitudes pueden formar un triángulo.

Las tres longitudes deben ser positivas y la suma de cada pareja de lados debe ser estrictamente mayor que el tercer lado.

## Nivel 4. Interpretar expresiones booleanas

En los siguientes ejercicios no debes escribir programas completos. Debes calcular el resultado de cada expresión para los valores indicados y explicar brevemente el motivo.

### Ejercicio 16. Evaluar expresiones

Considera estas variables:

```java
int a = 5;
int b = 10;
int c = 5;
```

Calcula el resultado de las siguientes expresiones:

1. `a < b`
2. `a == c`
3. `b != c`
4. `a >= c`
5. `a + c > b`
6. `b - a == c`

### Ejercicio 17. Operadores lógicos

Considera estas variables:

```java
boolean a = true;
boolean b = false;
boolean c = true;
```

Calcula el resultado de cada expresión:

1. `a && b`
2. `a || b`
3. `!a`
4. `!(a && b)`
5. `a && b || c`
6. `a && (b || c)`
7. `!a || c`
8. `!(a || b)`

Presta especial atención al uso de los paréntesis y a la precedencia de los operadores.

### Ejercicio 18. Comparaciones combinadas

Considera estas variables:

```java
int age = 20;
double grade = 7.5;
boolean hasTicket = true;
```

Determina el resultado de cada expresión:

1. `age >= 18 && hasTicket`
2. `age < 18 || grade >= 5`
3. `!(grade < 5)`
4. `age >= 18 && grade >= 5 && hasTicket`
5. `age < 18 && grade >= 5 || hasTicket`
6. `!(age < 18 || !hasTicket)`

## Nivel 5. Tablas de verdad y equivalencias

### Ejercicio 19. Tabla de verdad de AND

Completa una tabla de verdad para el operador `&&`.

Incluye todas las combinaciones posibles de dos variables booleanas `a` y `b`, e indica el resultado de `a && b`.

### Ejercicio 20. Tabla de verdad de OR

Completa una tabla de verdad para el operador `||`.

Incluye todas las combinaciones posibles de `a` y `b`, e indica el resultado de `a || b`.

### Ejercicio 21. Tabla de verdad de NOT

Completa una tabla de verdad para el operador `!`.

Indica el resultado de `!a` cuando `a` vale `true` y cuando vale `false`.

### Ejercicio 22. Expresiones equivalentes

Para dos variables booleanas `a` y `b`, determina si las siguientes parejas de expresiones son equivalentes:

1. `!(a && b)` y `!a || !b`
2. `!(a || b)` y `!a && !b`
3. `a && b` y `a || b`
4. `a || !a` y `true`
5. `a && !a` y `false`

Utiliza tablas de verdad para justificar tus respuestas.

### Ejercicio 23. Simplificar condiciones

Simplifica las siguientes expresiones sin cambiar su significado:

1. `age >= 18 && age >= 21`
2. `number > 0 || number == 0`
3. `!(isAdult == true)`
4. `isMember == true && hasTicket == true`
5. `number < 10 || number >= 10`

Indica qué expresiones pueden simplificarse y escribe su versión más sencilla.

## Nivel 6. Encontrar errores y razonar

### Ejercicio 24. Detectar errores

Analiza las siguientes expresiones y explica qué problema tiene cada una, si existe:

1. `age = 18`
2. `age => 18`
3. `grade >= 5 && <= 10`
4. `isAdult && age >= 18`
5. `age >= 18 || age <= 65`

Corrige las expresiones que no sean válidas o que no representen correctamente una condición habitual, según corresponda.

### Ejercicio 25. Diseñar condiciones

Escribe una expresión booleana para cada situación:

1. Una persona tiene entre 18 y 30 años, ambos incluidos.
2. Un número es múltiplo de 3 y de 5.
3. Un número no está comprendido entre 20 y 50, ambos incluidos.
4. Un usuario tiene permiso de administrador o de editor, pero no está bloqueado.
5. Una nota es válida si está entre 0 y 10, ambos incluidos, y no es exactamente 5.
6. Una persona puede entrar si es mayor de edad o va acompañada de un adulto.
7. Un pedido tiene envío gratuito si el importe es de al menos 50 euros y el cliente es socio, o si el importe supera los 100 euros.

**Importante:** utiliza operadores relacionales y lógicos. No necesitas emplear `if`, `switch` ni bucles para resolver este ejercicio.
