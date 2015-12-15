package com.alexvolov.ads.algorithms.cryptography;

/**
 * Simple implementation of cryptography algorithm
 * known as the Caesar cipher.
 *
 * Created by Alexander on 08/12/15.
 */
public final class CaesarCipher {

    /**
     * Encodes given text using shift.
     *
     * @param text any not null string.
     * @param shift any positive integer.
     * @return encoded string.
     */
    public static String encode(String text, int shift) {
        return cipher(false, text, shift);
    }

    /**
     * Decodes given text using shift.
     *
     * @param text any not null string.
     * @param shift any positive integer.
     * @return decoded string.
     */
    public static String decode(String text, int shift) {
        return cipher(true, text, shift);
    }

    private static int getCode(String text, int position) {
        return text.charAt(position) ;
    }

    private static String cipher(boolean decode, String text, int shift) {
        if (shift < 0) {
            throw new RuntimeException("The shift must be positive!");
        }

        StringBuffer sb = new StringBuffer("");
        char letter;
        int sign = 1;

        if (decode) {
            sign = -1;
        }

        for (int i = 0; i < text.length(); i++) {
            letter = (char) ((getCode(text, i) - shift * sign) % 255);
            sb.append(letter);
        }

        return sb.toString();
    }

}
