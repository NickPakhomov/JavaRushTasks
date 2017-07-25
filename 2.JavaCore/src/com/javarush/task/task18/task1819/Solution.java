package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("File 1: "); ///Users/Nick/Downloads/Report1.txt
        String file1 = bufferedReader.readLine();
        System.out.print("File 2: ");
        String file2 = bufferedReader.readLine();

        FileInputStream inputStream = new FileInputStream(file1);
        FileInputStream inputStream2 = new FileInputStream(file2);

        byte[] bytes1 = new byte[1000];
        while (inputStream.available() > 0) {
            inputStream.read(bytes1);
        }

        inputStream.close();

        byte[] bytes2 = new byte[1000];
        while (inputStream2.available() > 0) {
            inputStream2.read(bytes2);
        }

        inputStream2.close();

        FileOutputStream outputStream = new FileOutputStream(file1);

        outputStream.write(concatArrays(removeZeros(bytes2), removeZeros(bytes1)));

        outputStream.close();

    }

    private static byte[] removeZeros(byte[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0)
                array[j++] = array[i];
        }
        byte[] newArray = new byte[j];
        System.arraycopy(array, 0, newArray, 0, j);
        return newArray;
    }

    private static byte[] concatArrays(byte[] arr1, byte[] arr2) {
        byte[] result = new byte[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);

        return result;
    }
}
