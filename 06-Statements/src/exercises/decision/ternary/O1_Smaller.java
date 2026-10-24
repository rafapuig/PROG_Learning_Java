/**
 * Escribe un programa que lea dos enteros y muestre el menor
 */

void main() {

    int x = Integer.parseInt(IO.readln("Dame el valor del entero X: "));
    int y = Integer.parseInt(IO.readln("Dame el valor del entero Y: "));

    int menor = x < y ? x : y;

    IO.println("El menor entre " + x +  " y " + y + " es " + menor);
}