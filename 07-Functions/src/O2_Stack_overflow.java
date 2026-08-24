/**
 * Stack overflow (desbordamiento de la pila de llamadas)
 * ---------------------------------------------------------------------
 *
 * En este ejemplo
 *
 * A llama a B
 * B llama a C
 * y C llama a A (con lo que A llamará a B, y B a C, que llamara a A y así sucesivamente)
 * Se entra en un bucle infinito de llamadas.
 *
 * Ninguna llamada es capaz de retornar porque nunca recupera el control cedido,
 * ya que el código de la función llamada inicia nuevas llamadas, que se apilan una encima de otra,
 * pero nunca termina, no se retorna la llamada y, por tanto, la pila crece y crece.
 *
 * Llega un momento que la pila se "desborda" y ya no permite que se apilen más llamadas.
 * Cuando sucede esto el programa lanza una excepción de tipo StackOverflow.
 */

void A() {
    IO.println("Ejecutando código de A()");
    IO.println("Llamando a B()...");
    B();
    IO.println("Retornando desde A...");
}

void B() {
    IO.println("Ejecutando código de B()");
    IO.println("Llamando a C()...");
    C();
    IO.println("Retornando desde B...");
}

void C() {
    IO.println("Ejecutando código de C()");
    IO.println("Llamando a A()...");
    A();
    IO.println("Retornando desde C...");
}

void main() {
    A();
}