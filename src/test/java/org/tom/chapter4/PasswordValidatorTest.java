package org.tom.chapter4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PasswordValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "KillBill, false, 1, 2, 2, 0, 8",
            "OR3nIshii, true, 1, 2, 2, 0, 8",
            "Bl@ckM@mb@, false, 2, 2, 2, 2, 10",
            "TheBr!deVsCr@zy88, true, 2, 2, 2, 2, 10"
    })
    public void testValidate(String password, boolean valid, int requiredDigits, int requiredLowercase,
                             int requiredUppercase, int requiredSpecialCharacters, int minimumLength) {
        PasswordValidator validator = new PasswordValidator(requiredDigits, requiredLowercase, requiredUppercase,
                requiredSpecialCharacters, minimumLength);
        Assertions.assertThat(validator.validate(password)).isEqualTo(valid);
    }
}
