package com.example.morseEncoder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseEncoderImpl implements MorseEncoder {
    private static final Map<Character, String> morseCode = new HashMap<>() {{
        put('a', ".-");
        put('b', "-...");
        put('c', "-.-.");
        put('d', "-..");
        put('e', ".");
        put('f', "..-.");
        put('g', "--.");
        put('h', "....");
        put('i', "..");
        put('j', ".---");
        put('k', "-.-");
        put('l', ".-..");
        put('m', "--");
        put('n', "-.");
        put('o', "---");
        put('p', ".--.");
        put('q', "--.-");
        put('r', ".-.");
        put('s', "...");
        put('t', "-");
        put('u', "..-");
        put('v', "...-");
        put('w', ".--");
        put('x', "-..-");
        put('y', "-.--");
        put('z', "--..");
        put(' ', "  ");
    }};

    @Override
    public void encodeFromConsoleToConsole() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Please enter message: ");
        String msg = scanner1.nextLine();
        StringBuilder result = new StringBuilder();
        char[] charArray = msg.toLowerCase().toCharArray();

        for (char c : charArray) {
            result.append(morseCode.get(c)).append(" ");
        }

        System.out.println(result.toString());
    }

    @Override
    public void encodeFromFileToConsole() {
        Scanner scanner1 = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        System.out.println("Введите абсолютный путь до файла: ");
        String path = scanner1.nextLine();
        try (FileInputStream fin = new FileInputStream(path);) {
            int i;
            do {
                i = fin.read();
                if (i != -1) result.append(morseCode.get((char) i)).append(" ");
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("Файла по указанному пути не существует");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result.toString());
    }

    @Override
    public void encodeFromConsoleToFile() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите сообщение: ");
        String msg = scanner1.nextLine();
        System.out.println();
        System.out.println("Введите абсолютный путь до файла: ");
        String path = scanner1.nextLine();
        try (FileOutputStream fout = new FileOutputStream(path)) {
            char[] charArray = msg.toLowerCase().toCharArray();
            for (char c : charArray) {
                String code = morseCode.get(c) + " ";
                char[] arr = code.toCharArray();
                for (char c1 : arr) {
                    fout.write(c1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
