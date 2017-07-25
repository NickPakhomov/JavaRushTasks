package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args == null || args[0].length() < 1)
            throw new IllegalArgumentException();

        String fileName = args[0];

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        Map<String, Double> treeMap = new TreeMap<>();

        while (br.ready()) {
            String[] readLine = br.readLine().split(" ");
            if (treeMap.containsKey(readLine[0])) {
                treeMap.put(readLine[0],
                        treeMap.get(readLine[0]) + Double.valueOf(readLine[1]));
            } else {
                treeMap.put(readLine[0], Double.valueOf(readLine[1]));
            }
        }

        br.close();

        Double maxValueInMap = (Collections.max(treeMap.values()));  // This will return max value in the Hashmap
        for (Map.Entry<String, Double> entry : treeMap.entrySet()) {  // Itrate through hashmap
            if (Objects.equals(entry.getValue(), maxValueInMap)) {
                System.out.println(entry.getKey());     // Print the key with max value
            }
        }
    }
}
