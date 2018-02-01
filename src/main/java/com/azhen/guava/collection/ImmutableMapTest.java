package com.azhen.guava.collection;

import com.google.common.collect.ImmutableMap;

import java.util.Map;


public class ImmutableMapTest {
    public static void main(String[] args) {
        Map<String, String> immutableMap = ImmutableMap.<String, String>builder()
                .put("apple", null)
                .put("banana", null)
                .build();
        System.out.println(immutableMap.size());
    }
}
