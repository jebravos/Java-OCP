import java.util.ListResourceBundle;

public class JavaMessages_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
            { "helloWorld", "Hello from fucking java" },
            { "firstApp", " This is my first resource bundle app" },
            { "IntegerValue", 1},
        };
    }
}
