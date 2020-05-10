package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class MorseCommonHelper {
    public static final Map<Character, String> morseCode = new HashMap<>() {{
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

    public static ArrayList<Character> readDataFromFile() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Please enter absolute path to the file: ");
        String path = scanner1.nextLine();

        ArrayList<Character> list = new ArrayList<>();
        int i;
        try (FileInputStream fin = new FileInputStream(path)) {
            do {
                i = fin.read();
                if (i != -1) list.add((char) i);
            } while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void saveDataToFile(String msg) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Please enter absolute path to the file: ");
        String path = scanner1.nextLine();

        try (FileOutputStream fout = new FileOutputStream(path)) {
            char[] charArray = msg.toLowerCase().toCharArray();
            for (char c : charArray) {
                fout.write(c);
            }
            System.out.println("File successfully updated");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readDataFromConsole() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Please enter message: ");
        return scanner1.nextLine();
    }
}
