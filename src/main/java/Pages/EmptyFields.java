package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmptyFields {

    WebDriver driver;
    WebDriverWait wait;

    public EmptyFields(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By loginButton = By.xpath("//button[normalize-space()='تسجيل الدخول']");
    By emailRequiredError = By.xpath("//p[contains(text(),'البريد الإلكتروني مطلوب')]");
    By passwordRequiredError = By.xpath("//p[contains(text(),'كلمة المرور مطلوبة')]");


    public void clickLogin() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        try {
            btn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        }
    }

    public boolean  isEmailErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailRequiredError)).isDisplayed();
    }

    public boolean isPasswordErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordRequiredError)).isDisplayed();
    }
}

