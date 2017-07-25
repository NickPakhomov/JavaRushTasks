package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;

/* 
Самые частые байты
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        FileInputStream fileInputStream = new FileInputStream(/*"/Users/Nick/Downloads/Report1.txt"*/fileName);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < map.size(); i++) {
            map.put(0, 0);
        }
        //long value = 0;

        while (fileInputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = fileInputStream.read();//прочитать очередной байт
            if (!map.containsKey(data)) {
                map.put(data, 1);
            } else {
                map.put(data, map.get(data) + 1);
            }
            /*if (data > value)
                value = data; //добавить его к общей сумме*/
        }
        fileInputStream.close(); // закрываем поток

        map = sortByValue(map);

        /*for (int i = 0; i < map.size(); i++) {
            System.out.print(ke);
        }*/
        Object[] valarr = map.values().toArray();
        Object[] keyarr = map.keySet().toArray();
        int index = 1;
        for (int i = 1; i < valarr.length; i++) {
            if (valarr[i] == valarr[0])
                index++;
        }
        Integer[] array = Arrays.copyOf(keyarr, index, Integer[].class);
        for (Integer anArray : array) {
            System.out.print(anArray + " ");
        }
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
