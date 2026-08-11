/**
 * La instrucción switch
 * <p>
 * Es como un conmutador entre varias opciones.
 * <p>
 * Sintaxis:
 * <p>
 * switch (expresión) {
 * case etiqueta1:
 * instrucciones
 * case etiqueta2:
 * instrucciones
 * ...
 * default:
 * instrucciones
 * }
 * <p>
 * La expresión
 * - debe ser de tipo integral (byte, short, int, char, long), enumerado (ya se verá), o String
 *
 * <p>
 * Las etiquetas
 * - deben ser constantes de tiempo de compilación (recordar de temas anteriores).
 * - y tener un valor dentro del rango del tipo de la expresión.
 * <p>
 * En tiempo de ejecución.
 * - se evalúa la expresión obteniendo un valor.
 * - se empieza por el case de la primera etiqueta1 y se compara para ver si coincide con el valor obtenido.
 * - Así hasta que se encuentra un case cuya etiqueta n coincida con el valor de la expresión.
 * - A partir de ahí se ejecutan TODAS las instrucciones de ese case y de todos los que quedan hacia abajo.
 * - Si ninguna etiqueta de un case coincide con el valor obtenido al evaluar la expresión se ejecutan las instrucciones
 * a partir de la instrucción que viene a continuación de la etiqueta opcional denominada default.
 * <p>
 * La etiqueta default no tiene por qué ser la última
 * <p>
 * Podemos usar la instrucción de control break dentro del bloque de instrucciones del switch
 * <p>
 * Break transfiere el control de flujo a la instrucción siguiente fuera de la propia instrucción switch.
 *
 */

void ejemplo1() {
    char letter = 'b'; // Probar con a, c, o con otra

    switch (letter) {
        case 'a':
            IO.println("Letra A");
        case 'b':
            IO.println("Letra B (o A)");
        case 'c':
            IO.println("Letra C (o B, o A)");
        default:
            IO.println("Una letra");
    }
}

void ejemplo2() {
    char letter = 'a';

    // Constantes en tiempo de compilación (si quitamos la keyword final aparecen errores de compilación)
    final char lowerCaseA = 'a'; // Valor final a partir de un literal, es constante de compilación
    final char lowerCaseB = lowerCaseA + 1; // Por ser una expresión que usa valores finales lo calcula el compilador

    switch (letter) {
        case lowerCaseA:
            IO.println("Letra A");
        case lowerCaseB:
            IO.println("Letra B (o A)");
        case lowerCaseA + 2: // Es un valor conocido en tiempo de compilación
            IO.println("Letra C (o B, o A)");
        default:
            IO.println("Una letra");
    }
}

void ejemplo3() {
    char letter = 'b'; // Probar con a, c, o con otra

    switch (letter) {
        case 'a':
            IO.println("Letra A");
            break;
        case 'b':
            IO.println("Letra B");
            break;
        case 'c':
            IO.println("Letra C");
            break;
        default:
            IO.println("Una letra");
    }
    IO.println("LLego antes aquí si ha habido un break");
}


void ejemplo4() {
    char letter = 'b'; // Probar con a, c, o con otra

    switch (letter) {
        case 'a':
            IO.println("Letra A");
            break;
        case 'b':
            IO.println("Letra B");
            break;
        case 'c':
            IO.println("Letra C");
            break;
        default:
            IO.println("Una letra");
            break; // Es conveniente usarla incluso en la última etiqueta, por si posteriormente se añadieran más
    }
    IO.println("LLego antes aquí si ha habido un break");
}

void ejemplo5() {
    String forecast = "Soleado";

    switch (forecast) {
        case "Soleado":
            IO.println("Sal de casa y aprovecha");
            break;
        case "Lluvia":
            IO.println("No te olvides el paraguas");
            break;
        case "Nublado":
            IO.println("No te hace falta ponerte protector solar");
            break;
        default:
            IO.println("No te puedo aconsejar");
            break;
    }
}

/**
 * La instrucción switch es una manera más clara de escribir un if-else
 * cuando la condición del if-else compara el valor de la misma variable para ver si es igual
 */
void ejemplo6() {
    char letter = 'b';

    if (letter == 'a') {
        IO.println("Letra A");
    } else if (letter == 'b') {
        IO.println("Letra B");
    } else if (letter == 'c') {
        IO.println("Letra C");
    } else {
        IO.println("Una letra");
    }
}

/**
 * El problema de los ejemplos 4, 5 y 6 es que se repiten.
 * Todos quieren escribir un texto por la consola. Por eso, aparece tantas veces IO.println
 *
 * Aquí tenemos que invocar un principio de buenas prácticas de la programación
 * que determina la calidad de un código.
 *
 * Se denomina DRY (Don't Repeat Yourself) No te repitar a ti mismo
 */


void main() {
    ejemplo1();
    ejemplo2();
    ejemplo3();
    ejemplo4();
    ejemplo5();
}
