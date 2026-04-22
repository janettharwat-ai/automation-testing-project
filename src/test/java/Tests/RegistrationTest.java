package Tests;

import Pages.HomePage;
import Base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {


    @Epic("Authentication")
    @Feature("Signup")
    @Description("Verify that user can open signup page")
    @Severity(SeverityLevel.NORMAL)


    @Test
    public void testOpenSignupPage() {

        HomePage homePage = new HomePage(driver, wait);

        homePage.clickJoinUs();

        wait.until(driver -> driver.getCurrentUrl().contains("auth/login")
                || driver.getCurrentUrl().contains("join-as-instructor"));

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("auth/login") ||
                        currentUrl.contains("join-as-instructor"),
                "Navigation failed. Current URL: " + currentUrl
        );
    }
}