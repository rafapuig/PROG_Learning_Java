/**
 * Operador
 * Es un tipo de token que realiza una determinada operación
 * a partir de uno, dos o tres operandos.
 *
 * Existen dos criterios para clasificar:
 * - Número de operandos
 *      - Unario (1)
 *          - Prefijo: ++n
 *          - Postfijo: n++
 *      - Binario (2) infijo --> o1 op o2
 *      - Ternario (3) infijo --> o1 op(parte1) o2 op(parte2) o3
 * - Tipo de operación que realiza:
 *      - Aritmético
 *      - Relacional
 *      - Lógico
 *      - A nivel de bit
 */

/**
 * EXPRESIÓN
 * Es una serie de variables, operadores y llamadas a métodos
 * construidos siguiendo las reglas de la gramática del lenguaje de programación.
 *
 * Reglas más importantes:
 *
 * Expresión --> literal
 * Expresion --> variable
 * Expresion --> llamada_a_función
 * Expresion --> operador_unario_prefijo <expresión>
 * Expresion --> <expresión> operador_unario_postfijo
 * Expresion --> <expresion_izquieda> operador_binario <expresion_derecha>
 * Expresion --> ( <expresion> )
 *
 * Las expresiones se evalúan dando como resultado un valor (en tiempo de ejecución)
 *
 * No obstante,
 * las expresiones tienen tipo,
 * y este se evalúa por el compilador (en tiempo de compilación)
 *
 * El operador de asignación forma una expresión.
 * Por tanto, resultará en un valor y tiene un tipo.
 */


/**
 * operador de asignación =
 * Se usa para asignar (escribir) un valor a una variable.
 *
 * El operador izquierdo debe ser un lvalue (una variable en sentido amplio)
 * El operador de la derecha deber ser un rvalue (una expresión)
 *
 * El valor de la derecha debe ser ASIGNABLEMENTE COMPATIBLE
 * con el tipo de datos del operador izquierdo
 */
void assignment() {
    /** Declaración de la variable number */
    int number;
    number = 26; // Asignación como instrucción de la variable number

    /**
    * El valor de la derecha debe ser ASIGNABLEMENTE COMPATIBLE
    * con el tipo de datos del operador izquierdo
    */
    byte b = 10;
    char c = 'ñ';
    short s = -325;
    int i = 100;
    i = b; // OK
    i = c; // OK
    i = s; // OK

    long big = 512L;
    float f = 1.5f;

    //i = big; // Error rvalue long y lvalue int, no asignablemente compatible
    //i = f; // Error

    /**
     * Se puede solucionar conviertiendo el rvalue a un tipo asignablemente compatible
     */
    i = (int)big; // Se convierte el valor de big a int, rvalue es la expresión (int)big
    i = (int)f; // rvalue es (int)f que es una expresión de tipo int

    /**
     * Asignación como expresión
     */
    int number1, number2; // Declaración de varias variables
    /**
     * Se asigna el valor 1024 a la variable number1
     * El resultado de la expresion number1 = 1024 es el operando derecho, 1024
     * Quedando number2 = 1024;
     * y, por tanto, se asigna el valor 1024 a number2
     */
    number2 = number1 = 1024;

    /* Declaración de n1, n2, n3 e inicialización de n1 y n3 */
    int n1 = 10, n2, n3 = 20;
}

void main() {
    
}