package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        FileInputStream inputStream = new FileInputStream(name);

        byte[] buffer = new byte[1000];
        int count = 0;
        //Users/Nick/Downloads/Report1.txt
        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            inputStream.read(buffer);//прочитать очередной байт

            for (byte aBuffer : buffer) {
                if (aBuffer == (byte) 44)
                    count++;
            }

            /*if (data > value)
                value = data; //добавить его к общей сумме*/
        }
        inputStream.close();

        System.out.println(count);
    }
}
