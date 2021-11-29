package com.github.zoltanpal.prog2.zh.example.input.converter;

public class StringToIntegerConverter {

    public Integer convert(String s) {
        Integer i = null;
        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Unable to parse value: " + s);
        }
        return i;
    }
}
