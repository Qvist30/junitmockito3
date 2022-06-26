package org.tom.chapter4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    private Pattern pattern;

    PasswordValidator(int requiredDigits, int requiredLowercase, int requiredUpercase, int requiredSpecialCharacters, int minimumLength) {
        String passwordRegex = "^(?=(.*\\d){"+requiredDigits+"})(?=(.*[a-z]){"+ requiredLowercase +"})(?=(.*[A-Z]){"
                + requiredUpercase + "})(?=(.*[!@#$%]){"+requiredSpecialCharacters+"})[0-9a-zA-Z!@#$%]{" + minimumLength +",}";
        pattern = Pattern.compile(passwordRegex);
    }

    public boolean validate(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
