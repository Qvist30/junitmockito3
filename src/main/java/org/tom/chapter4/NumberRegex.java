package org.tom.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberRegex {
    public static List<String> getValues(String originalString) {
        Pattern pattern = Pattern.compile("(\\d{3})");
        Matcher matcher = pattern.matcher(originalString);
        List<String> strings = new ArrayList<>();
        while(matcher.find()) {
            strings.add(matcher.group());
        }
        return strings;
    }
}
