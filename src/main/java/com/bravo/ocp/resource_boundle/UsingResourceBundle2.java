package com.bravo.ocp.resource_boundle;

import static com.bravo.ocp.utils.PrintUtils.println;

import com.bravo.ocp.utils.ResourceBundleUtils;
import java.util.Locale;
import java.util.MissingResourceException;

public class UsingResourceBundle2 {


  public static void main(String[] args) {


    println("default local: {}", Locale.getDefault());
    // It loads messages in :
    // messages_fr_FR
    // messages_fr
    // messages
    ResourceBundleUtils.printBundleContentForSpecificLocale("messages", new Locale("fr", "FR"));
    println("----------------------------------");
    // Since we dont have a bundle message_aa_AA and default local is fr_FR it loads messages in :
    // messages_fr
    // messages
    ResourceBundleUtils.printBundleContentForSpecificLocale("messages", new Locale("aa", "AA"));
    println("----------------------------------");
    // Since we dont have a bundle message_aa_AA and default local is aa AA it loads messages in :
    // messages
    Locale.setDefault(new Locale("aa", "AA"));
    println("default local: {}", Locale.getDefault());
    ResourceBundleUtils.printBundleContentForSpecificLocale("messages", new Locale("aa", "AA"));
    println("----------------------------------");
    // Since no bundle file for nonExistent_aa_AA, nor nonExistent_aa_AA, nor nonExistent
    // We'll have an exception
    try{
      ResourceBundleUtils.printBundleContentForSpecificLocale("nonExistent", new Locale("aa", "AA"));
    } catch (MissingResourceException e){
      println("No bundle file was found!");
    }
    println("----------------------------------");

  }


}
