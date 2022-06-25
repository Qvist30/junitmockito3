package org.tom.chapter6;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BookConditionTest {
    private static final String ENGLISH = "English";
    private Book book;
    Condition<Book> writtenInEnglish = new Condition<>(
            book -> book.getLanguage().equals(ENGLISH),
            "book in English");

    Condition<Book> moreThan100Pages = new Condition<>(
            book -> book.getNumberOfPages() > 100,
            "book be more than 100 pages");
    @Test
    void languageCheck() {
        book = new Book("title");
        assertThat(book).is(writtenInEnglish).has(moreThan100Pages);
    }
}
