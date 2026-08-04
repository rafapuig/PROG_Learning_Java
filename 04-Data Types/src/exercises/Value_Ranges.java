import static util.Utils.bits;

/**
 * Cual es el resultado de la expresión 1.000.000 x 1.000.000
 */

void main() {

    IO.println(1_000_000 * 1_000_000); // -727379968 (hay un overflow, se truncan los bits del 33 en adelante)

    IO.println(bits(1_000_000));
    IO.println(bits(1_000_000 * 1_000_000));

    var isOverflow = 1_000_000 * 1_000_000L > Integer.MAX_VALUE;
    IO.println(isOverflow);


    /**
     * Por qué de esta manera no hay un overflow?
     */
    IO.println(1_000_000 * 1_000_000L);

    IO.println(" ".repeat(32) + bits(1_000_000 * 1_000_000));
    IO.println(bits(1_000_000 * 1_000_000L));
}