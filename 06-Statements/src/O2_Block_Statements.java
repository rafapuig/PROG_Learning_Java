/**
 * Bloque de instrucciones (Block statement)
 *
 * Es una secuencia
 * de cero o más instrucciones (statements)
 * encerrados (encapsulados) entre { } (braces)
 *
 * {
 *     instrucción1
 *     instrucción2
 *     ...
 *     instrucciónN
 * }
 *
 * Se usa para agrupar varias instrucciones
 * para poder usarlas en situaciones que nada más admiten el uso de una única instrucción.
 *
 * Un bloque se considera una instrucción compuesta
 * a le que se trata como si fuera una sola instrucción.
 *
 * NOTA: El bloque de instrucciones NO necesita un separador ; para completar la sintaxis.
 */

void ejemplo1() { // <-- de hecho, esta llave delimita el inicio de un bloque de instrucciones

    // Ejemplo
    { // <-- Comienzo del bloque de instrucciones
        int number = 25; // <-- instrucción 1, declaración
        number++; // <-- instrucción 2, una instrucción de expresión (incremento)
    } // Fin del bloque

    {
        // Otro bloque, esta vez vacío, no contiene ninguna instrucción
    }
} // <-- fin del bloque de instrucciones de la función

/**
 * Todas las variables declaradas dentro de un bloque
 * solamente se pueden usar / acceder (leer, modificar) dentro del bloque
 * Ese es su scope (alcance, ámbito)
 *
 * Se puede anidar un bloque dentro de otro.
 * Todas las variables declaradas en los bloques externos
 * están disponibles para los bloques internos
 * Pero no al revés.
 */

void ejemplo2() { // <-- bloque externo
    int number1;
    { // Inicio de un bloque interno
        int number2;
        number2 = 10; // Se puede acceder dentro del bloque donde se declara
        // También se puede acceder a number1
        // el bloque interno es una instrucción del bloque externo
        number1 = 4;
    } // Fin del bloque interno
    // number2 = 6; // Error, no se puede acceder a la variable number2, estamos fuera de su scope
}

/**
 * No es posible definir en un bloque interior una variable con el mismo nombre
 * ya declarada en un bloque exterior.
 * (Porque esta variable se puede usar en el bloque interior,
 * y si se declarara una con el mismo nombre en el bloque interior
 * no habría forma de distinguirla)
 */

void ejemplo3() {
    int number;
    {
        //int number; // Error, La variable tiene el mismo nombre que otra variable declarada en un bloque externo
        //float number; //Error, No importa que no tengan el mismo tipo de datos
    }
}

void main() {
}

