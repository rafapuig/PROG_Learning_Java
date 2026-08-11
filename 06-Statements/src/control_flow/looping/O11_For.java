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

/**
 * Condición
 * <p>
 * Es una expresión de tipo boolean
 * <p>
 * Es opcional,
 * si se omite se asume implícitamente el valor true
 * (lo que resulta en un bucle infinito a menos que se salga mediante un break)
 */

void conditionOptional1() {
    // La condición es opcional, se asume implícitamente que es el literal true
    for (int i = 1; ; i++) // Implicitamente la condición es true
        IO.println(i);
}

void conditionOptional2() {
    // Es equivalente al anterior
    for (int i = 1; true; i++)
        IO.println(i);
}


/*
 * NOTA: Esto no es una buena práctica de programación, siempre que se pueda, es preferible
 * hacer uso de la condición del bucle para controlar la salida
 */
void conditionOptional3() {
    // Para escapar de un bucle infinito se usa la instrucción break;
    for (int i = 1; ; i++) {
        IO.println(i);
        if (i == 10) break; // Cuando i llegue a 10 saldremos del bucle mediante el break;
    }
}

/*
 * Mejor estilo de programación:
 */
void conditionOptional4() {
    for (int i = 1; i <= 10; i++)
        IO.println(i);
}

/**
 * Lista de instrucciones de expresión
 *
 * Una lista cuyos elementos son instrucciones de expresión separados unos de otros por la coma (,)
 */

/* Reescribimos la función anterior */
void expresionStatementList1() {
    // Usamos una lista de dos elementos (instrucciones de expresión):
    // 1) IO.println(i)
    // 2) i++
    for (int i = 1; i <= 10; IO.println(i), i++);
}

/* Aún podemos hacerla más compacta */
void expresionStatementList2() {
    // Al usar el operador postfijo, se usa para el println la version antes de incrementar
    for (int i = 1; i <= 10; IO.println(i++));
}


/**
 * Bucles for anidados (nested)
 *
 * Podemos hacer un bucle que se repita dentro de otro bucle
 * Por ejemplo,
 * Escribir una línea de 5 puntos tres veces
 * Si repetimos 5 veces la escritura del punto tenemos la línea de 5 puntos (bucle 1)
 * Si repetimos 3 veces la instrucción que escribe la línea (el bucle 1) tenemos las 3 líneas de 5 puntos (bucle 2)
 *
 * El bucle 1 estaría repitiéndose dentro del bucle 2 (estaría anidado en el bucle 2)
 */

void nestedForLoops() {
    // El bucle externo se repite 3 veces, para i=0, i=1 e i=2, para i=3 no se cumple que i<3
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 5; j++) {
            IO.print(".");
        }
        IO.println(); // El salto de línea
    }
}

void main() {
    //optionalParts();
    nestedForLoops();
}