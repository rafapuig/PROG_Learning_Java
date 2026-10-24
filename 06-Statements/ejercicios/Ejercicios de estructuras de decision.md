# Ejercicios de Java: estructuras de decisión

**Ciclo:** 1.º DAW  
**Objetivo:** practicar las estructuras de decisión en Java.  
**Contenidos:** `if`, `if-else`, `if-else if` y `switch`.

## Nivel 1. Condicional simple: `if`

### Ejercicio 1. Número positivo

Solicita al usuario un número entero. Si el número es mayor que cero, muestra el mensaje `El número es positivo`.

### Ejercicio 2. Mayor de edad

Solicita la edad de una persona. Si tiene 18 años o más, muestra el mensaje `Eres mayor de edad`.

### Ejercicio 3. Número par

Solicita un número entero e indica si es par. Si lo es, muestra el mensaje `El número es par`.

### Ejercicio 4. Descuento en una compra

Solicita el importe de una compra. Si el importe es superior a 100 euros, muestra un mensaje indicando que el cliente tiene derecho a un descuento del 10 %.

En este ejercicio solo hay que comprobar si se cumple la condición, no calcular el descuento.

### Ejercicio 5. Acceso permitido

Solicita al usuario su edad y si tiene entrada para un evento. Si tiene 18 años o más y dispone de entrada, muestra `Acceso permitido`.

Para representar si tiene entrada, utiliza una variable de tipo `boolean`.

## Nivel 2. Condicional doble: `if-else`

### Ejercicio 6. Número positivo o negativo

Solicita un número entero e indica si es positivo o si es negativo o cero.

### Ejercicio 7. Par o impar

Solicita un número entero e indica si es par o impar.

### Ejercicio 8. Aprobado o suspenso

Solicita la nota de un alumno, comprendida entre 0 y 10. Si obtiene una nota igual o superior a 5, muestra `Aprobado`; en caso contrario, muestra `Suspenso`.

### Ejercicio 9. El mayor de dos números

Solicita dos números enteros e indica cuál es mayor. Si ambos son iguales, muestra `Los números son iguales`.

### Ejercicio 10. Número divisible

Solicita dos números enteros. Si el segundo número es distinto de cero, comprueba si el primero es divisible por el segundo. Si lo es, muestra `Es divisible`; en caso contrario, muestra `No es divisible`.

Si el segundo número es cero, muestra un mensaje de error.

## Nivel 3. Condicional múltiple: `if-else if`

### Ejercicio 11. Clasificación de una nota

Solicita una nota entre 0 y 10 y muestra su calificación según los siguientes criterios:

- De 0 a menos de 5: Insuficiente.
- De 5 a menos de 6: Suficiente.
- De 6 a menos de 7: Bien.
- De 7 a menos de 9: Notable.
- De 9 a 10: Sobresaliente.

Si la nota está fuera del intervalo permitido, muestra un mensaje de error.

### Ejercicio 12. Clasificación por edad

Solicita la edad de una persona y clasifícala en una de las siguientes categorías:

- Menor de 12 años: niño.
- De 12 a 17 años: adolescente.
- De 18 a 64 años: adulto.
- 65 años o más: persona mayor.

Si se introduce una edad negativa, muestra un mensaje de error.

### Ejercicio 13. El mayor de tres números

Solicita tres números enteros y muestra cuál es el mayor de los tres.

Si hay dos o tres números que comparten el valor máximo, el programa debe indicarlo.

### Ejercicio 14. Precio de una entrada de cine

Solicita la edad del cliente y calcula el precio de su entrada según estas tarifas:

- Menores de 5 años: entrada gratuita.
- De 5 a 17 años: 5 euros.
- De 18 a 64 años: 8 euros.
- 65 años o más: 6 euros.

Si la edad es negativa, muestra un mensaje de error.

### Ejercicio 15. Año bisiesto

Solicita un año y determina si es bisiesto.

Un año es bisiesto si cumple alguna de estas condiciones:

- Es divisible por 400.
- Es divisible por 4, pero no por 100.

Si no cumple ninguna de ellas, no es bisiesto.

**Ejemplos:**

- 2024: bisiesto.
- 1900: no bisiesto.
- 2000: bisiesto.

## Nivel 4. Selección múltiple: `switch`

### Ejercicio 16. Día de la semana

Solicita un número entero del 1 al 7 y muestra el día de la semana correspondiente. El 1 representa el lunes y el 7 el domingo.

Si el número no está comprendido entre 1 y 7, muestra un mensaje de error.

Resuelve el ejercicio utilizando `switch`.

### Ejercicio 17. Calculadora básica

Solicita dos números y una operación matemática (`+`, `-`, `*` o `/`). Utiliza `switch` para realizar la operación y mostrar el resultado.

Si se intenta dividir entre cero, muestra un mensaje de error.

### Ejercicio 18. Menú de opciones

Muestra el siguiente menú:

```text
1. Saludar
2. Mostrar la fecha de nacimiento solicitada
3. Mostrar un mensaje de despedida
4. Salir
```

Solicita una opción y utiliza `switch` para ejecutar la acción correspondiente.

Si se introduce una opción no válida, muestra un mensaje de error.

### Ejercicio 19. Mes del año

Solicita un número del 1 al 12 y muestra el nombre del mes correspondiente.

Si el número no es válido, muestra un mensaje de error.

Utiliza `switch`.

### Ejercicio 20. Conversor de unidades

Crea un programa que permita convertir una cantidad introducida por el usuario. Muestra este menú:

```text
1. Metros a centímetros
2. Kilómetros a metros
3. Kilogramos a gramos
4. Litros a mililitros
```

Solicita una opción y una cantidad. Utiliza `switch` para realizar la conversión correspondiente.

Si la opción no es válida, muestra un mensaje de error.

## Nivel 5. Ejercicios combinados

### Ejercicio 21. Cajero automático

Solicita al usuario el saldo de su cuenta y la cantidad que desea retirar.

El programa debe cumplir las siguientes condiciones:

- Si la cantidad solicitada es menor o igual que cero, muestra un mensaje de error.
- Si la cantidad solicitada supera el saldo disponible, muestra `Saldo insuficiente`.
- En caso contrario, calcula y muestra el saldo restante.

### Ejercicio 22. Envío de un pedido

Solicita el importe de una compra y el tipo de envío:

- `1`: envío estándar, 4 euros.
- `2`: envío urgente, 8 euros.

Si la compra alcanza los 50 euros, el envío es gratuito independientemente de la modalidad elegida.

Utiliza `switch` para determinar el coste del envío y estructuras `if` para aplicar la gratuidad.

Muestra el importe de la compra, el coste del envío y el total.

### Ejercicio 23. Acceso a una aplicación

Solicita un nombre de usuario y una contraseña.

El acceso solo está permitido si el nombre de usuario es `admin` y la contraseña es `java123`.

Muestra `Acceso correcto` o `Usuario o contraseña incorrectos`.

Utiliza el operador `&&` y compara cadenas correctamente en Java.

### Ejercicio 24. Cálculo de una factura eléctrica

Solicita el consumo eléctrico mensual en kWh y calcula el importe de la energía según estas tarifas:

- Hasta 100 kWh, incluidos: 0,12 €/kWh.
- Más de 100 y hasta 200 kWh, incluidos: 0,15 €/kWh.
- Más de 200 kWh: 0,18 €/kWh.

La tarifa correspondiente se aplica a todo el consumo. Por ejemplo, un consumo de 150 kWh se calcula íntegramente a 0,15 €/kWh.

Si el consumo es negativo, muestra un mensaje de error.

### Ejercicio 25. Triángulo válido

Solicita las longitudes de los tres lados de un triángulo.

El programa debe comprobar primero que las longitudes son positivas y que cumplen la desigualdad triangular: la suma de cada pareja de lados debe ser mayor que el tercer lado.

Si forman un triángulo válido, indica si es:

- Equilátero: los tres lados son iguales.
- Isósceles: exactamente dos lados son iguales.
- Escaleno: los tres lados son diferentes.

Si no forman un triángulo válido, muestra un mensaje de error.

## Indicaciones generales

- Utiliza nombres de variables descriptivos.
- No utilices arrays, listas ni colecciones.
- Emplea la estructura de decisión más adecuada para cada ejercicio.
- Valida los datos de entrada cuando el enunciado lo requiera.
- En los ejercicios con `switch`, contempla las opciones no válidas.
- Evita repetir condiciones innecesariamente.
- Prueba cada programa con distintos valores, incluidos los casos límite.
