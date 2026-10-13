/**
 * Tipo double
 *
 * Se usa para representar números decimales de 64 bits con signo (positivos y negativos) mediante
 * el formato IEEE 754
 *
 * Si se usan 64 bits para representar el valor se dice que estamos usando precision doble (double)
 *
 * - Conjunto de valores:
 * El rango va desde tan pequeño TODO: como 4.9 x 10^324 hasta tan grande como 1.7976931348623157 x 10^308
 * tanto en positivo como en negativo.
 *
 *
 * Para que un literal se considere de tipo float debe llevar el sufijo d o D o no llevarlo
 *
 * Se definen dos valores cero: +0.0 y el -0.0 en el conjunto de valores,
 * aunque cuando se comparan se consideran iguales.
 *
 * Se definen dos infinitos: infinito positivo e infinito negativo
 * Por ejemplo, el resultado de dividir 2.5 entre 0.0 es infinito positivo
 * y dividir 2.5 entre -0.0 es infinito negativo.
 *
 * El resultado de algunas operaciones no está definido.
 * Por ejemplo, dividir 0.0 entre 0.0 es indeterminado.
 * El valor indeterminado está incluido en el conjunto de valores del tipo double,
 * tiene representación en binario
 * y se denomina NaN (Not a Number)
 *
 * - Representación en memoria:
 * Se necesitan 64 bits de memoria para almacenar un valor de tipo float
 * Se usa el formato estandar IEEE 754 con doble-precision:
 * Signo: 1 bit
 * Exponente: 11 bits
 * Mantisa: 52 bits
 * <p>
 * Máximo Exponente: 1023
 * Mínimo Exponente: -1022     bias = 1023 (sesgo)
 */

import static util.Utils.printBinaryRepresentation;

void main() {
    //intro();
    //suma();
    //twoZeros();
    //memoryRepresentation();
    //memoryRepresentation2();
    memoryRepresentation3();
    //conversion();
}

void suma() {
    var sum = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 - 0.1;
    IO.println(sum);
}

void intro() {
    /** Podemos asignar un literal de tipo double a una variable de tipo double */
    double number = 15d;
    double ten = 10d;
    double hex = 0xA.p0;
    double numhex = 0xdecafe.p0;

    /**
     * La clase Double define constantes que equivalen al máximo y mínimo valores del
     * tipo de datos double
     */
    double max = Double.MAX_VALUE; // 1.7976931348623157 x 10^308
    double min = Double.MIN_VALUE; // 4.9 x 10^324

    /**
     * También define constantes para los valores de infinito, positivo y negativo
     */
    double negativeInfinity = Double.NEGATIVE_INFINITY; // = -1.0 / 0.0 --- 0xff_f0_00_00_00_00_00_00L
    double positiveInfinity = Double.POSITIVE_INFINITY; // =  1.0 / 0.0 --- 0x7f_f0_00_00_00_00_00_00L

    /**
     * Y también para el valor indeterminado / Not a Number
     */
    double notANumber = Double.NaN; // = 0.0 / 0.0 --- 0x7f_f8_00_00_00_00_00_00L


    /**
     * Podemos saber cuantos bits son necesarios para un valor de tipo float
     */
    IO.println(Double.SIZE); // 32

    /**
     * Y también el número de bytes
     */
    IO.println(Double.BYTES); // 4
}



void twoZeros() {
    double positiveZero = 0.0; // o +0.0
    double negativeZero = -0.0;

    boolean areEqual = positiveZero == negativeZero;
    IO.println("Son iguales? " + areEqual);
}

void memoryRepresentation() {
    printBinaryRepresentation(1.0);
    printBinaryRepresentation(0.5);
    printBinaryRepresentation(0.25);
    printBinaryRepresentation(1000.0);
    printBinaryRepresentation(-1000.0);

    printBinaryRepresentation(0.0);
    printBinaryRepresentation(-0.0);
    printBinaryRepresentation(Double.MAX_VALUE);
    printBinaryRepresentation(Double.MIN_VALUE);
    printBinaryRepresentation(Double.NEGATIVE_INFINITY);
    printBinaryRepresentation(Double.POSITIVE_INFINITY);
    printBinaryRepresentation(Double.NaN);
}

void memoryRepresentation2() {
    printBinaryRepresentation(0.1);
    printBinaryRepresentation(0.01);
    printBinaryRepresentation(0.001);

    printBinaryRepresentation(0.0001);
    printBinaryRepresentation(1.e-4);
    printBinaryRepresentation(0.1e-3);
    printBinaryRepresentation(0.01e-2);
    printBinaryRepresentation(0.001e-1);
    printBinaryRepresentation(0.00001e+1);
}

void memoryRepresentation3() {
    // Signo 0
    // Exponente 01111111111 -> 1023 menos sesgo 1023 = 0
    // Mantisa 1000_00000000_00000000_00000000_00000000_00000000_00000000 normalizada 1.1
    // Número representado 1.1 x 2 ^ 0 = 1.5
    double x = Double.longBitsToDouble(0b0_01111111111_1000_00000000_00000000_00000000_00000000_00000000_00000000L);
    IO.println(x);

    // Igual que el anterior, pero con signo 1 (negativo)
    // Número representado es el -1.5
    x = Double.longBitsToDouble(0b1_01111111111_1000_00000000_00000000_00000000_00000000_00000000_00000000L);
    IO.println(x);

    x = Double.longBitsToDouble(0b0_00000000001_0000_00000000_00000000_00000000_00000000_00000000_00000000L); // 1.0 x 2^-1022
    IO.println(x); // mínimo número normalizable para double

    x = Double.MIN_NORMAL; // 0x1.0p-126f;
    IO.println(x);

    double z = Double.longBitsToDouble(0b0_00000000000_0000_00000000_00000000_00000000_00000000_00000000_00000001L); // 1.0 x 2^-(1022+52) = 1.0 x 2^-1074
    IO.println(z); // número más pequeño distinto de cero (más cercano a cero)
    z = Double.MIN_VALUE; // 0x0.0000000000001p-1022f;
    IO.println(z);
}

