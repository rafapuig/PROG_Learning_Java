package exercises.exercise_06.helpers;

public class CharArrayHelpers {

    /**
     * printCharacter
     * @param chars
     * @param separator
     */
    public static void printCharacters(char[] chars, String separator) {
        for (int i = 0; i < chars.length; i++) {
            if (i != 0) IO.print(separator);
            IO.print(chars[i]);
        }
        IO.println();
    }

    /**
     * replace
     * @param chars
     * @param replacement
     * @param ignoreSpaces
     * @return
     */
    public static char[] replace(char[] chars, char replacement,  boolean ignoreSpaces ) {
        char[] result = new char[chars.length];
        for (int i = 0; i < result.length; i++) {
            if (ignoreSpaces && chars[i] == ' ') result[i] = ' ';
            else result[i] = replacement;
        }
        return result;
    }

    /**
     * matchesCount
     * @param chars
     * @param character
     * @return
     */
    public static int matchesCount(char[] chars, char character) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if( chars[i] == character) count++;
        }
        return count;
    }

    /**
     * contains
     * @param text
     * @param character
     * @return
     */
    public static boolean contains(char[] text, char character) {
        for (int i = 0; i < text.length; i++) {
            if (text[i] == character) return true;
        }
        return false;
    }

    /***
     * unmaskCharacter
     * @param masked
     * @param clear
     * @param character
     * @return
     */
    public static char[] unmaskCharacter(char[] masked, char[] clear, char character) {
        char[] result = new char[clear.length];
        for (int i = 0; i < clear.length; i++) {
            if (clear[i] == character) result[i] = character;
            else result[i] = masked[i];
        }
        return result;
    }

    /**
     * apppend
     * Crea una copia del array añadiéndole al final el carácter proporcionado
     * @param chars
     * @param character
     * @return
     */
    public static char[] append(char[] chars, char character) {
        char[] copy = new char[chars.length + 1];
        //System.arraycopy(chars, 0, copy, 0, chars.length);
        for (int i = 0; i < chars.length; i++) {
            copy[i] = chars[i];
        }
        copy[chars.length] = character;
        return copy;
    }
}
