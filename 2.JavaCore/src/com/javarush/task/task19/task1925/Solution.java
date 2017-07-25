package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];

        BufferedReader br = new BufferedReader(new FileReader(file1));
        StringBuilder stringBuilder = new StringBuilder();
        while (br.ready()) {
            String line = br.readLine();
            String[] strings = line.split(" ");

            for (String string : strings) {
                if (string.length() > 6)
                    stringBuilder.append(string).append(",");
            }
        }

        br.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
        bufferedWriter.write(stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1));

        bufferedWriter.close();
    }
}
