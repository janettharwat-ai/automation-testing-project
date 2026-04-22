package Tests;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.CoursesPage;

public class CoursesTest extends BaseTest {


    @Epic("Courses")
    @Feature("Course Details")
    @Description("Verify that user can open course details page from courses list")
    @Severity(SeverityLevel.NORMAL)



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