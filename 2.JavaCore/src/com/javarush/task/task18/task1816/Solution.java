package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args == null || args.length < 1)
            return;

        String fileName = args[0];
        FileInputStream inputStream = new FileInputStream(fileName);

        int counter = 0;
        while (inputStream.available() > 0) {
            int digit = inputStream.read();
            if (digit >= 65 && digit <= 122) {
                counter++;
            }
        }
        inputStream.close();
        System.out.println(counter);
    }
}
