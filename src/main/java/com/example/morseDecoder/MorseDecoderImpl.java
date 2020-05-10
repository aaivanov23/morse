package com.example.morseDecoder;

import com.example.MorseCommonHelper;

import java.util.Map;

public class MorseDecoderImpl implements MorseDecoder {
    @Override
    public String decoder(String code) {
        StringBuilder result = new StringBuilder();
        String[] s = code.split(" ");
        int count = 0;
        for (String item : s) {
            if (item.equals("")) {
                count++;
                if (count == 3) {
                    result.append(" ");
                    count = 0;
                }
            }
            for (Map.Entry<Character, String> entry : MorseCommonHelper.morseCode.entrySet()) {
                if (entry.getValue().equals(item)) {
                    result.append(entry.getKey());
                }
            }
        }

        return result.toString();
    }
}
