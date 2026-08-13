/**
 * El parsing a valor boolean solamente da como resultado el valor true
 * cuando el texto está exactamente compuesto por 4 caracteres `true`
 * sin importar mayúsculas o minúsculas
 */

void booleanParsing() {
    boolean bool1 = Boolean.parseBoolean("true");
    boolean bool3 = Boolean.parseBoolean("True"); // Se ignora el "Case" version mayusculas o minusculas

    boolean bool2 = Boolean.parseBoolean("false");
    boolean bool4 = Boolean.parseBoolean("verdadero"); // false
    boolean bool5 = Boolean.parseBoolean(""); // false
    boolean bool6 = Boolean.parseBoolean(null); // false
    boolean bool7 = Boolean.parseBoolean("true "); // El espacio adicional hace que sea false
    boolean bool8 = Boolean.parseBoolean(" true");
    boolean bool9 = Boolean.parseBoolean("tru"); // Le falta la letra e al final

    IO.println(bool1);
    IO.println(bool2);
    IO.println(bool3);
    IO.println(bool4);
    IO.println(bool5);
    IO.println(bool6);
    IO.println(bool7);
    IO.println(bool8);
    IO.println(bool9);
}

void main() {
    booleanParsing();
}