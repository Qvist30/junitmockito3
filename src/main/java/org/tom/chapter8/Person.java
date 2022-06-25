package org.tom.chapter8;

import org.tom.chapter6.Book;

public class Person {
    private String nick;
    public Person(String nameWithSurname) {
        this.nick = nameWithSurname;
    }

    public String getNick() {
        return nick;
    }
}
