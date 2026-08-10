# Tabla de precedencia de operadores en Java

La siguiente tabla muestra la **precedencia de los operadores de Java**, ordenados **de mayor a menor prioridad**.

| Precedencia | Operadores | Asociatividad |
|:-----------:|------------|:-------------:|
| **1** | `[]` `()` `.` `::` | Izquierda → Derecha |
| **2** | `expr++` `expr--` | Izquierda → Derecha |
| **3** | `++expr` `--expr` `+` `-` `!` `~` `(tipo)` | Derecha → Izquierda |
| **4** | `*` `/` `%` | Izquierda → Derecha |
| **5** | `+` `-` | Izquierda → Derecha |
| **6** | `<<` `>>` `>>>` | Izquierda → Derecha |
| **7** | `<` `<=` `>` `>=` `instanceof` | Izquierda → Derecha |
| **8** | `==` `!=` | Izquierda → Derecha |
| **9** | `&` | Izquierda → Derecha |
| **10** | `^` | Izquierda → Derecha |
| **11** | `\|` | Izquierda → Derecha |
| **12** | `&&` | Izquierda → Derecha |
| **13** | `\|\|` | Izquierda → Derecha |
| **14** | `?:` | Derecha → Izquierda |
| **15** | `=` `+=` `-=` `*=` `/=` `%=` `&=` `^=` `\|=` `<<=` `>>=` `>>>=` | Derecha → Izquierda |

---

# Truco para recordarla

Puedes memorizar la precedencia agrupando los operadores por categorías:

1. **Acceso**
    - `[]` `()` `.` `::`

2. **Incremento y decremento**
    - `x++` `x--`
    - `++x` `--x`

3. **Unarios**
    - `+`
    - `-`
    - `!`
    - `~`
    - `(tipo)` *(casting)*

4. **Multiplicativos**
    - `*`
    - `/`
    - `%`

5. **Aditivos**
    - `+`
    - `-`

6. **Desplazamientos**
    - `<<`
    - `>>`
    - `>>>`

7. **Relacionales**
    - `<`
    - `<=`
    - `>`
    - `>=`
    - `instanceof`

8. **Igualdad**
    - `==`
    - `!=`

9. **Bit a bit**
    - `&`
    - `^`
    - `|`

10. **Lógicos**
    - `&&`
    - `||`

11. **Condicional**
    - `?:`

12. **Asignación**
    - `=`
    - `+=`
    - `-=`
    - `*=`
    - `/=`
    - `%=`
    - `&=`
    - `^=`
    - `|=`
    - `<<=`
    - `>>=`
    - `>>>=`

---

# Regla mnemotécnica

Una frase fácil de recordar es:

> **Accedo, Incremento, Uno, Multiplico, Sumo, Desplazo, Comparo, Igualo, Opero Bits, Evalúo Lógica, Decido y Asigno.**

Es decir:

```text
Acceso
↓
Incremento
↓
Unarios
↓
Multiplicación
↓
Suma
↓
Desplazamiento
↓
Relacionales
↓
Igualdad
↓
Bits
↓
Lógicos
↓
Ternario
↓
Asignación
```

---

# Los dos errores más comunes

### 1. El desplazamiento tiene menor prioridad que la suma

```java
2 << 1 + 2
```

se interpreta como

```java
2 << (1 + 2)
```

y **no** como

```java
(2 << 1) + 2
```

---

### 2. `&&` tiene mayor prioridad que `||`

```java
true || false && false
```

equivale a

```java
true || (false && false)
```

---

# Consejo para los exámenes

No intentes memorizar los 15 niveles individualmente. Basta con recordar este orden:

```text
Acceso
→ Unarios
→ Multiplicación
→ Suma
→ Desplazamientos
→ Comparaciones
→ Igualdad
→ Bits
→ Lógica
→ Ternario
→ Asignación
```

Con esta secuencia podrás resolver prácticamente cualquier expresión sin necesidad de aprender la tabla completa de memoria.