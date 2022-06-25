package org.tom.chapter8;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class UserToPersonConverterTest {
    @Test
    void shouldConvertUserNamesIntoPersonNick() {

        String name = RandomStringUtils.randomAlphabetic(8);
        String surname = RandomStringUtils.randomAlphabetic(12);
        User user = new User(name, surname);
        Person person = UserToPersonConverter.convert(user);

        assertThat(person.getNick()).isEqualTo(name + " " + surname);

    }


    private static Stream<Arguments> getRandomNames() {
        return Stream.generate(() -> {
            return Arguments.of(
                    RandomStringUtils.randomAlphabetic(8),
                    RandomStringUtils.randomAlphabetic(12)
            );
        }).limit(100);
    }

    @ParameterizedTest
    @MethodSource(value = "getRandomNames")
    void shouldConvertUserNamesIntoPersonNick(
            String name, String surname) {
        User user = new User(name, surname);
        Person person = UserToPersonConverter.convert(user);
        assertThat(person.getNick())
                .isEqualTo(name + " " + surname);
    }
}
