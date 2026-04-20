package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By searchInput = By.xpath("//input[@placeholder='بحث عن الدورات التدريبية']");
    private By resultsText = By.xpath("//*[contains(text(),'البنك')]");

    public void search(String keyword) {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchInput)
        );

        input.clear();
        input.sendKeys(keyword);
        input.sendKeys(Keys.ENTER);
    }

    public boolean isSearchResultDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(resultsText)
        ).isDisplayed();
    }
}