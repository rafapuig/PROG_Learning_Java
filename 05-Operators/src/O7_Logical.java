/**
 * Operadores booleanos / lógicos
 *
 * Se aplican solamente a operandos (valores, expresiones) de tipo boolean y dan como resultado otro boolean.
 * (Existen otros operadores que usan los mismos simbolos, pero cuyos operandos son numéricos)
 *
 * Una expresión de tipo boolean también recibe el nombre de CONDICION.
 *
 * Operadores:
 * !    NOT (Unario prefijo)
 * &&   AND lógico de cortocircuito
 * &    AND lógico
 * ||   OR logico de cortocricuito
 * |    OR logico
 * ^    XOR
 * &=   AND compuesto con asignación
 * !=   OR compuesto con asignación
 * ^=   XOR compuesto
 *
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

void main() {

}