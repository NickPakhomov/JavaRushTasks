package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("File1: "); ///Users/Nick/Downloads/Report1.txt
        String file1 = bufferedReader.readLine();

        System.out.print("File2: ");
        String file2 = bufferedReader.readLine();

        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);

        StringBuilder str = new StringBuilder();
        while (inputStream.available() > 0) {
            str.append(Character.toChars(inputStream.read()));
        }

        String[] numbers = str.toString().split(" ");
        for (String number : numbers) {
            int digit = Math.round(Float.parseFloat(number));
            outputStream.write(Integer.toString(digit).getBytes());
            outputStream.write(32);
        }
        inputStream.close();
        outputStream.close();
    }
}
