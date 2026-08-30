/**
 * Operadores booleanos / lógicos
 * <p>
 * Se aplican solamente a operandos (valores, expresiones) de tipo boolean y dan como resultado otro boolean.
 * (Existen otros operadores que usan los mismos simbolos, pero cuyos operandos son numéricos)
 * <p>
 * Una expresión de tipo boolean también recibe el nombre de CONDICIÓN.
 * <p>
 * Operadores:
 * !    NOT (Unario prefijo)
 * &&   AND lógico de cortocircuito
 * &    AND lógico
 * ||   OR lógico de cortocircuito
 * |    OR lógico
 * ^    XOR
 * &=   AND compuesto con asignación
 * !=   OR compuesto con asignación
 * ^=   XOR compuesto
 * <p>
 * Solamente NOT ! es unario el resto son binarios
 */

void not() {
    IO.println(!true);
    IO.println(!false);

    boolean b = true;
    b = !b; // Canbiar el valor de true a false, y si fuera false a true
    IO.println(b);

    b = 12 > 10; // true
    IO.println(!b); // false

    int i = 2;
    int j = 3;
    //IO.println(!j > i); // Error, el operador lógico NOT tiene precedencia sobre el relacional >
    IO.println(!(j > i)); // Los paréntesis permiten asociar j con el > y aplicar el not al resultado
}

/**
 * Operador AND lógico y de cortocircuito &&
 * <p>
 * operando1 && operando2 (operandos expresiones de tipo boolean, condiciones)
 * <p>
 * Solamente devuelve true si ambas condiciones se evalúan con resultado true
 * <p>
 * Al ser de cortocircuito la condición del segundo operando solamente se evalua si la primera resulta true
 * Porque, si el primer operando es false, ya da igual lo que resulte evaluar el segundo,
 * el resultado final ya está determinado a ser false y ningun resultado del segundo operando lo puede cambiar.
 * De esta manera nos ahorramos evaluar la segunda condición.
 * A veces, conviene no evaluar la segunda condición si no se cumplen unos requisitos previos.
 */

void shortCircuitAnd() {
    int i = 5;
    int j = 10;
    boolean result = i < 10 && j < 20;
    IO.println(result);

    i = 11;
    // Si i no es menor que 10 ya con se comprueba si j es menor que 20
    // da igual lo que valga j (y, por tanto, el resultado de la segunda condición) puesto que no va a influir en
    // el resultado final que será inevitablemente false
    result = i < 10 && j < 20;
    IO.println(result);

    // Un ejemplo más util
    // Evitar que se divide si el divisor es cero
    result = i != 0 && j / i > 1;
    i = 0;
    result = i != 0 && j / i > 1;

    // Evitar una asignación
    i = 5;
    result = i % 2 == 0  && (j = j * i) < 100; // j no se asigna si i no es par
    IO.println(j);
}

/**
 * Operador AND son cortocircuitar &
 * Da el mismo resultado que el AND de cortocircuito, salvo que siempre evalúa los dos operandos
 */
void logicalAnd() {
    int i = 5;
    int j = 10;
    boolean result = i % 2 == 0  & (j = j * i) < 100; // siempre asigna el valor a j
    IO.println(j);
}

void main() {
    shortCircuitAnd();
    logicalAnd();

}