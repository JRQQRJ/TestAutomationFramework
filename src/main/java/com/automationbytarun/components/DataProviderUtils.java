package com.automationbytarun.components;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProviderUtils {

    @DataProvider(name= "jsonDataProvider")
    public static Object[][] getJsonTestData(Method method) throws IOException, ParseException {

        String testCaseName = method.getName();
        DataProviderArgs args = method.getAnnotation(DataProviderArgs.class);
        String testCaseArguments =args.value();
        String testDataName = testCaseArguments.split("=")[0];
//        System.out.println(testDataName);
        String testFields = testCaseArguments.split("=")[1];
//        System.out.println(testFields);
        List<String> allTestFields = Arrays.asList(testFields.split(","));
        System.out.println(allTestFields);

        File testDataFile = new File(System.getProperty("user.dir")+ "//src//test//resources//testData.json");

        FileReader fis = new FileReader(testDataFile);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fis);
//        System.out.println(obj);
        JSONObject testCase = (JSONObject) obj;

        JSONArray testArray = (JSONArray) testCase.get(testDataName);

        List<List<String>> listOfList = new ArrayList<>();

//        System.out.println(testArray);
        for(int i=0; i < testArray.size();i++){
            List<String> valueFromFields = new ArrayList<String>();
            JSONObject subset =  (JSONObject) testArray.get(i);
//            System.out.println(subset);
            for(int j =0;j<allTestFields.size();j++){

                valueFromFields.add(subset.get(allTestFields.get(j)).toString());

            }

            System.out.println(valueFromFields);
            listOfList.add(valueFromFields);
            System.out.println(listOfList);
        }

        return null;
    }
}
