package Lab12;

public class SumOfDigits {

    /**
     * Recursive function to calculate the sum of digits of a number.
     * @param number The input integer (positive or negative).
     * @return The sum of the digits of the absolute value of the input number.
     */
    public static int sumOfDigits(int number) {
        // Convert to positive if negative
        number = Math.abs(number);

        // Base case: if the number is 0, return 0
        if (number == 0) {
            return 0;
        }

        // Recursive case: add the last digit to the sum of the remaining digits
        return (number % 10) + sumOfDigits(number / 10);
    }
}
