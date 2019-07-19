package com.bravo.ocp.utils;

import java.util.Arrays;
import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;

public class StringUtils {

    public static String stringValueOrNull(Object o) {
        return o != null ? o.toString() : null;
    }

    //TODO use another method name more explicit
    public static String format(String template, Object... args) {
        if (args.length > 0) {
            StringBuilder textBuilder = new StringBuilder(template);
            Arrays.stream(args)
                    .forEach(replaceNextWildcardWithNonNullValueOnTemplate(textBuilder));
            return  textBuilder.toString();
        }
        return template;
    }

    static Consumer<Object> replaceNextWildcardWithNonNullValueOnTemplate(StringBuilder stringBuilder) {
        return value -> {
            if (value != null) {
                int nextWildcardIndex = stringBuilder.indexOf("{}");
                if (nextWildcardIndex >= 0) {
                    requireNonNull(stringBuilder).replace(nextWildcardIndex, nextWildcardIndex + 2, value.toString());
                }
            }
        };
    }
}
