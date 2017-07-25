package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws DownloadException, IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);

        System.out.print("File path: "); ///Users/Nick/Downloads/Report1.txt
        String fileName = br.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);

        while (fileInputStream.available() >= 1000) {
            System.out.print("File path: "); ///Users/Nick/Downloads/Report1.txt
            fileName = br.readLine();
            fileInputStream = new FileInputStream(fileName);
        }
        fileInputStream.close();
        inputStreamReader.close();
        br.close();

        throw new DownloadException();
    }

    public static class DownloadException extends Exception {
    }
}
