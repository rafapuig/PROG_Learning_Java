/**
 * Tipos de datos integrales
 *
 * Es un tipo de datos numérico cuyos valores son números enteros
 *
 * En Java tenemos 5 tipos de datos integrales / enteros:
 * - byte <--
 * - short
 * - int
 * - long
 * - char
 */

/**
 * Tipo byte
 *
 * Se usa para representar numeros de 8 bits CON signo
 * Se necesitan 8 bits de memoria para almacenar un valor
 *
 *
 *
 * El rango es desde -2^7 (128) hasta 2^7-1 (127) Es decir, 256 posibles valores
 *
 * Otra vez, la mitad positivos y la otra mitad negativos. El cero es positivo
 *
 * Se usa cuando:
 * - necesitamos una gran cantidad de variables cuyos valores no van a estar fuera del rango -128 a 127
 * - tratamos con datos binarios en un fichero o en un flujo de red.
 *
 * No exiten literales de tipo byte
 *
 */

void main() {

    /** Podemos asignar un literal de tipo entero a una variable de tipo byte simpre que este entre -128 y 127 */
    byte number = 15; // 15 es un literal de tipo int
    byte decimal = 10;
    byte hex = 0xA;
    byte numhex = 0x7F;
    byte negative = -11;
    //byte beyondMaxPositive = 128;
    //byte beyondMinNegative = -129;

    /**
     * No podemos asignar literales de tipo long aunque esten dentro del rango
     */
    //byte number2 = 15L; // 15L es un literal de tipo long


    byte maxByte = 0x7F;
    byte minByte = -0x80; // No deja 0x80 porque es 128 no -128

    IO.println(maxByte);
    IO.println(minByte);

    /**
     * La clase Byte define constantes que equivalen al máximo y mínimo valores del
     * tipo de datos byte
     */

    byte max = Byte.MAX_VALUE; // 0x7F 127
    byte min = Byte.MIN_VALUE; // -0x80 -128

    IO.println(Byte.SIZE); // 8
    IO.println(Byte.BYTES); // 1
}

void overflow() {
    /**
     * No está garantizado que se pueda almacenar un valor de tipo int en una variable de tipo byte
     */

    byte bNumber = 15; // El literal de tipo int si está permitido

    int iNumber = 15;


    /**
     * Error, no podemos asignar el valor de una variable (aunque este dentro del rango, no se sabe en tipo de compilación)
     * Porque como es una variable, el compilador no sabe su valor cuando compila el código
     */
    //bNumber = iNumber;

    /**
     * Si en lugar de una variable es una constante de tiempo de compilación entonces el compilador si sabe que valor tiene
     * y si permite o no la asignación
     */
    final int allowedValue = 15;
    final int notAllowedValue = 150;

    bNumber = allowedValue; // Permitido, el compilador si puede saber el valor de una constante
    //bNumber = notAllowedValue; // Aquí el compilador comprueba que el valor de notAllowedValue que es 150 y excede el rango

   /**
     * Otra caso que podemos hacer,
    * convertir un valor de tipo int en uno de tipo byte de manera manual usando un molde (cast)
     * En este caso el casting se hace mediante el operador de casting (tipo) donde tipo es byte --> (byte)
     * Y Java que se quedara solamente con los 8 bits menos significativos de los 32 que tiene el valor int
     * en el momento de ejecutar el casting en tiempo de ejecución.
     */
    int i = 25;
    bNumber = (byte)25;
    bNumber = (byte)iNumber;
    bNumber = (byte)notAllowedValue;

    /* También sirve para literales y variables long */
    long lNumber = 25L;
    bNumber = (byte)25L;
    bNumber = (byte)lNumber;
}