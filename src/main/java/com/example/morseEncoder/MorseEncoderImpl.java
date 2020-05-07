package com.example.morseEncoder;

import com.example.MorseCommonHelper;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class MorseEncoderImpl extends MorseCommonHelper implements MorseEncoder {
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
        List<Character> list = readDataFromFile(path);
        list.forEach(item -> {
            result.append(morseCode.get(item)).append(" ");
        });
        System.out.println("\nResult:\n" + result.toString());
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
