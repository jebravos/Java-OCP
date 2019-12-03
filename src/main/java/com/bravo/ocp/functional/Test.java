package com.bravo.ocp.functional;

import static com.bravo.ocp.utils.PrintUtils.println;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

    public Test() {
        super();
    }

    class MyObject{
        String string;
        Integer id;

        public String getString() {
            return string;
        }

        MyObject(String string, Integer id) {
            this.string = string;
            this.id = id;



        }
    }

    public static void main(String[] args) {
//        Test t = new Test();
//        t.test();
//        t.test();
//        t.test();
        t();
    }

    private void test() {
        List<MyObject> list = Arrays.asList(new MyObject("01", 1), null, new MyObject("01", 3), new MyObject("02", 12));
        Set<String> set = list.stream().map(MyObject::getString).filter(Objects::nonNull).collect(Collectors.toSet());
        println(set);
    }


    private static void t(){
        StringWriter sw = new StringWriter();
        sw.append("hello world");
        println(sw.toString());
    }


}
