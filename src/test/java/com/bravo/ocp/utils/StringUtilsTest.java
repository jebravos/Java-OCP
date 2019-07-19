package com.bravo.ocp.utils;

import org.junit.Assert;
import org.junit.Test;

import static com.bravo.ocp.utils.StringUtils.format;

public class StringUtilsTest {

    public static final String TEMPLATE_1 = "{}";
    public static final String TEMPLATE_2 = "hola {}";
    public static final String TEMPLATE_3 = "hola {} y adios";


    @Test
    public void testFormat(){

        //GIVEN
        String replacementValue = "Esteban";

        //WHEN
        String result1 = format(TEMPLATE_1, replacementValue);
        String result2 = format(TEMPLATE_2, replacementValue);
        String result3 = format(TEMPLATE_3, replacementValue);
        //THEN
        Assert.assertEquals(replacementValue, result1);
        Assert.assertEquals("hola " + replacementValue, result2);
        Assert.assertEquals("hola " + replacementValue + " y adios", result3);

    }

    @Test
    public void testFormatNoArguments(){

        //GIVEN
        String replacementValue = "Esteban";

        //WHEN
        String result1 = format(TEMPLATE_1);
        String result2 = format(TEMPLATE_2);
        String result3 = format(TEMPLATE_3);
        //THEN
        Assert.assertEquals(TEMPLATE_1, result1);
        Assert.assertEquals(TEMPLATE_2, result2);
        Assert.assertEquals(TEMPLATE_3, result3);

    }

}
