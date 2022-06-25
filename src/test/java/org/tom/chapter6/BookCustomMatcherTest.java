package org.tom.chapter6;

import org.junit.jupiter.api.Test;

public class BookCustomMatcherTest {
    private static final String TITLE = "My book";
    @Test
    void constructorShouldSetTitle() {
        Book book = new Book(TITLE);
        BookAssert.assertThat(book).hasTitle(TITLE);
    }
}
