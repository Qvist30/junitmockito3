package org.tom.chapter4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberRegexTest {

    @ParameterizedTest
    @CsvSource({
            "abc 12,''",
            "cdefg 345 12bb23, '345'",
            "cdefg 345 12bbb33 678tt, '345 678'"
    })
    public void testRegex(String originalString, String expectedStringUnSplit) {
        String[] expectedValues = expectedStringUnSplit.equals("") ? new String[0] :
                expectedStringUnSplit.split(" ");
        List<String> listOfStrings = NumberRegex.getValues(originalString);
        assertThat(listOfStrings.size()).isEqualTo(expectedValues.length);
        for(int i=0; i<expectedValues.length; i++) {
            assertThat(listOfStrings.contains(expectedValues[i])).isTrue();
        }
    }

}
