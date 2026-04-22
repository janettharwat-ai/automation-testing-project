package Tests;

import Base.BaseTest;
import Pages.EmptyFields;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyFieldsTest extends BaseTest {


    @Epic("Authentication")
    @Feature("Login Validation")
    @Description("Verify validation messages appear when login fields are empty")
    @Severity(SeverityLevel.CRITICAL)


    @Test
    public void loginWithEmptyFields_shouldShowValidationErrors() {

        driver.get("https://eyouthlearning.com/ar/auth/login");

        EmptyFields loginPage = new EmptyFields(driver);

        loginPage.clickLogin();


        Assert.assertTrue(
                loginPage.isEmailErrorDisplayed(), "البريد الإلكتروني مطلوب");

        Assert.assertTrue(
                loginPage.isPasswordErrorDisplayed(),  "كلمة المرور مطلوبة");
    }
}
