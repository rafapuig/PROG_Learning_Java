package exercises.exercise_06.helpers;

public class Helpers {

    public static String replaceAt(String text, char character, int index) {
        return replaceAtStringBuilderImpl(text, character, index);
    }

    private static String replaceAtConcatenationImpl(String text, char character, int index) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (i != index) result += text.charAt(i);
            else result += character;
        }
        return result;
    }

    private static String replaceAtStringBuilderImpl(String text, char character, int index) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i != index) result.append(text.charAt(i));
            else result.append(character);
        }
        return result.toString();
    }



    public static String replace(String text, char character) {
        return replaceStringBuilderImplOptimization2(text, character);
    }

    private static String replaceConcatenationImpl(String text, char character) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            result += character;
        }
        return result;
    }

    private static String replaceStringBuilderImpl(String text, char character) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(character);
        }
        return result.toString();
    }

    private static String replaceStringBuilderImplOptimization1(String text, char character) {
        StringBuilder result = new StringBuilder();
        result.repeat(String.valueOf(character), text.length());
        return result.toString();
    }

    private static String replaceStringBuilderImplOptimization2(String text, char character) {
        return String.valueOf(character).repeat(text.length());
    }


    public static String replace(String text, char character, boolean replaceSpaces) {
        return replaceStringBuilderImpl(text, character, replaceSpaces);
    }

    private static String replaceStringConcatenationImpl(String text, char character, boolean replaceSpaces) {
        final char space = ' ';
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (replaceSpaces && text.charAt(i) == space) result += space;
            else result += character;
        }
        return result;
    }

    private static String replaceStringBuilderImpl(String text, char character, boolean replaceSpaces) {
        final char space = ' ';
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (replaceSpaces && text.charAt(i) == space) result.append(space);
            else result.append(character);
        }
        return result.toString();
    }

    /**
     * contains
     * Busca el carácter letter en la String text y devuelve true si al menos encuentra una vez el carácter
     *
     * @param text
     * @param letter
     * @return
     */
    private static boolean contains_v1(String text, char letter) {
        boolean found = false;
        for (int i = 0; i < text.length(); i++) {
            if (letter != text.charAt(i)) continue;
            found = true;
            break;
        }
        return found;
    }

    public static boolean contains(String text, char letter) {
        for (int i = 0; i < text.length(); i++) {
            if (letter == text.charAt(i)) return true;
        }
        return false;
    }

    public static int matchesCount(String text, char character) {
        int matches = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == character) matches++;
        }
        return matches;
    }


    private static String uncoverLetter(String maskedWord, char letter, int position) {
        return replaceAt(maskedWord, letter, position);
    }

    /**
     * uncoverMaskedLetterInefficient
     * Sustituye el carácter en la maskedWord por el carácter letter
     * en cada posición en la que encuentra el carácter letter en el String word
     *
     * Es ineficiente porque se apoya en la función uncoverLetter
     * y esto implica crear una nueva versión de la palabra enmascarada cada vez que se encuentra
     * una aparición de la letra en word
     * @param maskedWord
     * @param word
     * @param letter
     * @return
     */
    private static String uncoverMaskedLetterInefficient(String maskedWord, String word, char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != letter) continue;
            // Descubrir la letra en la maskedWord
            maskedWord = uncoverLetter(maskedWord, letter, i);
        }
        return maskedWord;
    }


    /**
     * unmaskLetterDirectly
     * Sustituye el carácter en la maskedWord por el carácter letter
     * en cada posición en la que encuentra el carácter letter en el String word
     *
     * Al contrario que uncoverMaskedLetterInefficient
     * no crea una nueva palabra enmascarada cada vez que sustituye una aparición de la letra letter en word
     * Crea directamente la palabra enmascarada resultante final de manera directa
     * @param maskedWord
     * @param word
     * @param letter
     * @return
     */
    private static String unmaskLetterDirectly(String maskedWord, String word, char letter) {
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != letter) result += maskedWord.charAt(i);
            else result += word.charAt(i);
        }
        return result;
    }

    /**
     * unmaskLetterDirectlyStringBuilderImpl
     * Sustituye el carácter en la maskedWord por el carácter letter
     * en cada posición en la que encuentra el carácter letter en el String word
     *
     * Al contrario que uncoverMaskedLetterInefficient
     * no crea una nueva palabra enmascarada cada vez que sustituye una aparición de la letra letter en word
     * Crea directamente la palabra enmascarada resultante final de manera directa
     *
     * Como usa StringBuilder es más eficiente que concatenar Strings,
     * ya que el propio String result se genera una vez llamando al final a toString()
     * @param maskedWord
     * @param word
     * @param letter
     * @return
     */
    private static String unmaskLetterDirectlyStringBuilderImpl(String maskedWord, String word, char letter) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != letter) result.append(maskedWord.charAt(i));
            else result.append(word.charAt(i));
        }
        return result.toString();
    }

    public static String unmaskLetter(String maskedWord, String word, char letter) {
        return unmaskLetterDirectlyStringBuilderImpl(maskedWord, word, letter);
    }


    /**
     * Función de utilidad genérica para imprimir los caracteres de un String
     * separados entre sí por el separador
     * @param text
     * @param separator
     */
    private static void printCharacters_v1(String text, String separator) {
        for (int i = 0; i < text.length(); i++) {
            if (i != 0) IO.print(separator);
            IO.print(text.charAt(i));
        }
        IO.println();
    }

    /**
     * Función de utilidad genérica para imprimir los caracteres de un String
     * separados entre sí por el separador (sola una llamada final al método de I/O println)
     * @param text
     * @param separator
     */
    private static void printCharactersConcatenationImpl(String text, String separator) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (i != 0) result += separator;
            result += text.charAt(i);
        }
        IO.println(result);
    }

    /**
     * Función de utilidad genérica para imprimir los caracteres de un String
     * separados entre sí por el separador (sola una llamada final al método de I/O println)
     * Y optimizada por usar StringBuilder
     * @param text
     * @param separator
     */
    private static void printCharactersStringBuilderImplementation(String text, String separator) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i != 0) result.append(separator);
            result.append(text.charAt(i));
        }
        IO.println(result.toString());
    }

    public static void printCharacters(String text, String separator) {
        printCharactersStringBuilderImplementation(text, separator);
    }

}
