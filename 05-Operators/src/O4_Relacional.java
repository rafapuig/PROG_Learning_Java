/**
 * Operadores relacionales
 * <p>
 * Comparan los valores de sus operandos
 * <p>
 * igualdad ==
 * inigualdad !=
 * mayor que >
 * menor que <
 * mayor o igual que >=
 * menor o igual que <=
 * <p>
 * Java soporta 7 operadores de comparación (o relacionales)
 * ( ==, !=, >, >=, <, <= y instanceof )
 * <p>
 * Todos los operadores relacionales son binarios (e infijos), toman dos operandos
 * Sus operandos son expresiones (rvalue)
 */


/**
 * Operador de igualdad == (son dos caracteres para el símbolo del operador, el operador de asignación es =)
 *
 * Se usa para comprobar la igualdad de los dos operandos.
 *
 * 1) Ambos operandos de tipos primitivos
 *    - Se evalua con resultado true sin ambos representan el mismo valor, si no, false.
 *    - Ambos deben ser númericos o ambos boolean (mezclar un boolean y un numerico no está permitido)
 *
 * 2) Ambos operandos valores de tipos referencia
 *    - Se evalua como resultado true si ambos operandos hacen referencia al MISMO objeto.
 *
 */

void main() {

    int i = 10;
    float x = 10.0f;
    boolean bool = true;
    boolean bool2 = false;

    IO.println(i == x);
    //IO.println(bool == i); // Error, mezcla de boolean e int

    IO.println(bool == bool2);

    // Error i == x se evalúa primero con dos operadores int y genera un boolean que no se puede comparar con un int
    // bool = (i == x == i);

    /**
     * El cero negativo -0.0 y el cero positivo 0.0 se consideran iguales
     */
    IO.println(0.0 == -0.0); // true

    /**
     * Infinito positivo e infinito negativo NO se consideran igual
     */
    IO.println(Double.POSITIVE_INFINITY == Double.NEGATIVE_INFINITY); // false
    IO.println(Double.POSITIVE_INFINITY == Double.POSITIVE_INFINITY); // true

    /**
     * Si algún operando es NaN el resultado de la operación es false
     */
    IO.println(Double.NaN == 1.5); // false

    /*
     * Incluso si comparamos NaN con NaN el resultado es false
     */
    IO.println(Double.NaN == Double.NaN); // false

    double number = 1.45f;
    /* Para comprobar si number es NaN no podremos usar el operador == porque siempre daría false  */
    IO.println(number == Double.NaN); // false

    number = Double.NaN;
    IO.println(number == Double.NaN); // false

    /* La forma correcta de comparar si el valor es Nan es con la función isNaN de Double (o Float) */
    IO.println(Double.isNaN(number)); // true

    IO.println(isNaN(Float.NaN));
    IO.println(Float.isNaN(1.5f));

    // Uso de la version "casera" de isNaN
    IO.println(isNaN(Float.NaN));
    IO.println(isNaN(1.6f));


    // Valores de tipo de referencia (String en este ejemplo)
    String s1 = new String("abc"); // Se crea un objeto String y una referencia a este que se guarda en la variable s1
    String s2 = new String("abc"); // Se crea otro objeto String y una referencia a este que se guarda en la variable s2

    /*
    El operador == para referencias compara las referencias
    Ambas referencias s1 y s2 refieren a objetos String iguales (ambos contienen la secuencia abc)
    pero NO se refieren al mismo objeto String (son dos objetos gemelos, iguales pero no el mismo)
    s1 contiene la referencia al primer String creado
    s2 contiene la referencia al segundo String creado
     */
    IO.println(s1 == s2);

    /** Para comparar si dos cadenas string (y en general dos objetos) son iguales en Java se usa el método equals */
    IO.println(s1.equals(s2));
}

boolean isNaN(float number) {
    final int bits = Float.floatToIntBits(number);
    //IO.println(String.format("%32s", Integer.toBinaryString(bits)).replace(' ', '0'));

    final int exponent = (bits & 0x7f_80_00_00) >> 23;
    //IO.println(String.format("%8s", Integer.toBinaryString(exponent)).replace(' ', '0'));

    final int mantissa = bits & 0x00_7F_FF_FF;
    //IO.println(String.format("%23s", Integer.toBinaryString(mantissa)).replace(' ', '0'));

    // Un NaN se representa mediante el exponente máximo y una mantisa distinta de cero
    return mantissa != 0 && exponent == 255;
}