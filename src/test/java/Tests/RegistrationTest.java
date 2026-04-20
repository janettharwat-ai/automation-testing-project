package Tests;

import Pages.HomePage;
import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void testOpenSignupPage() {

        HomePage homePage = new HomePage(driver, wait);

        homePage.clickJoinUs();

        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("join-as-instructor"),
                ExpectedConditions.urlContains("auth/login")
        ));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/join-as-instructor")
        );
    }
}