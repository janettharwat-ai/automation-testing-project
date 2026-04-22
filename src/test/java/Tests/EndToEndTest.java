package Tests;

import Base.BaseTest;
import Pages.EndToEndPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {

    @Epic("End to End")
    @Feature("User Journey")
    @Description("Verify full flow: login, navigate to courses, subscribe, and check cart")
    @Severity(SeverityLevel.CRITICAL)



    @Test
    public void endToEndSubscribeCourse() {

        EndToEndPage page = new EndToEndPage(driver);

        page.openLoginPage();

        page.login(
                "andrewsamir2011@gmail.com",
                "Gin@01091502308"
        );

        page.openAllCourses();

        String courseName = page.subscribeToFirstCourse();

        page.goToCart();

        boolean result = page.isCourseAddedToCart(courseName);

        Assert.assertTrue(result,
                "Course NOT added to cart: " + courseName
        );
    }
}