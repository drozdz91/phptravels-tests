package general;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ScreenshotMaker;

import static general.PropertyManager.getInstance;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.ITestResult.FAILURE;
import static org.testng.ITestResult.SUCCESS_PERCENTAGE_FAILURE;

public class TestBase {

    protected WebDriver driver;

    @Step("Loading configuration and setting up browser")
    @BeforeMethod
    public void launchBrowser() {
        getInstance();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
    }

    @Step("Disposing browser")
    @AfterMethod
    public void closeBrowser(ITestResult result) {
        makeScreenshotOnTestFailure(result);
        driver.close();
        driver.quit();
    }

    private void makeScreenshotOnTestFailure(ITestResult result) {
        ScreenshotMaker screenshotMaker = new ScreenshotMaker();
        if (result.getStatus() == FAILURE || result.getStatus() == SUCCESS_PERCENTAGE_FAILURE)
            screenshotMaker.makeScreenshot(driver);
    }
}
