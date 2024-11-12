package com.dbd.dev.Practice.Java8Concept;

import org.apache.commons.lang3.stream.Streams;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class MergeTwoSortedLists {
    public static void main(String[] args) {
        List<Integer> integerListFirst = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> integerListTwo = Arrays.asList(8,9,10);
        List<Integer> integerListThree = Arrays.asList(11,23,24);

        List<Integer> margeList = Streams.of(integerListFirst,integerListTwo).flatMap(Collection::stream).toList();
        System.out.println("Combination of list : " + margeList);

        List<Integer> mergedList = Streams.of(integerListFirst, integerListTwo, integerListThree)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }
}
