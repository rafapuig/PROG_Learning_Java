package exercises.exercise_06.helpers;

import java.util.Arrays;

public class ArrayHelpers {

    /**
     * printCharacter
     *
     * @param items
     * @param separator
     */
    public static <T> void print(T[] items, String separator) {
        for (int i = 0; i < items.length; i++) {
            if (i != 0) IO.print(separator);
            IO.print(items[i]);
        }
        IO.println();
    }

    /**
     * replace
     *
     * @param items
     * @param replacement
     * @param ignoreSpaces
     * @return
     */
    public static <T> T[] replace(T[] items, T replacement, boolean ignoreSpaces) {
        T[] result = Arrays.copyOf(items, items.length);
        for (int i = 0; i < result.length; i++) {
            if (items[i].equals(' ')) result[i] = items[i];
            else result[i] = replacement;
        }
        return result;
    }

    /**
     * matchesCount
     *
     * @param items
     * @param element
     * @return
     */
    public static <T> int matchesCount(T[] items, T element) {
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == element) count++;
        }
        return count;
    }

    /**
     * contains
     *
     * @param items
     * @param element
     * @return
     */
    public static <T> boolean contains(T[] items, T element) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == element) return true;
        }
        return false;
    }

    /***
     * unmaskCharacter
     * @param masked
     * @param clear
     * @param element
     * @return
     */
    public static <T> T[] unmaskCharacter(T[] masked, T[] clear, T element) {
        T[] result = Arrays.copyOf(clear, clear.length);
        for (int i = 0; i < clear.length; i++) {
            if (clear[i] == element) result[i] = element;
            else result[i] = masked[i];
        }
        return result;
    }

    /**
     * apppend
     * Crea una copia del array añadiéndole al final el carácter proporcionado
     *
     * @param items
     * @param element
     * @return
     */
    public static <T> T[] append(T[] items, T element) {
        T[] copy = Arrays.copyOf(items, items.length + 1);
        //System.arraycopy(chars, 0, copy, 0, chars.length);
        for (int i = 0; i < items.length; i++) {
            copy[i] = items[i];
        }
        copy[items.length] = element;
        return copy;
    }
}
