package com.wheatherapi.encryption;

import utils.GetApiKey;

import javax.crypto.*;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encryption {
    public static void main(String[] args) throws Exception {
        // Генерация ключа для шифрования
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // Указываем размер ключа
        SecretKey secretKey = keyGenerator.generateKey();

        // Создание экземпляра Cipher для алгоритма AES
        Cipher cipher = Cipher.getInstance("AES");

        // Инициализация Cipher в режиме шифрования с нашим ключом
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        String secretMessage = "Это секретное сообщение";
        byte[] encryptedMessage = cipher.doFinal(secretMessage.getBytes());

        // Преобразование зашифрованного сообщения в строку для отправки
        String encodedMessage = Base64.getEncoder().encodeToString(encryptedMessage);
        System.out.println("Зашифрованное сообщение: " + encodedMessage);

        // Инициализация Cipher в режиме дешифрования
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encodedMessage));
        String decryptedMessage = new String(decryptedBytes);
        System.out.println("Расшифрованное сообщение: " + decryptedMessage);

        System.out.println();

        //encryptApi();
        decryptApi(keyGeneration(), encryptApi());
    }


    public static SecretKey keyGeneration() throws NoSuchAlgorithmException {
        // Генерация ключа для шифрования
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // Указываем размер ключа
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println(secretKey);
        return secretKey;
    }

    public static String encryptApi() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKey secretKey = keyGeneration();

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
