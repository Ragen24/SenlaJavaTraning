package Util;

import java.util.Random;

public abstract class DigitGenerator {
    public static int get3DigitNumber() {
        return new Random().nextInt(900) + 100;
    }
}
