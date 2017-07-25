package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException, IOException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t1.join();
        t2.start();
        t2.join();

        //add your code here - добавьте код тут

        t1.printResult();
        t2.printResult();
        reader.close();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread {
        List<String> strings = new ArrayList<>();
        @Override
        public void run() {
            while (!isInterrupted())
            try {
                strings.add(reader.readLine());
                if (strings.size() == 3)
                    return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void printResult() {
            for (String string: strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
