package com.automationbytarun.components;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.lang.reflect.Method;

public class DataProviderUtils {

    @DataProvider(name="jsonDataProvider")
    public static Object[][] getJsonTestData(Method method){

        String testCaseName = method.getName();
        DataProviderArgs args = method.getAnnotation(DataProviderArgs.class);
        String testCaseArguments =args.value();
        String TestDataName = testCaseArguments.split("=")[0];
        String TestFields = testCaseArguments.split("=")[1];

        File testDataFile = new File(System.getProperty("user.dir")+ "src//test//resources//testData.json");
        return null;
    }
}
