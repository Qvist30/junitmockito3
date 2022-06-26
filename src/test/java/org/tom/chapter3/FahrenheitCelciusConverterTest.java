package org.tom.chapter3;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FahrenheitCelciusConverterTest {
    @ParameterizedTest
    @CsvSource({
            "0,32",
            "37,98",
            "100,212"
    })
    void shouldConvertCelciusToFahrenheit(int celsius, int fahrenheit) {
        assertThat(FahrToCelcConverter.toFahrenheit(celsius)).isEqualTo(fahrenheit);
    }

    @ParameterizedTest
    @CsvSource({
            "0,32",
            "37,98",
            "100,212"
    })
    void shouldConvertFahrenheitToCelcius(int celsius, int fahrenheit) {
        assertThat(FahrToCelcConverter.toCelcius(fahrenheit)).isEqualTo(celsius);
    }
}
