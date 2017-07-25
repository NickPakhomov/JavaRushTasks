package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args == null || args.length < 1)
            throw new IllegalArgumentException("Пожалуйста, введите верные аргументы");

        FileInputStream inputStream = new FileInputStream(args[0]);

        Map<Integer, Integer> map = new TreeMap<>();

        while (inputStream.available() > 0) {
            int readByte = inputStream.read();

            if (map.containsKey(readByte)) {
                map.put(readByte, map.get(readByte) + 1);
            } else {
                map.put(readByte, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.printf("%s %d\n",
                    (char)(int) entry.getKey(),
                    entry.getValue());
        }
        inputStream.close();
    }
}
