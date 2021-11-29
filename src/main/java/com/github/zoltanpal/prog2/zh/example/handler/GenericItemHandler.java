package com.github.zoltanpal.prog2.zh.example.handler;

import java.util.List;

@FunctionalInterface
public interface GenericItemHandler<T> {

    void processItems(List<T> items);
}
