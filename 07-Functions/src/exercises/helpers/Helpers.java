package exercises.helpers;

public class Helpers {

    private Helpers() {
    }

    public static int random(int minInclusive, int maxInclusive) {
        return (int) (Math.random() * (maxInclusive + 1 - minInclusive)) + minInclusive;
    }

    private static int findMaxWithoutRepetitionBy(final int[] values, int lowest, int highest) {
        int[] times = new int[highest - lowest + 1];

        for (int i = 0; i < values.length; i++) {
            times[values[i] - lowest]++;
        }

        int position = -1;
        for (int max = highest; max >= lowest; max--) {
            if (times[max - lowest] != 1) continue;

            for (int i = 0; i < values.length; i++) {
                if (values[i] == max) {
                    position = i;
                    break;
                }
            }
            break;
        }
        return position;
    }

    private static int findMaxWithoutRepetitionBy(final int[] values) {

        int max = Integer.MIN_VALUE;
        int posicion = -1;

        for (int i = 0; i < values.length; i++) {

            if (values[i] <= max) continue; // Si no es mayor que el máximo continuamos con el siguiente

            int contador = 0; // Vamos a contar cuantas veces aparece ese valor máximo
            for (int j = 0; j < values.length; j++) {
                if (values[j] == values[i]) contador++;
            }

            // Si solamente aparece una vez
            if (contador == 1) {
                max = values[i]; // Lo consideramos como nuevo máximo único
                posicion = i; // y asignamos la posicion donde lo hemos encontrado
            }

        }
        return posicion;
    }

    private static int findMaxWithRepetitionBy(final int[] values) {
        int position = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
                position = i;
            }
        }
        return position;
    }

    public static int findMaxBy(final int[] values, boolean withoutRepetition) {
        return withoutRepetition ?
                findMaxWithoutRepetitionBy(values) :
                findMaxWithRepetitionBy(values);
    }

}
