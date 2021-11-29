package com.github.zoltanpal.prog2.zh.example;

import java.util.List;
import java.util.function.Function;

import com.github.zoltanpal.prog2.zh.example.handler.GenericItemHandler;
import com.github.zoltanpal.prog2.zh.example.handler.IntegerHandler;
import com.github.zoltanpal.prog2.zh.example.handler.StringHandler;
import com.github.zoltanpal.prog2.zh.example.input.converter.StringToIntegerConverter;
import com.github.zoltanpal.prog2.zh.example.input.reader.TextFileContentReader;

public class Main {

    public static void main(String[] args) {
        final TextFileContentReader reader = new TextFileContentReader();
        final StringToIntegerConverter stringToIntegerConverter = new StringToIntegerConverter();
        final GenericItemHandler<String> stringHandler = new StringHandler();
        final GenericItemHandler<Integer> intHandler = new IntegerHandler();

        List<String> strings = reader.read("strings.txt", Function.identity());
        List<Integer> ints = reader.read("ints.txt", stringToIntegerConverter::convert);

        stringHandler.processItems(strings);
        intHandler.processItems(ints);
    }
}
