package org.tom.chapter3;

import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class HashMapTest {
    private Map<Integer, String> hashMap;

    @BeforeEach
    public void initializeMap() {
        hashMap= new HashMap<>();
    }

    @ParameterizedTest
    @CsvSource({
            "1, test",
            "2, otherValue",
            "999, badValue",
            ", NullKeyIsValidShockingly"
    }
    )
    public void testHashMapPut(Integer key, String value) {
        hashMap.put(key, value);
        assertThat(hashMap.get(key)).isEqualTo(value);
    }

    @ParameterizedTest
    @CsvSource({
            "1, test, test2",
            "2, otherValue, doh",
            "999, badValue, longValue",
            ", NullKeyIsValidShockingly, IGuessItsNotThatShocking"
    }
    )
    public void testHashMapPutTwoValues(Integer key, String value, String replacedValue) {
        hashMap.put(key, value);
        hashMap.put(key, replacedValue);
        assertThat(hashMap.get(key)).isEqualTo(replacedValue);
    }

    @Test
    @MethodSource(value = "getRandomHashMap")
    public void testClearWorks() {
        Random random = new Random(System.currentTimeMillis());
        RandomString string = new RandomString();
        int randomInt = random.nextInt(100);
        for(int i=0; i<randomInt; i++) {
            String actualString = string.nextString();
            int actualInt = random.nextInt();
            hashMap.put(actualInt, actualString);
            assertThat(hashMap.get(actualInt)).isEqualTo(actualString);
        }
        assertThat(hashMap.size()).isNotZero();
        hashMap.clear();
        assertThat(hashMap.size()).isZero();
    }
}
