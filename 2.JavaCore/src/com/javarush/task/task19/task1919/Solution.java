package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args == null || args[0].length() < 1)
            throw new IllegalArgumentException();

        String fileName = args[0];

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        Map<String, String> treeMap = new TreeMap<>();

        while (br.ready()) {
            String[] readLine = br.readLine().split(" ");
            if (treeMap.containsKey(readLine[0])) {
                treeMap.put(readLine[0],
                        String.valueOf(
                                Double.valueOf(treeMap.get(readLine[0])) + Double.valueOf(readLine[1])));
            } else {
                treeMap.put(readLine[0], String.valueOf(Double.valueOf(readLine[1])));
            }
        }

        br.close();

        for (Map.Entry<String,String> entry : treeMap.entrySet()) {
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());
        }
    }
}
