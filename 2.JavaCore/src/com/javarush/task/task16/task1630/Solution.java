package com.javarush.task.task16.task1630;

import java.io.File;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        File f = new File("/Users/Nick/Downloads/Report1");
        File f2 = new File("/Users/Nick/Downloads/Report2");
        firstFileName = f.getName();
        secondFileName = f2.getName();
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        private String filename;
        private String fileContent;

        static {

        }

        @Override
        public void setFileName(String fullFileName) {
            filename = fullFileName;
        }

        @Override
        public String getFileContent() {
            return null;
        }

        @Override
        public void run() {

        }

        /*@Override
        public void join() throws InterruptedException {

        }*/

        @Override
        public void start() {

        }
    }


    //add your code here - добавьте код тут
}
