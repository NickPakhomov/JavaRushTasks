package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("File 1: "); //Users/Nick/Downloads/Report1.txt
        String file1 = scanner.nextLine();
        System.out.print("File 2: ");
        String file2 = scanner.nextLine();
        System.out.print("File 3: ");
        String file3 = scanner.nextLine();

        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        FileOutputStream outputStream2 = new FileOutputStream(file3);

        int totalBytes = 0;
        byte[] bytes = new byte[1000];

        while (inputStream.available() > 0) {
            totalBytes += inputStream.read(bytes);
        }

        bytes = Arrays.copyOf(bytes, totalBytes);
        outputStream.write(bytes, 0,
                totalBytes % 2 == 0 ?
                        totalBytes / 2 : totalBytes / 2 + 1);

        outputStream2.write(bytes,
                totalBytes % 2 == 0 ?
                        totalBytes / 2 : totalBytes / 2 + 1,
                totalBytes / 2);

        inputStream.close();
        outputStream.close();
        outputStream2.close();
    }
}
