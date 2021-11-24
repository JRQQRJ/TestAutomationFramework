package com.automationbytarun.helpers;

import org.testng.Assert;

public class TestAsserts {
    public static void checkIfValuesAreEqual(String value1, String value2){
        Assert.assertEquals(value1,value2,"Vales are not equal");
    }
    private static void checkIfValueContains(String valueToCHeck, String value){
        Assert.assertTrue(value.contains(valueToCHeck),"Value is not found in strings");
    }
}
