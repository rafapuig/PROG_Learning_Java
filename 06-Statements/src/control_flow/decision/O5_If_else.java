/**
 * La instrucción de decision if-else
 * ------------------------------------------------------------------------------------------------------
 * El formato es:
 * if (condición) instrucción1 else instrucción2
 *
 * if y else son dos keyword del lenguaje Java para formar la estructura gramatical de la instrucción.
 * NO termina en un ;
 *
 * La condición
 * - es una expresión booleana (de tipo boolean)
 * - se escribe obligatoriamente dentro de unos paréntesis ( )
 * - se evalúa cuando el flujo de ejecución alcanza la instrucción if-else
 * - si el resultado es:
 * - true se ejecuta la instrucción1
 * - false se ejecuta la instrucción2
 *
 * Una vez ejecutada la instrucción1 o la instrucción2 según el resultado de la condición
 * el flujo de ejecución pasa a la siguiente instrucción (la situada a continuación del if-else)
 *
 * La parte else instrucción2, es opcional (no es obligatoria).
 * Si no hay parte else y la condición da como resultado false, entonces simplemente no se ejecuta instrucción1
 * y se continúa con la siguiente instrucción que sigue en la secuencia.
 * Se suele llamar entonces no un if-else sino un if.
 *
 * Normalmente, se suele escribir las instrucciones en una nueva línea (después de la condición y en su caso del else)
 * e identadas (con espacios adicionales) para indicar visualmente que su ejecución dependerá de la condición
 *
 * if (condicion)
 *     instrucción1
 * else
 *     instruccion2
 *
 * Instruccion1 e instrucción2 pueden ser un bloque de instrucciones.
 * (recordar que un bloque de instrucciones funciona como una única instrucción compuesta)
 *
 * En este caso, las llaves se usan asi:
 *
 * if (condicion) {
 *     instrucciones del bloque if
 * } else {
 *     instrucciones del bloque else
 * }
 *
 * En Java se suelen usar SIEMPRE las llaves, aunque las instrucciónes condicionadas no sean un bloque.
 *
 * Podemos combinar if-else de manera escalonada y de forma anidada.
 */

/**
 * Un if sin parte else
 */
void ejemplo1() {
    int edad = 15;

    // Versión con solamente la parte if
    if (edad >= 18)
        IO.println("Es mayor de edad"); // El ; pertenece a la instrucción de expresión no a la instrucción if
}

/**
 * If-else sin uso de {} para instrucciones no compuestas.
 */
void ejemplo2() {
    int edad = 15;
    if (edad >= 18)
        IO.println("Es menor de edad"); // El ; pertenece a la instrucción de expresión no a la instrucción if-else
    else
        IO.println("Es menor de edad"); // El ; pertenece a la instrucción de expresión

}

/**
 * If-else con {}
 */
void ejemplo3() {
    int edad = 15;
    if (edad >= 18) {
        IO.println("Es mayor de edad");
    } else {
        IO.println("Es menor de edad");
    } // Noy hay ; porque un bloque no lo necesita (y porque if-else tampoco)
}


void ejemplo4() {
    int number = 10;

    if (number >= 0) {
        IO.println("Es positivo");
    } else {
        IO.println("Es negativo");
    }
}

/**
 * If-else anidado en la parte else (también se puede anidar en el if)
 */
void ejemplo5() {
    int number = 20;
    if (number > 0) {
        IO.println("Es positivo");
    } else {
        // La instrucción de la parte else es a su vez una instrucción if-else
        // Esto se denomina if-else anidado
        if (number < 0) {
            IO.println("Es negativo");
        } else {
            IO.println("Es cero");
        }
    }
}


void ejemplo6() {
    int number = 20;

    // Error, no compila porque la expresión no es una condición, no es de tipo boolean
    /*if (number = 0) {
        IO.println("Es cero");
    }*/
}


void ejemplo7() {
    int number = 20;

    // Si se usa el operador de igualdad == en lugar del de asignación,
    // la expresión si es una condición, y es de tipo boolean
    if (number == 0) {
        IO.println("Es negativo");
    }
}


void ejemplo8() {

    int number = 20;

    boolean isZero = number == 0;

    // Una variable de tipo boolean es una expresión boolean y, por tanto, una condición
    if (isZero) {
        IO.println("Es cero");
    }

    // Es totalmente innecesario hacer algo como esto
    if (isZero == true) {
        IO.println("Es negativo");
    }

}

void main() {
}