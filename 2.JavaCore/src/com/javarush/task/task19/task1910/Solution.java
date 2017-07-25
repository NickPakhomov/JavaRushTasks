package com.javarush.task.task19.task1910;

/* 
Пунктуация
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

        while (br.ready()) {
            String str = br.readLine();
            bw.write(str.replaceAll("[^a-zA-Z ]", ""));
        }

        br.close();
        bw.close();
    }
}
