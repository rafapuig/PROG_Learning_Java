/**
 * https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-4.html#jls-4.2.2
 * https://docs.oracle.com/en/java/javase/26/docs/specs/jls/jls-4.html#jls-4.2.4
 * <p>
 * Operador
 * <p>
 * Es un tipo de token que realiza una determinada operación
 * a partir de uno, dos o tres operandos.
 * <p>
 * Existen dos criterios para clasificar:
 * <p>
 * - Número de operandos:
 * - Unario (1)
 * - Prefijo: ++n
 * - Postfijo: n++
 * - Binario (2) infijo --> o1 op o2
 * - Ternario (3) infijo --> o1 op(parte1) o2 op(parte2) o3
 * <p>
 * - Tipo de operación que realiza:
 * - Aritmético
 * - Relacional
 * - Lógico
 * - A nivel de bit
 *
 * Además, podemos componerlos con la operación de asignación, el operando de la izquierda guarda el resultado
 */


void main() {
    int n = 0;
    //Unarios
    n++;
    ++n;
    --n;
    n--;

    var m = ~n;

    boolean bool = true;
    bool = !bool;

    // Binarios
    n = n + 2;
    n += 5;
    n = 100 * 2;

    bool = n > 100;

    bool = n == 100;

    // Ternario
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

    // a nivel de bit
    n = n << 2;
    n = n >> 2;
    n = n >>> 2;
    n <<= 2;
    n = n ^ 255;
}