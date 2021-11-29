package com.automationbytarun.components;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.ITestListener;


public class Retry implements IRetryAnalyzer {


    private static final int MAX_RETRY = 2;
    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {

        if (!result.isSuccess()) {
            if (retryCount < MAX_RETRY) {
                retryCount++;
                result.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                System.out.println("a");
                result.setStatus(ITestResult.FAILURE);
            }
        } else {
            result.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
