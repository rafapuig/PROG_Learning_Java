/**
 * Los operadores a nivel de bit
 *
 * Solamente se aplican con operandos de tipo entero,
 *
 */

/**
 * El operador AND a nivel de bit &
 *
 * Opera bit a bit cada uno de los bits correspondientes de los operandos
 * por cada bit de los operandos genera un bit del resultado
 *
 * Solamente si ambos bits son 1 el bit resultante en 1
 * 1 & 1 = 1
 * 1 & 0 = 0
 * 0 & 1 = 0
 * 0 & 0 = 0
 *
 */
void bitwiseAND() {
    // Valor entero 45, representado en bits 00000000 00000000 00000000 00101101
    int n = 45;
    // Valor entero 3, representado en bits  00000000 00000000 00000000 00100011
    int i = 35;
    // Resultado 33                          00000000 00000000 00000000 00100001

    int and = 45 & 35;

    IO.println(n);
    IO.println(i);
    IO.println(and);
}

/**
 * El operador OR a nivel de bit |
 *
 * Opera bit a bit cada uno de los bits correspondientes de los operandos
 * por cada bit de los operandos genera un bit del resultado
 *
 * Si en la posición correspondiente alguno de los bits de los operados es un 1 el bit resultante en esa posición es 1
 * 1 | 1 = 1
 * 1 | 0 = 1
 * 0 | 1 = 1
 * 0 | 0 = 0
 *
 */
void bitwiseOR() {
    // Valor entero 45, representado en bits 00000000 00000000 00000000 00101101
    int n = 45;
    // Valor entero 3, representado en bits  00000000 00000000 00000000 00100011
    int i = 35;
    // Resultado 47                          00000000 00000000 00000000 00101111

    int or = 45 | 35;

    IO.println(n);
    IO.println(i);
    IO.println(or);
}


/**
 * El operador XOR (OR exclusivo) a nivel de bit ^
 *
 * Opera bit a bit cada uno de los bits correspondientes de los operandos
 * por cada bit de los operandos genera un bit del resultado
 *
 * Si en la posición correspondiente solamente uno de los bits de los operados es un 1
 * el bit resultante en esa posición es 1
 * 1 ^ 1 = 0
 * 1 ^ 0 = 1
 * 0 ^ 1 = 1
 * 0 ^ 0 = 0
 */
void bitwiseXOR() {
    // Valor entero 45, representado en bits 00000000 00000000 00000000 00101101
    int n = 45;
    // Valor entero 3, representado en bits  00000000 00000000 00000000 00100011
    int i = 35;
    // Resultado 14                          00000000 00000000 00000000 00001110

    int xor = 45 ^ 35;

    IO.println(n);
    IO.println(i);
    IO.println(xor);
}

/**
 * El operador NOT a nivel de bit ~ (Unario)
 *
 * Opera bit a bit cada uno de los bits correspondientes del operando
 * por cada bit del operando genera un bit del resultado
 *
 * el bit resultante en esa posición es el bit invertido
 * ~ 1 = 0
 * ~ 0 = 1
 */
void bitwiseNOT() {
    // Valor entero 45, representado en bits 00000000 00000000 00000000 00101101
    int n = 45;
    // Resultado -46                         11111111 11111111 11111111 11010010

    int not = ~45;

    IO.println(n);
    IO.println(not);
}

/**
 * El operador desplazamiento hacia la izquierda <<
 *
 * Desplaza hacia la izquierda todos los bits del operando izquierdo
 * tantas posiciones como indica el operador de la derecha.
 *
 * Los bits que se salen por la izquierda, son ignorados
 * Los bits que entran por la derecha se añaden con valor 0
 *
 * El efecto desplazar 1 bit a la izquierda (una posición)
 * equivale a multiplicar por 2
 *
 * En general, desplazar n posiciones equivale a multiplicar por 2^n
 *
 * Solamente podemos desplazar hasta 31 posiciones
 * Si deplazamos 32 equivale a no desplazar ninguna
 *
 * Solamente se usan los 5 primeros bits del operador de la derecha para determinar el desplazamiento
 * (si el operadorde la izquierda es de tipo int)
 * 31 --> 31
 * 32 --> 0
 * 33 --> 1
 * 34 --> 2
 *
 * Si el operador de la izquierda es de tipo long (tiene 64 bits)
 * desplazamientos entre 0 y 63 posiciones
 * y se usan los 6 primeros bits del operador de la derecha
 */
void bitwiseLeftShift() {
    // Valor entero 45, representado en bits    00000000 00000000 00000000 00101101
    int n = 45;
    // Resultado de desplazar 4 posiciones 0000|00000000 00000000 00000010 1101[0000]
    // Los bits se desplazan a la izquierda <--
    IO.println(n);
    IO.println(n << 1);
    IO.println(n << 2);
    IO.println(n << 3);
    IO.println(n << 4);
    IO.println(n << 25);
    IO.println(n << 30);
    IO.println(n << 31);
    IO.println(n << 32); // Equivale a n << 0, el 0 sale de 32 % 32 = 0 -- 32 es 2^5
    IO.println(n << 33); // Equivale a n << 1, el 1 sale de 33 % 32 = 1

    long l = 45;
    IO.println(l << 25);
    IO.println(l << 30);
    IO.println(l << 31);
    IO.println(l << 32);
    IO.println(l << 63);
    IO.println(l << 64); // Equivale a n << 0, el 0 sale de 64 % 64 = 0 -- 64 es 2^6
    IO.println(l << 65); // Equivale a n << 0, el 0 sale de 65 % 64 = 0
}



/**
 * El operador desplazamiento hacia la derecha con signo >>
 *
 * Desplaza hacia la derecha todos los bits del operando izquierdo
 * tantas posiciones como indica el operador de la derecha.
 *
 * Los bits que se salen por la derecha, son ignorados
 * Los bits que entran por la derecha se añaden con valor
 * - 0 si el operando izquierdo es positivo
 * - 1 si el operando izquierdo es negativo
 *
 * Para que el signo del valor resultado se mantenga
 *
 * El efecto desplazar 1 bit a la izquierda (una posición)
 * equivale a dividir por 2
 *
 * En general, desplazar n posiciones equivale a dividir por 2^n
 *
 * Solamente podemos desplazar hasta 31 posiciones
 * Si deplazamos 32 equivale a no desplazar ninguna
 *
 * Solamente se usan los 5 primeros bits del operador de la derecha para determinar el desplazamiento
 * (si el operadorde la izquierda es de tipo int)
 * 31 --> 31
 * 32 --> 0
 * 33 --> 1
 * 34 --> 2
 *
 * Si el operador de la izquierda es de tipo long (tiene 64 bits)
 * desplazamientos entre 0 y 63 posiciones
 * y se usan los 6 primeros bits del operador de la derecha
 */
void bitwiseRightShift() {
    // Valor entero 45, representado en bits      00000000 00000000 00000000 00101101
    int n = 45;
    // Resultado de desplazar 6 posiciones      [000000]00 00000000 00000000 00000000 | 101101 <-- salen
    // Los bits se desplazan a la derecha --> entran ceros si positivo y unos si negativo
    IO.println(n);
    IO.println(n >> 1);
    IO.println(n >> 2);
    IO.println(n >> 3);
    IO.println(n >> 6);
    IO.println(n >> 7);
    IO.println(n >> 32); // Equivale a n << 0, el 0 sale de 32 % 32 = 0 -- 32 es 2^5
    IO.println(n >> 33); // Equivale a n << 1, el 1 sale de 33 % 32 = 1

    n = -45;
    IO.println(n);
    IO.println(n >> 1);
    IO.println(n >> 2);
    IO.println(n >> 3);
    IO.println(n >> 6);
    IO.println(n >> 7);
    IO.println(n >> 32); // Equivale a n << 0, el 0 sale de 32 % 32 = 0 -- 32 es 2^5
    IO.println(n >> 33); // Equivale a n << 1, el 1 sale de 33 % 32 = 1


    long l = 45;
    IO.println(l >> 25);
    IO.println(l >> 30);
    IO.println(l >> 31);
    IO.println(l >> 32);
    IO.println(l >> 63);
    IO.println(l >> 64); // Equivale a n << 0, el 0 sale de 64 % 64 = 0 -- 64 es 2^6
    IO.println(l >> 65); // Equivale a n << 0, el 0 sale de 65 % 64 = 0

    l = -45;
    IO.println(l);
    IO.println(l >> 25);
    IO.println(l >> 30);
    IO.println(l >> 31);
    IO.println(l >> 32);
    IO.println(l >> 63);
    IO.println(l >> 64); // Equivale a n << 0, el 0 sale de 64 % 64 = 0 -- 64 es 2^6
    IO.println(l >> 65); // Equivale a n << 0, el 0 sale de 65 % 64 = 0
}

/**
 * El operador desplazamiento hacia la derecha con signo >>>
 * Equivalente en comportamiento al >> salvo que siempre añade ceros por la izquierda,
 * no tiene en cuenta, por tanto, el signo del operando izquierdo
 */
void unsignedBitwiseRightShift() {
    // Valor entero 45, representado en bits      00000000 00000000 00000000 00101101
    int n = 45;
    // Resultado de desplazar 6 posiciones      [000000]00 00000000 00000000 00000000 | 101101 <-- salen
    // Los bits se desplazan a la derecha --> entran ceros si positivo y unos si negativo
    IO.println(n);
    IO.println(n >>> 1);
    IO.println(n >>> 2);
    IO.println(n >>> 3);
    IO.println(n >>> 6);
    IO.println(n >>> 7);
    IO.println(n >>> 32); // Equivale a n << 0, el 0 sale de 32 % 32 = 0 -- 32 es 2^5
    IO.println(n >>> 33); // Equivale a n << 1, el 1 sale de 33 % 32 = 1

    n = -45;
    IO.println(n);
    IO.println(n >>> 1);
    IO.println(n >>> 2);
    IO.println(n >>> 3);
    IO.println(n >>> 6);
    IO.println(n >>> 7);
    IO.println(n >>> 32); // Equivale a n << 0, el 0 sale de 32 % 32 = 0 -- 32 es 2^5
    IO.println(n >>> 33); // Equivale a n << 1, el 1 sale de 33 % 32 = 1


    long l = 45;
    IO.println(l >>> 25);
    IO.println(l >>> 30);
    IO.println(l >>> 31);
    IO.println(l >>> 32);
    IO.println(l >>> 63);
    IO.println(l >>> 64); // Equivale a n << 0, el 0 sale de 64 % 64 = 0 -- 64 es 2^6
    IO.println(l >>> 65); // Equivale a n << 0, el 0 sale de 65 % 64 = 0

    l = -45;
    IO.println(l);
    IO.println(l >>> 25);
    IO.println(l >>> 30);
    IO.println(l >>> 31);
    IO.println(l >>> 32);
    IO.println(l >>> 63);
    IO.println(l >>> 64); // Equivale a n << 0, el 0 sale de 64 % 64 = 0 -- 64 es 2^6
    IO.println(l >>> 65); // Equivale a n << 0, el 0 sale de 65 % 64 = 0
}

/**
 * Operadores a nivel de bit compuestos
 *
 * op1 op= op2 (op puede ser & | ^ << >> >>>) op1 y op2 integrales
 * op1 debe ser una variable (lvalue)
 * op2 puede ser un valor (expresión, rvalue)
 *
 * equivale a op1 = (tipo_de_op1) (op1 op op2)
 *
 * Se utilizan para guardar el resultado de la operación en el operando1
 */


void main() {
    //bitwiseAND();
    //bitwiseOR();
    //bitwiseXOR();
    //bitwiseNOT();
    //bitwiseLeftShift();
    bitwiseRightShift();
    unsignedBitwiseRightShift();

    short i = 10;
    var n = i & 3;
}