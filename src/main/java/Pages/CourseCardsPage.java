package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CourseCardsPage {

    WebDriver driver;
    WebDriverWait wait;

    public CourseCardsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // increased timeout
    }

    By firstCourseCard = By.xpath("(//div//h3)[1]/ancestor::div[1]");

    By courseImage = By.xpath(".//img");
    By courseTitle = By.xpath(".//h3");
    By instructorName = By.xpath(".//h6");
    By subscribeButton = By.xpath(".//button");


    @Step("Get first course card")
    public WebElement getFirstCourseCard() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(firstCourseCard));
    }

    @Step("Scroll and wait for first course card")
    public void waitForFirstCourseCard() {
        WebElement card = getFirstCourseCard();

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", card);

        wait.until(ExpectedConditions.visibilityOf(card));
    }

    @Step("Verify course image is displayed")
    public boolean isCourseImageDisplayed() {

        WebElement card = getFirstCourseCard();

        By imgLocator = courseImage;

        WebElement img = wait.until(
                ExpectedConditions.presenceOfNestedElementLocatedBy(card, imgLocator)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", img);

        wait.until(ExpectedConditions.visibilityOf(img));

        return img.isDisplayed();
    }

    @Step("Verify course title is displayed")
    public boolean isCourseTitleDisplayed() {
        WebElement card = getFirstCourseCard();

        return wait.until(
                ExpectedConditions.visibilityOfNestedElementsLocatedBy(card, courseTitle)
        ).get(0).isDisplayed();
    }

    @Step("Verify instructor name is displayed")
    public boolean isInstructorNameDisplayed() {
        WebElement card = getFirstCourseCard();

        return wait.until(
                ExpectedConditions.visibilityOfNestedElementsLocatedBy(card, instructorName)
        ).get(0).isDisplayed();
    }

    @Step("Verify subscribe button is displayed")
    public boolean isSubscribeButtonDisplayed() {
        WebElement card = getFirstCourseCard();

        return wait.until(
                ExpectedConditions.visibilityOfNestedElementsLocatedBy(card, subscribeButton)
        ).get(0).isDisplayed();
    }
}