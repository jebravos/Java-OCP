package com.bravo.ocp;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormatingNumbers {

    private final static Long LONG_VALUE = 3_253_000L;
    private final static double CURRENCY_VALUE = 10_000;
    private final static double PERCENTAGE_VALUE = 10_000.3;
    private final static String US_NUMBER_TEXT = "3,253,000";
    private final static String US_CURRENCY_TEXT = "$10,000.00";
    private final static String FRENCH_CURRENCY_TEXT = "10 000,00 €";

    public static void main(String[] args) throws ParseException {
        formatNumbers();
        parseNumbers();
    }

    private static void formatNumbers() {
        System.out.println("default locale: " + Locale.getDefault());
        NumberFormat defaultLocaleFormatter = NumberFormat.getInstance();
        // is the same as
        NumberFormat frenchFormatter = NumberFormat.getInstance(Locale.FRANCE);
        // is the same as
        NumberFormat frenchNumberFormatter = NumberFormat.getNumberInstance(Locale.FRANCE);
        System.out.println(defaultLocaleFormatter.format(LONG_VALUE));
        System.out.println(frenchFormatter.format(LONG_VALUE));
        System.out.println(frenchNumberFormatter.format(LONG_VALUE));

        //Same value in different formats depending on the locale
        NumberFormat englishNumberFormatter = NumberFormat.getNumberInstance(Locale.ENGLISH);
        NumberFormat germanNumberFormatter = NumberFormat.getNumberInstance(Locale.GERMAN);

        System.out.println("---------------------------------------------------");
        System.out.println("Same value in different locales: ");
        System.out.println(frenchNumberFormatter.format(LONG_VALUE));
        System.out.println(englishNumberFormatter.format(LONG_VALUE));
        System.out.println(germanNumberFormatter.format(LONG_VALUE));
        System.out.println("---------------------------------------------------");
        System.out.println("Formatting currencies: ");
        // Using only languages like Locale.FRENCH does not adds the exact currency sign
        NumberFormat frenchCurrencyFormatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        NumberFormat englishCurrencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat germanCurrencyFormatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(frenchCurrencyFormatter.format(CURRENCY_VALUE));
        System.out.println(englishCurrencyFormatter.format(CURRENCY_VALUE));
        System.out.println(germanCurrencyFormatter.format(CURRENCY_VALUE));
        System.out.println("---------------------------------------------------");
    }

    private static void parseNumbers() throws ParseException {
        System.out.println("Parse numbers");
        NumberFormat englishNumberFormatter = NumberFormat.getNumberInstance(Locale.US);
        // ParseException should be managed
        System.out.println("parsing " + US_NUMBER_TEXT + " to " + englishNumberFormatter.parse(US_NUMBER_TEXT));
        System.out.println("---------------------------------------------------");
        System.out.println("Parse currencies");
        NumberFormat englishCurrencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat frenchCurrencyFormatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("parsing " + US_CURRENCY_TEXT + " to " + englishCurrencyFormatter.parse(US_CURRENCY_TEXT));
        System.out.println("parsing " + FRENCH_CURRENCY_TEXT + " to " + frenchCurrencyFormatter.parse(FRENCH_CURRENCY_TEXT));
        System.out.println("---------------------------------------------------");
        // Parsing something like 123QSD will result in the first  part 123 being parsed and the rest being ignored
        System.out.println("parsing 123abc to " + englishNumberFormatter.parse("123abc"));
        //
        try {
            frenchCurrencyFormatter.parse(US_CURRENCY_TEXT);
        } catch (ParseException e) {
            System.out.println("parsing an invalid value will throw a " + e.getClass() + " " + e.getMessage());
        }

    }
}
