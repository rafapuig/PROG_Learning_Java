# Ejercicios de programación: Variables y operadores en Java

> **Objetivo:** Practicar la declaración de variables, la asignación de valores y el uso de operadores aritméticos. En estos ejercicios **no se deben utilizar estructuras de control** (`if`, `switch`, `for`, `while`) ni métodos propios.

---

# Ejercicio 1. Datos personales

Crea un programa que almacene en variables:

- Nombre
- Edad
- Altura
- Peso

Muestra la siguiente información:

```text
Name: Alice
Age: 20
Height: 1.68 m
Weight: 60.5 kg
```

---

# Ejercicio 2. Suma de dos números

Declara dos variables enteras.

Calcula su suma y muestra el resultado.

### Ejemplo

```text
Number 1: 15
Number 2: 8

Sum = 23
```

---

# Ejercicio 3. Operaciones básicas

Dados dos números enteros, calcula:

- Suma
- Resta
- Multiplicación
- División
- Resto de la división

---

# Ejercicio 4. Área de un rectángulo

Declara las variables:

- Base
- Altura

Calcula el área mediante la fórmula:

```text
Área = base × altura
```

---

# Ejercicio 5. Perímetro de un rectángulo

Calcula el perímetro utilizando la fórmula:

```text
Perímetro = 2 × (base + altura)
```

---

# Ejercicio 6. Área de un círculo

Utiliza el valor:

```java
final double PI = 3.1416;
```

Calcula el área de un círculo.

```text
Área = π × radio²
```

---

# Ejercicio 7. Longitud de una circunferencia

Calcula la longitud mediante la fórmula:

```text
Longitud = 2 × π × radio
```

---

# Ejercicio 8. Conversión de grados Celsius a Fahrenheit

Utiliza la fórmula:

```text
F = C × 9 / 5 + 32
```

---

# Ejercicio 9. Conversión de kilómetros a millas

Utiliza la equivalencia:

```text
1 km = 0.621371 millas
```

---

# Ejercicio 10. Conversión de euros a dólares

Supón el siguiente cambio:

```text
1 € = 1.17 $
```

Calcula el importe equivalente.

---

# Ejercicio 11. Edad en días

Suponiendo que un año tiene 365 días, calcula aproximadamente cuántos días ha vivido una persona.

---

# Ejercicio 12. Salario mensual

Conociendo:

- Salario por hora
- Horas trabajadas

Calcula el salario mensual.

---

# Ejercicio 13. Nota media

Declara tres variables con las notas de un alumno y calcula la nota media.

---

# Ejercicio 14. Precio con IVA

Calcula el precio final de un producto aplicando un IVA del **21 %**.

---

# Ejercicio 15. Descuento

Aplica un descuento del **15 %** sobre el precio de un producto.

---

# Ejercicio 16. Interés simple

Calcula el interés simple utilizando la fórmula:

```text
Interés = capital × interés × tiempo
```

---

# Ejercicio 17. Velocidad media

Dados:

- Distancia recorrida
- Tiempo empleado

Calcula la velocidad media.

```text
Velocidad = distancia / tiempo
```

---

# Ejercicio 18. Consumo de combustible

Dados:

- Kilómetros recorridos
- Litros consumidos

Calcula el consumo medio.

```text
Consumo = (litros / kilómetros) × 100
```

---

# Ejercicio 19. Conversión de tiempo a segundos

Convierte:

- Horas
- Minutos
- Segundos

en segundos totales.

---

# Ejercicio 20. Conversión de segundos

Dado un número de segundos, calcula:

- Horas
- Minutos
- Segundos restantes

> **Pista:** Utiliza la división entera (`/`) y el operador resto (`%`).

---

# Ejercicio 21. Intercambiar dos variables

Dados los valores:

```text
a = 10
b = 20
```

Intercambia su contenido utilizando una tercera variable.

Resultado esperado:

```text
a = 20
b = 10
```

---

# Ejercicio 22. Índice de Masa Corporal (IMC)

Calcula el IMC mediante la fórmula:

```text
IMC = peso / altura²
```

---

# Ejercicio 23. Precio por persona

Una comida cuesta **156 €** y deben pagarla **6 personas**.

Calcula cuánto debe pagar cada una.

---

# Ejercicio 24. Hipotenusa de un triángulo

Dados los catetos:

```text
a
b
```

Calcula la hipotenusa.

```text
c = √(a² + b²)
```

Utiliza el método:

```java
Math.sqrt()
```

---

# Ejercicio 25. Volumen de un cubo

Calcula el volumen de un cubo.

```text
Volumen = lado³
```

---

# Ejercicio 26. Volumen de un cilindro

Calcula el volumen utilizando la fórmula:

```text
Volumen = π × radio² × altura
```

---

# Ejercicio 27. Conversión de unidades de almacenamiento

Dado un número de bytes, calcula:

- Kilobytes (KB)
- Megabytes (MB)
- Gigabytes (GB)

Utiliza:

```text
1 KB = 1024 bytes
1 MB = 1024 KB
1 GB = 1024 MB
```

---

# Ejercicio 28. Edad futura

Calcula la edad que tendrá una persona dentro de **10 años**.

---

# Ejercicio 29. Factura de una compra

Tres productos tienen precios diferentes.

Calcula:

- Subtotal
- IVA (21 %)
- Precio final

---

# Ejercicio 30. Factura de electricidad

Conociendo:

- Consumo en kWh
- Precio por kWh

Calcula el coste total de la factura.

---

# ⭐ Ejercicio final

Realiza un programa que almacene la siguiente información:

- Nombre
- Edad
- Altura
- Peso
- Salario mensual

Calcula además:

- Edad dentro de 5 años.
- Altura en centímetros.
- Peso en gramos.
- Salario anual.

Muestra un informe con un formato similar al siguiente:

```text
-----------------------------
PERSONAL REPORT
-----------------------------
Name............. Alice
Age.............. 20 years
Age in 5 years... 25 years
Height........... 1.68 m
Height (cm)...... 168 cm
Weight........... 60 kg
Weight (g)....... 60000 g
Monthly salary... 1800 €
Annual salary.... 21600 €
-----------------------------
```

---

# Resumen de dificultad

| Nivel | Ejercicios | Objetivo |
|--------|------------|----------|
| 🟢 Básico | 1 – 10 | Declaración de variables y operaciones sencillas. |
| 🟡 Intermedio | 11 – 20 | Aplicación de fórmulas y conversiones de unidades. |
| 🟠 Avanzado | 21 – 30 | Combinación de operaciones y uso de la clase `Math`. |
| 🔵 Integrador | Ejercicio final | Desarrollo de un programa completo utilizando variables y operadores. |