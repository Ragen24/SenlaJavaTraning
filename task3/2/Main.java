import Util.DigitGenerator;
import Util.DigitSummator;

public class Main {
    public static void main(String[] args) {
        int number = DigitGenerator.get3DigitNumber();
        int sumOfDigit = DigitSummator.sumDigits(number);
        System.out.println("number = " + number + " sumOfDigits = " + sumOfDigit);
    }
}
