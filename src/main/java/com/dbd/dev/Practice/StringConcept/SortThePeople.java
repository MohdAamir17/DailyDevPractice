package com.dbd.dev.Practice.StringConcept;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class SortThePeople {
    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        SortThePeople sortThePeople = new SortThePeople();
        String[] strings = sortThePeople.sortPeople(names, heights);
        for (String str : strings) {
            System.out.println("Array : " + str);
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        String[] sortedNames = new String[names.length];
        Map<Integer, String> heightToNameMap = new HashMap<>();

        // Map each height to its corresponding name
        for (int i = 0; i < names.length; i++) {
            heightToNameMap.put(heights[i], names[i]);
        }

        // Sort heights in descending order
        Integer[] sortedHeights = Arrays.stream(heights).boxed()
                .sorted((a, b) -> b - a)
                .toArray(Integer[]::new);

        // Populate sortedNames based on sorted heights
        for (int i = 0; i < sortedHeights.length; i++) {
            sortedNames[i] = heightToNameMap.get(sortedHeights[i]);
        }

        return sortedNames;
    }
}
