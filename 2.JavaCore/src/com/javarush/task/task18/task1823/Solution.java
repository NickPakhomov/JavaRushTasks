package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (true) {
            System.out.print("File: "); ///Users/Nick/Downloads/Report1.txt
            fileName = bufferedReader.readLine();
            if (!fileName.equals("exit")){
                new ReadThread(fileName).start();
            } else {
                break;
            }
        }
    }

    public static class ReadThread extends Thread {
        String fileName;
        FileInputStream inputStream;
        Map<Integer, Integer> bytesMap;
        public ReadThread(String fileName) throws FileNotFoundException {
            this.fileName = fileName;
            inputStream = new FileInputStream(fileName);
            bytesMap = new HashMap<>();
        }

        @Override
        public void run() {
            try {
                while (inputStream.available() > 0) {
                    int readByte = inputStream.read();
                    if (bytesMap.containsKey(readByte)) {
                        bytesMap.put(readByte, bytesMap.get(readByte) + 1);
                    } else {
                        bytesMap.put(readByte, 1);
                    }
                }
                inputStream.close();

                bytesMap = sortByValue(bytesMap);

                Solution.resultMap.put(fileName,
                        bytesMap.entrySet().iterator().next().getKey());
            } catch (IOException e) {
                e.printStackTrace();
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
}
