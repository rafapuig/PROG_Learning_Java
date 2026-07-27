void main() {

    // Declarar una variable
    // - con identificador num1
    // - de tipo int
    int num1;

    // Declaración de la variable num2
    /*tipo de dato*/ int /*identificador*/ num2;

    /* Guardar (asignar) un valor (12) de tipo entero
       en espacio de memoria utilizado por la variable num1 */
    num1 = 12;

    /* No podemos asignar un valor con decimales (es de otro tipo)
       El valor a asignar no es del tipo de la variable!!!
       Java es un lenguaje fuertemente tipado y por eso no lo permite */
    //num1 = 12.5; // Error
    //num1 = 'X'; // Porque si permite un caracter?????

    //num1 = "ABC"; // Error, no es valor de tipo int

    num2 = 25;

    IO.println(num1); // Leemos el valor de num1 y lo imprimimos
    IO.println(num2); // Lo mismo con el valor de num2

    int num3;
    num3 = num1 + num2; // Operación + con 2 valores enteros

    IO.println(num3);
}