package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CoursesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By allCoursesBtn = By.xpath("//a[@href='/ar/courses']");
    private By coursesContainer = By.xpath("//div[contains(@class,'grid')]");
    private By firstCourse = By.xpath("(//a[contains(@href,'/course')])[1]");
    private By courseDetailsSection = By.xpath("//*[contains(text(),'حول الدورة')]");


    @Step("Click on All Courses button")
    public void clickAllCourses() {

        wait.until(ExpectedConditions.elementToBeClickable(allCoursesBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(coursesContainer));
    }

    @Step("Click on first course card")
    public void clickFirstCourse() {

        WebElement course = wait.until(
                ExpectedConditions.presenceOfElementLocated(firstCourse)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", course);

        for (int i = 0; i < 2; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(course)).click();
                return;
            } catch (StaleElementReferenceException e) {
                course = driver.findElement(firstCourse);
            }
        }
    }

    @Step("Verify course details page is opened")
    public boolean isCourseDetailsPageOpened() {
        return wait.until(driver ->
                driver.getCurrentUrl().contains("/course")
        );
    }

    @Step("Verify course details section is visible")
    public boolean isCourseDetailsSectionVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(courseDetailsSection)
        ).isDisplayed();
    }
}