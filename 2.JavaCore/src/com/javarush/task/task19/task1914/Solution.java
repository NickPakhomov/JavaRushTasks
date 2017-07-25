package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(byteArrayOutputStream);
        System.setOut(newStream);

        testString.printSomething();

        System.setOut(consoleStream);

        //String result = byteArrayOutputStream.toString().replace(" \n", "");
        String result = byteArrayOutputStream.toString().trim();

        System.out.println(result + " " + equationResult(result));
    }

    private static String equationResult(String input) {
        String[] arr = input.split(" ");
        switch (arr[1]) {
            case "+":
                return String.valueOf(Integer.valueOf(arr[0]) + Integer.valueOf(arr[2]));
            case "-":
                return String.valueOf(Integer.valueOf(arr[0]) - Integer.valueOf(arr[2]));
            case "*":
                return String.valueOf(Integer.valueOf(arr[0]) * Integer.valueOf(arr[2]));
            default:
                return "";
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

