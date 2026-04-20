package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class EndToEndPage {

    WebDriver driver;
    WebDriverWait wait;

    public EndToEndPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    By emailField = By.id("email");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//button[contains(.,'تسجيل الدخول')]");
    By allCoursesBtn = By.xpath("//a[contains(@href,'courses')]");
    By firstSubscribeBtn = By.xpath("(//button[contains(text(),'اشترك')])[1]");
    By cartIcon = By.xpath("//a[contains(@href,'cart') or contains(@class,'cart')]");
    By cartCourseTitles = By.xpath("//a[contains(@href,'/courses/')]");
    By successToast = By.xpath("//*[contains(text(),'تمت') or contains(text(),'added') or contains(text(),'نجاح')]");

    public void openLoginPage() {
        driver.get("https://eyouthlearning.com/ar/auth/login?redirect=/ar");
    }

    public void login(String email, String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

        wait.until(ExpectedConditions.urlContains("/ar"));
    }

    public void openAllCourses() {

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(allCoursesBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

        wait.until(ExpectedConditions.urlContains("courses"));
    }

    public String subscribeToFirstCourse() {

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(firstSubscribeBtn));

        String courseName = btn.findElement(By.xpath("./ancestor::div//h3")).getText();

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

        wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(successToast),
                ExpectedConditions.urlContains("cart")
        ));

        return courseName;
    }

    public void goToCart() {

        WebElement cart = wait.until(
                ExpectedConditions.elementToBeClickable(cartIcon)
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cart);

        wait.until(ExpectedConditions.urlContains("cart"));

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[contains(@href,'courses') or contains(@href,'course')]")
        ));
    }

    public boolean isCourseAddedToCart(String expectedCourse) {

        wait.until(driver -> driver.findElements(cartCourseTitles).size() > 0);

        List<WebElement> items = driver.findElements(cartCourseTitles);

        System.out.println("Cart courses found: " + items.size());

        for (WebElement item : items) {
            System.out.println("Cart item: " + item.getText());
        }

        return items.stream()
                .map(WebElement::getText)
                .anyMatch(text -> text.contains(expectedCourse));
    }
}