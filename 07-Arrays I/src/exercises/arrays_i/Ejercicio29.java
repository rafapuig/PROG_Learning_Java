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

    // Invertir
    for (int i = 0; i < numbers.length / 2; i++) {
        int temp = numbers[i];
        numbers[i] = numbers[numbers.length - 1 - i];
        numbers[numbers.length - 1 - i] = temp;
    }

    // Imprimir
    for (int i = 0; i < numbers.length; i++) {
        IO.print(i != 0 ? ", " : "");
        IO.print(numbers[i]);
    }
    IO.println();
}



