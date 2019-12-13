package com.bravo.ocp.i18n_l10n;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.util.Locale;

public class I18nL10n {

    public static void main(String[] args) {

        pickingALocale();
        changingDefaultLocal();
        useBuilder();
        nonExistentLocales();
    }

    private static void pickingALocale() {
        //Oracle defines a locale as a specific geographical, political or cultural region".
        //For the exams you will see only languages and regions
        // Users current local
        Locale locale = Locale.getDefault();
        // This output tells us that our computer is using French and is sitting in France
        // fr: Language (lowercase)
        // fr_Fr: Language-Country (lowercase_UPPERCASE)
        println("Users current local: " + locale);

        // You can also use a local different than the system default locale
        println(Locale.GERMAN);
        println(Locale.GERMANY);

        // The Locale builder converts to uppercase or lowercase for you as needed, which means this is legal:
        // Locale l2 = new Locale.Builder() // bad but legal
        //     .setRegion("us")
        //     .setLanguage("EN")
        //     .build();

        // Local could be just a language or language_REGION. It could never be only a REGION
        Locale noLanguageLocale = new Locale.Builder().setRegion("CO").build();
        // Java will let you create Locales with invalid language and regions.
        // However it won't match the Local that you want to use and your program won't behave as expected.
        println("No language locale: " + noLanguageLocale);

        println("-------------------------------------------------");
    }

    private static void changingDefaultLocal() {
        println("current default locale: " + Locale.getDefault());
        Locale newDefaultLocal = Locale.ITALY;
        Locale.setDefault(newDefaultLocal);
        println("new default locale: " + Locale.getDefault());
        println("-------------------------------------------------");
    }

    private static void useBuilder() {
        // We can also use builder to create a Locale
        Locale l1 = new Locale.Builder()
            .setLanguage("en")
            .setRegion("US")
            .build();
        println(l1);
        println("-------------------------------------------------");
    }

    private static void nonExistentLocales() {
        // We can create our own Locales defining a language an a country
        Locale nonExistent = new Locale("inglishhh", "iunaited esteits");
        println(nonExistent);
        println("-------------------------------------------------");
    }

}
