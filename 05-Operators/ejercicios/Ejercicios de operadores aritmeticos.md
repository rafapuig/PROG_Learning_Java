# Ejercicios de operadores aritméticos en Java

## 1. Operaciones básicas

**Ejercicio 1. Suma y resta**

Declara dos variables enteras `firstNumber` y `secondNumber`. Asigna valores y muestra por pantalla su suma, resta, multiplicación y división.

**Ejercicio 2. Calculadora básica**

Solicita al usuario dos números decimales y muestra el resultado de las cuatro operaciones aritméticas básicas.

**Ejercicio 3. Área de un rectángulo**

Solicita la base y la altura de un rectángulo. Calcula y muestra su área y su perímetro.

**Ejercicio 4. Conversión de minutos**

Solicita una cantidad de minutos y conviértela en horas y minutos restantes. Por ejemplo, 135 minutos son 2 horas y 15 minutos.

**Ejercicio 5. Conversión de segundos**

Solicita una cantidad de segundos y muestra cuántas horas, minutos y segundos representa.

## 2. División y operador módulo (`%`)

**Ejercicio 6. Cociente y resto**

Solicita dos números enteros y muestra el cociente entero y el resto de su división.

**Ejercicio 7. Par o impar**

Solicita un número entero y utiliza el operador módulo para determinar si es par o impar.

**Ejercicio 8. Reparto de caramelos**

Solicita el número de caramelos y el número de alumnos. Calcula cuántos caramelos recibe cada alumno y cuántos sobran.

**Ejercicio 9. Última cifra**

Solicita un número entero positivo y muestra su última cifra utilizando únicamente operaciones aritméticas.

**Ejercicio 10. Extraer cifras**

Solicita un número entero positivo de tres cifras y muestra por separado sus centenas, decenas y unidades.

## 3. Operadores compuestos e incremento

**Ejercicio 11. Operadores de asignación**

Declara una variable `score` con valor inicial 20. Aplica sucesivamente las operaciones `+= 5`, `-= 3`, `*= 2` y `/= 4`. Muestra el valor después de cada operación.

**Ejercicio 12. Incremento y decremento**

Declara `number = 10`. Incrementa la variable dos veces, decrementa una vez y muestra su valor final.

**Ejercicio 13. Prefijo y sufijo**

Indica qué muestra cada instrucción y cuál es el valor final de `number`.

```java
int number = 5;

System.out.println(number++);
System.out.println(++number);
System.out.println(number--);
System.out.println(--number);

System.out.println(number);
```

**Ejercicio 14. Actualización de saldo**

Una cuenta tiene un saldo inicial de 500 euros. Añade un ingreso de 120 euros y resta un gasto de 75 euros utilizando operadores de asignación compuesta. Muestra el saldo final.

**Ejercicio 15. Precio con descuento**

Solicita el precio de un producto y un descuento porcentual entero. Calcula el importe descontado y el precio final.

## 4. Expresiones aritméticas y prioridad de operadores

**Ejercicio 16. Evaluación de expresiones**

Calcula el resultado de las siguientes expresiones sin ejecutarlas primero. Después, comprueba tus respuestas con Java.

```java
int result1 = 8 + 3 * 4;
int result2 = (8 + 3) * 4;
int result3 = 20 / 3;
int result4 = 20 % 3;
int result5 = 10 - 4 / 2 + 3 * 2;
```

**Ejercicio 17. Expresiones con variables**

Declara `a = 12`, `b = 5` y `c = 2`. Calcula y muestra:

- `a + b * c`
- `(a + b) * c`
- `a / b + c`
- `a % b * c`
- `a - b * c + 10 / c`

**Ejercicio 18. Media aritmética**

Solicita tres notas decimales y calcula su media aritmética. Evita que la división se realice como una división entera.

**Ejercicio 19. Velocidad media**

Solicita la distancia recorrida en kilómetros y el tiempo empleado en horas. Calcula la velocidad media.

**Ejercicio 20. Interés simple**

Solicita un capital inicial, un porcentaje de interés anual y el número de años. Calcula los intereses generados mediante la fórmula del interés simple y el capital final.

## 5. Retos de programación

**Ejercicio 21. Cambio de monedas**

Solicita una cantidad entera de euros y calcula cuántos billetes de 50, 20, 10 y 5 euros, y cuántas monedas de 2 y 1 euro, se necesitan para representarla usando la menor cantidad posible de piezas.

**Ejercicio 22. Conversión de temperatura**

Solicita una temperatura en grados Celsius y conviértela a Fahrenheit mediante la fórmula:

`fahrenheit = celsius * 9 / 5 + 32`

Comprueba que Java realiza correctamente las operaciones cuando se utilizan valores decimales.

**Ejercicio 23. Intercambio de valores**

Declara dos variables enteras `firstNumber` y `secondNumber`. Intercambia sus valores utilizando una tercera variable auxiliar.

**Ejercicio 24. Intercambio sin variable auxiliar**

Repite el ejercicio anterior, pero intercambia los valores utilizando exclusivamente operaciones aritméticas, sin declarar una tercera variable. Prueba con distintos valores y evita desbordamientos.

**Ejercicio 25. Descomposición de una cantidad**

Solicita una cantidad de segundos y conviértela en días, horas, minutos y segundos. Por ejemplo, 200000 segundos deben descomponerse en días completos y el tiempo restante.