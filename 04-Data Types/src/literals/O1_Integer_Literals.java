void main() {
    tenInDifferentBasesDemo();
    underscoreSeparatorDemo();
    largestPositiveLiteralIntDemo();
    mostNegativeLiteralIntDemo();
    minusOneIntDemo();

    // Longs
    largestPositiveLiteralLongDemo();
    mostNegativeLiteralLongDemo();
}

void tenInDifferentBasesDemo() {
    // Valor literal 10 expresado en base 10 o decimal
    var decimalTen = 10;
    IO.println(decimalTen); // 10

    // El mismo valor 10, pero esta vez expresado en base 16 o hexadecimal (requiere el prefijo 0x)
    var hexadecimalTen = 0xA;
    IO.println(hexadecimalTen); // 10
    IO.println(Integer.toHexString(hexadecimalTen)); // Para imprimirlo en hexadecimal -> a

    // El mismo valor 10, pero expresado en base 8 u octal (requiere prefijo 0, empezar por 0)
    var octalTen = 012;
    IO.println(octalTen); // 10
    IO.println(Integer.toOctalString(octalTen)); // Para imprimirlo en octal --> 12

    // El mismo valor 10, pero expresado en base 2 o binario (requiere el prefijo 0b)
    var binaryTen = 0b1010;
    IO.println(binaryTen); // 10
    IO.println(Integer.toBinaryString(binaryTen)); // Para imprimirlo en binario --> 1010
}

/**
 * Podemos usar el carácter _ (underscore) para separar dígitos del literal
 * con la finalidad de mejorar su legibilidad
 */
void underscoreSeparatorDemo() {
    // Separamos cada 3 cifras en decimal que son millares
    var aMillion = 1_000_000;

    // Separamos cada byte, que son 2 dígitos en hexadecimal
    var hex = 0xBE_BE_CA_FE; // -1094792450

    // Separamos cada medio byte (nibble), que son 4 dígitos en binario
    var binary = 0b1011_1110_1011_1110_1100_1010_1111_1110; // B = 1011 C = 1100 A = 1010 E = 1110

    IO.println(aMillion);
    IO.println(hex);
    IO.println(Integer.toHexString(hex));
    IO.println(binary);
    IO.println(Integer.toBinaryString(binary));
}


void largestPositiveLiteralIntDemo() {
    // El valor literal entero más alto expresable
    var largestPositive = 2_147_483_647;
    //var largestPositiveWrong = 2_147_483_648; / uno más y el compilador ya da error

    // También lo podemos expresar en hexadecimal (complemento a 2)
    /**
     * En hexadecimal cada dígito representa 4 bits (cada 2 dígitos un byte)
     * 8 dígitos hexadecimales x 4 bits = 32 bits
     * 0111 -> 7
     * 1111 -> F
     */
    var largestPositiveIntHexadecimal = 0x7f_ff_ff_ff;

    // Y también lo podemos expresar en octal (Sufijo para octal el 0)
    /**
     * En octal cada digito representa 3 bits
     * 1 digito de 2 bits (0 a 3) + (10 dígitos de tres bits (0 a 7) -> 30 bits) = 32 bits
     * 01 -> 1
     * 111 -> 7
     * 01 111 - 111 111 111 - 111 111 111 - 111 111 111
     */
    var largestPositiveInOctal = 017_777_777_777;

    // Y en binario
    var largestPositiveInBinary = 0b0111_1111_1111_1111_1111_1111_1111_1111;

    IO.println(largestPositive);
    IO.println(largestPositiveIntHexadecimal);
    IO.println(largestPositiveInOctal);
    IO.println(largestPositiveInBinary);

    IO.println(Integer.toHexString(largestPositive));
    IO.println(Integer.toOctalString(largestPositive));
    IO.println(Integer.toBinaryString(largestPositive));
}

void mostNegativeLiteralIntDemo() {
    var mostNegative = -2_147_483_648; // Se puede usar el literal más alto con el signo negativo

    var mostNegativeInHex = -0x80_00_00_00;
    var mostNegativeInOctal = -020_000_000_000;
    var mostNegativeInBinary = -0b1000_0000_0000_0000_0000_0000_0000_0000;

    IO.println(mostNegative);
    IO.println(mostNegativeInHex);
    IO.println(mostNegativeInOctal);
    IO.println(mostNegativeInBinary);

    IO.println(Integer.toHexString(mostNegative));
    IO.println(Integer.toOctalString(mostNegative));
    IO.println(Integer.toBinaryString(mostNegative));
}


void minusOneIntDemo() {
    var minusOne = -1;
    var minusOneInHex = 0xff_ff_ff_ff;
    var minusOneInOctal = 037_777_777_777;
    var minusOneInBinary = 0b1111_1111_1111_1111_1111_1111_1111_1111;

    IO.println(minusOne);
    IO.println(minusOneInHex);
    IO.println(minusOneInOctal);
    IO.println(minusOneInBinary);

    IO.println(Integer.toHexString(minusOne));
    IO.println(Integer.toOctalString(minusOne));
    IO.println(Integer.toBinaryString(minusOne));
}

void longLiteralsDemo() {
    /**
     * Los literales de tipo long deben llevar el sufijo l o L
     * (preferiblemente L por legibilidad, porque l se confunde con el 1 en algunas tipografías)
     */
    var longDecimalTen = 10L;

    // El número siguiente al literal más grande de tipo int si lo podemos usar como literal de tipo long
    var beyondLargestPositiveIntLiteral = 2_147_483_648L;

    // Incluso valores más grandes
    var tooLargeForIntButNotForLongLiteral = 2_000_000_000_000_000_000L;

}

void largestPositiveLiteralLongDemo() {
    // El valor literal long más grande positivo está por encima de los 9 trillones!!
    var largestLongLiteral = 9_223_372_036_854_775_807L;
    //var largestLongLiteralOverflow = 9_223_372_036_854_775_808L; //ERROR, me paso por una unidad

    // 16 dígitos hexadecimales = 64 bits (8 bytes)
    var largestPositiveLongHexadecimal = 0x7F_FF_FF_FF_FF_FF_FF_FFL;

    // 64 bits / 3 dígitos por bit = 21 dígitos y un bit de resto
    var largestPositiveLongOctal = 0777_777_777_777_777_777_777L;

    var largestPositiveLongBinary = 0b01111111_11111111_11111111_11111111_11111111_11111111_11111111_11111111L;

    IO.println(largestLongLiteral);
    IO.println(largestPositiveLongHexadecimal);
    IO.println(largestPositiveLongOctal);
    IO.println(largestPositiveLongBinary);

    IO.println(Long.toHexString(largestLongLiteral));
    IO.println(Long.toOctalString(largestLongLiteral));
    IO.println(Long.toBinaryString(largestLongLiteral));
}

void mostNegativeLiteralLongDemo() {
    // El valor literal long más grande negativo está por encima de los 9 trillones!!
    var mostNegativeLongLiteral = -9_223_372_036_854_775_808L;
    //var mostNegativeLongLiteralOverflow = -9_223_372_036_854_775_809L; //ERROR, me paso por una unidad

    // 16 dígitos hexadecimales = 64 bits (8 bytes)
    var mostNegativeLongLiteralHexadecimal = 0x80_00_00_00_00_00_00_00L;

    // 64 bits / 3 dígitos por bit = 21 dígitos y un bit de resto
    var mostNegativeLongLiteralOctal = 01_000_000_000_000_000_000_000L;

    var mostNegativeLongLiteralBinary = 0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L;

    IO.println(mostNegativeLongLiteral);
    IO.println(mostNegativeLongLiteralHexadecimal);
    IO.println(mostNegativeLongLiteralOctal);
    IO.println(mostNegativeLongLiteralBinary);

    IO.println(Long.toHexString(mostNegativeLongLiteral));
    IO.println(Long.toOctalString(mostNegativeLongLiteral));
    IO.println(Long.toBinaryString(mostNegativeLongLiteral));
}