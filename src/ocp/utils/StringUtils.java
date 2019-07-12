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
                int nextWildcardIndex = stringBuilder.indexOf("{}");
                if(nextWildcardIndex > 0){
                    requireNonNull(stringBuilder).replace(nextWildcardIndex, nextWildcardIndex + 2, value.toString());
                }
            }
        };
    }
}
