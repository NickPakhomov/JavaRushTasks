package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        if (args == null || args[0].length() < 1)
            throw new IllegalArgumentException();

        String fileName = args[0];

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        while (br.ready()) {
            String[] readLine = br.readLine().split(" ");

            Date birthday = new Date(
                    Integer.valueOf(readLine[readLine.length - 1]) - 1900,
                    Integer.valueOf(readLine[readLine.length - 2]) - 1,
                    Integer.valueOf(readLine[readLine.length - 3])
            );

            StringBuilder name = new StringBuilder();
            for (int i = readLine.length - 4; i >= 0 ; i--) {
                name.insert(0, readLine[i] + " ");
            }

            PEOPLE.add(new Person(name.toString().trim(), birthday));
        }

        br.close();
    }
}
