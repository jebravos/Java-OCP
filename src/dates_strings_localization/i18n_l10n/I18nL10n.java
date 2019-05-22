package dates_strings_localization.i18n_l10n;

import java.util.Locale;

public class I18nL10n {


    public static void main(String[] args) {

        pickingALocale();
    }

    private static void pickingALocale() {
        // Users current local
        Locale locale = Locale.getDefault();
        // This output tells us that our computer is using French and is sitting in France
        // fr: Language (lowercase)
        // fr_Fr: Language-Country (lowercase_UPPERCASE)
        System.out.println("Users current local: " + locale);

        // You can also use a local different than the system default locale
        System.out.println(Locale.GERMAN);
        System.out.println(Locale.GERMANY);

        // We can also use builder to create a Locale
        Locale l1 = new Locale.Builder()
            .setLanguage("en")
            .setRegion("US")
            .build();

        // The Locale builder converts to uppercase or lowercase for you as needed, which means this is legal:
        // Locale l2 = new Locale.Builder() // bad but legal
        //     .setRegion("us")
        //     .setLanguage("EN")
        //     .build();

        System.out.println("-------------------------------------------------");
    }

}
