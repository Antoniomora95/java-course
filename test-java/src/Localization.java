import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Localization {
    public static void main(String[] args) {
        Locale uk = new Locale("en", "GB");
        Locale ukEuro = new Locale("en", "GB", "EURO");
        Locale us = new Locale("en", "US");
        System.out.printf("the local uk is: %s, and the uk euro is:%s, and the US: %s %n", uk, ukEuro, us);

        printFormattedValuesForSpecificLocale(new Locale("en", "GB"));
        printFormattedValuesForSpecificLocale(new Locale("es", "MX"));
        printFormattedValuesForSpecificLocale(new Locale("pt", "BR"));
    }

    static void printFormattedValuesForSpecificLocale(Locale locale) {
        BigDecimal price = BigDecimal.valueOf(2.99);
        Double tax = 0.2;
        int quantity = 12345;

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        NumberFormat percentageFormat = NumberFormat.getPercentInstance(locale);
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);

        String formattedPrice = currencyFormat.format(price);
        String formattedTax = percentageFormat.format(tax);
        String formattedNumber = numberFormat.format(quantity);

        System.out.printf("The price %s is represented as %s for the country with code: %s%n",
                price, formattedPrice, locale.getCountry());
        System.out.printf("The tax %s is represented as %s in the country with name %s%n",
                tax, formattedTax, locale.getDisplayCountry());
        System.out.printf("The quantity %s is represented as %s in %s, also they speak %s%n%n",
                quantity, formattedNumber, locale.getDisplayCountry(),  locale.getDisplayLanguage());
    }
}
