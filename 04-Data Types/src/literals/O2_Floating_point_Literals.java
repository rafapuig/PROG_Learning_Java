import static util.Utils.bits;

/**
 * Literales de valores de punto flotante
 *
 * Consta de las siguientes partes:
 *
 * ParteEntera PuntoDecimal ParteFraccionaria Exponente Sufijo
 * Digitos      .        Dígitos          e E p P  Dígitos  f F d D
 *
 * Se puede expresar en decimal (base 10) o en hexadecimal (base 16)
 *
 * Para valores en decimal:
 * - Al menos un dígito en parte entera o en la parte fraccionaria
 * - el punto decimal (.) y/o el exponente (E) y/o el sufijo
 *
 * Para valores en hexadecimal:
 * - Al menos un dígito bien en parte entera o en la parte fraccionaria
 * - Exponente OBLIGATORIO {p|P} + Entero con signo
 * - Sufijo opcional
 *
 * Se permiten _ como separadores entre dígitos que denoten: parte entera, parte fraccionaria y exponente
 *
 * Sufijos:
 * - f (o F) para que el valor sea de tipo float
 * - d (o D) o sin sufijo el valor se considera de tipo double
 *
 * - El valor más grande positivo de tipo float es numéricamente igual a (2-2^23)*2^127
 * y se corresponde con el literal 3.4028235e38f
 * y 0x1.fffffeP+127f
 *
 * - El valor más pequeño positivo de tipo float es numéricamente equivalente a 2^-149
 * y se corresponde con el literal 1.4e-45f
 * y 0x0.00002P-126f o también 0x1.0P-149f
 *
 */

void main() {
    //floatLiterals();
    //largestPositiveFiniteFloatLiteral();
    smallestPositiveFiniteNonZeroFloatLiteral();
    largestPositiveFiniteDoubleLiteral();
    smallestPositiveFiniteNonZeroDoubleLiteral();
}


void largestPositiveFiniteFloatLiteral() {
    var mostPositive = 3.4028235e38f;
    // signo 0 -> positivo,
    // exponente de 8 bits 2^127 con sesgo de 127 => 127 + 127 = 254 -> 11111110
    // 23 unos en la mantisa normalizada 1.xxxxxxx --> ff_ff_fe
    var mostPositiveHex = 0x1.ff_ff_feP+127f;

    /**
     * Es un error de compilación si el literal es demasiado grande
     * y en la conversion de redondeo a su representación interna
     * se convierte en el valor infinito
     */

    IO.println(mostPositive);
    IO.println(bits(mostPositive));
    IO.println(mostPositiveHex);
    IO.println(bits(mostPositiveHex));
}

void smallestPositiveFiniteNonZeroFloatLiteral() {
    var smallestPositive = 1.4e-45f;
    // 149 - 23 = 126 el 1 desplazado 23 posiciones en la mantisa a la derecha
    var smallestPositiveHex =  0x1.0P-149f;
    // Mantisa 22 ceros y un 1 (y un cero) por eso el 2
    // Desnormalizada, por eso exponente 0000_0000 (8 ceros)
    // signo positivo 0
    var smallestPositiveHexAlt = 0x0.00_00_02P-126f;

    /**
     * Es un error de compilación si el literal demasiado pequeño
     * y la conversion de redondeo a su representación interna
     * resulta en 0
     */
    //var smallestPositiveHexAltError = 0x0.00_00_01P-126f;

    IO.println(smallestPositive);
    IO.println(bits(smallestPositive));
    IO.println(smallestPositiveHex);
    IO.println(bits(smallestPositiveHex));
    IO.println(smallestPositiveHexAlt);
    IO.println(bits(smallestPositiveHexAlt));
}

void floatLiterals() {
    /* Literales de tipo float (Obligatorio el sufijo f o F */
    var zero = 0f;
    IO.println(zero);

    IO.println(5f);
    IO.println(5.f);
    IO.println(.5f);
    IO.println(0.5f);
    IO.println(3.14f);

    IO.println(+5f);
    IO.println(+5.f);
    IO.println(+.5f);
    IO.println(+0.5f);
    IO.println(+3.14f);

    IO.println(-5f);
    IO.println(-5.f);
    IO.println(-.5f);
    IO.println(-0.5f);
    IO.println(-3.14f);

    IO.println(5e2f); // 5 * 10^2
    IO.println(5.e2f);
    IO.println(5.0e2f);
    IO.println(5e+2f);

    IO.println(-5e2f);
    IO.println(-5e+2f);
    IO.println(5e-2f); // 5 * 10^-2
    IO.println(-5e-2f);
    IO.println(-.5e+2f);
    IO.println(-.5e-2f);
    IO.println(0.5e2f);
    IO.println(-0.5e+2f);
    IO.println(6.022137e+23f);

    // Literal float en hexadecimal */
    IO.println(0xCAFEP23f);

}

void doubleLiterals() {
    /* Literales de tipo double Sufijo d D (o ningún sufijo) */
    var zero = 0d;

    IO.println(0d); // Digito (entero) y sufijo D
    IO.println(0D); // Digito (entero) y sufijo D
    IO.println(0.); // Digito entero y punto
    IO.println(.0);  // Digito decimal y punto
    IO.println(0.0); // Digito entero y decimal (y punto)
    IO.println(0e0); // Digito (entero) y exponente

    var zero2 = 0e0;

    var negativeZero = -0.;

    IO.println(-0d); // Digito (entero) y sufijo D
    IO.println(-0D); // Digito (entero) y sufijo D
    IO.println(-0.); // Digito entero y punto
    IO.println(-.0);  // Digito decimal y punto
    IO.println(-0.0); // Digito entero y decimal (y punto)
    IO.println(-0e0); // Digito (entero) y exponente

    IO.println(5d);
    IO.println(-5d);
    IO.println(5D);
    IO.println(-5D);
    IO.println(5.);
    IO.println(.5);
    IO.println(0.5);

    IO.println(3.1416);
    IO.println(-3.1416);
    IO.println(+3.1416d);
    IO.println(-3.1416D);

    IO.println(1e-9d);
    IO.println(1e137);
}

/**
 * El valor más grande finito de tipo double es numéricamente
 * igual a (2-2^52) * 2^1023
 *
 * 1.7976931348623157e308
 */

void largestPositiveFiniteDoubleLiteral() {
    var largest = 1.7976931348623157e308;
    IO.println(largest);
    IO.println(bits(largest));

    // Signo 1 bit positivo a 0
    // Exponente 11 bits (0 a 2048) 1023 + 1023 de sesgo = 2046 -> 11111111110 (10 unos y un cero)
    // Mantisa (64 - 11 - 1) = 52 bits -> 6,5 bytes --> 13 dígitos hexadecimales (mantisa normalizada)
    var largestHex = 0x1.f_ffff_ffff_ffffP+1023;
    IO.println(largestHex);
    IO.println(bits(largestHex));
}

/**
 * El valor más pequeño distinto de cero finito de tipo double es numéricamente
 * igual a 2^-1074
 *
 * 4.9e-324
 */

void smallestPositiveFiniteNonZeroDoubleLiteral() {
    var smallest = 4.9e-324;
    IO.println(smallest);
    IO.println(bits(smallest));

    // 1074 - 52 = 1022
    var smallestHex = 0x1.0P-1074;
    IO.println(smallestHex);
    IO.println(bits(smallestHex));

    // Mantisa 51 ceros y un 1 (13 dígitos hexadecimales)
    // Desnormalizada, por eso exponente en binario 000_0000_0000 11 ceros
    var smallestHexAlt = 0x0.0_0000_0000_0001P-1022;
    IO.println(smallestHexAlt);
    IO.println(bits(smallestHexAlt));
}

