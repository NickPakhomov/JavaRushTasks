package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        FileInputStream fileInputStream = new FileInputStream(/*"/Users/Nick/Downloads/Report1.txt"*/fileName);

        long value = 0;

        while (fileInputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = fileInputStream.read(); //прочитать очередной байт
            if (data > value)
                value = data; //добавить его к общей сумме
        }
        fileInputStream.close(); // закрываем поток

        System.out.println(value); //выводим сумму на экран.
    }
}
