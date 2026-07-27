void main() {
    /* Leemos la entrada del usuario
    y la almacenamos en la variable name
     */
    var name = IO.readln("Dime tu nombre: ");

    /* Imprimimos Hola,
    seguido de lo que hemos guardado en la variable name
    El símbolo + en este caso es el operador de CONCATENACION
    Este operador toma dos textos y crea otro nuevo
    que es el resultado de pegar el segundo a continuación del primero
     */
    IO.println("Hola, " + name);
}