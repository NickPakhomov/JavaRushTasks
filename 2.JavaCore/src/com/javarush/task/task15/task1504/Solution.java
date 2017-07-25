package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
ООП - книги
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            if (this instanceof AgathaChristieBook)
                return author + ", " + getBook().getTitle() + " is a detective";
            if (this instanceof MarkTwainBook)
                return getBook().getTitle() + " book was written by " + author;

            return "";
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

    private static class MarkTwainBook extends Book {
        private String title;
        public MarkTwainBook(String s) {
            super("Mark Twain");
            title = s;
        }

        @Override
        public MarkTwainBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return title;
        }
    }

    private static class AgathaChristieBook extends Book {
        private String title;
        public AgathaChristieBook(String s) {
            super("AgathaChristie");
            title = s;
        }

        @Override
        public AgathaChristieBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return title;
        }
    }
}
