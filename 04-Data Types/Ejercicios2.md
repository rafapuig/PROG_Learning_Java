# Ejercicios de programación: Variables y operadores
## Temática: Desarrollo de videojuegos

> **Objetivo:** Practicar la declaración de variables y el uso de operadores aritméticos mediante situaciones inspiradas en el desarrollo de videojuegos.
>
> **Importante:** En estos ejercicios **no se deben utilizar estructuras de control** (`if`, `switch`, `for`, `while`). Solo variables, constantes y operaciones.

---

# Ejercicio 1. Crear un personaje

Declara variables para almacenar la información de un personaje:

- Nombre
- Nivel
- Vida
- Mana
- Oro

Muestra toda la información por pantalla.

---

# Ejercicio 2. Daño recibido

Un personaje tiene:

- Vida inicial
- Daño recibido

Calcula la vida restante.

---

# Ejercicio 3. Curación

Un personaje tiene:

- Vida actual
- Puntos de curación

Calcula la vida después de utilizar una poción.

---

# Ejercicio 4. Daño total

Un arma produce un daño base.

El personaje tiene además un bonus de ataque.

Calcula el daño total.

---

# Ejercicio 5. Experiencia necesaria

Un jugador necesita:

- Experiencia actual
- Experiencia para subir de nivel

Calcula cuánta experiencia le falta.

---

# Ejercicio 6. Oro total

El jugador posee:

- Oro inicial
- Oro encontrado en un cofre
- Recompensa de una misión

Calcula el oro total.

---

# Ejercicio 7. Compra de objetos

Una espada cuesta **150** monedas.

Un escudo cuesta **80** monedas.

Una poción cuesta **25** monedas.

Calcula cuánto dinero necesita un jugador para comprar los tres objetos.

---

# Ejercicio 8. Inventario

Un jugador tiene:

- Pociones de vida
- Pociones de maná
- Flechas

Calcula el número total de objetos del inventario.

---

# Ejercicio 9. Velocidad del personaje

Calcula la velocidad final sabiendo:

- Velocidad base
- Bonus de las botas
- Bonus de una habilidad

---

# Ejercicio 10. Puntos de habilidad

Cada nivel concede **5 puntos**.

Calcula los puntos obtenidos al alcanzar un nivel determinado.

---

# Ejercicio 11. Daño crítico

Un arma produce:

- Daño base
- Multiplicador crítico

Calcula el daño crítico.

---

# Ejercicio 12. Vida máxima

La vida máxima de un personaje depende de:

```text
Vida base + bonus del equipo + bonus del nivel
```

Calcula la vida máxima.

---

# Ejercicio 13. Mana máximo

Realiza el mismo cálculo que en el ejercicio anterior para el maná.

---

# Ejercicio 14. Tiempo de recarga

Una habilidad tiene un tiempo de recarga de **18 segundos**.

El personaje posee un objeto que reduce el tiempo un **20 %**.

Calcula el nuevo tiempo de recarga.

---

# Ejercicio 15. Daño por segundo (DPS)

Calcula:

```text
DPS = daño / tiempo
```

---

# Ejercicio 16. Puntuación final

Calcula la puntuación total a partir de:

- Enemigos derrotados
- Monedas recogidas
- Bonus por completar la misión

---

# Ejercicio 17. Munición restante

Un jugador dispone de:

- Munición inicial
- Disparos realizados

Calcula la munición restante.

---

# Ejercicio 18. Tiempo de partida

Convierte:

- Horas
- Minutos
- Segundos

a segundos totales.

---

# Ejercicio 19. FPS medios

Un juego ha generado:

- 5400 imágenes

en

- 90 segundos

Calcula los FPS medios.

```text
FPS = imágenes / segundos
```

---

# Ejercicio 20. Posición del jugador

El jugador se encuentra en la posición:

```text
X = 150
Y = 320
```

Se mueve:

```text
+40 en X
-15 en Y
```

Calcula su nueva posición.

---

# Ejercicio 21. Coste de mejora

Para mejorar un arma se necesitan:

- Oro
- Gemas

Calcula el coste total sabiendo el valor de cada gema.

---

# Ejercicio 22. Durabilidad del arma

Un arma posee una durabilidad inicial.

Después de varios combates pierde una determinada cantidad de puntos.

Calcula la durabilidad restante.

---

# Ejercicio 23. Energía restante

Un personaje consume energía al utilizar habilidades.

Calcula la energía disponible tras lanzar tres habilidades.

---

# Ejercicio 24. Precio de una tienda

Calcula el coste total de comprar:

- Espada
- Escudo
- Armadura
- Casco
- Botas

---

# Ejercicio 25. Conversión de monedas

En un juego existen:

- 100 monedas de cobre = 1 moneda de plata
- 100 monedas de plata = 1 moneda de oro

Convierte una cantidad de monedas de cobre a plata y oro.

---

# Ejercicio 26. Distancia recorrida

Un personaje avanza:

- 4 metros por segundo

Calcula la distancia recorrida tras un tiempo determinado.

---

# Ejercicio 27. Experiencia total

Un jugador obtiene experiencia por:

- Derrotar enemigos
- Completar misiones
- Descubrir zonas

Calcula la experiencia total.

---

# Ejercicio 28. Daño elemental

Un hechizo produce:

- Daño base
- Bonus de fuego
- Bonus de hielo

Calcula el daño total.

---

# Ejercicio 29. Espacio ocupado en el inventario

Cada objeto ocupa un número de casillas.

Calcula el espacio utilizado.

---

# Ejercicio 30. Recompensa de la misión

Una misión concede:

- Oro
- Experiencia
- Gemas

Calcula la recompensa total sabiendo el valor económico de cada gema.

---

# ⭐ Ejercicio final

Desarrolla un programa que almacene la información de un personaje de un videojuego.

Declara variables para:

- Nombre
- Clase
- Nivel
- Vida
- Maná
- Ataque
- Defensa
- Oro
- Experiencia

Calcula:

- Vida restante tras recibir daño.
- Ataque total con un arma equipada.
- Oro después de comprar un objeto.
- Experiencia necesaria para subir de nivel.
- Daño crítico del personaje.

Muestra un informe con un formato similar al siguiente:

```text
=============================
CHARACTER SHEET
=============================
Name............... Arthas
Class.............. Warrior
Level.............. 12
Health............. 320 / 400
Mana............... 80 / 120
Attack............. 54
Defense............ 38
Gold............... 275
Experience......... 1860
Critical Damage.... 81
=============================
```

---

# Resumen de dificultad

| Nivel | Ejercicios | Objetivo |
|--------|------------|----------|
| 🟢 Básico | 1–10 | Declarar variables y realizar operaciones sencillas. |
| 🟡 Intermedio | 11–20 | Aplicar fórmulas relacionadas con personajes y mecánicas de juego. |
| 🟠 Avanzado | 21–30 | Combinar varias operaciones y realizar conversiones. |
| 🔵 Integrador | Ejercicio final | Crear una ficha completa de un personaje utilizando variables y operadores. |