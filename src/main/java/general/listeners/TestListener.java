package general.listeners;

import general.TestBase;
import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j
public class TestListener extends TestBase implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test " + result.getName() + " passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test " + result.getName() + " failed!");

        Object testClass = result.getInstance();
        WebDriver driver = ((TestBase) testClass).getDriver();

        if (driver != null)
        makeScreenShot(driver);

        saveTextLog(getTestMethodName(result) + " failed and screenshot taken");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("Test " + result.getName() + " skipped!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("Test " + result.getName() + " failed!");

        Object testClass = result.getInstance();
        WebDriver driver = ((TestBase) testClass).getDriver();

        if (driver != null)
        makeScreenShot(driver);

        saveTextLog(getTestMethodName(result) + " failed and screenshot taken");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    @Attachment(value = "Page screenshot test failure", type = "image/png")
    public byte[] makeScreenShot(WebDriver driver) {
        byte[] screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return screenshotFile;
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }
}
