package com.bravo.ocp.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleUtils {

  public static void printBundleContentForSpecificLocale(String bundleName, Locale locale) {
    ResourceBundle messagesBundle = getResourceBundleForLocale(bundleName, locale);
    // If a default resource bundle exist,
    // this will also print the key - value pairs that dont exist in the bundle for the requested locale
    // and exist in the default bundle
    messagesBundle.keySet()
        .stream()
        // messagesBundle.getString(key)) is also valid when you don't use Java bundle resources
        .map(key -> key + " = " + messagesBundle.getObject(key))
        .forEach(PrintUtils::println);
  }


  public static ResourceBundle getResourceBundleForLocale(String bundleName, Locale locale) {
    return ResourceBundle.getBundle(bundleName, locale);
  }

}
