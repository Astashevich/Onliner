package by.onliner.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/***
 * RetryAnalyzer helps to check if the failure was caused by a network glitch, random machine issues, server issues
 * like unexpected delay in the response from server.
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    private int actualRetry = 0;
    private static final int MAX_RETRY = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (actualRetry < MAX_RETRY) {
                actualRetry++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
