package by.onliner.core.listener;

import by.onliner.core.driver.DriverManager;
import by.onliner.core.configer.BrowserConfig;
import by.onliner.core.utils.recorder.VideoManager;
import by.onliner.core.utils.FileUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

import static by.onliner.constants.OnlinerConstants.LOG_PATH;
import static by.onliner.constants.OnlinerConstants.SAVE_VIDEO_PATH;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

/***
 * TestListener is used to log information on the test run flow and to the reporting system.
 */
public class TestListener implements ITestListener {

    protected final Logger logger = LogManager.getLogger(this);

    /***
     * This method is called before suite get Started.
     */
    @BeforeSuite
    public void onSuiteStart(ITestContext context) {
        context.getCurrentXmlTest().getSuite().setThreadCount(getThreadCount());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("The test class run started on " + context.getStartDate());
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", BrowserConfig.getType().getName())
                        .build(), System.getProperty("user.dir")
                        + "/target/allure-results/");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("\n" +
                "  _____ _____ ____ _____   _____ ___ _   _ ___ ____  _   _ _____ ____  \n" +
                " |_   _| ____/ ___|_   _| |  ___|_ _| \\ | |_ _/ ___|| | | | ____|  _ \\ \n" +
                "   | | |  _| \\___ \\ | |   | |_   | ||  \\| || |\\___ \\| |_| |  _| | | | |\n" +
                "   | | | |___ ___) || |   |  _|  | || |\\  || | ___) |  _  | |___| |_| |\n" +
                "   |_| |_____|____/ |_|   |_|   |___|_| \\_|___|____/|_| |_|_____|____/ \n" +
                "on -> " + context.getEndDate());
        try {
            FileUtils.deleteDirectory(new File(SAVE_VIDEO_PATH));
            FileUtil.clearTextFile(LOG_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * When Test case get Started, this method is called.
     */
    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        logger.info(String.format("Test {%s} STARTED", testName));
        VideoManager.getVideoRecorder().startRecording(testName);
    }

    /***
     * When Test case get passed, this method is called.
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getName();
        logger.info(String.format("Test {%s} PASSED", testName));
        VideoManager.stopDefaultRecording(testName);
        appendLogToAllure();
        takeScreenshot();
        attachVideoToAllure(SAVE_VIDEO_PATH + testName);
    }

    /***
     * When Test case get failed, this method is called.
     */
    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        logger.info(String.format("Test {%s} FAILED", testName));
        VideoManager.stopDefaultRecording(testName);
        appendLogToAllure();
        takeScreenshot();
        attachVideoToAllure(SAVE_VIDEO_PATH + testName);
    }

    /***
     * When Test case get Skipped, this method is called.
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getName();
        logger.info(String.format("Test {%s} SKIPPED", testName));
        VideoManager.stopDefaultRecording(testName);
        appendLogToAllure();
        takeScreenshot();
        attachVideoToAllure(SAVE_VIDEO_PATH + testName);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        String testName = result.getName();
        logger.info(String.format("Test {%s} FAILED but with some percentage of success", testName));
        VideoManager.stopDefaultRecording(testName);
        appendLogToAllure();
        takeScreenshot();
        attachVideoToAllure(SAVE_VIDEO_PATH + testName);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        String testName = result.getName();
        logger.info(String.format("Test {%s} FAILED due to the timeout", testName));
        VideoManager.stopDefaultRecording(testName);
        appendLogToAllure();
        takeScreenshot();
        attachVideoToAllure(SAVE_VIDEO_PATH + testName);
    }

    /***
     * Attachment logging for report.
     */
    @Attachment(value = "Test logs", type = "text/plain")
    private byte[] appendLogToAllure() {
        try {
            return FileUtils.readFileToByteArray(new File(LOG_PATH));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    /***
     * Attachment screenshot for report.
     */
    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    /***
     * Attachment video of test for report.
     */
    @Attachment(value = "VideoFile", type = "video/mp4")
    public byte[] attachVideoToAllure(String videoFileLocation) {
        try {
            return Files.toByteArray(new File(videoFileLocation + ".mp4"));
        } catch (IOException e) {
            logger.info("attachVideoToAllure(): FAILED\n" + e.getMessage());
            return new byte[0];
        }
    }

    private int getThreadCount() {
        String count = System.getProperty("threadCount");
        return Integer.parseInt(count);
    }
}
