package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseCommonHelper {
    protected static final Map<Character, String> morseCode = new HashMap<>() {{
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

    protected ArrayList<Character> readDataFromFile(String path) {
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
}
