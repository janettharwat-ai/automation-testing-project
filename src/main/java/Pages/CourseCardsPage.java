package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CourseCardsPage {

    WebDriver driver;
    WebDriverWait wait;

    public CourseCardsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By firstCourseCard = By.xpath("(//div//h3)[1]/ancestor::div[1]");

    By courseImage = By.xpath(".//img");
    By courseTitle = By.xpath(".//h3");
    By instructorName = By.xpath(".//h6");
    By subscribeButton = By.xpath(".//button");

    public WebElement getFirstCourseCard() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstCourseCard));
    }

    public boolean isCourseImageDisplayed() {
        WebElement card = getFirstCourseCard();
        return wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(card, courseImage))
                .get(0)
                .isDisplayed();
    }

    public boolean isCourseTitleDisplayed() {
        return getFirstCourseCard().findElement(courseTitle).isDisplayed();
    }

    public boolean isInstructorNameDisplayed() {
        return getFirstCourseCard().findElement(instructorName).isDisplayed();
    }

    public boolean isSubscribeButtonDisplayed() {
        return getFirstCourseCard().findElement(subscribeButton).isDisplayed();
    }
}