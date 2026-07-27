void main() {
    /* Leemos la entrada del usuario
    y la almacenamos en la variable name
     */
    var name = IO.readln("Dime tu nombre: ");

    /* Imprimimos Hola,
    seguido de lo que hemos guardado en la variable name
    En este caso, si no hacemos uso del operador de concatenación
    Tenemos que imprimir primero sin el salto de línea: `Hola, `
    y luego el contenido de la variable name ya con salto de línea
     */
    IO.print("Hola, "); // IO.print Imprime un texto sin salto de línea
    IO.println(name); // IO.println Imprime un texto y luego además un salto de línea
}