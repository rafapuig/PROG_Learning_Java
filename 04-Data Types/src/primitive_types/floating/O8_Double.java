/**
 * Tipo double
 *
 * Se usa para representar números decimales de 64 bits con signo (positivos y negativos) mediante
 * el formato IEEE 754
 *
 * Si se usan 64 bits para representar el valor se dice que estamos usando precision doble (double)
 *
 * - Conjunto de valores:
 * El rango va desde tan pequeño TODO: como 1.4 x 10^-45 hasta tan grande como 3.4 x 10^38
 * tanto en positivo como en negativo.
 *
 *
 * Para que un literal se considere de tipo float debe llevar el sufijo f o F
 *
 * Se definen dos valores cero: +0.0f y el -0.0f en el conjunto de valores,
 * aunque cuando se comparan se consideran iguales
 *
 * Se definen dos infinitos: infinto positivo e infinito negativo
 * Por ejemplo, el resultado de dividir 2.5f entre 0.0f es infinito positivo
 * y dividir 2.5f entre -0.0f es infinito negativo.
 *
 * El resultado de algunas operaciones no está definido.
 * Por ejemplo, dividir 0.0f entre 0.0f es indeterminado.
 * El valor indeterminado está incluido en el conjunto de valores del tipo float,
 * tiene representación en binario
 * y se denomina NaN (Not a Number)
 *
 * - Representación en memoria:
 * Se necesitan 64 bits de memoria para almacenar un valor de tipo float
 * Se usa el formato estandar IEEE 754 con doble-precision:
 *  Signo: 1 bit
 *  Exponente: 11 bits
 *  Mantisa: 52 bits
 *
 *  Máximo Exponente: 1023
 *  Mínimo Exponente: -1022     bias = 1023 (sesgo)
 *
 *
 */

import static util.Utils.printBinaryRepresentation;


void suma() {
    var sum = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 - 0.1;
    IO.println(sum);
}


void main() {

    suma(

    );

    /** Podemos asignar un literal de tipo float a una variable de tipo float */
    float number = 15f;
    float ten = 10f;
    float hex = 0xAf;
    float numhex = 0xdecafef;

    /**
     * La clase Float define constantes que equivalen al máximo y mínimo valores del
     * tipo de datos float
     */
    int max = Integer.MAX_VALUE; // 0x7F_FF_FF_FF
    int min = Integer.MIN_VALUE; // 0x80_00_00_00

    /**
     * También define constantes para los valores de infinito, positivo y negativo
     */
    float negativeInfinity = Float.NEGATIVE_INFINITY; // = -1.0f / 0.0f
    float positiveInfinity = Float.POSITIVE_INFINITY; // = -1.0f / 0.0f

    /**
     * Y también para el valor indeterminado / Not a Number
     */
    float notANumber = Float.NaN; // = 0.0f / 0.0f 0x7f_c0_00_00


    /**
     * Podemos saber cuantos bits son necesarios para un valor de tipo float
     */
    IO.println(Float.SIZE); // 32

    /**
     * Y también el número de bytes
     */
    IO.println(Float.BYTES); // 4

    //twoZeros();
    //memoryRepresentation();
    memoryRepresentation2();
    //conversion();

}

void twoZeros() {
    float positiveZero = 0.0f; // o +0.0f
    float negativeZero = -0.0f;

    boolean areEqual = positiveZero == negativeZero;
    IO.println("Son iguales? " + areEqual);
}

void memoryRepresentation() {
    printBinaryRepresentation(0.0f);
    printBinaryRepresentation(-0.0f);
    printBinaryRepresentation(1.0f);
    printBinaryRepresentation(0.5f);
    printBinaryRepresentation(0.25f);
    printBinaryRepresentation(1000.0f);
    printBinaryRepresentation(-1000.0f);
    printBinaryRepresentation(Float.MAX_VALUE);
    printBinaryRepresentation(Float.MIN_VALUE);
    printBinaryRepresentation(Float.NEGATIVE_INFINITY);
    printBinaryRepresentation(Float.POSITIVE_INFINITY);
    printBinaryRepresentation(Float.NaN);
}

void memoryRepresentation2() {
    printBinaryRepresentation(0.1f);
    printBinaryRepresentation(0.01f);
    printBinaryRepresentation(0.001f);

    printBinaryRepresentation(0.0001f);
    printBinaryRepresentation(1.e-4f);
    printBinaryRepresentation(0.1e-3f);
    printBinaryRepresentation(0.01e-2f);
    printBinaryRepresentation(0.001e-1f);
    printBinaryRepresentation(0.00001e+1f);
}

void conversion() {
    int n = 1;
    printBinaryRepresentation(n);
    float x = n;
    printBinaryRepresentation(x);

    x = x + 10;
    printBinaryRepresentation(x);

    n = (int) x;
    printBinaryRepresentation(n);
}


