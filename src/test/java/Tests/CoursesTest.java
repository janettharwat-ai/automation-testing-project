package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CoursesPage;

public class CoursesTest extends BaseTest {

    @Test
    public void testOpenCourseDetails() {

        CoursesPage coursesPage = new CoursesPage(driver);

        coursesPage.clickAllCourses();

        coursesPage.clickFirstCourse();

        Assert.assertTrue(
                coursesPage.isCourseDetailsPageOpened(),
                "Course details page did not open"
        );

        Assert.assertTrue(
                coursesPage.isCourseDetailsSectionVisible(),
                "Course details section is NOT visible"
        );

        Assert.assertTrue(
                coursesPage.isCourseDetailsSectionVisible(),
                "حول الدورة التدريبية"
        );
    }
}