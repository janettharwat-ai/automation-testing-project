package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Epic("Authentication")
    @Feature("Login Validation")
    @Description("Verify that error message is displayed when user enters invalid credentials")
    @Severity(SeverityLevel.CRITICAL)


    @Test
    public void loginWithInvalidCredentials_shouldShowErrorMessage() {

        driver.get("https://eyouthlearning.com/ar/auth/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("jjanet@gmil.com");
        loginPage.enterPassword("jaannet123");

        loginPage.clickLogin();

        String actualMessage = loginPage.getErrorMessage();

        Assert.assertTrue(
                actualMessage.contains("لم يتم العثور على حساب نشط للبيانات المقدمة")
        );
    }
}
