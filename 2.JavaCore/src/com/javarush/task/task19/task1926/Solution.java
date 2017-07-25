package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        bufferedReader = new BufferedReader(new FileReader(fileName));

        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            stringBuilder.append(line).reverse();
            System.out.println(stringBuilder.toString());
            stringBuilder.setLength(0);
        }

        bufferedReader.close();
    }
}
