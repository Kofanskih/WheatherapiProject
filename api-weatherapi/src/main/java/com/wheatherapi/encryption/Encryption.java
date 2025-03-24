package com.wheatherapi.encryption;

import utils.GetApiKey;

import javax.crypto.*;
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
        // Генерация ключа для шифрования
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // Указываем размер ключа
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println(secretKey.toString());
        return secretKey;
    }

    public static String keyGeneration1() throws NoSuchAlgorithmException {
        // Генерация ключа для шифрования
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // Указываем размер ключа
        SecretKey secretKey = keyGenerator.generateKey();
        String key = secretKey.toString();
        System.out.println(secretKey);
        return key;

    }

    public static String encryptApi(SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        String secretApi = "076542489b7542299d1200203250703";
        byte[] encryptedApi = cipher.doFinal(secretApi.getBytes());

        String encodedMessage = Base64.getEncoder().encodeToString(encryptedApi);
        System.out.println("Зашифрованное сообщение: " + encodedMessage);
        return encodedMessage;
    }

    public static String decryptApi(SecretKey secretKey, String encodedMessage) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encodedMessage));
        String decryptedMessage = new String(decryptedBytes);
        System.out.println("Расшифрованное сообщение: " + decryptedMessage);

        return decryptedMessage;

    }




}
