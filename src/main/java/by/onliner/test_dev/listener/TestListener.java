package by.onliner.test_dev.listener;

import by.onliner.driver.DriverManager;
import by.onliner.utils.Recorder;
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
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

/***
 * TestListener is used to log information on the test run flow and to the reporting system.
 */
public class TestListener implements ITestListener {

    protected final Logger logger = LogManager.getLogger(this);

    @Override
    public void onStart(ITestContext context) {
        logger.info("The test class run started on " + context.getStartDate());
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "96.0.4664.110 (Official build), (64 bit)")
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
            FileUtils.deleteDirectory(new File(Recorder.savePath));
            clearFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * When Test case get Started, this method is called.
     */
    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test [" + result.getName() + "] STARTED");
        try {
            Recorder.startRecording(result.getName());
        } catch (Exception e) {
            logger.info("Can't start video recording");
            e.printStackTrace();
        }
    }

    /***
     * When Test case get passed, this method is called.
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test [" + result.getName() + "] PASSED");
        try {
            Recorder.stopRecording(result.getName());
            appendLogToAllure();
            takeScreenshot();
            attachVideoToAllure(Recorder.savePath + result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * When Test case get failed, this method is called.
     */
    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Test [" + result.getName() + "] FAILED");
        try {
            Recorder.stopRecording(result.getName());
            appendLogToAllure();
            takeScreenshot();
            attachVideoToAllure(Recorder.savePath + result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * When Test case get Skipped, this method is called.
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Test [" + result.getName() + "] SKIPPED");
        try {
            Recorder.stopRecording(result.getName());
            appendLogToAllure();
            takeScreenshot();
            attachVideoToAllure(Recorder.savePath + result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info("Test [" + result.getName() + "] FAILED but with some percentage of success");
        try {
            Recorder.stopRecording(result.getName());
            appendLogToAllure();
            takeScreenshot();
            attachVideoToAllure(Recorder.savePath + result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        logger.info("Test [" + result.getName() + "] FAILED due to the timeout");
        try {
            Recorder.stopRecording(result.getName());
            appendLogToAllure();
            takeScreenshot();
            attachVideoToAllure(Recorder.savePath + result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * Attachment logging for report.
     */
    @Attachment(value = "Test logs", type = "text/plain")
    private byte[] appendLogToAllure() {
        try {
            return FileUtils.readFileToByteArray(new File("target/logs/appTest.log"));
        } catch (IOException ignored) {
            return null;
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
            logger.debug("attachVideoToAllure(): FAILED\n" + e.getMessage());
            return new byte[0];
        }
    }

    /***
     * Clear log file after attaching log file to report.
     */
    private void clearFile() throws IOException {
        PrintWriter writer = new PrintWriter("target/logs/appTest.log");
        writer.print("");
        writer.close();
    }
}
