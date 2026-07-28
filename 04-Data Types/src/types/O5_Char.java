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
 * - char <--
 */

/**
 * Tipo char
 *
 * Se usa para representar números de 16 bits SIN signo (a diferencia del short que es con signo)
 * Se necesitan 16 bits de memoria para almacenar un valor
 *
 * El rango es desde 0 hasta 2^16-1 (65535) Es decir, 65.536 posibles valores
 *
 * TODOS positivos!!! Una variable de tipo char no puede contener valores negativos
 *
 * Se usa cuando:
 * - necesitamos almacenar el código de un caracter Unicode desde el 0000 al FFFF
 *
 * Exiten literales de tipo character
 *
 */

void main() {

    /** Podemos asignar un literal de tipo entero a una variable de tipo byte siempre que esté entre 0 y 65.535 */
    char number = 15; // 15 es un literal de tipo int

    // char negative = -15; // Error, no podemos usar literal de valor negativo

    //char beyondMaxPositive = 65536; // Error, fuera del rango
    //char beyondMinNegative = -1; // Error, fuera del rango

    /**
     * No podemos asignar literales de tipo long aunque estén dentro del rango
     */
    //char number2 = 15L; // 15L es un literal de tipo long


    char maxChar = 0xFFFF;
    char minChar = 0x0000; // No deja 0x8000 porque es 32768 no -32768

    IO.println(maxChar);
    IO.println(minChar);

    /**
     * La clase Character define constantes que equivalen al máximo y mínimo valores del
     * tipo de datos byte
     */
    char max = Character.MAX_VALUE; // 0xFFFF 65535 '\uffff'
    char min = Character.MIN_VALUE; // 0x0000 0 '\u0000'
}

void charLiterals() {
    /* Un carácter encerrado entre comillas simples */
    char c1 = 'a';
    char c2 = '/';
    char c3 = '*';
    char c4 = 'A';
    /* Una secuencia de escape de carácter (character scape sequence) */
    char css1 = '\n';
    char css2 = '\\';
    char css3 = '\'';
    char css4 = '\t';
    char css5 = '\b';
    char css6 = '\f';
    char css7 = '\r';
    //char css8 = '\a'; // Error, no existe esa secuencia de escape

    /* Una secuencia de escape de carácter Unicode */
    char uc1 = 'A';
    char uc2 = '\u0041'; //  0041 Es el código Unicode de la A

    /* Una secuencia de escape de carácter octal */
    char oc1 = '\52';
    char oc2 = '\5';
    char oc3 = '\377'; // El valor más alto en octal de tres dígitos
    //char oc4 = '\400'; // Error, Fuera de rango
    char oc5 = '\10'; // Es lo mismo que \n

    // Mismo carácter mediante 4 tipos de literales
    char cc1 = 97; // Literal int
    char cc2 = 'a'; // Literal de character entre '
    char cc3 = '\141'; // Secuencia de escape octal
    char cc4 = '\u0061'; // Secuencia de escape Unicode
}

void overflow() {
    /**
     * No está garantizado que se pueda almacenar un valor de tipo int en una variable de tipo char
     */

    char cNumber = 15; // El literal de tipo int sí está permitido

    byte bNumber = 15;
    short sNumber = 15;
    int iNumber = 15;


    /**
     * Error, no podemos asignar el valor de una variable (aunque este dentro del rango, no se sabe en tipo de compilación)
     * Porque como es una variable, el compilador no sabe su valor cuando compila el código
     */
    //bNumber = cNumber; // Error, el número positivo podría ser mayor de 127
    //cNumber = sNumber; // Los rangos no coinciden porque char es 16 bits sin signo y short es 16 bits pero con signo
    //cNumber = iNumber;
    //cNumber = lNumber;

    /**
     * Aunque byte sea de 8 bits y char de 16 no se puede asignar dado que byte es con signo e incluye los números
     * negativos del -1 al -128, que no existen en el conjunto de valores del tipo de datos char
     */
    //cNumber = bNumber; // Error, podría ser un número negativo

    /**
     * Si en lugar de una variable es una constante de tiempo de compilación entonces el compilador si sabe qué valor tiene
     * y si permite o no la asignación
     */
    final int allowedIntValue = 65535;
    final int notAllowedIntValue1 = -1;
    final int notAllowedIntValue2 = 65536;

    cNumber = allowedIntValue; // Permitido, el compilador sabe el valor de una constante y comprueba que es válido para el rango
    //cNumber = notAllowedIntValue1; // Error, el valor no queda dentro del rango 0-65535
    //cNumber = notAllowedIntValue2; // Error, el valor no queda dentro del rango 0-65535

    /**
     * Castings,
     * convertir un valor de tipo en uno de otro tipo de manera manual usando un molde (cast)
     */

    // byte y char
    //bNumber = cNumber; // Error
    bNumber = (byte) cNumber;

    /* Un literal es como una constante de compilación, el compilador puede hacer la comprobación
    y no es necesario el casting */
    bNumber = 'a';
    bNumber = (byte) 'a';

    //cNumber = bNumber; // Error
    cNumber = (char) bNumber;

    // short y char
    final short allowedShort = 32_000; // Cualquier número positivo entre 0 y 32767
    final short notAllowedShort = -32_000;
    cNumber = allowedShort;
    //cNumber = notAllowedShort; // Error que detecta el compilador al ser una constante
    //sNumber = cNumber; // Error, no coinciden los rangos

    // long y char
    long lNumber = 15L;
    final long allowedLongValue = 65535L;
    final long notAllowedLongValue = -65535L;
    lNumber = cNumber; // OK, todo valor del tipo Char existe en el rango del tipo long
    //cNumber = lNumber; // Error, los valores mayores de 65535 y los negativos no se pueden usar como valor Char

    // cNumber = 15L; // Aunque el literal sea de valor en el rango de char, por ser de tipo long no se puede
    //cNumber = allowedLongValue; // ERROR!!! aunque sea un valor válido y constante por ser de tipo long no se puede

    // Solamente podemos usar el casting

    cNumber = (char) 15L;
    cNumber = (char) lNumber;
    cNumber = (char) allowedLongValue;
    cNumber = (char) notAllowedLongValue;
}