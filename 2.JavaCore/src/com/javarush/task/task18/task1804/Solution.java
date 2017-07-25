package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;

/*
Самые редкие байты
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        FileInputStream fileInputStream = new FileInputStream(/*"/Users/Nick/Downloads/Report1.txt"*/fileName);

        Map<Integer, Integer> map = new HashMap<>();

        while (fileInputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = fileInputStream.read();//прочитать очередной байт
            if (!map.containsKey(data)) {
                map.put(data, 1);
            } else {
                map.put(data, map.get(data) + 1);
            }
        }
        fileInputStream.close(); // закрываем поток

        map = sortByValue(map);

        Object[] valarr = map.values().toArray();
        Object[] keyarr = map.keySet().toArray();
        int index = 0;
        for (int i = 1; i < valarr.length; i++) {
            if (valarr[i] != valarr[0]) {
                index = i;
                break;
            }
        }
        Integer[] array = Arrays.copyOf(keyarr, index, Integer[].class);
        for (Integer anArray : array) {
            System.out.print(anArray + " ");
        }
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(/*Collections.reverseOrder()*/))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
