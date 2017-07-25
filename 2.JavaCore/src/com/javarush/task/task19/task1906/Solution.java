package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("File1: "); ///Users/Nick/Downloads/Report1.txt
        String file1 = bufferedReader.readLine();
        System.out.print("File2: ");
        String file2 = bufferedReader.readLine();

        bufferedReader.close();

        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);

        int counter = 0;

        while (fileReader.ready()) {
            int data = fileReader.read();
            if (++counter % 2 == 0)
                fileWriter.write(data);
        }

        fileReader.close();
        fileWriter.close();

    }
}
