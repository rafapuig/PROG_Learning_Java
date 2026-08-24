/**
 * La pila de llamadas (Call Stack)
 * -----------------------------------------------------------------------------------------
 * Cada vez que desde el código de una función, una instrucción realiza una llamada a una función,
 * la función llamadora cede el control a la función que recibe la llamada y queda a la espera de que
 * esta última termine de ejecutar todo su código (y/o retorne)
 * para poder continuar por el punto donde le cedió el control.
 *
 * Existe una estructura, que se crea en tiempo de ejecución, para controlar
 * qué función ha llamado a qué otra función
 * y en que punto de su código cedió el control.
 * Esta estructura funciona como una pila, es decir, una LIFO. Lo ultimo, que entra es lo primero que sale.
 *
 * Tiene su logica, si la funcion A llama a la funcion B, y la funcion B a la funcion C.
 * Se ejecutara el codigo de C,
 * y cuando retorne se sigue con B
 * y cuando termine B se sigue con A.
 * Es decir, se retoma en orden contrario al que suceden las llamadas.
 *
 * Los elementos que se apilan y desapilan en la Pila de llamadas (Call Stack) son las llamadas a función.
 *
 * La llamada a la función contiene la siguiente información:
 * - nombre de la funcion llamada
 * - Un puntero o referencia a la siguiente instrucción que se debe ejecutar por la función llamada.
 * - (Memoria donde se almacenan los valores de los parámetros de entrada y las variables locales)
 *
 * Al principio la pila contiene la llamada a la función main realizada por el S.O.
 * Si durante la ejecución de la función main una de sus instrucciones ejecutadas es una llamada a una funcion X,
 * se apila la llamada a X, si X hace una llamada a la funcion Y se apila la llamada a Y, si ahora Y llama de nuevo
 * a X se apila una llamada a X, de manera que la pila quedaria en ese momento asi:
 *
 * +--------+
 * |  X     | <-- cima de la pila
 * +--------+
 * +  Y     |
 * +--------+
 * +  X     |
 * +--------+
 * | main   |
 * +--------+
 *
 * Este mecanismo tiene como consecuencia que
 * en todo momento se están ejecutando las instrucciones del cuerpo de la función
 * que corresponde con la función de la llamada que ocupa la cima de la pila de llamadas.
 *
 *
 * Cuando se produce una llamada a una función:
 * - Se crea un elemento llamada y se "apila" (encima de todos los elementos / llamadas aun no finalizadas)
 * que guarda una referencia a la instrucción de la función que hay que ejecutar a continuación.
 *
 * - Cada vez que se completa la ejecución de una instrucción se actualiza el valor de la cima de la pila,
 * haciendo que la referencia siempre apunte a la siguiente intrucción del código de la función pendiente de ser ejecutada.
 *
 * - Si durante la ejecución del código de la función, una de sus instrucciones implica realizar otra llamada a función,
 * entonces, se apila esta nueva llamada a función (con la referencia apuntado a la siguiente instrucción
 * a ejecutar, que será la primera instrucción de la función que ha sido llamada)
 * Inmediatamente debajo de esta llamada, en la pila, quedará la llamada que estaba antes en la cima,
 * es decir, la llamada a la función cuyo ejecución a desencadenado otra llamada a función, con la información del puntero
 * referencia a la siguiente instruccion a ejecutar, que queda pendiente para continuar cuando la funcion llamada retorne.
 *
 * - Cuando la función que ejecuta sus intrucciones termina su ejecución,
 * la llamada que había producido que su ejecución se da por concluida,
 * retorna un valor al llamador (en su caso)
 * y se desapila de la cima pila.
 *
 * - Como consecuencia, la llamada que queda ahora en la cima de la pila de llamadas es la llamada anterior,
 * (que fue, a su vez, la generadora de la llamada acaba de retornar y se ha desapilado)
 * y que contiene como información el puntero referencia a la siguiente instrucción a ejecutar por la función en esa llamada,
 * cuando cedió el control, y quedó a la espera del retorno para poder continuar.
 *
 * En resumen,
 * La cima de la pila de llamadas siempre contiene el puntero que referencia
 * a la siguiente instrucción que debe ejecutar el programa.
 */

void A() {
    IO.println("Ejecutando el código de la función A...");
    IO.println("Código de la función A() finalizado, retornando al llamador...");
}

void B() {
    IO.println("Ejecutando el código de la función B");
    IO.println("Llamando a C()...");
    C();
    IO.println("Continuando después de que C haya finalizado");
    IO.println("Código de la función B() finalizado, retornando al llamador...");
}

void C() {
    IO.println("Ejecutando el código de la función C");
    IO.println("Código de la función C() finalizado, retornando al llamador...");
}


void test3() {
    IO.println("Ejecutando el código de la función test3()");
    IO.println("Llamando a A()...");
    A();
    IO.println("Llamando a A()...");
    A();
    IO.println("Llamando a A()...");
    A();
    IO.println("Código de la función test3() finalizado, retornando al llamador...");
}


void test1() {
    IO.println("Llamando a A()...");
    A();
    IO.println("Continuando después de que A haya finalizado");
}

void test2() {
    IO.println("Ejecutando el código de la función test2()");
    IO.println("Llamando a B()...");
    B();
    IO.println("Continuando después de que B haya finalizado");
    IO.println("Código de test2() finalizado, retornado al llamador...");
}


void main() {
    IO.println("Ejecutando el código de la función main()");
    //test1();
    //test2();
    test3();
    IO.println("Código de main() finalizado, retornado al llamador...");
}