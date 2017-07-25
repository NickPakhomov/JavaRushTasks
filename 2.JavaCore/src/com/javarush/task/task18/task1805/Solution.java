package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        FileInputStream fileInputStream = new FileInputStream(/*"/Users/Nick/Downloads/Report1.txt"*/fileName);

        List<Integer> dataList = new ArrayList<>();

        while (fileInputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = fileInputStream.read();//прочитать очередной байт
            dataList.add(data);
        }
        fileInputStream.close(); // закрываем поток

        Collections.sort(dataList);

        Set<Integer> s = new LinkedHashSet<>(dataList);
        List<Integer> list = new ArrayList<>(s);

        for (Integer aList : list) {
            System.out.print(aList + " ");
        }
    }
}