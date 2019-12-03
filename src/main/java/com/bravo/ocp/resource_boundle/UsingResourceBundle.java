package com.bravo.ocp.resource_boundle;

import com.bravo.ocp.utils.PrintUtils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import static com.bravo.ocp.utils.PrintUtils.println;

public class UsingResourceBundle {

    public static void main(String[] args) {
        UsingResourceBundle urb = new UsingResourceBundle();
        urb.usingResourceBundle();
//        urb.usingProperties();
//        urb.usingJavaClassResourceBundle();
//        urb.usingMessageFormatter();
    }

    public void usingResourceBundle() {
        printBundleContentForSpecificLocale("Messages", new Locale("en", "US"));
        PrintUtils.println("----------------------------------------");
        printBundleContentForSpecificLocale("Messages", Locale.US);
        PrintUtils.println("----------------------------------------");
        printBundleContentForSpecificLocale("Messages", Locale.FRENCH);
        PrintUtils.println("----------------------------------------");
        printBundleContentForSpecificLocale("Messages", Locale.FRANCE);
        PrintUtils.println("----------------------------------------");
        printBundleContentForSpecificLocale("Messages", Locale.CANADA_FRENCH);
        PrintUtils.println("----------------------------------------");
        //
        ResourceBundle messages = getResourceBundleForLocale("Messages", Locale.getDefault());
        PrintUtils.println("For locale: " + Locale.getDefault());
        PrintUtils.println(messages.getString("helloWorld"));
        PrintUtils.println(messages.getString("onlyInDefault"));
        PrintUtils.println("----------------------------------------");
        //
    }

    public void usingProperties() {
        Properties systemLocaleMessages = new Properties();
        ResourceBundle systemLocalMessagesBundle = getResourceBundleForLocale("Messages", Locale.getDefault());
        systemLocalMessagesBundle.keySet()
            .forEach(key -> systemLocaleMessages.put(key, systemLocalMessagesBundle.getString(key)));


        PrintUtils.println(systemLocaleMessages.getProperty("helloWorld"));
        // It will be null since the property does not exist in the bundle properties object
        PrintUtils.println(systemLocaleMessages.getProperty("nonExistentProperty"));
        // We can use default values for properties that doesn't exist
        PrintUtils.println(systemLocaleMessages.getProperty("nonExistentProperty", "a default value"));

        PrintUtils.println("----------------------------------------");

    }

    private void usingJavaClassResourceBundle() {
        printBundleContentForSpecificLocale("JavaMessages", Locale.US);
        PrintUtils.println("----------------------------------------");
    }

    private void usingMessageFormatter(){
        ResourceBundle rb = getResourceBundleForLocale("Messages", Locale.getDefault());
        String hello = rb.getString("helloByName");
        PrintUtils.println(MessageFormat.format(hello, "Esteban"));
        PrintUtils.println("----------------------------------------");

    }

    private void printBundleContentForSpecificLocale(String bundleName, Locale locale) {
        ResourceBundle messagesBundle = getResourceBundleForLocale(bundleName, locale);
        // If a default resource bundle exist,
        // this will also print the key - value pairs that dont exist in the bundle for the requested locale
        // and exist in the default bundle
        messagesBundle.keySet()
            .stream()
            // messagesBundle.getString(key)) is also valid when you don't use Java bundle resources
            .map(key -> key + " - " + messagesBundle.getObject(key))
            .forEach(PrintUtils::println);
    }

    private ResourceBundle getResourceBundleForLocale(String bundleName, Locale locale) {
        return ResourceBundle.getBundle(bundleName, locale);
    }

}
