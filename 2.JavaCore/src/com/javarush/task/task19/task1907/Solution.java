package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("File:"); ///Users/Nick/Downloads/Report1.txt
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        FileReader fileReader = new FileReader(fileName);

        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()) {
            stringBuilder.append((char) fileReader.read());
        }
        fileReader.close();

        int i = 0;
        /*Pattern p = Pattern.compile("(?<=(\\s|\\W))world(?=(\\s|\\W))");
        Matcher m = p.matcher(stringBuilder.toString());
        while (m.find()) {
            i++;
        }*/

        i = stringBuilder.toString().split("\\Wworld\\W").length - 1;
        //String[] array = stringBuilder.toString().toLowerCase().split("\\W");
        /*for (String s : array) {
            if (s.equals("world")) {
                i++;
            }
        }*/

        System.out.println(i);

    }
}
