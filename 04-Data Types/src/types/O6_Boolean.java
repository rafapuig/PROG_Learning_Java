/**
 * Tipo de datos booleano (lógicos)
 *
 * - Conjunto de valores: Verdadero, Falso (solamente 2 valores)
 * - Conjunto de operaciones:
 * - operaciones lógicas AND OR NOT XOR
 * - comparación igualdad, desigualdad
 * - Representación en memoria:
 * - desde el punto de vista del programador nos podemos abstraer!!!
 * - En Java no se especifica y depende de la implementación de la JVM
 * - (típicamente se suele mapear un valor boolean en un int por el compilador)
 * - (y un array de booleans en un byte array)
 *
 * El tipo boolean solamente cuenta con dos posibles valores: Verdadero y falso
 *
 * El lenguaje de programación Java pone a disposición del programador
 * 2 literales, cada uno asociado con cada uno de los valores:
 * - Verdadero: true
 * - False: false
 */

boolean isRaining = true;
boolean hasChildren = false;
boolean canDrive = true;

void main() {
    operatorNOT();
    operadorANDShortcircuit();
    operatorANDShortcircuit2();
}

/**
 * El operador ! (not) es un operador de aridad 1 (unario)
 * Es decir, solamente tiene un operando (a su derecha) !operando
 * El resultado de evaluarlo es verdadero si el operando es falso
 * y falso si el operando tiene valor verdadero
 */

void operatorNOT() {

    boolean b;
    b = !true; // Se asigna el valor falso (no verdadero)
    b = !false; // Se asigna el valor verdadeo (no falso)

    var isAlive = true;
    /**
     * Queremos que isDead sea verdadero si isAlive es false
     * y que sea falso si isAlive es verdadero
     */
    var isDead = !isAlive;

    IO.println(isAlive);
    IO.println(isDead);


    var isRaining = false;
    var isNotRaining = !isRaining;

    IO.println(isRaining);
    IO.println(isNotRaining);
}


/**
 * El operador && (AND cortocircuitado)
 * Es un operador binario e infijo --> operando1 && operando2
 * El resultado es verdadero solamente si operando1 y operando2 son verdaderos
 * y falso en el resto de los casos
 * <p>
 * ¿Qué quiere decir que se sea cortocircuitado?
 * Como el resultado final solamente puede ser verdadero si ambos operandos
 * son verdaderos, si el operando1 es falso ya da igual evaluar si el operando2
 * es verdadero o falso porque el resultado ya no podrá verse afectado por
 * el valor del operando2, y será irremediablemente falso.
 */
void operadorANDShortcircuit() {
    var isWhite = false;
    var isBottled = true;

    /* Si no es blanco ya no podrá ser leche  */
    var isMilk = isWhite && isBottled; // && es el operador AND de cortocircuito

    IO.println(isMilk);
}

boolean slowComputationHasDoneTasks() {
    IO.println("Comprobando si se han realizado todas las tareas...");
    try {
        Thread.sleep(2000);
    } catch (InterruptedException _) {
    }
    return true;
}

/**
 * En este ejemplo se supone que compramos que para
 * que un alumno pase una asignatura
 * tiene que haber superado el examen
 * y tiene que haber hecho las tareas
 * <p>
 * Supongamos que corregir el examen lleva poco tiempo,
 * pero revisar la completitud de todas las tareas lleva mucho tiempo
 * ¿Si fueras profesor por donde empezarías a comprobar?
 * ¿El examen o las tareas?
 * ¿Si el examen está suspendido, vale la pena mirar si ha hecho todas las tareas?
 * ¿Va a cambiar en algo el veredicto final?
 */
void operatorANDShortcircuit2() {

    /* Pongamos que el alumno no ha superado el examen */
    var hasPassExam = false;
    /**
     * Como el primer argumento resulta ser falso
     * Se cortocircuta el cálculo y no se llama a slowComputationHasDoneTasks
     * porque el valor del segundo argumento del operador &&
     * ya es indiferente para el resultado final
     */
    var hasPassSubject = hasPassExam && slowComputationHasDoneTasks();

    IO.println(hasPassSubject);

    hasPassSubject = slowComputationHasDoneTasks() && hasPassExam;
    IO.println(hasPassSubject);
}

void operatorANDShortcircuit3() {
    var i = 10;
    var j = 3;
    /*
    La division por cero fallaría si j es 0
    Pero gracias al cortocircuito i / j nunca se llega a calcular
    si j != 0 es falso, es decir, si j es igual a 0
     */
    boolean result = j != 0 && i / j > 1;
}


/**
 * Ciertos operadores relacionales no están definidos para el tipo boolean
 * Esto quiere decir que no se pueden comparar > < >= <=
 * Solamente son aplicables == (igual) y != (distinto)
 */
void operatorRelationalsNotDefined() {

    boolean isClean = false;
    boolean isEmpty = false;

    //IO.println(isClean > isEmpty); // Error
    //IO.println(isClean >= isEmpty); // Error
    //IO.println(isClean <= isEmpty); // Error
    //IO.println(isClean < isEmpty); // Error
    //IO.println(isClean == isEmpty);
    IO.println(isClean != isEmpty);
}