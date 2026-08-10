/**
 * Considera el siguiente código
 * ¿Cuál será el valor de i después de ejecutar el código?
 */

void main() {
    int i = 7;
    i = i++ % i;

    IO.println(i);
}