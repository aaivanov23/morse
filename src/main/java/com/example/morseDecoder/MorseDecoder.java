package com.example.morseDecoder;

import java.util.List;

public interface MorseDecoder {
    String decoder(String msg);
    <T> String decoder(List<T> list);
}
