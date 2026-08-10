/**
 * La instrucción while
 * <p>
 * Es una instrucción de repetición (bucle, loop)
 * basándose en el resultado de evaluar una condición
 * <p>
 * Sintaxis
 * <p>
 * while (condición)
 * instrucción
 * <p>
 * La instrucción de while se repite una y otra vez mientras se cumpla la condición
 * (el resultado de evaluarla sea true)
 * <p>
 * Primero se comprueba una condición y después se procede con la acción si se cumple
 * (pero a diferencia del if que una vez realizado o no la acción se continúa con la siguiente instrucción)
 * en el bucle while si la condición fue cierta, tras ejecutar la instrucción se vuelve atrás a evaluar
 * de nuevo la condición y si se sigue cumpliendo se volverá de nuevo a ejecutar la instrucción
 * y así hasta que la condición deje de cumplirse.
 * <p>
 * La instrucción puede ser un bloque de instrucciones (nuevamente funciona como una unica instrucción compuesta)
 * <p>
 * NOTA:
 * Si la primera vez que se evalúa la condición el resultado es false, la instrucción no llegará a ejecutarse
 * ni siquiera una sola vez.
 * <p>
 * NOTA 2:
 * Si no hacemos algo dentro de la instrucción del while que haga que la condición cambie
 * la condición se seguirá cumpliendo eternamente
 * y nunca terminaremos de repetir el bucle --> bucle infinito
 * a no ser que usemos alguna instrucción del control de flujo
 * que nos permita saltar el flujo fuera del bucle (salir del bucle)
 */

void infiniteLoop() {
    while (true) {
        IO.println("Bucle infinito...");
    }
}

void infiniteLoop2() {
    int count = 0;
    while (true) {
        count++;
        IO.println("Repetición numero " + count);
    }
}

void whileNotTenMultiple() {
    int number = 26;

    while (number % 10 != 0) {
        IO.println(number + " no es múltiplo de 10, incrementado...");
        number++;
    }

    IO.println(number);
}

void digitFrom0To9() {
    char digit = '0'; // Primer valor
    while (digit <= '9') { // Mientras el código del dígito sea menor o igual que el del dígito 9
        IO.println(digit);
        digit++; // Cambiar el valor de una variable que participa en la condición para tener la posibilidad de salir del bucle
    }
}

void exitInfinityLoop() {
    while (true) {
        IO.println("Bucle infinito...");
        if (Math.random() < 0.1) break; // Le damos un 10% de probabilidad de salir del bucle
    }
}

/**
 * Equivalente al anterior (siempre hay que tratar de evitar el uso de break en la medida de lo posible)
 * A no ser que el código quede más legible mediante el uso del break
 */
void exitLoop() {
    while (Math.random() >= 0.1) { // Le damos un 10% de probabilidad de salir del bucle
        IO.println("Se ha cumplido la condición ... repetimos");
    }
}

void main() {
    //infiniteLoop();
    //infiniteLoop2();
    //whileNotTenMultiple();
    //digitFrom0To9();
    //exitInfinityLoop();
    exitLoop();

}