package com.github.zoltanpal.prog2.zh.example.input.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TextFileContentReader {

    public <T> List<T> read(String path, Function<String, T> itemConverter) {
        List<T> fileContents = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                T convertedItem = itemConverter.apply(currentLine);
                if (convertedItem != null) {
                    fileContents.add(convertedItem);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to load file from path: " + path);
        } catch (IOException e) {
            System.out.println("Unable to process file on path: " + path);
        }
        return fileContents;
    }
}
