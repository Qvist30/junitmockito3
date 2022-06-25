package org.tom.chapter6;

public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return "English";
    }

    public int getNumberOfPages() {
        return 101;
    }
}
