/**
 * Operador ternario
 * <p>
 * Uso alternativo a una instrucción if-else
 * <p>
 * Conviene usar el operador ternario cuando queremos que if-else sea una expresión
 * que nos genere un resultado para luego poder usar más adelante.
 * Para no repetirnos en lo que hacemos en ambas ramas.
 * Para usar la expresión como argumento de llamada a una función.
 */

void ejemplo1() {
    int i = 1;
    int j = 2;
    int n;

    // En este caso nos estamos repitiendo,
    // En ambas ramas estamos haciendo una escritura mediante una asignación en la variable n
    if (i < j) {
        n = i;
    } else {
        n = j;
    }

    IO.println(n);

    // Alternativa mediante el operador ternario
    n = (i < j) ? i : j;

    IO.println(n);

    // O directamente como expresión argumento de la llamada
    IO.println((i < j) ? i : j);
}


void main() {
    ejemplo1();
}