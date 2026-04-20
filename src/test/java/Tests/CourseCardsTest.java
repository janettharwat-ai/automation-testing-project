package Tests;

import Base.BaseTest;
import Pages.CourseCardsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseCardsTest extends BaseTest {

    @Test
    public void verifyCourseCardUI() {

        driver.get("https://eyouthlearning.com/ar/courses");

        CourseCardsPage courseCardsPage = new CourseCardsPage(driver);

        courseCardsPage.getFirstCourseCard(); // force wait

        Assert.assertTrue(courseCardsPage.isCourseImageDisplayed(),
                "Course image is NOT displayed");

        Assert.assertTrue(courseCardsPage.isCourseTitleDisplayed(),
                "Course title is NOT displayed");

        Assert.assertTrue(courseCardsPage.isInstructorNameDisplayed(),
                "Instructor name is NOT displayed");

        Assert.assertTrue(courseCardsPage.isSubscribeButtonDisplayed(),
                "Subscribe button is NOT displayed");
    }
}
