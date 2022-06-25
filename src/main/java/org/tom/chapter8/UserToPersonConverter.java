package org.tom.chapter8;

public class UserToPersonConverter {
    public static Person convert(User user) {
        return new Person(user.getName() + " " + user.getSurname());
    }
}
