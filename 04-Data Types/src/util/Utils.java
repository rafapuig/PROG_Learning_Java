package util;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Utils {

    public static String representation(int number) {
        var binaryString = Integer.toBinaryString(number);
        var leadingZeros = Integer.numberOfLeadingZeros(number) - (number == 0 ? 1 : 0);
        return "0".repeat(leadingZeros) + binaryString;
    }

    public static String bits(byte b) {
        return String
                .format("%8s", Integer.toBinaryString(b & 0xFF))
                .replace(' ', '0');
    }

    public static String bits(char c) {
        return String
                .format("%16s", Integer.toBinaryString(c))
                .replace(' ', '0');
    }

    public static String bits(short s) {
        return String
                .format("%16s", Integer.toBinaryString(s & 0xFFFF))
                .replace(' ', '0');
    }

    public static String representation(float number) {
        var rawBits = Float.floatToRawIntBits(number);
        return representation(rawBits);
    }

    public static String binRepresentation(float number) {
        return binRepresentation(number, false);
    }

    public static String binRepresentation(float number, boolean separateFields) {
        var rawBits = Float.floatToRawIntBits(number);
        var rawString = String.format("%32s",
                Integer.toBinaryString(rawBits)).replace(' ', '0');

        if (!separateFields) return rawString;

        /**
         * Ponemos espacios en el signo exponente y mantisa
         */
        StringBuilder sb = new StringBuilder();
        sb.append(rawString, 0, 1); // Empezamos por el signo
        sb.append(" ");
        sb.append(rawString, 1, 1 + 8);
        sb.append(" ");
        sb.append(rawString.substring(1 + 8));
        return sb.toString();
    }

    public static String hexRepresentation(float number) {
        var rawBits = Float.floatToRawIntBits(number);
        return String.format("0x%08X", rawBits);

    }

    public static void printBinaryRepresentation(Object number) {
        switch (number.getClass().getSimpleName()) {
            case "Integer":
                IO.println(Utils.representation((int) number));
                break;
            case "Float":
                IO.println(Utils.representation((float) number));
                break;
        }
    }

    public static String insertSpace(String texto, int blockSize) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < texto.length(); i += blockSize) {

            if (i > 0) {
                sb.append(' ');
            }

            sb.append(texto, i, Math.min(i + blockSize, texto.length()));
        }

        return sb.toString();
    }


    public static BigDecimal exactFloat(float f) {
        int bits = Float.floatToRawIntBits(f);

        int sign = (bits >>> 31) & 1;
        int exp = (bits >>> 23) & 0xFF;
        int frac = bits & 0x7FFFFF;

        if (exp == 255)
            throw new IllegalArgumentException("NaN o infinito");

        BigInteger mantissa;
        int exponent;

        if (exp == 0) {
            // Subnormal
            mantissa = BigInteger.valueOf(frac);
            exponent = -149;
        } else {
            // Normal
            mantissa = BigInteger.valueOf((1 << 23) | frac);
            exponent = exp - 127 - 23;
        }

        BigDecimal value;

        if (exponent >= 0) {
            value = new BigDecimal(mantissa.shiftLeft(exponent));
        } else {
            BigInteger denominator = BigInteger.ONE.shiftLeft(-exponent);
            value = new BigDecimal(mantissa)
                    .divide(new BigDecimal(denominator));
        }

        return sign == 1 ? value.negate() : value;
    }

    public static void printExactFloat(float number) {
        IO.println(exactFloat(number).toPlainString());
    }

    public static String exactFloatStored(float number) {
        return exactFloat(number).toPlainString();
    }

}
