/**
 * Los operadores de comparación <, <=, >, >=
 *
 * Son operadores que solamente se pueden aplicar a los tipos de datos primitivos numéricos:
 * byte short int long char float y double
 *
 * Todos son binarios infijos (dos operandos izquierdo y derecho y operador en medio)
 *
 * Si algún operando es NaN el resultado es false *
 */

/**
 * Operador mayor que >
 *
 * operando1 > operando2
 *
 * Da como resultado true si el operando1 es mayor que el operando2
 */
void greaterThan() {

}

/**
 * Operador mayor o igual que >= (el igual va a la derecha)
 *
 * operando1 >= operando2
 *
 * Da como resultado true si operando1 es mayor o igual que el operando2
 */
void greaterThanOrEqual() {

}

/**
 * Operador menor que <
 *
 * operando1 < operando2
 *
 * Da como resultado true si el operando1 es menor que el operando2
 */

void lessThan() {
    IO.println(10 < 15.0); // true
    IO.println(100 < 15.0); // false
    IO.println(-1.5 < 0); // true

    // IO.println(false < true); // No se puede utilizar con operandos de tipo boolean

    double d = Double.NaN;
    IO.println(Double.NaN < 15.0); // false
    IO.println(1.5 < Double.NaN); // false
    IO.println(Double.NaN < Double.NaN); // false
}

/**
 * Operador menor o igual que <=
 *
 * operando1 <= operando2
 *
 * Da como resultado true si operando1 es menor o igual que el operando2
 */
void lessThanOrEqual() {
    IO.println(10 <= 15.0); // true
    IO.println(100 <= 15.0); // false
    IO.println(-1.5 <= 0); // true
    IO.println(10 <= 10); // true

    // IO.println(false <= true); // No se puede utilizar con operandos de tipo boolean

    double d = Double.NaN;
    IO.println(Double.NaN <= 15.0); // false
    IO.println(1.5 <= Double.NaN); // false
    IO.println(Double.NaN <= Double.NaN); // false
}

void main() {
    
}