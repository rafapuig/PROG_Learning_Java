
void parseFloat() {
    float f1 = Float.parseFloat("3.14159");
    float f2 = Float.parseFloat("-1.0002E-10");
    float f3 = Float.parseFloat("0xFFp2");
    float f4 = Float.parseFloat("0xB.CAFEp-1");

    IO.println(f1);
    IO.println(f2);
    IO.println(f3);
    IO.println(f4);
}


void main() {

    parseFloat();

    float fNumber = Float.parseFloat("1.00000017881393421514957253748434595763683319091796875001");
    float fNumber1 = Float.parseFloat("1.00000017881393421514957253748434595763683319091796875001f");
    float fNumber2 = Float.parseFloat("1.00000017881393421514957253748434595763683319091796875001d");

    IO.println(fNumber);
    IO.println(fNumber1);
    IO.println(fNumber2);

    double dNumber1 = Double.parseDouble("1.00000017881393421514957253748434595763683319091796875001f");
    double dNumber2 = Double.parseDouble("1.00000017881393421514957253748434595763683319091796875001d");
    IO.println(dNumber1);
    IO.println(dNumber2);

    float fNumberFromDoubleIntermediate = (float) (dNumber2);
    IO.println(fNumberFromDoubleIntermediate);


    float f = Float.valueOf("1.1").floatValue(); // Unboxing explicito
    double d = Double.valueOf("1.1").doubleValue(); // Unboxing explicito

    // Un parsing a directo a float
    float f1 = Float.valueOf("1.00000017881393421514957253748434595763683319091796875001d").floatValue();
    IO.println(f1); // 1.0000001

    // Un parsing a Double intermediario y luego conversión a float
    float f2 = Double.valueOf("1.00000017881393421514957253748434595763683319091796875001d").floatValue();
    IO.println(f2); // 1.0000002
    
}