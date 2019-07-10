package ocp.resource_boundle;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import static ocp.utils.PrintUtils.println;

public class UsingResourceBundle {

    public static void main(String[] args) {
        UsingResourceBundle urb = new UsingResourceBundle();
        urb.usingResourceBundle();
        urb.usingProperties();
        urb.usingJavaClassResourceBundle();
        urb.usingMessageFormatter();
    }

    public void usingResourceBundle() {
        printBundleContentForSpecificLocale("Messages", new Locale("en", "US"));
        printBundleContentForSpecificLocale("Messages", Locale.US);
        printBundleContentForSpecificLocale("Messages", Locale.FRENCH);
        printBundleContentForSpecificLocale("Messages", Locale.FRANCE);
        println("----------------------------------------");
        //
        ResourceBundle messages = getResourceBundleForLocale("Messages", Locale.getDefault());
        println("For locale: " + Locale.getDefault());
        println(messages.getString("helloWorld"));
        println(messages.getString("onlyInDefault"));
        println("----------------------------------------");
        //
    }

    public void usingProperties() {
        Properties systemLocaleMessages = new Properties();
        ResourceBundle systemLocalMessagesBundle = getResourceBundleForLocale("Messages", Locale.getDefault());
        systemLocalMessagesBundle.keySet()
            .forEach(key -> systemLocaleMessages.put(key, systemLocalMessagesBundle.getString(key)));


        println(systemLocaleMessages.getProperty("helloWorld"));
        // It will be null since the property does not exist in the bundle properties object
        println(systemLocaleMessages.getProperty("nonExistentProperty"));
        // We can use default values for properties that doesn't exist
        println(systemLocaleMessages.getProperty("nonExistentProperty", "a default value"));

        println("----------------------------------------");

    }

    private void usingJavaClassResourceBundle() {
        printBundleContentForSpecificLocale("JavaMessages", Locale.US);
        println("----------------------------------------");
    }

    private void usingMessageFormatter(){
        ResourceBundle rb = getResourceBundleForLocale("Messages", Locale.getDefault());
        String hello = rb.getString("helloByName");
        println(MessageFormat.format(hello, "Esteban"));
        println("----------------------------------------");

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
            .forEach(System.out::println);
    }

    private ResourceBundle getResourceBundleForLocale(String bundleName, Locale locale) {
        return ResourceBundle.getBundle(bundleName, locale);
    }

}
