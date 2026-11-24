void main() {
    int[] numbers = new int[6];

    //Generar
    for (int i = 0; i < numbers.length; i++) {
        numbers[i] = (int) (Math.random() * 100 + 1);
    }

    // Imprimir
    for (int i = 0; i < numbers.length; i++) {
        IO.print(i != 0 ? ", " : "");
        IO.print(numbers[i]);
    }

    int max = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
        if(numbers[i] > max){
            max = numbers[i];
        }
    }
    IO.print("El mayor es " + max);
}
