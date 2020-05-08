package com.example.morseDecoder;

import com.example.MorseCommonHelper;

import java.util.HashMap;
import java.util.Map;

public class MorseDecoderImpl extends MorseCommonHelper implements MorseDecoder {
    @Override
    public String decoder(String msg) {
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

        return result.toString();
    }

    public void decodeFromConsoleToConsole() {
        String result = decoder(readDataFromConsole());
        System.out.println(result);
    }
}
