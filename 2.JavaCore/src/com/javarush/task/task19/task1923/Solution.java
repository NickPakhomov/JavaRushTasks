package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] strings = line.split(" ");
            for (String string : strings) {
                if (string.matches(".*\\d+.*")) {
                    bufferedWriter.write(string + " ");
                }
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
