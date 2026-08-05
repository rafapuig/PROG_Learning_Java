/**
 * Tipo float
 * <p>
 * Se usa para representar números decimales de 32 bits con signo (positivos y negativos) mediante
 * el formato IEEE 754
 * <p>
 * Si se usan 32 bits para representar el valor se dice que estamos usando precision sencilla, simple (single)
 * <p>
 * - Conjunto de valores:
 * El rango va desde tan pequeño como 1.4 x 10^-45 hasta tan grande como 3.4 x 10^38
 * tanto en positivo como en negativo.
 * <p>
 * <p>
 * Para que un literal se considere de tipo float debe llevar el sufijo f o F
 * <p>
 * Se definen dos valores cero: +0.0f y el -0.0f en el conjunto de valores,
 * aunque cuando se comparan se consideran iguales
 * <p>
 * Se definen dos infinitos: infinto positivo e infinito negativo
 * Por ejemplo, el resultado de dividir 2.5f entre 0.0f es infinito positivo
 * y dividir 2.5f entre -0.0f es infinito negativo.
 * <p>
 * El resultado de algunas operaciones no está definido.
 * Por ejemplo, dividir 0.0f entre 0.0f es indeterminado.
 * El valor indeterminado está incluido en el conjunto de valores del tipo float,
 * tiene representación en binario
 * y se denomina NaN (Not a Number)
 * <p>
 * - Representación en memoria:
 * Se necesitan 32 bits de memoria para almacenar un valor de tipo float
 * Se usa el formato estandar IEEE 754 con single-precision
 * <p>
 * Se divide en 4 partes:
 * - signo
 * - Mantisa
 * - Base (radix)
 * - exponente
 * <p>
 * Ejemplo:
 * 19.25 --> +19.25 x 10^0 --> +19.25E0
 * signo positivo
 * significando (mantisa) 19.25
 * base 10
 * exponente 0
 * <p>
 * Existen infinitas formas de representar la misma cantidad
 * 19.25e0, 1.925e1, 0.1925e2, 192.5e-1, 1925e-2
 * <p>
 * La forma normalizada en base 10 es la que cumple que:
 * 0.1 <= mantisa < 1
 * <p>
 * Por tanto, 0.1925e2 es la forma normalizada
 * <p>
 * En base 2 (binario) el número 19.25 se representa como: 10011.01
 * <p>
 * 1001101 x 2^-2 10110.1 x 2^-1, 10011.01 x 2^0, 1001.101 x 2^1, ... 1.001101 x 2^4 ...
 * <p>
 * Cuando desplazamos el punto decimal el exponente:
 * - se decrementa si lo desplazamos hacia la derecha
 * - se incremente cuando lo desplazamos hacia la izquierda
 * <p>
 * La forma normalizada en base 2 cumple:
 * 1 <= mantisa < 2
 * <p>
 * Entonces la mantisa normalizada tiene el formato 1.bbbbbbb... donde b es un dígito binario (1 o 0)
 * <p>
 * 1.001101 x 2^4 es la forma normalizada (empieza por un uno seguido del punto binario y varios digitos binarios)
 * <p>
 * NOTA: No todos los números se pueden representar de forma normalizada.
 * - Números que no tienen ningún 1. Ejemplo, el 0.0
 * - Hay un número determinado de bits para el exponente
 * (si el exponente de un número es el mínimo permitido por el formato y la mantisa es <1 no se puede normalizar)
 * Por ejemplo, -126 sea mínimo exponente y el número es el 0.01101 x 2^-126 porque normalizado
 * sería 1.101x2^-128, pero -128 es menor que el exponente mínimo.
 * <p>
 * Ventajas de la normalización:
 * - Es única
 * - El punto binario siempre se sitúa después del primer 1, no es necesario almacenar la posición del punto
 * - 2 números normalizados son fáciles de comparar, mediante sus signos, mantisas y exponentes.
 * - Siempre se almacenan los dígitos más interesantes de la mantisa
 * (si tenemos 5 bits para mantisa, con 0.0010110x2^10 solo almacenamos 0.00101 y perdemos el 10 final,
 * pero si normalizamos a 1.00110x2^7 podemos almacenar sus 5 bits a 1
 * - En la forma normalizada la mantisa siempre empieza por 1
 * (y, por tanto, no hace falta gastar un bit para almacenarlo, el hidden bit)
 * <p>
 * Estándares del IEEE 754:
 * - 32 bit single-precision floating point format --> Java lo usa para el tipo float
 * - 64 bit double-precision floating point format --> Java lo usa para el tipo double
 * <p>
 * <p>
 * 32 bit single-precision floating point format:
 * <p>
 * Signo * mantisa * 2^exponente
 * <p>
 * Como la base siempre es 2, no se almacena el valor de la base, se asume que es 2
 * <p>
 * Los 32 bits se distribuyen de la siguiente manera:
 * -  1 bit  -- signo (0 positivos - 1 negativo)
 * -  8 bits -- exponente [-127,128] biased por 127, biased exp = exp + 127
 * - 23 bits -- mantisa
 * <p>
 * 1     8              23 (16 + 7)
 * s eeeeeeee fffffff ffffffff ffffffff
 * <p>
 * -- Exponente
 * Los 8 bit del exponente guardan la versión desplazada o sesgada en 127 unidades,
 * es decir,
 * - a -127 se le suma 127 quedando 0 y es lo que se guarda en memoria
 * - el 0 + 127 = 127
 * - el 128 + 127 = 255
 * <p>
 * Por tanto, los 255 valores que van desde -127 hasta el 128 se desplazan 127 unidades y se convierten en
 * valores positivos, desde 0 hasta 255, que son números que se pueden codificar en binario directamente.
 * <p>
 * Estos valores extremos de exponente (-127 y 128) se usan para representar números especiales:
 * - cero
 * - infinitos
 * - NaN
 * - no normalizados
 * Los exponentes desde -126 hasta 127 (desviados a 1 hasta 254) representan números normalizados.
 * <p>
 * -- Mantisa (23 bits)
 * Determina la precisión del número en punto flotante.
 * <p>
 * Si está normalizado será 1.fffffff_ffffffff_ffffffff (24 dígitos)
 * El primer uno se sobreentiende, y no hace falta almacenarlo, no consume ninguno de los 23 bits
 * <p>
 * Por tanto, la precisión es 23 + 1 = 24
 * <p>
 * Número mínimo normalizado:
 * - signo, 0 o 1 según sea positivo o negativo.
 * - exponente: El mínimo es -126 --> -126 + 127 = 1 luego los 8 bits quedan como 00000001
 * - mantisa: 1.0000000_00000000_00000000 --> 0000000 00000000 00000000
 * <p>
 * Correspondiendo al número 1.0 x 2^-126
 * <p>
 * NO podemos aproximarnos más al número cero, queda un gap (hueco en la recta real no representable)
 * <p>
 * Esto es un problema cuando trabajamos con números muy pequeños. Muy próximos a cero.
 * <p>
 * --- Números de punto flotante especiales
 * <p>
 * -- Los ceros (negativo y positivo) 0.0 y -0.0
 * <p>
 * - exponente --> -127 (el valor mínimo) + 127 desvío = 0
 * - mantisa --> 0.0
 * <p>
 * +0.0 --> (0) (00000000) (0000000 00000000 00000000)
 * -0.0 --> (1) (00000000) (0000000 00000000 00000000) igual menos el bit de signo
 * <p>
 * -- Los infinitos
 * - exponente --> 128 (el valor máximo) + 127 = 255 --> 11111111
 * - mantisa --> 0
 * <p>
 * -infinito --> (1) (11111111) (0000000 00000000 00000000)
 * +infinito --> (0) (11111111) (0000000 00000000 00000000)
 * <p>
 * -- Not a number NaN
 * Existen dos versiones:
 * - una que es callada (quiet)
 * - una que es señaladora (signaling)
 * <p>
 * En una operación en la que NaN sea un operando, por ejemplo NaN + 100.0
 * - si es callado el resultado será nuevamente Nan
 * - si es señal se lanzará una excepción
 * <p>
 * Ambas se representan con el exponente máximo 128 --> 255 --> 11111111
 * y mantisa distinta de 0
 * donde (primer bit, el de más a la izquierda, el más significativo):
 * - callada es un 1 --> 1ffffff_ffffffff_ffffffff
 * - señal es un 0   --> 0ffffff_ffffffff_ffffffff
 * <p>
 * En Java siempre se usa la version callada de NaN
 * <p>
 * <p>
 * -- Los números desnormalizados
 * Rellenan el vacío entre el mínimo valor normalizado y el cero
 * - exponente --> valor mínimo -127 --> + 127 = 0 --> 00000000
 * - mantisa --> distinta de 0
 * <p>
 * (-1)* signo * 0.fffffff_ffffffff_ffffffff * 2^-126
 * <p>
 * Ejemplo:
 * Número 0.0001 x 2 ^ 126
 * - signo --> 0
 * - exponente --> 00000000
 * - mantisa --> 0001000_00000000_00000000
 * <p>
 * <p>
 * --- Redondeos
 * No todos los números reales se pueden expresar de forma exacta (lo numeros reales son continuos)
 * y hay que redondear.
 * Otros nombres para el redondeo son truncado o recorte.
 * <p>
 * Hay varias formas de redondear:
 * - Redondeo hacia el cero
 * - Redondeo hacia el infinito (positivo o negativo)
 * - Redondeo hacia el más cercano
 * <p>
 * -- Redondeo hacia el cero
 * En este sistema se retienen tantos bits del número original como tenemos disponibles para almacenarlo.
 * El resto de bits se ignoran.
 * El efecto de este sistema de redondeo es acercar el número hacia el cero.
 * <p>
 * Ejemplos: (para dos bits disponibles)
 * <p>
 * 1.1101 --> 1.11
 * -0.1011 --> -0.10
 * 0.1010 --> 0.10
 * 0.0011 --> 0.00
 * <p>
 * <p>
 * -- Redondeo hacia infinito positivo
 * El redondeo acerca al infinito positivo
 * <p>
 * Ejemplos:
 * 1.1101 --> 10.00
 * -0.1011 --> -0.10
 * 0.1010 --> 0.11
 * 0.0011 --> 0.01
 * <p>
 * -- Redondeo hacia infinito negativo
 * Ejemplos:
 * 1.1101 --> 1.11
 * -0.1011 --> -0.11
 * 0.1010 --> 0.10
 * 0.0011 --> 0.00
 * <p>
 * -- Redondeo hacia el valor más cercano representable
 * -- Si las 2 igual de cerca, se escoge el par (último bit a 0) "ties to even"
 * <p>
 * Ejemplos:
 * 1.1101 --> 1.11
 * -0.1011 --> -0.11
 * 0.1010 --> 0.10
 * 0.0011 --> 0.01
 * <p>
 * Este último sistema de redondeo es el que utiliza el lenguaje Java
 *
 */

import static util.Utils.*;


void main() {

    /** Podemos asignar un literal de tipo float a una variable de tipo float */
    float number = 15f;
    float ten = 10f;
    float hex = 0xAf;
    float numhex = 0xdecafef;

    /**
     * La clase Float define constantes que equivalen al máximo y mínimo valores del
     * tipo de datos float
     */
    float max = Float.MAX_VALUE; //
    float min = Float.MIN_VALUE; // 1.4 x 10-45

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
    memoryRepresentation();
    //memoryRepresentation2();
    memoryRepresentation3();
    //conversion();
    //precision();
    //precision2();
}

void twoZeros() {
    float positiveZero = 0.0f; // o +0.0f
    float negativeZero = -0.0f;

    boolean areEqual = positiveZero == negativeZero;
    IO.println("Son iguales? " + areEqual);
}

void memoryRepresentation() {
    // Zeros
    printBinaryRepresentation(0.0f);
    printBinaryRepresentation(-0.0f);

    printBinaryRepresentation(1.0f);
    printBinaryRepresentation(0.5f);
    printBinaryRepresentation(0.25f);
    printBinaryRepresentation(1000.0f);
    printBinaryRepresentation(-1000.0f);

    printBinaryRepresentation(Float.MAX_VALUE);
    printBinaryRepresentation(Float.MIN_VALUE);
    printBinaryRepresentation(-Float.MIN_NORMAL);

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

void memoryRepresentation3() {
    float x = Float.intBitsToFloat(0b0_01111111_1000000_00000000_00000000);
    IO.println(x);

    x = Float.intBitsToFloat(0b1_01111111_1000000_00000000_00000000);
    IO.println(x);

    x = Float.intBitsToFloat(0b0_00000001_0000000_00000000_00000000); // 1.0 x 2^-126
    IO.println(x); // mínimo número normalizable para float
    x = Float.MIN_NORMAL; // 0x1.0p-126f;
    IO.println(x);

    float z = Float.intBitsToFloat(0b0_00000000_0000000_00000000_00000001); // 1.0 x 2^-(126+23) = 1.0 x 2^-149
    IO.println(z); // numero mas cercano a cero
    z = Float.MIN_VALUE; // 0x0.000002p-126f;
    IO.println(z);

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


/**
 * El número decimal 0.1 en binario es
 * 0.000110011001100110011001100110011001100110011...
 * se repite el patron 0011 infinitamente
 * (al igual que ocurre con el 1/3 es 0.333333333... en decimal)
 *
 * No podemos representarlo de manera exacta en un valor de tipo float
 * Java almacena el valor IEEE 754 de single precisión más cercano
 *
 * Normalizado sería 1.1001100110011001100110011001100110011 x 2 ^ -4
 *
 * signo -- 0
 * exponente -- -4 + 127 = 123 01111011
 * mantisa --> 1001100_11001100_1100110X ---- se redondea esto 11001100110011 en este caso está cerca
 * 1001100_11001100_11001101 que 1001100_11001100_11001100,
 * por tanto, la mantisa queda en 1001100_11001100_1100110(1)
 *
 * El valor representado sería el 1.10011001100110011001101₂ × 2⁻⁴
 *  S  E             M
 * [0] 011_1101 (1)  100_1100 1100_1100 1100_1101
 * 0x3D_CC_CC_CD
 *
 *  El valor exacto de 0.1f es la fracción:
 *   13421773
 *  ---------- = 0.100000001490116119384765625
 *   134217728
 *
 *   13421773 = 0x00CCCCCD
 *   134217728 = 2^27 (denominador potencia exacta de 2, como en todo float)
 */
void precision() {
    IO.println("0.1f en hex: " + hexRepresentation(0.1f));
    IO.println("0.1f en binario: " + binRepresentation(0.1f));
    IO.println("0.1f en binario (campos S E M): " + binRepresentation(0.1f, true));

    IO.println("Valor exacto almacenado para 0.1f: " + exactFloatStored(0.1f));
}

void precision2() {

    var sum = 0.1f + 0.1f + 0.1f - 0.1f;

    IO.println("Suma 0.1f + 0.1f + 0.1f - 0.1f = " + sum + "\tSorprendido?");

    IO.println("Valor exacto almacenado en sum: " + exactFloatStored(sum));
    IO.println("Hex: " + hexRepresentation(sum));
    IO.println("Bin: " + binRepresentation(sum));
    IO.println("Campos: " + binRepresentation(sum, true));

    IO.println("Exacto 0.2f: " + exactFloatStored(0.2f));
    IO.println("Hex: " + hexRepresentation(0.2f));
    IO.println("Bin: " + binRepresentation(0.2f));
    IO.println("Campos: " + binRepresentation(0.2f, true));

    var sum2 = 0.2f + 0.2f + 0.2f - 0.2f;
    IO.println("Suma 0.2f + 0.2f + 0.2f - 0.2f: " + sum2 + "\tSorprendido aun?");
}


