package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By joinUsButton = By.xpath("//a[contains(@href,'join-as-instructor')]");

    public void clickJoinUs() {

        WebElement joinUsBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(joinUsButton)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", joinUsBtn);

        wait.until(ExpectedConditions.elementToBeClickable(joinUsButton));

        try {
            joinUsBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", joinUsBtn);
        }
    }
}