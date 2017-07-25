package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args == null || args.length < 1) {
            return;
        }

        String fileName = args[0];
        FileInputStream inputStream = new FileInputStream(fileName);

        int counterAll = 0;
        int counterSpaces = 0;
        while (inputStream.available() > 0) {
            int digit = inputStream.read();
            if (digit == 32)
                counterSpaces++;

            counterAll++;
        }

        System.out.printf("%.2f", ((double) counterSpaces / (double) counterAll) * 100);

        inputStream.close();
    }
}
