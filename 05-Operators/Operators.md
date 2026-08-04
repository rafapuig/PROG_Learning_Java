# Operadores de Java

## Operadores aritméticos

| Operador | Nombre | Uso | Ejemplo |
|----------|--------|-----|---------|
| `+` | Suma | Suma dos valores. | `a + b` |
| `-` | Resta | Resta dos valores. | `a - b` |
| `*` | Multiplicación | Multiplica dos valores. | `a * b` |
| `/` | División | Divide dos valores. | `a / b` |
| `%` | Módulo | Devuelve el resto de una división. | `a % b` |
| `++` | Incremento | Incrementa una unidad el valor de una variable. | `a++` o `++a` |
| `--` | Decremento | Decrementa una unidad el valor de una variable. | `a--` o `--a` |

## Operadores de asignación

| Operador | Nombre | Uso | Ejemplo |
|----------|--------|-----|---------|
| `=` | Asignación | Asigna un valor a una variable. | `a = 5` |
| `+=` | Suma y asigna | Suma y guarda el resultado. | `a += 3` |
| `-=` | Resta y asigna | Resta y guarda el resultado. | `a -= 3` |
| `*=` | Multiplica y asigna | Multiplica y guarda el resultado. | `a *= 3` |
| `/=` | Divide y asigna | Divide y guarda el resultado. | `a /= 3` |
| `%=` | Módulo y asigna | Calcula el resto y lo asigna. | `a %= 3` |
| `&=` | AND bit a bit y asigna | Aplica AND bit a bit y asigna. | `a &= b` |
| `|=` | OR bit a bit y asigna | Aplica OR bit a bit y asigna. | `a |= b` |
| `^=` | XOR bit a bit y asigna | Aplica XOR bit a bit y asigna. | `a ^= b` |
| `<<=` | Desplazamiento izquierdo y asigna | Desplaza bits a la izquierda y asigna. | `a <<= 2` |
| `>>=` | Desplazamiento derecho y asigna | Desplaza bits a la derecha y asigna. | `a >>= 2` |
| `>>>=` | Desplazamiento derecho sin signo y asigna | Desplaza bits a la derecha sin conservar el signo. | `a >>>= 2` |

## Operadores relacionales

| Operador | Nombre | Uso | Ejemplo |
|----------|--------|-----|---------|
| `==` | Igual que | Comprueba si dos valores son iguales. | `a == b` |
| `!=` | Distinto de | Comprueba si dos valores son diferentes. | `a != b` |
| `>` | Mayor que | Comprueba si un valor es mayor que otro. | `a > b` |
| `<` | Menor que | Comprueba si un valor es menor que otro. | `a < b` |
| `>=` | Mayor o igual que | Comprueba si un valor es mayor o igual que otro. | `a >= b` |
| `<=` | Menor o igual que | Comprueba si un valor es menor o igual que otro. | `a <= b` |


## Operadores lógicos con cortocircuito

| Operador | Nombre | Uso | Ejemplo |
|----------|--------|-----|---------|
| `&&` | AND lógico (con cortocircuito) | Devuelve `true` si ambas expresiones son verdaderas. Si la primera es `false`, no evalúa la segunda. | `a && b` |
| `\|\|` | OR lógico (con cortocircuito) | Devuelve `true` si al menos una expresión es verdadera. Si la primera es `true`, no evalúa la segunda. | `a \|\| b` |
| `!` | NOT lógico | Invierte el valor lógico de una expresión. | `!a` |

## Operadores lógicos sin cortocircuito

| Operador | Nombre | Uso | Ejemplo |
|----------|--------|-----|---------|
| `&` | AND lógico (sin cortocircuito) | Devuelve `true` si ambas expresiones son verdaderas. Siempre evalúa ambos operandos. | `a & b` |
| `\|` | OR lógico (sin cortocircuito) | Devuelve `true` si al menos una expresión es verdadera. Siempre evalúa ambos operandos. | `a \| b` |
| `^` | XOR lógico | Devuelve `true` si exactamente una de las expresiones es verdadera. Siempre evalúa ambos operandos. | `a ^ b` |

## Operadores bit a bit

| Operador | Nombre | Uso | Ejemplo |
|----------|--------|-----|---------|
| `&` | AND bit a bit | Realiza una operación AND entre los bits de dos valores enteros. | `a & b` |
| `\|` | OR bit a bit | Realiza una operación OR entre los bits de dos valores enteros. | `a \| b` |
| `^` | XOR bit a bit | Realiza una operación XOR entre los bits de dos valores enteros. | `a ^ b` |
| `~` | Complemento bit a bit | Invierte todos los bits de un valor entero. | `~a` |

### Diferencia entre operadores lógicos y bit a bit

Los operadores `&`, `|` y `^` tienen **dos usos** en Java:

- Si los operandos son de tipo `boolean`, actúan como **operadores lógicos sin cortocircuito**.
- Si los operandos son de tipo entero (`byte`, `short`, `int`, `long`), actúan como **operadores bit a bit**, operando sobre la representación binaria de los valores.

### Ejemplo

```java
// Operadores lógicos
boolean a = true;
boolean b = false;

System.out.println(a && b); // false
System.out.println(a & b);  // false (evalúa ambos operandos)
System.out.println(a ^ b);  // true

// Operadores bit a bit
int x = 6;   // 0110
int y = 3;   // 0011

System.out.println(x & y);  // 2  -> 0010
System.out.println(x | y);  // 7  -> 0111
System.out.println(x ^ y);  // 5  -> 0101
System.out.println(~x);     // -7
```

## Operadores de desplazamiento

| Operador | Nombre | Uso | Ejemplo |
|----------|--------|-----|---------|
| `<<` | Desplazamiento izquierdo | Desplaza los bits hacia la izquierda. | `a << 2` |
| `>>` | Desplazamiento derecho | Desplaza los bits hacia la derecha conservando el signo. | `a >> 2` |
| `>>>` | Desplazamiento derecho sin signo | Desplaza los bits hacia la derecha rellenando con ceros. | `a >>> 2` |

## Operadores especiales

| Operador | Nombre | Uso | Ejemplo |
|----------|--------|-----|---------|
| `?:` | Operador ternario | Evalúa una condición y devuelve uno de dos valores. | `edad >= 18 ? "Mayor" : "Menor"` |
| `instanceof` | Comprobación de tipo | Comprueba si un objeto pertenece a una clase o interfaz. | `obj instanceof String` |
| `new` | Creación de objetos | Crea una nueva instancia de una clase. | `new Persona()` |

## Ejemplo

```java
int a = 10;
int b = 5;

int suma = a + b;
boolean mayor = a > b;
boolean valido = (a > 0) && (b > 0);

System.out.println(suma);
System.out.println(mayor);
System.out.println(valido);
```