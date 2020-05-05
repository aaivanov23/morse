package com.netcracker;

import com.netcracker.morseEncoder.MorseEncoder;
import com.netcracker.morseEncoder.MorseEncoderImpl;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

//        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        MorseEncoder morseEncoder = new MorseEncoderImpl();

        // Menu
        System.out.println("[1] Ввод данных в консоль, получение закодированных данных в консоль");
        System.out.println("[2] Ввод кода Морзе в консоль, получение декодированных данных в консоль");
        System.out.println("[3] Выбор файла с данными, получение закодированных данных в консоль");
        System.out.println("[4] Ввод текста в консоль, сохранение закодированных данных в файл");
        System.out.println("[5] Выбор файла с закодированными данными, получение декодированных данных в консоль");
        System.out.println("[6] Выбор файла с данными, сохранение закодированных данных в файл");
        System.out.println("[7] Выбор файла с кастомным набором для шифрования, выбор файла с данными, сохранение закодированных данных в файл");

        System.out.println("Выберите цифру: ");
        int action = scanner.nextInt(); // example '4'
        System.out.println();

        if (action == 1) {
            morseEncoder.encodeFromConsoleToConsole();
        } else if (action == 3) {
            morseEncoder.encodeFromFileToConsole();
        } else if(action == 4) {
            morseEncoder.encodeFromConsoleToFile();
        }else {
            System.out.println("Функциаонал находится в разработке");
        }
    }
}
