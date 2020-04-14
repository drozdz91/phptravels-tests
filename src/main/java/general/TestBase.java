package general;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static general.PropertyManager.getInstance;
import static java.util.concurrent.TimeUnit.SECONDS;

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
        if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SUCCESS_PERCENTAGE_FAILURE)
            makeScreenShot(result);
        driver.close();
        driver.quit();
    }

    @Attachment(value = "Page screenshot test failure", type = "image/png")
    public byte[] makeScreenShot(ITestResult result) {
        byte[] screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return screenshotFile;
    }
}
