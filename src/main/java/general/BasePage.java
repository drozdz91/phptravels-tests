package general;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

@Getter
public class BasePage implements IAssertions {

    protected WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        initElements(new DefaultElementLocatorFactory(driver), this);
    }

    public void clickElementUsingJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    @SuppressWarnings("unchecked")
    public <G extends BasePage, T extends AbstractAssertions<G>> T check(Class<T> clazz) throws RuntimeException {
        try {
            AbstractAssertions<G> assertions = clazz.newInstance();
            assertions.setPage((G)this);
            return (T) assertions;
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @SuppressWarnings("unchecked")
    public <Input extends BasePage, Output extends BasePage> Output run(Scenario<Input, Output> scenario) {
        return scenario.run((Input)this);
    }
}
