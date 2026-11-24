void main() {
    int[] numbers = new int[10];

    //Generar
    for (int i = 0; i < numbers.length; i++) {
        numbers[i] = (int) (Math.random() * 50 + 1);
    }

    // Imprimir
    for (int i = 0; i < numbers.length; i++) {
        IO.print(i != 0 ? ", " : "");
        IO.print(numbers[i]);
    }
    IO.println();

    String input = IO.readln("Dime un numero entre 1 y 50");
    int number = Integer.parseInt(input);

    // Busqueda
    boolean found = false;

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] != number) continue;
        found = true;
        break;
    }
    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == number) {
            found = true;
            break;
        }
    }

    IO.println("El número " + number + (found ? " " : " no ") + "está en el array");

}



