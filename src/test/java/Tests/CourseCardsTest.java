package Tests;

import Base.BaseTest;
import Pages.CourseCardsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CourseCardsTest extends BaseTest {

    CourseCardsPage courseCardsPage;

    @BeforeMethod
    public void setupPage() {
        courseCardsPage = new CourseCardsPage(driver);
    }

    @Epic("Courses")
    @Feature("Course Cards UI")
    @Description("Verify course card displays image, title, instructor name, and subscribe button")
    @Severity(SeverityLevel.CRITICAL)

    @Test
    public void verifyCourseCard() {

        openCoursesPage();
        waitForCourseCard();
        verifyCourseImage();
        verifyCourseTitle();
        verifyInstructorName();
        verifySubscribeButton();
    }

    public void openCoursesPage() {
        driver.get("https://eyouthlearning.com/ar/courses");
    }

    public void waitForCourseCard() {
        courseCardsPage.waitForFirstCourseCard();
    }

    public void verifyCourseImage() {
        Assert.assertTrue(courseCardsPage.isCourseImageDisplayed(),
                "Course image is NOT displayed");
    }

    public void verifyCourseTitle() {
        Assert.assertTrue(courseCardsPage.isCourseTitleDisplayed(),
                "Course title is NOT displayed");
    }

    public void verifyInstructorName() {
        Assert.assertTrue(courseCardsPage.isInstructorNameDisplayed(),
                "Instructor name is NOT displayed");
    }

    public void verifySubscribeButton() {
        Assert.assertTrue(courseCardsPage.isSubscribeButtonDisplayed(),
                "Subscribe button is NOT displayed");
    }
}