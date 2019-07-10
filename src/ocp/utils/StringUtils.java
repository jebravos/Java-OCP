package ocp.utils;

import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;

class StringUtils {

    static String stringValueOrNull(Object o){
        return  o != null ? o.toString() : null;
    }

    static Consumer<Object> replaceNextWildcardWithNonNullValueOnTemplate(StringBuilder stringBuilder) {
        return value -> {
            if(value != null){
                requireNonNull(stringBuilder).replace(stringBuilder.indexOf("{}"), stringBuilder.indexOf("{}") + 2, value.toString());
            }
        };
    }
}
