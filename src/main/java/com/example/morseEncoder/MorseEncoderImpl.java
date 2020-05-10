package com.example.morseEncoder;

import com.example.MorseCommonHelper;

import java.util.List;

public class MorseEncoderImpl implements MorseEncoder {
    @Override
    public String encoder(String msg) {
        StringBuilder result = new StringBuilder();
        char[] charArray = msg.toLowerCase().toCharArray();

        for (char c : charArray) {
            result.append(MorseCommonHelper.morseCode.get(c)).append(" ");
        }
        return result.toString();
    }

    @Override
    public <T> String encoder(List<T> list) {
        StringBuilder result = new StringBuilder();
        list.forEach(item -> {
            result.append(MorseCommonHelper.morseCode.get(item)).append(" ");
        });

        return "\nResult:\n" + result.toString();
    }
}
