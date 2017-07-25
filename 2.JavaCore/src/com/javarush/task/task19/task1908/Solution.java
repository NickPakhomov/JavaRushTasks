package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine(); ///Users/Nick/Downloads/Report1.txt
        String file2 = bufferedReader.readLine();

        bufferedReader.close();

        BufferedReader br = new BufferedReader(new FileReader(file1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));

        StringBuilder stringBuffer = new StringBuilder();
        while (br.ready()) {
            stringBuffer.append(br.readLine());
        }

        String[] words = stringBuffer.toString().split(" ");
        for (String word : words) {
            if (word.matches("-?\\d+(\\.\\d+)?")) {
                bw.write(word + " ");
            }
        }

        br.close();
        bw.close();
    }
}
