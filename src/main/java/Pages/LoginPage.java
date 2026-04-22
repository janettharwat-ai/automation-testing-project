package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By emailField = By.xpath("//input[@id='email']");
    By passwordField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[contains(text(),'تسجيل الدخول')]");
    By errorMessage = By.xpath("//p[contains(text(),'لم يتم العثور على حساب نشط')]");


    @Step("Enter email: {0}")
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }
    @Step("Enter password")
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    @Step("Click login button")
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
    @Step("Get login error message")
    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage))
                .getText()
                .trim();
    }
}