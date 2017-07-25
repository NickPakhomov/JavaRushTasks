package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args == null || args.length < 1)
            throw new IllegalArgumentException("Please provide arguments");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("File: "); ///Users/Nick/Downloads/Report1.txt
        String fileName = bufferedReader.readLine();
        //bufferedReader.close();

        BufferedReader inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        String readLine;
        while ((readLine = inputStream.readLine()) != null) {
            String[] arr = readLine.split(" ");
            if (arr[0].equals(args[0]))
                System.out.println(readLine);
        }

        inputStream.close();
    }
}
