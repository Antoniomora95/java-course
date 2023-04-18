

// Java program to reduce a fraction x/y
// to its lowest form
public class simplifiedFraction {

    // Function to reduce a fraction to its lowest form
    static void reduceFraction(double numerator, double denominator) {
        double commonDivisor;
        commonDivisor = __gcd(numerator, denominator);

        numerator = numerator / commonDivisor;
        denominator = denominator / commonDivisor;

        System.out.println("numerator = " + (int)Math.round(numerator) + ", denominator = " + denominator);
    }

    static double __gcd(double numerator, double denominator) {
        if (denominator == 0)
            return numerator;
        return __gcd(denominator, numerator % denominator);

    }

    // Driver Code
    public static void main(String[] args) {
        double numerator = 0.16666666666666666;
        double denominator = 1;

        reduceFraction(numerator, denominator);
    }
}

/* This code contributed by PrinceRaj1992 */

