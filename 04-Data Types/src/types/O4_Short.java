/**
 * Tipos de datos integrales
 *
 * Es un tipo de datos numérico cuyos valores son números enteros
 *
 * En Java tenemos 5 tipos de datos integrales / enteros:
 * - byte
 * - short <--
 * - int
 * - long
 * - char
 */

/**
 * Tipo short
 *
 * Se usa para representar numeros de 16 bits CON signo
 * Se necesitan 16 bits de memoria para almacenar un valor
 *
 *
 *
 * El rango es desde -2^15 (-32.768) hasta 2^15-1 (32.767) Es decir, 65.536 posibles valores
 *
 * Otra vez, la mitad positivos y la otra mitad negativos. El cero es positivo
 *
 * Se usa cuando:
 * - necesitamos una gran cantidad de variables cuyos valores van a estar dentro del rango -32.768 a 32.767
 *
 * No exiten literales de tipo short
 *
 */

void main() {

    /** Podemos asignar un literal de tipo entero a una variable de tipo byte siempre que esté entre -32.768 y 32.767 */
    short number = 15; // 15 es un literal de tipo int

    //short beyondMaxPositive = 32768; // Error, fuera del rango
    //short beyondMinNegative = -32769; // Error, fuera del rango

    /**
     * No podemos asignar literales de tipo long aunque estén dentro del rango
     */
    //short number2 = 15L; // 15L es un literal de tipo long


    short maxShort = 0x7FFF;
    short minShort = -0x8000; // No deja 0x8000 porque es 32768 no -32768

    IO.println(maxShort);
    IO.println(minShort);

    /**
     * La clase Short define constantes que equivalen al máximo y mínimo valores del
     * tipo de datos byte
     */
    short max = Short.MAX_VALUE; // 0x7FFF 32.767
    short min = Short.MIN_VALUE; // -0x8000 -32.768
}

void overflow() {
    /**
     * No está garantizado que se pueda almacenar un valor de tipo int en una variable de tipo short
     */

    short sNumber = 15; // El literal de tipo int sí está permitido

    byte bNumber = 15;
    int iNumber = 15;


    /**
     * Error, no podemos asignar el valor de una variable (aunque este dentro del rango, no se sabe en tipo de compilación)
     * Porque como es una variable, el compilador no sabe su valor cuando compila el código
     */
    //sNumber = iNumber;

    /**
     * Si en lugar de una variable es una constante de tiempo de compilación entonces el compilador si sabe qué valor tiene
     * y si permite o no la asignación
     */
    final int allowedValue = 150;
    final int notAllowedValue = 32768;

    sNumber = allowedValue; // Permitido, el compilador si puede saber el valor de una constante
    //sNumber = notAllowedValue; // Aquí el compilador comprueba que el valor de notAllowedValue que es 150 y excede el rango

   /**
     * Otra cosa que podemos hacer,
    * convertir un valor de tipo int en uno de tipo byte de manera manual usando un molde (cast)
     * En este caso el casting se hace mediante el operador de casting (tipo) donde tipo es short --> (short)
     * Y Java que se quedara solamente con los 16 bits menos significativos de los 32 que tiene el valor int
     * en el momento de ejecutar el casting en tiempo de ejecución.
     */
    sNumber = (short)25;
    sNumber = (short)iNumber;
    sNumber = (short)notAllowedValue;

    /* También sirve para literales y variables long */
    long lNumber = 25L;
    sNumber = (short)25L;
    sNumber = (short)lNumber;

    /**
     * La asignación de un valor de una variable de tipo byte al ser menos bits 8 que un short 16
     * se puede realizar de forma automática
     * Es una conversion de extensión / ampliación
     * Añadirá 8 bits más con ceros y respetará el signo
     */
    sNumber = bNumber;
}