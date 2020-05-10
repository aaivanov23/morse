package com.example;

import com.example.morseDecoder.MorseDecoder;
import com.example.morseDecoder.MorseDecoderImpl;
import com.example.morseEncoder.MorseEncoder;
import com.example.morseEncoder.MorseEncoderImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        MorseEncoder morseEncoder = new MorseEncoderImpl();
        MorseDecoder morseDecoder = new MorseDecoderImpl();

        // Menu
        //todo переписать меню на англ язык
        System.out.println("[1] Ввод данных в консоль, получение закодированных данных в консоль");
        System.out.println("[2] Ввод кода Морзе в консоль, получение декодированных данных в консоль");
        System.out.println("[3] Выбор файла с данными, получение закодированных данных в консоль");
        System.out.println("[4] Ввод текста в консоль, сохранение закодированных данных в файл");
        System.out.println("[5] Выбор файла с закодированными данными, получение декодированных данных в консоль");
        System.out.println("[6] Выбор файла с данными, сохранение закодированных данных в файл");

        System.out.println("Please choose number: ");
        int action = scanner.nextInt(); // example '4'
        System.out.println();

        if (action == 1) {
            String text = MorseCommonHelper.readDataFromConsole();
            String code = morseEncoder.encoder(text);
            System.out.println(code);
        } else if (action == 2) {
            String code = MorseCommonHelper.readDataFromConsole();
            String result = morseDecoder.decoder(code);
            System.out.println(result);
        } else if (action == 3) {
            List<Character> list = MorseCommonHelper.readDataFromFile();
            String code = morseEncoder.encoder(list);
            System.out.println(code);
        } else if (action == 4) {
            String text = MorseCommonHelper.readDataFromConsole();
            String code = morseEncoder.encoder(text);
            MorseCommonHelper.saveDataToFile(code);
        } else if (action == 5) {

        } else {
            System.out.println("Функционал находится в разработке");
        }
    }
}
