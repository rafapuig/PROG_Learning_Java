/**
 * La instrucción do-while (bucle do-while)
 * <p>
 * Instrucción de repetición (bucle)
 * <p>
 * Sintaxis:
 * <p>
 * do
 * instrucción
 * while (condición);
 * <p>
 * NOTA:
 * - La instrucción do-while termina con un ;
 * - La instrucción asociada puede ser una instrucción simple o un bloque.
 * <p>
 * La instrucción asociada al do-while se ejecuta al menos una vez,
 * si la condición se evalúa a false la primera vez.
 * <p>
 * Primero se ejecuta la instrucción y después se comprueba si hay que repetir de nuevo.
 * Se puede usar la instrucción break para salir del bucle do-while.
 * <p>
 * ¿Cuándo es recomendable usar u do-while?
 * - Cuando condición depende de valores que se calculan dentro del bucle (en la instrucción asociada)
 */

void autoGuessNumber() {
    int number = 5;
    int guess;
    do {
        guess = (int) Math.floor(Math.random() * 10 + 1);
        IO.println("Es el " + guess + "?");
    } while (guess != number);
    IO.println("Acertaste");
}


void userInput1() {
    int age;
    do {
        age = Integer.parseInt(IO.readln("Dime la edad: "));  // Problema con cadena vacía
    } while (age < 0 || age > 150);
}


void userInput2() {
    int age = -1;

    do {
        String input = IO.readln("Dime la edad: ");
        if (input.isEmpty()) {
            IO.println("Por favor, ingrese un número valido");
            continue;
        }
        age = Integer.parseInt(IO.readln("Dime la edad: "));
    } while (age < 0 || age > 150);
}


void userInput() {
    int age = -1;
    do {
        try {
            age = Integer.parseInt(IO.readln("Dime la edad: "));
        } catch (NumberFormatException e) {
            IO.println("Por favor, ingrese un número valido");
            continue;
        }

        if (age < 0) {
            IO.println("Por favor, ingrese un valor positivo");
            continue;
        }

        if (age > 150) {
            IO.println("Por favor, ingrese un valor que no supere 150");
        }
    } while (age < 0 || age > 150);
}

void menu() {
    boolean exit = false;
    do {
        IO.println("1. Saludar");
        IO.println("2. Despedirse");
        IO.println("0. Salir");

        String input = IO.readln("Por favor, selecciona una opción: ");
        switch (input) {
            case "1" -> IO.println("Hola, que tal?");
            case "2" -> IO.println("Hasta otra!");
            case "0" -> exit = true;
        }

    } while (!exit);
}

void main() {
    //userInput1();
    //autoGuessNumber();
    menu();
}