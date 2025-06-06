package com.wheatherapi.encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encryption {
    public static void main(String[] args) throws Exception {
        SecretKey secretKey1 = keyGeneration();
        String encryptApi = encryptApi(secretKey1);
        decryptApi(secretKey1, encryptApi);

    }

    public static SecretKey keyGeneration() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        String key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println(key);
        return secretKey;
    }

    public static SecretKey decodeSecretKey(String secretKey) {
        byte[] decodedKey = Base64.getDecoder().decode(secretKey);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        return originalKey;

    }

    public static String encryptApi(SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        String secretApi = "076542489b7542299d1200203250703";
        byte[] encryptedApi = cipher.doFinal(secretApi.getBytes());
        String encodedMessage = Base64.getEncoder().encodeToString(encryptedApi);
        return encodedMessage;
    }

    public static String decryptApi(SecretKey secretKey, String encodedMessage) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encodedMessage));
        String decryptedMessage = new String(decryptedBytes);
        return decryptedMessage;

    }

}
