/**
 * Tipos de datos integrales
 *
 * Es un tipo de datos numérico cuyos valores son números enteros
 *
 * En Java tenemos 5 tipos de datos integrales / enteros:
 * - byte
 * - short
 * - int
 * - long
 * - char
 */

/**
 * Tipo int
 *
 * Se usa para representar números enteros de 32 bits con signo (positivos y negativos)
 *
 * - Conjunto de valores:
 * El rango va desde -2^31 (-2.147.483.648) hasta 2^31-1 (2.147.483.647)
 * La mitad de valores son negativos y la otra mitad son positivos
 * Parece que tenemos un positivo menos,
 * pero esto es porque hay que incluir el cero (que se considera positivo)
 *
 * - Representación en memoria:
 * Se necesitan 32 bits de memoria para almacenar un valor de tipo int
 * Se usa el formato complemento a 2 (ya que tenemos que representar también números negativos)
 */

import static util.Utils.printBinaryRepresentation;

void main() {

    /** Podemos asignar un literal de tipo entero a una variable de tipo int */
    int number = 15;
    int decimal = 10;
    int hex = 0xA;
    int numhex = 0xdecafe;

    /**
     * La clase Integer define constantes que equivalen al máximo y mínimo valores del
     * tipo de datos int
     */
    int max = Integer.MAX_VALUE; // 0x7F_FF_FF_FF
    int min = Integer.MIN_VALUE; // 0x80_00_00_00


    /**
     * Podemos saber cuantos bits son necesarios para un valor de tipo int
     */
    IO.println(Integer.SIZE); // 32

    /**
     * Y también el número de bytes
     */
    IO.println(Integer.BYTES); // 4

    memoryRepresentation();

}

void memoryRepresentation() {
    printBinaryRepresentation(-1000);
    printBinaryRepresentation(1000);
    printBinaryRepresentation(Integer.MAX_VALUE);
    printBinaryRepresentation(Integer.MIN_VALUE);
    printBinaryRepresentation(0);
    printBinaryRepresentation(1);
    printBinaryRepresentation(-1);
    printBinaryRepresentation(2);
    printBinaryRepresentation(-2);
    printBinaryRepresentation(3);
    printBinaryRepresentation(-3);
}

