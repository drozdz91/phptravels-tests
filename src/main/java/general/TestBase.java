package general;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import static general.PropertyManager.getInstance;
import static java.util.concurrent.TimeUnit.SECONDS;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void launchBrowser() {
        getInstance();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
    }

    @AfterMethod
    public void closeBrowser(ITestResult result) {
        takeScreenshots(result);
        driver.close();
        driver.quit();
    }

    private void takeScreenshots(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE){
            try {
                String reportDirectory = new File(System.getProperty("user.dir")) + "/test-output/failed-tests-screenshots/";
                String screenshotPath = reportDirectory + result.getName() + ".jpg";
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(screenshotPath));
                Reporter.log("<a href='"+ screenshotPath + "'> <img src='"+ screenshotPath + "' height='100' width='100'/> </a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
