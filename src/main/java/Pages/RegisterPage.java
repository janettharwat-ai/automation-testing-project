package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }


    By emailField = By.id("email");
    By phoneField = By.id("phone");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("confirm_password");
    By createButton = By.xpath("//button[contains(.,'إنشاء')]");
    By countryField = By.xpath("//button[.//span[contains(text(),'الدولة')]]");
    By governorateField = By.xpath("//button[.//span[contains(text(),'المحافظة')]]");
    By genderField = By.xpath("//button[.//span[contains(text(),'النوع')]]");
    By usernameError = By.xpath("//p[contains(text(),'الاسم مطلوب')]");

    private void click(By locator) {

        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", el);

        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));

        try {
            el.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", el);
        }
    }

    private void selectRadixOption(String value) {

        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By option = By.xpath("//*[normalize-space()='" + value + "']");

        WebElement el = localWait.until(driver -> {
            for (WebElement e : driver.findElements(option)) {
                if (e.isDisplayed() && e.getSize().getHeight() > 0) {
                    return e;
                }
            }
            return null;
        });

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", el);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(el));
            el.click();
        } catch (Exception e) {
            actions.moveToElement(el).pause(Duration.ofMillis(200)).click().perform();
        }

        try {
            Thread.sleep(300);
        } catch (InterruptedException ignored) {
        }
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField)).sendKeys(phone);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(password);
    }

    public void selectCountry(String country) {
        click(countryField);
        selectRadixOption(country);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectGovernorate(String gov) {
        click(governorateField);
        selectRadixOption(gov);
    }

    public void selectGender(String gender) {
        click(genderField);
        selectRadixOption(gender);
    }

    public void clickCreate() {
        click(createButton);
    }

    public String getUsernameErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameError))
                .getText().trim();
    }
}