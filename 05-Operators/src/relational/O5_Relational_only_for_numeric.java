/**
 * Los operadores relacionales de comparación:  <, <=, >, >=
 * ---------------------------------------------------------------------------------------------- *
 * Son operadores que solamente se pueden aplicar a los tipos de datos primitivos numéricos:
 * byte short int long char float y double
 * <p>
 * Todos son binarios infijos (dos operandos izquierdo y derecho y operador en medio)
 * <p>
 * Si algún operando es NaN el resultado es false
 */

/**
 * Operador mayor que >
 *
 * operando1 > operando2
 *
 * Da como resultado true si el operando1 es mayor que el operando2
 */
void greaterThan() {
    IO.println(10 > 15.0); // false
    IO.println(100 > 15.0); // true
    IO.println(-1.5 < 0); // false

    // IO.println(false > true); // ERROR, No se puede utilizar con operandos de tipo boolean

    /** La comparación con NaN siempre da como resultado false */
    double d = Double.NaN;
    IO.println(Double.NaN > 15.0); // false
    IO.println(1.5 > Double.NaN); // false
    IO.println(Double.NaN > Double.NaN); // false


}

/**
 * Operador mayor o igual que >= (el igual va a la derecha)
 *
 * operando1 >= operando2
 *
 * Da como resultado true si operando1 es mayor o igual que el operando2
 */
void greaterThanOrEqual() {
    IO.println(10 >= 15.0); // false
    IO.println(100 >= 15.0); // true
    IO.println(-1.5 >= 0); // false
    IO.println(10 >= 10); // true

    // IO.println(false >= true); // ERROR: No se puede utilizar con operandos de tipo boolean

    double d = Double.NaN;
    IO.println(Double.NaN >= 15.0); // false
    IO.println(1.5 >= Double.NaN); // false
    IO.println(Double.NaN >= Double.NaN); // false
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

    // IO.println(false < true); // ERROR: No se puede utilizar con operandos de tipo boolean

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

    // IO.println(false <= true); // ERROR: No se puede utilizar con operandos de tipo boolean

    double d = Double.NaN;
    IO.println(Double.NaN <= 15.0); // false
    IO.println(1.5 <= Double.NaN); // false
    IO.println(Double.NaN <= Double.NaN); // false
}


void main() {
    greaterThan();
    greaterThanOrEqual();
    lessThan();
    lessThanOrEqual();
}