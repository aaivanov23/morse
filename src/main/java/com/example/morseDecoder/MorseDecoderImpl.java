package com.example.morseDecoder;

import java.util.HashMap;
import java.util.Map;

public class MorseDecoderImpl implements MorseDecoder {
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
    public void decoder(String msg) {
        StringBuilder result = new StringBuilder();
        String[] s = msg.split(" ");
        int count = 0;
        for (String item : s) {
            if (item.equals("")) {
                count++;
                if (count == 3) {
                    result.append(" ");
                    count = 0;
                }
            }
            for (Map.Entry<Character, String> entry : morseCode.entrySet()) {
                if (entry.getValue().equals(item)) {
                    result.append(entry.getKey());
                }
            }
        }

        System.out.println(result.toString());
    }
}
