/**
 * Instrucción for (bucle for)
 * <p>
 * https://docs.oracle.com/javase/specs/jls/se26/html/jls-14.html#jls-14.14
 * <p>
 * Es una instrucción de iteración, repetición.
 * Se usa para iterar la ejecucion de una instrucción
 * un número de veces
 * en funcion de que se cumplan o no ciertas condiciones
 * <p>
 * Sintaxis:
 * for(inicialización; condicion; lista_de_expresiones)
 * instrucción
 * <p>
 * Por tanto, la estructura del bucle for consta de varias partes:
 * - inicialización
 * - condición
 * - lista de instrucciones de expresión
 * - instrucción
 * <p>
 * Las tres primeras:
 * - van entre () y separados por ;
 * - son opcionales!!!
 * (Al ser opcionales tenemos
 *
 * <p>
 * 1º Se ejecuta la inicialización
 * 2º Se evalua la condición para ver si se cumple o no, resultado true o false
 * 3º Si la condición se cumple
 * se ejecuta la instrucción asociada con el bucle (la que queremos iterar o repetir)
 * Si no se cumple se va al punto 6º
 * 4º Se evaluan las expresiones de la lista de expresiones
 * 5º Se vuelve atrás al punto 2
 * 6º El flujo de ejecución continua por la siguiente instrucción al for, saliendo de esta manera del bucle
 * <p>
 */


void ejemplo1() {
    // 1º se declara e inicializar number a 1 (instrucción de declaración)
    // 2º se evalúa la condición number <= 10
    // 3º Si es true se ejecuta la instrucción IO.println(number); y al punto 4º
    //    Si es false el flujo salta a la instrucción que viene después del for IO.println("Salí del bucle");
    // 4º Se ejecuta number++ y se vuelve al punto 2º

    for (int number = 1; number <= 10; number++)
        IO.println(number);

    IO.println("Salí del bucle");
}

void optionalParts() {
    for (; ; )
        IO.println("Bucle infinito");
}

void optionalPartsPlusEmptyStatement() {
    // La instrucción vacía consiste en nada más que un ;
    for (
            int x = 1,
            n = 2
            ; ; )
        ;
}

void optionalPartsPlusEmptyStatement2() {
    int n;
    String s;
    for (s = IO.readln(), n = Integer.parseInt(s); ; ) ;
}


/**
 * Inicialización
 * <p>
 * Puede ser:
 * - una instrucción de declaración de variable(s) local(es)
 * - una lista de instrucciones de expresión (cuyos elementos (instrucciones de expresión) van separados por coma ,)
 */

void initializationWithVariableDeclaration1() {
    // La inicialización es una instrucción de declaración de variable
    for (int i = 0; ; ) ;
}

void initializationWithVariableDeclaration2() {
    // La inicialización es una instrucción de declaración de variable
    // Podemos usar el formato para declarar e inicializar varias variables del mismo tipo
    for (int i = 0, j = 1; ; ) ;
}

void initializationWithVariableDeclaration3() {
    // La inicialización es una instrucción de declaración de variable
    // Podemos usar el formato para declarar e inicializar varias variables del mismo tipo
    for (int i = 0, j, k = 2; ; ) ;
}

void initializationWithVariableDeclaration4() {
    short i; // La variable i se declara en el scope de la función
    // No podemos declarar una variable con un nombre que ya esté en el scope
    // for (int i = 0, j , k = 2; ; ) ; // Error,
}


void initializationWithExpresionStatementList1() {
    // Para remediar el caso anterior, podemos hacer esto
    short i;
    // La inicialización ahora es una instrucción de expresión (concretamente una lista de solo una elemento)
    for (i = 0; ; ) ;
}

void initializationWithExpresionStatementList2() {
    // Esto nos da la libertad para poder inicializar variables de distinto tipo
    short i;
    String s;
    // La inicialización es una lista de instrucciones de expresión separadas por coma (2 elementos)
    for (i = 0, s = ""; ; ) ;
}

void initializationWithExpresionStatementList3() {
    short i;
    String s;
    // La inicialización es una lista de instrucciones de expresión separadas por coma
    for (i = 0, s = "", IO.println("Inicializando..."); ; ) ;
}


void main() {
    optionalParts();
}