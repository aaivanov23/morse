package com.example.morseEncoder;

import java.util.List;

public interface MorseEncoder {
    String encoder(String msg);
    <T> String encoder(List<T> list);
}
