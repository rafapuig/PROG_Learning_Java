/**
 * Considera el siguiente código
 * ¿Que se imprimirá cuando se ejecute?
 */

void main() {
    boolean done = true;
    String message = !done + " no es " + done;
    IO.println(message);
}