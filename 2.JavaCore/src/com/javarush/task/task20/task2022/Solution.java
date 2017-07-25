package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(this.fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        //in.close();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/Nick/Downloads/Report3.txt"));
        Solution solution = new Solution("/Users/Nick/Downloads/Report4.txt");
        //solution.writeObject("testtesttest");
        oos.writeObject(solution);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/Nick/Downloads/Report3.txt"));

        Solution solution1 = (Solution) ois.readObject();
        //solution1.writeObject(" heheheheheheheh");
    }
}
