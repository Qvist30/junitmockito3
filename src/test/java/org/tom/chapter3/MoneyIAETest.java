package org.tom.chapter3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
public class MoneyIAETest {
    private final static String VALID_CURRENCY = "USD";
    @ParameterizedTest
    @ValueSource(ints = { -12387, -5, -1 })
    public void constructorShouldThrowIAEForInvalidAmount(int invalidAmount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Money(invalidAmount, VALID_CURRENCY);
                });
    } }