# Ejercicios de programación: Entrada de datos, constantes y operadores

> **Objetivo:** Practicar la lectura de datos mediante la clase `IO`, el uso de **constantes** (`final`) y la realización de cálculos utilizando operadores aritméticos.
>
> En todos los ejercicios se utilizarán los métodos:
>
> - `IO.readln()` para leer datos desde el teclado.
> - `IO.println()` para mostrar información por pantalla.
>
> **Importante:** En estos ejercicios **no se deben utilizar estructuras de control** (`if`, `switch`, `for`, `while`).

---

# Ejercicio 1. Área de un círculo

Solicita al usuario el radio de un círculo utilizando `IO.readln()`.

Declara una constante para el valor de π.

```java
final double PI = 3.141592653589793;
```

Calcula el área y muestra el resultado utilizando `IO.println()`.

---

# Ejercicio 2. Longitud de una circunferencia

Solicita el radio de una circunferencia.

Utiliza una constante para π y calcula su longitud.

Muestra el resultado mediante `IO.println()`.

---

# Ejercicio 3. Precio con IVA

Solicita el precio de un producto.

Declara una constante para el IVA.

```java
final double VAT = 0.21;
```

Calcula:

- IVA.
- Precio final.

Muestra ambos valores.

---

# Ejercicio 4. Precio con descuento

Solicita el precio de un producto.

Utiliza una constante para un descuento del 15 %.

```java
final double DISCOUNT = 0.15;
```

Calcula:

- Importe del descuento.
- Precio final.

---

# Ejercicio 5. Conversión de euros a dólares

Solicita una cantidad en euros.

Declara la constante:

```java
final double EXCHANGE_RATE = 1.17;
```

Calcula el importe equivalente en dólares.

---

# Ejercicio 6. Conversión de kilómetros a millas

Solicita una distancia en kilómetros.

Utiliza la constante:

```java
final double KM_TO_MILES = 0.621371;
```

Calcula la distancia en millas.

---

# Ejercicio 7. Conversión de grados Celsius a Fahrenheit

Solicita una temperatura en grados Celsius.

Utiliza la fórmula:

```text
F = C × 9 / 5 + 32
```

Declara las siguientes constantes:

```java
final int NUMERATOR = 9;
final int DENOMINATOR = 5;
```

---

# Ejercicio 8. Salario anual

Solicita el salario mensual.

Declara la constante:

```java
final int MONTHS_PER_YEAR = 12;
```

Calcula el salario anual.

---

# Ejercicio 9. Edad en días

Solicita la edad de una persona.

Utiliza la constante:

```java
final int DAYS_PER_YEAR = 365;
```

Calcula aproximadamente cuántos días ha vivido.

---

# Ejercicio 10. Conversión de horas a segundos

Solicita un número de horas.

Utiliza las constantes:

```java
final int MINUTES_PER_HOUR = 60;
final int SECONDS_PER_MINUTE = 60;
```

Calcula el número total de segundos.

---

# Ejercicio 11. Consumo de combustible

Solicita:

- Kilómetros recorridos.
- Litros consumidos.

Declara la constante:

```java
final int FACTOR = 100;
```

Calcula el consumo medio en litros cada 100 kilómetros.

---

# Ejercicio 12. Nota media

Solicita tres notas.

Declara la constante:

```java
final int NUMBER_OF_GRADES = 3;
```

Calcula la nota media.

---

# Ejercicio 13. Velocidad media

Solicita:

- Distancia recorrida (km).
- Tiempo empleado (horas).

Calcula la velocidad media.

---

# Ejercicio 14. Precio por persona

Solicita:

- Importe total de una comida.
- Número de comensales.

Calcula cuánto debe pagar cada persona.

---

# Ejercicio 15. Índice de Masa Corporal (IMC)

Solicita:

- Peso (kg).
- Altura (m).

Calcula el IMC.

---

# Ejercicio 16. Hipotenusa

Solicita los dos catetos de un triángulo rectángulo.

Calcula la hipotenusa utilizando:

```java
Math.sqrt()
```

---

# Ejercicio 17. Volumen de un cilindro

Solicita:

- Radio.
- Altura.

Utiliza una constante para π y calcula el volumen.

---

# Ejercicio 18. Tiempo total de una película

Solicita:

- Horas.
- Minutos.

Declara la constante:

```java
final int MINUTES_PER_HOUR = 60;
```

Calcula la duración total en minutos.

---

# Ejercicio 19. Conversión de almacenamiento

Solicita una cantidad de gigabytes.

Utiliza las constantes:

```java
final int BYTES_PER_KB = 1024;
final int KB_PER_MB = 1024;
final int MB_PER_GB = 1024;
```

Calcula el número de bytes.

---

# Ejercicio 20. Reparto de un premio

Solicita:

- Importe del premio.
- Número de participantes.

Calcula cuánto dinero recibe cada uno.

---

# ⭐ Ejercicio 21. Factura de electricidad

Solicita:

- Consumo en kWh.
- Precio por kWh.

Declara la constante:

```java
final double VAT = 0.21;
```

Calcula:

- Importe sin IVA.
- IVA.
- Importe final.

---

# ⭐ Ejercicio 22. Presupuesto de un ordenador

Solicita el precio de:

- Procesador.
- Memoria RAM.
- Disco SSD.
- Tarjeta gráfica.

Declara una constante para el IVA y calcula:

- Subtotal.
- IVA.
- Precio final.

---

# ⭐ Ejercicio 23. Pintar una habitación

Solicita:

- Largo.
- Ancho.

Declara la constante:

```java
final double PRICE_PER_SQUARE_METER = 12.50;
```

Calcula:

- Superficie.
- Coste del pintado.

---

# ⭐ Ejercicio 24. Viaje en coche

Solicita:

- Distancia del viaje.
- Consumo del vehículo (L/100 km).
- Precio del combustible.

Declara la constante:

```java
final int FACTOR = 100;
```

Calcula el coste aproximado del viaje.

---

# ⭐ Ejercicio 25. Compra en un supermercado

Solicita el precio de cinco productos.

Declara la constante:

```java
final double VAT = 0.21;
```

Calcula:

- Subtotal.
- IVA.
- Total de la compra.

---

# ⭐ Desafío final

Realiza un programa que solicite:

- Nombre del cliente.
- Precio de un producto.
- Cantidad comprada.

Declara las siguientes constantes:

```java
final double VAT = 0.21;
final double DISCOUNT = 0.10;
```

Calcula:

- Precio sin IVA.
- Descuento aplicado.
- Precio tras aplicar el descuento.
- IVA.
- Precio final.

Muestra un informe con un formato similar al siguiente:

```text
==============================
PURCHASE SUMMARY
==============================
Customer............. Alice
Quantity............. 3
Unit price........... 25.00 €
Subtotal............. 75.00 €
Discount............. 7.50 €
VAT.................. 14.18 €
Total................ 81.68 €
==============================
```

---

# Objetivos de aprendizaje

Al finalizar esta colección de ejercicios el alumnado será capaz de:

- Leer datos desde el teclado utilizando `IO.readln()`.
- Mostrar resultados mediante `IO.println()`.
- Declarar y utilizar constantes con la palabra reservada `final`.
- Realizar operaciones aritméticas con variables y constantes.
- Aplicar fórmulas matemáticas sencillas.
- Diferenciar cuándo un dato debe almacenarse en una **variable** y cuándo en una **constante**.