void main() {
    tenInDifferentBasesDemo();
    underscoreSeparatorDemo();
    largestPositiveIntDemo();
    mostNegativeIntDemo();
    minusOneIntDemo();
}

void tenInDifferentBasesDemo() {
    // Valor literal 10 expresados en base 10 o decimal
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


void largestPositiveIntDemo() {
    // El valor literal entero más alto expresable
    var largestPositive = 2_147_483_647;
    //var largestPositiveWrong = 2_147_483_648; / uno más y el compilador ya da error

    // También lo podemos expresar en hexadecimal (complemento a 2)
    var largestPositiveInHexadecimal = 0x7f_ff_ff_ff;

    // Y también lo podemos expresar en octal
    var largestPositiveInOctal = 017_777_777_777;

    // Y en binario
    var largestPositiveInBinary = 0b0111_1111_1111_1111_1111_1111_1111_1111;

    IO.println(largestPositive);
    IO.println(largestPositiveInHexadecimal);
    IO.println(largestPositiveInOctal);
    IO.println(largestPositiveInBinary);

    IO.println(Integer.toHexString(largestPositive));
    IO.println(Integer.toOctalString(largestPositive));
    IO.println(Integer.toBinaryString(largestPositive));
}

void mostNegativeIntDemo() {
    var mostNegative = -2_147_48_3648; // Se puede usar el literal más alto con el signo negativo
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








