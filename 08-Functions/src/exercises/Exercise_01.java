/**
 * Escribe un método con nombre sumRecursive que acepte un número entero mediante un parámetro de entrada
 * y devuelva la suma de los números desde el 1 hasta ese número incluido.
 * <p>
 * Escribe un programa que pida al usuario un numero positivo y haciendo uso del método anterior
 * obtenga la suma desde 1 hasta el numero introducido por el usuario y lo muestre por consola.
 */

long sumRecursive(int toNumber) {
    if (toNumber == 1) return 1;
    return toNumber + sumRecursive(toNumber - 1);
}

int readPositiveNumber(String prompt) {
    while (true) {
        try {
            final String input = IO.readln(prompt);
            final int number = Integer.parseInt(input);
            if (number > 0) return number;

            throw new RuntimeException();

        } catch (RuntimeException e) {
            IO.println("Por favor, introduce un número entero positivo");
        }
    }
}

void main() {
    final int number = readPositiveNumber("Introduce el número (n) del cual obtener la suma de 1 a n: ");
    final long result = sumRecursive(number);
    IO.println("La suma desde 1 hasta " + number + " es: " + result);
}