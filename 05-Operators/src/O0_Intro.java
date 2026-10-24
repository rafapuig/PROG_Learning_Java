/**
 * https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-4.html#jls-4.2.2
 * https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-4.html#jls-4.2.4

 * OPERADOR
 * ----------------------------------------------------------------------------
 * Es un tipo de token que realiza una determinada operación
 * a partir de uno, dos o tres operandos.
 *
 * Existen dos criterios para clasificar:
 *
 * 1) Número de operandos:
 * - Unario (1)
 * - Prefijo: ++n
 * - Postfijo: n++
 * - Binario (2) infijo --> o1 op o2
 * - Ternario (3) infijo --> o1 op(parte1) o2 op(parte2) o3
 *
 * 2) Tipo de operación que realiza:
 * - Aritmético
 * - Relacional
 * - Lógico
 * - A nivel de bit
 *
 * Además, podemos componerlos con la operación de asignación, el operando de la izquierda
 * (que debe ser un almacén de datos)
 * guardará el resultado.
 */


void main() {
    int n = 0;
    //Unarios
    n++;
    ++n;
    --n;
    n--;

    // ~ Operador NOT a nivel de bit (se obtiene el símbolo ~ pulsado ALTGR + 4
    var m = ~n;

    boolean bool = true;
    bool = !bool; // Operador NOT lógico (operando de tipo boolean)

    // Binarios
    n = n + 2;
    n += 5;
    n = 100 * 2;

    bool = n > 100;

    bool = n == 100;

    // Ternario (tres operandos) op1 ? op2 : op3
    var name = "Hilario";
    var greeting = "Hola, " + name != "" ? name : "Anonimo";

    var evenResult = n % 2 == 0 ? "Par" : "Impar";

    // Aritméticos
    n = 100 / 4;
    n = 15 % 2;
    n = 25 * 2;

    // Relacionales
    bool = n > 100;
    bool = n == 100;

    // Lógicos
    bool = false || true;
    bool = true && true;
    bool = !true;
    bool = true ^ true;

    // a nivel de bit (bitwise)
    n = n << 2;
    n = n >> 2;
    n = n >>> 2;
    n <<= 2;
    n = n ^ 255;
}