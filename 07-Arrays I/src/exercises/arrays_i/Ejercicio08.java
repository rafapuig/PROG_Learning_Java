void main() {
    int[] numbers = {10, 20, 30, 40, 50};

    int temp;

    // Intercambio
    temp = numbers[0];
    numbers[0] = numbers[4];
    numbers[4] = temp;

    IO.println(numbers[0]);
    IO.println(numbers[4]);
}