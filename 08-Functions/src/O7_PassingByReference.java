/**
 * Paso por referencia
 * <p>
 * El paso de argumentos (parámetros) por referencia NO exite en Java !!!!!!
 * <p>
 * Lo más parecido que podemos hacer es usar arrays de un único elemento en lugar de una variable del tipo
 * del elemento.
 */

void swap(int[] a, int[] b) {
    int temp = a[0];
    a[0] = b[0];
    b[0] = temp;
}

/**
 * Erróneo porque las referencias a los arrays se pasan por valor
 * `a` contiene una copia del valor del argumento (una copia de la referencia al array usado como argumento 1)
 * `b` contiene una copia del valor del argumento (una copia de la referencia al array usado como argumento 2)
 * En esta implementación solo estoy intercambiado los valores de las COPIAS de las referencias en a y b
 */
void swapWrong(int[] a, int[] b) {
    int[] temp = a;
    a = b;
    b = temp;
}

void callSwap() {
    int[] x = new int[]{3};
    int[] y = new int[]{5};

    IO.println(x[0] + " " + y[0]);

    swap(x, y);

    IO.println(x[0] + " " + y[0]);
}

void callSwapCleaner() {
    int[] x = {3};
    int[] y = {5};

    IO.println(x[0] + " " + y[0]);

    swap(x, y);

    IO.println(x[0] + " " + y[0]);
}

void callWrongSwap() {
    int[] x = {4};
    int[] y = {8};

    IO.println(x[0] + " " + y[0]);

    swapWrong(x, y);

    IO.println(x[0] + " " + y[0]);
}


int[] swapArray(int... arr) {
    int temp = arr[0];
    arr[0] = arr[1];
    arr[1] = temp;
    return arr;
}

void callSwapArray() {
    int[] swapped = swapArray(5, 7);
    IO.println(swapped[0] + " " + swapped[1]);
}

void callSwapArray2() {
    int[] values = {5, 7};
    IO.println(values[0] + " " + values[1]);

    int[] swapped = swapArray(values);
    IO.println(values[0] + " " + values[1]);
    IO.println(swapped[0] + " " + swapped[1]);
}


void main() {
    callSwap();
    callWrongSwap();
    callSwapArray();
    callSwapArray2();
}