package org.tom.chapter3;

public class FahrToCelcConverter {
    public static int toFahrenheit(int celsius) {
        return Math.round((int) (celsius*(9.0/5.0) + 32));
    }

    public static double toCelcius(int fahr) {
        return Math.round(((fahr-32) * 5.0/9.0));
    }
}
