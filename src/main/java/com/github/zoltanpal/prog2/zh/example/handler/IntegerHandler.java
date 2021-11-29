package com.github.zoltanpal.prog2.zh.example.handler;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerHandler implements GenericItemHandler<Integer> {

    @Override
    public void processItems(List<Integer> items) {
        System.out.println("Greatest: " + getGreatest(items));
        System.out.println("Avg: " + getAverage(items));
        System.out.println("Primes:");
        getPrimes(items).forEach(System.out::println);
        System.out.println("3 largest: ");
        get3Largest(items).forEach(System.out::println);
    }

    private int getGreatest(List<Integer> items) {
        return items.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    }

    private Double getAverage(List<Integer> items) {
        return items.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    private List<Integer> getPrimes(List<Integer> items) {
        return items.stream()
                .filter(this::isPrime)
                .collect(Collectors.toList());
    }

    private List<Integer> get3Largest(List<Integer> items) {
        return items.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
    }

    private boolean isPrime(int number) {
        boolean isPrime = true;
        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }
}
