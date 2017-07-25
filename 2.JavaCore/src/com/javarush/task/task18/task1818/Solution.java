package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("File 1: ");
        String file1 = bufferedReader.readLine();

        System.out.print("File 2: ");
        String file2 = bufferedReader.readLine();

        System.out.print("File 3: ");
        String file3 = bufferedReader.readLine();

        FileOutputStream outputStream = new FileOutputStream(file1);
        FileInputStream inputStream = new FileInputStream(file2);

        byte[] bytes = new byte[1000];

        while (inputStream.available() > 0) {
            int count = inputStream.read(bytes);
            outputStream.write(bytes, 0, count);
        }

        inputStream.close();

        inputStream = new FileInputStream(file3);
        while (inputStream.available() > 0) {
            int count = inputStream.read(bytes);
            outputStream.write(bytes, 0, count);
        }

        inputStream.close();
        outputStream.close();
    }
}
