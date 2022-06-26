package org.tom.chapter3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringReverseTest {

    @ParameterizedTest
    @CsvSource({
            "a, a",
            "abc, cba",
            "Supercalifragilisticexpialidocious, suoicodilaipxecitsiligarfilacrepuS"
    })
    public void testReverseString(String originalString, String reversedString) {
        assertThat(StringReverse.reverse(originalString)).isEqualTo(reversedString);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testNullOrEmptyReverseString(String originalString) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringReverse.reverse(originalString);
                });
    }
}
