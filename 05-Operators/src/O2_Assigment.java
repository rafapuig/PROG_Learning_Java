/**
 * Operador de asignación =
 * ------------------------------------------------------------------------------------------------
 * Se usa para asignar (escribir) un valor a una variable.
 *
 * El operador izquierdo debe ser un lvalue (una variable en sentido amplio)
 * El operador de la derecha puede ser un rvalue (una expresión valor)
 *
 * El valor de la derecha debe ser ASIGNABLEMENTE COMPATIBLE
 * con el tipo de datos del operador izquierdo.
 *
 * El operador de asignación forma una expresión.
 * Por tanto,
 * - resultará en un valor
 * - y tiene un tipo.
 */

void main() {
    /** Declaración de la variable number */
    int number;

    // number es el lvalue y debe ser una (variable en sentido amplio, es decir un almacén de datos)
    // 26 es un literal y, por tanto, una expresión valor
    number = 26; // Asignación, como instrucción, de la variable number

    /**
     * El operando de la derecha debe ser ASIGNABLEMENTE COMPATIBLE
     * con el tipo de datos del operando izquierdo
     */
    byte b = 10; // un literal de tipo int se puede asignar a una variable de tipo byte (si está entre -128 y 127)
    char c = 'ñ'; // un literal de tipo char se puede asignar a una variable de tipo char
    short s = -325;
    int i = 100;
    i = b; // OK
    i = c; // OK
    i = s; // OK

    long big = 512L;
    float f = 1.5f;

    //i = big; // ERROR rvalue long y lvalue int, no asignablemente compatible
    //i = f; // ERROR

    /**
     * Se puede solucionar convirtiendo el rvalue a un tipo asignablemente compatible
     */
    i = (int) big; // Se convierte el valor de big a int, rvalue es la expresión (int)big
    i = (int) f; // rvalue es (int)f que es una expresión de tipo int

    /**
     * Asignación como expresión
     */
    int number1, number2; // Declaración de varias variables
    /**
     * Se asigna el valor 1024 a la variable number1
     * El resultado de la expresión number1 = 1024 es el operando derecho, 1024
     * Quedando number2 = 1024;
     * y, por tanto, se asigna el valor 1024 a number2
     */
    number2 = number1 = 1024;

    /* Declaración de n1, n2, n3 e inicialización de n1 y n3 */
    int n1 = 10, n2, n3 = 20;
}