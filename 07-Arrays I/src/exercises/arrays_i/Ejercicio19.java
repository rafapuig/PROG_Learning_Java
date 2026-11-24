void main() {
    int[] numbers = new int[10];

    //Generar
    for (int i = 0; i < numbers.length; i++) {
        numbers[i] = (int) (Math.random() * 10 - 5);
    }

    // Imprimir
    for (int i = 0; i < numbers.length; i++) {
        IO.print(i != 0 ? ", " : "");
        IO.print(numbers[i]);
    }

    int positiveCounter = 0;
    int negativeCounter = 0;
    int zeroCounter = 0;

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] > 0) {
            positiveCounter++;
        } else if (numbers[i] < 0) {
            negativeCounter++;
        } else {
            zeroCounter++;
        }
    }
    IO.println();

    IO.println("Total positivos: " + positiveCounter);
    IO.println("Total negativos: " + negativeCounter);
    IO.println("Total ceros: " + zeroCounter);
}



