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
    int position = -1;
    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] != number) continue;
        position = i;
        break;
    }

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == number) {
            position = i;
            break;
        }
    }
    if (position == -1) {
        IO.println("El numero " + number + " no esta en el array");
    } else {
        IO.println("El número " + number + " se encuentra en la posición " + position);
    }

}



