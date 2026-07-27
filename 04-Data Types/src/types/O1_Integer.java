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
 * Se usa para representar numeros de 32 bits con signo
 * Se necesitan 32 bits de memoria para almacenar un valor
 *
 * El rango es desde -2*31 (-2.147.483.648) hasta 2^31-1 (2.147.483.647)
 * La mitad de valores son negativos y la otra mitad son positivios
 * Positivos parece que tenemos uno menos, pero esto es porque hay que incluir el cero
 */

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
}