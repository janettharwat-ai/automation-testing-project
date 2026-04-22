package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FooterPage {
    WebDriver driver;
    WebDriverWait wait;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By facebookIcon = By.xpath("//a[contains(@href,'facebook')]");
    By linkedinIcon = By.xpath("//a[contains(@href,'linkedin')]");


    @Step("Click on social media icon")
    private void clickSocial(By locator) {

        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", el
        );

        wait.until(ExpectedConditions.elementToBeClickable(el));

        try {
            el.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", el);
        }
    }

    @Step("Click on Facebook icon")
    public void clickFacebook() {
        clickSocial(facebookIcon);
    }

    @Step("Click on LinkedIn icon")
    public void clickLinkedIn() {
        clickSocial(linkedinIcon);
    }
}
