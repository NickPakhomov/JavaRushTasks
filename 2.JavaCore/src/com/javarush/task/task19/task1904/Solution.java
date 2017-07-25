package com.javarush.task.task19.task1904;

/*
И еще один адаптер
*/

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        PersonScannerAdapter(Scanner scanner) {
            fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String person = "";
            if (fileScanner.hasNext()) {
                person = fileScanner.nextLine();
            }
            String[] personData = person.split(" ");
            String lastName = personData[0];
            String firstName = personData[1];
            String middleName = personData[2];

            //SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            Date birthDate = new Date(
                    Integer.valueOf(personData[5]) - 1900,
                    Integer.valueOf(personData[4]) - 1,
                    Integer.valueOf(personData[3]));
            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
