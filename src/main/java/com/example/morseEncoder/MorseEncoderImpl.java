package com.example.morseEncoder;

import com.example.MorseCommonHelper;

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
        System.out.println("Please enter absolute path to the file: ");
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
        StringBuilder result = new StringBuilder();
        System.out.println("Please enter message: ");
        String msg = scanner1.nextLine();
        System.out.println();
        System.out.println("Please enter absolute path to the file: ");
        String path = scanner1.nextLine();

        char[] msgCharsArray = msg.toLowerCase().toCharArray();
        for (char item : msgCharsArray) {
            result.append(morseCode.get(item)).append(" ");
        }

        saveDataToFile(path, result.toString());
    }
}
