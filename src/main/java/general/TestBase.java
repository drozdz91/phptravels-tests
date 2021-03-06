package general;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static general.PropertyManager.getInstance;
import static java.util.concurrent.TimeUnit.SECONDS;

public class TestBase {

    @Getter
    protected WebDriver driver;

    @Step("Loading configuration and setting up browser")
    @BeforeMethod(alwaysRun = true)
    public void launchBrowser() {
        getInstance();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
    }

    @Step("Disposing browser")
    @AfterMethod(alwaysRun = true)
    public void closeBrowser(ITestResult result) {
        driver.close();
        driver.quit();
    }
}
