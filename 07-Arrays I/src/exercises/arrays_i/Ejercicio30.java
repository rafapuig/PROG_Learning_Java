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

    boolean duplicated = false;
    // Hay repetidos
    outerloop:
    for (int i = 0; i < numbers.length; i++) {
        for (int j = i + 1; j < numbers.length; j++) {
           if (numbers[i] == numbers[j]) {
               duplicated = true;
               break outerloop;
           }
       }
    }
    if (duplicated) {
        IO.println("Hay números repetidos");
    }

}



