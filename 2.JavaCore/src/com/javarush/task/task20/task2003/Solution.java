package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(br.readLine());
        br.close();
        //implement this method - реализуйте этот метод

        load(inputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        //BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        Properties myProperties = new Properties();
        myProperties.putAll(properties);
        myProperties.store(outputStream, "");


        /*for (Map.Entry<String, String> entry : properties.entrySet()) {
            bufferedWriter.write(entry.getKey() + ":" + entry.getValue());
        }

        bufferedWriter.close();*/
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties myProperties = new Properties();
        myProperties.load(inputStream);
        properties.clear();

        //myProperties.putAll(properties);
        for (Map.Entry e : myProperties.entrySet()){
            properties.put(e.getKey().toString(), e.getValue().toString());
        }


        //inputStream.close();

        /*BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        while (br.ready()) {
            String readLine = br.readLine();
            String[] words = readLine.split(":");
            properties.put(words[0], words[1]);
        }
        br.close();*/
    }

    public static void main(String[] args) {

    }
}
