package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        //Scanner scanner = new Scanner(System.in);
        System.out.print("Input file: "); //Users/Nick/Downloads/Report1.txt
        //String inputFile = scanner.nextLine();
        String inputFile = br.readLine();
        System.out.print("Output file: ");
        //String outputFile = scanner.nextLine();
        String outputFile = br.readLine();

        FileInputStream fileInputStream = new FileInputStream(inputFile);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);

        byte[] bytes = new byte[1000];
        int count = 0;
        while (fileInputStream.available() > 0) {
            count += fileInputStream.read(bytes);
        }

        fileOutputStream.write(reverse(Arrays.copyOf(bytes, count)), 0, count);

        fileInputStream.close();
        fileOutputStream.close();
    }

    private static byte[] reverse(byte[] arr) {
        for(int i = 0; i < arr.length / 2; i++) {
            byte temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }
}
