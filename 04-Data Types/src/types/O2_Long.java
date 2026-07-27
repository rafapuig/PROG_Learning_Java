/**
 * Tipos de datos integrales
 *
 * Es un tipo de datos numérico cuyos valores son números enteros
 *
 * En Java tenemos 5 tipos de datos integrales / enteros:
 * - byte
 * - short
 * - int
 * - long <--
 * - char
 */

/**
 * Tipo long
 *
 * Se usa para representar numeros de 64 bits con signo
 * Se necesitan 64 bits de memoria para almacenar un valor
 *
 * Se usa cuando los calculos con números enteros exceden el rango de un valor de tipo int, dado
 * que un valor de tipo long consume el doble de memoria que un valor de tipo int
 *
 * El rango es desde -2*64 (9.223.372.036.854.775.807, nueve trillones) hasta 2^64-1 (-9.223.372.036.854.775.808)
 * La mitad de valores son negativos y la otra mitad son positivios
 * Positivos parece que tenemos uno menos, pero esto es porque hay que incluir el cero
 */

void main() {

    /** Podemos asignar un literal de tipo entero a una variable de tipo long */
    long number = 15; // 15 es un literal de tipo int
    long decimal = 10;
    long hex = 0xA;
    long numhex = 0xdecafe;
    /**
     * Cuando hacemos esto Java realiza una conversión para rellenar los 32 bits adicionales que faltan con ceros
     * preservando el signo.
     * En este caso la conversión realizada se considera de tipo extensión o ampliación.
     * Las conversiones de extensión se realizan de forma automática porque no suponen ningún peligro de perdida
     * de información.
     */

    /**
     * Y además podemos asignar un literal de tipo entero largo
     * (Para que se considere un literal de tipo entero largo se añade el sufijo L o l)
     */
    long number2 = 15L; // 15L es un literal de tipo long
    long decimal2 = 10L; // Es preferible la L porque la l se confunde con el 1 en algunos tipos de letra
    long hex2 = 0xAL;
    long beyondMaxInt = 2_147_483_648L; // Necesita la L, si no el compilador se queja de que es un valor muy grande
    long beyondMinInt = -2_147_483_649L;

    long maxLong = 0x7FFFFFFF_FFFFFFFFL;
    long minLong = 0x80000000_00000000L; // Es lo mismo que -0x80000000_00000000L

    IO.println(maxLong);
    IO.println(minLong);

    // uno más que el valor más grande de tipo long
    //long beyondMaxLong = 9_223_372_036_854_775_808L; // Error de compilación, valor fuera del rango long

    /**
     * La clase Long define constantes que equivalen al máximo y mínimo valores del
     * tipo de datos long
     */

    long max = Long.MAX_VALUE; // 0x7FFFFFFF_FFFFFFFFL
    long min = Long.MIN_VALUE; // 0x80000000_00000000L
}

void overflow() {
    /**
     * No está garantizado que se pueda almacenar un valor de tipo long en una variable de tipo int
     */

    long lNumber1 = Integer.MAX_VALUE;
    long lNumber2 = Integer.MAX_VALUE + 1L;
    int iNumber;

    /**
     * Para garantizar que no hay perdida de información
     * Java no permite que escribamos estas líneas de código, son errores
     * Incluso si el valor almacenado en una variable long como lNumber1 cae dentro del rango de int
     * no se permite
     */
    //int num = 25L; // Error, un valor de tipo long No se puede asignar a una variable int aunque entre en el rango int
    //iNumber = lNumber1; // En este caso podría ser viable, pero no se permite tampoco
    //iNumber = lNumber2; // En este caso el valor es demasiado grande (se perderían los 32 bits adicionales de long)

    /**
     * Lo que podemos hacer es convertir un valor de tipo long en uno de tipo int de manera manual
     * usando un molde (cast)
     * En este caso el casting se hace mediante el operador de casting (tipo) donde tipo es int --> (int)
     * Y Java que se quedara solamente con los 32 bits menos significativos de los 64 que tiene el valor long
     * en el momento de ejecutar el casting en tiempo de ejecución.
     */
    int i = (int)25L;
    iNumber = (int)lNumber1;
    iNumber = (int)lNumber2;
}