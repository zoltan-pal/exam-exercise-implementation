package com.github.zoltanpal.prog2.zh.example.handler;

import java.util.List;
import java.util.stream.Collectors;

public class StringHandler implements GenericItemHandler<String> {

    @Override
    public void processItems(List<String> items) {
        System.out.println("Longest length: " + getLongestLength(items));
        System.out.println("Palindromes:");
        getPalindromes(items).forEach(System.out::println);
        System.out.println("Strings with A and B: ");
        getStringsWithAB(items).forEach(System.out::println);
    }

    private int getLongestLength(List<String> items) {
        return items.stream()
                .mapToInt(String::length)
                .max()
                .getAsInt();
    }

    private List<String> getPalindromes(List<String> items) {
        return items.stream()
                .filter(this::isPalindrome)
                .collect(Collectors.toList());
    }

    private List<String> getStringsWithAB(List<String> items) {
        return items.stream()
                .filter(this::hasAandB)
                .collect(Collectors.toList());
    }

    private boolean isPalindrome(String string) {
        String reversed = new StringBuilder(string).reverse().toString();
        return string.equals(reversed);
    }

    private boolean hasAandB(String string) {
        String loweredString = string.toLowerCase();
        return loweredString.contains("a") && loweredString.contains("b");
    }
}
