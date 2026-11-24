void main() {

    int[] numbers = new int[5];

    for (int i = 0; i < numbers.length; i++) {
        String input = IO.readln("Dame el numero " + (i + 1) + ":");
        numbers[i] = Integer.parseInt(input);
    }

    for (int number : numbers) {
        IO.println(number);
    }

}
