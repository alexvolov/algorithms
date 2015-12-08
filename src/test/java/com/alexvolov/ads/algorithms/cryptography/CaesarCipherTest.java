package com.alexvolov.ads.algorithms.cryptography;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for {@link com.alexvolov.ads.algorithms.cryptography.CaesarCipher}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 08/12/15
 */
public class CaesarCipherTest {

    @Test
    public void testDecodeEncode() throws Exception {
        // data
        final int shift = 90;
        String originalText = "qwertyuiop[]asdfghjkl;'zxcvbnm,./1234567890!@#$%^&*()_+ZXXXCCQWERTYUIOP{}:LKJHGFDS" +
                "AZXCVBNM<>?";

        // test
        String decodedText = CaesarCipher.decode(originalText, shift);

        // verify
        String encodedText = CaesarCipher.encode(decodedText, shift);
        assertEquals("Encoded text doesn't equal to original text!", originalText, encodedText);
    }

}