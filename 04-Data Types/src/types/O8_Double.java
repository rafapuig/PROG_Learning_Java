/**
 * Tipos de datos decimales (reales)
 * <p>
 * Es un tipo de datos numérico cuyos valores son números con parte entera y parte decimal
 * <p>
 * En Java tenemos 2 tipos de datos decimales:
 * - float
 * - double <--
 * <p>
 * Se representan en la memoria en binario mediante 1s y 0s
 * Por tanto, hay que convertir el valor a su formato en binario antes de almacenarlo
 * y volver a reconvertirlo a su valor decimal real para operar, mostrarlo, etc.
 * <p>
 * También se debe conocer la posición del punto decimal.
 * Existen 2 estrategias para almacenar un número real en la memoria del ordenador.
 * 1. FIXED-POINT Asumir que el número de dígitos decimales es fijo y siempre el mismo después del punto decimal.
 * 2. FLOATING_POINT Guardar la posición del punto decimal junto con la representación en binario
 * y que el número de decimales pueda variar (flotar)
 * <p>
 * Las representaciones es punto flotante son:
 * - más lentas
 * - menos precisas
 * --> pero... a cambio,
 * pueden representar un rango más grande de números con la misma cantidad de memoria que el punto fijo.
 * <p>
 * En Java tenemos dos tipos que usan el formato de punto flotante:
 * - float
 * - double
 * <p>
 * NOTA:
 * - NO todos los números reales tienen una representación en binario exacto de su valor,
 * en ese caso, se usan aproximaciones.
 * <p>
 * Java utiliza el estándar IEEE 754 para la representación de punto flotante.
 */

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
 * - Representación en memoria:
 * Se necesitan 64 bits de memoria para almacenar un valor de tipo float
 * Se usa el formato estandar IEEE 754 con single-precision
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


