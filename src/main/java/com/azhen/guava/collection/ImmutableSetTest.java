package com.azhen.guava.collection;

import com.google.common.collect.ImmutableSet;


public class ImmutableSetTest {

    public static void main(String[] args) {
        ImmutableSet<String> stringImmutableSet = ImmutableSet.<String>builder().add("Apple", "Banana").build();
        System.out.println(stringImmutableSet.size());
    }
}
