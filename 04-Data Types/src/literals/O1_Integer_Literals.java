void main() {
    tenInDifferentBasesDemo();
    underscoreSeparatorDemo();
    largestPositiveIntDemo();
    mostNegativeIntDemo();
    minusOneIntDemo();
}

void tenInDifferentBasesDemo() {
    var decimalTen = 10;
    IO.println(decimalTen);

    var hexadecimalTen = 0xA;
    IO.println(hexadecimalTen);
    IO.println(Integer.toHexString(hexadecimalTen));

    var octalTen = 012;
    IO.println(octalTen);
    IO.println(Integer.toOctalString(octalTen));

    var binaryTen = 0b1010;
    IO.println(binaryTen);
    IO.println(Integer.toBinaryString(binaryTen));
}

void underscoreSeparatorDemo() {
    var aMillion = 1_000_000;
    var hex = 0xFF_FF_CA_FE;
    var binary = 0b1111_1111_1111_1111_1100_1010_1111_1110;

    IO.println(aMillion);
    IO.println(binary);
    IO.println(hex);
}

void largestPositiveIntDemo() {
    var largestPositive = 2147483647;
    //var largestPositiveWrong = 2147483648;
    var largestPositiveInHexadecimal = 0x7f_ff_ff_ff;
    var largestPositiveInOctal = 017_777_777_777;
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
    var mostNegative = -2147483648; // Se puede usar el literal más alto con el signo negativo
    var mostNegativeInHex = -0x80_00_00_00;  //Integer.toHexString(mostNegative);
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








