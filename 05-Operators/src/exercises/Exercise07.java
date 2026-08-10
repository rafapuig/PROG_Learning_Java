/**
 * Considera el siguiente código
 */

void main() {
    /* Tienes declara e inicializada una variable de tipo short */
    short s = -10;

    /* Quieres invertir el valor de negativo a positivo mediante las instrucciones del código */
    // (No compilan, reescríbelos para que compilen)
    //s = -s;
    //s = -1 * s;

    s = (short) -s;
    s = (short) (-1 * s);

    /* Que está mal en esta instrucción para que no invierta el valor de s */
    // Pista: El orden de los caracteres  es -= o es =-
    s -= s;
}