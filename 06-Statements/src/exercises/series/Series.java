/**
 * La variable debe tomar los valores, 1, 2, 3 ... hasta el 15
 */

void series1() {
    int n = 1; // Primer valor de la serie
    while (n <= 15) { // menor o igual que el último de la serie
        IO.println(n);
        n++; // para pasar al siguiente tenemos que aumentar (incrementar) en 1 el valor de n
    }
}

void series1b() {
    int n = 0;
    while (n++ <= 15) IO.println(n);
}

void series1c() {
    int n = 1; // Primer valor de la serie
    while (n <= 15) IO.println(n++);
}

/**
 * La variable debe tomar los valores, 0, 2, 4, 6 ... hasta el 10
 */

void series2() {
    int n = 0; // Primer valor
    while (n <= 16) { // Menor o igual que el último (porque vamos aumentando)
        IO.println(n);
        n += 2; // Para pasar al siguiente valor necesitamos incrementar el número actual en 2 unidades
    }
}

/**
 * La variable debe tomar los valores 10, 9, 8, 7 .. hasta 0
 */
void series3() {
    int n = 10; // Valor inicial
    while (n >= 0) { // Mayor o igual que el último (porque vamos decrementando)
        IO.println(n);
        n--; // Para pasar al siguiente valor necesitamos decrementar el número actual en 1 unidad
    }
}

/**
 * La variable debe tomar los valores 10, 8, 6, 4 .. hasta 0
 */
void series4() {
    int n = 10; // Valor inicial
    while (n >= 0) { // Mayor o igual que el último (porque vamos decrementando)
        IO.println(n);
        n -= 2; // Para pasar al siguiente valor necesitamos decrementar el número actual en 1 unidad
    }
}

/**
 * La variable debe tomar los valores desde 13, múltiplos de 3 hasta 31
 */
void series5() {
    int n = 13;
    while (n <= 31) {
        if (n % 3 == 0) IO.println(n);
        n++; // Para pasar al siguiente valor necesitamos incrementar el número actual en 1 unidad
    }
}

/**
 * Imprime el abecedario en minúsculas
 */
void series6() {
    char letter = 'a';
    while (letter <= 'z') {
        IO.print(letter + " ");
        letter++;
    }
    IO.println("\b");
}

/**
 * Imprime el abecedario en minúsculas, separadas por comas
 */
void series7() {
    char letter = 'a';
    while (letter <= 'z') {
        IO.print(letter + (letter != 'z' ? ", " : "\n"));
        letter++;
    }
}

/**
 * Imprime el abecedario en minúsculas, separadas por comas, sin vocales
 */
void series8() {
    char letter = 'a';
    while (letter <= 'z') {
        switch (letter) {
            case 'a', 'e', 'i', 'o', 'u' -> {}
            default -> IO.print(letter);
        }
        IO.print((letter != 'z' ? ", " : "\n"));
        letter++;
    }
}


void main() {
    //series6();
    series7();
    series8();

}