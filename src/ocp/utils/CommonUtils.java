package ocp.utils;

import java.util.Arrays;
import static ocp.utils.StringUtils.replaceNextWildcardWithNonNullValueOnTemplate;
import static ocp.utils.StringUtils.stringValueOrNull;

public class CommonUtils {

    public static void printLn(Object o){
        System.out.println(stringValueOrNull(o));
    }

    public static void printLn(String message){
        System.out.println(message);
    }

    public static void printLn(String template, Object... args){
        if(args.length > 0){
            StringBuilder textBuilder = new StringBuilder(template);
            Arrays.stream(args)
                    .forEach(replaceNextWildcardWithNonNullValueOnTemplate(textBuilder));
            printLn(textBuilder.toString());
        }

    }

    public static void wait(int timeToWaitInMillis) throws InterruptedException {
        Thread.sleep(timeToWaitInMillis);
    }

//
//    public static void main(String[] args) {
//        printLn("Hello {} ... {} ... {}", "world", "aze", "123");
//        printLn("Hello {} ... {} ... {}", "AZE");
//        printLn("Hello {} ... {} ... {}", null, null, "123");
//    }
}
