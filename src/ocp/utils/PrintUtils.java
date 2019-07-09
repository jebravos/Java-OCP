package ocp.utils;

import java.time.Duration;
import java.util.Arrays;
import static ocp.utils.StringUtils.replaceNextWildcardWithNonNullValueOnTemplate;
import static ocp.utils.StringUtils.stringValueOrNull;

public class PrintUtils {

    public static void print(Object o){
        System.out.print(stringValueOrNull(o));
    }

    public static void print(String template, Object... args){
        if(args.length > 0){
            StringBuilder textBuilder = new StringBuilder(template);
            Arrays.stream(args)
                    .forEach(replaceNextWildcardWithNonNullValueOnTemplate(textBuilder));
            print(textBuilder.toString());
        }

    }

    public static void println(){
        System.out.println();
    }

    public static void println(Object o){
        System.out.println(stringValueOrNull(o));
    }

    public static void println(String message){
        System.out.println(message);
    }

    public static void println(String template, Object... args){
        if(args.length > 0){
            StringBuilder textBuilder = new StringBuilder(template);
            Arrays.stream(args)
                    .forEach(replaceNextWildcardWithNonNullValueOnTemplate(textBuilder));
            println(textBuilder.toString());
        }

    }

    //TODO move this to another class
    public static void sleep(long timeToWaitInMillis) {
        try {
            Thread.sleep(timeToWaitInMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error while sleeping", e.getCause());
        }
    }

//
//    public static void main(String[] args) {
//        println("Hello {} ... {} ... {}", "world", "aze", "123");
//        println("Hello {} ... {} ... {}", "AZE");
//        println("Hello {} ... {} ... {}", null, null, "123");
//    }
}
