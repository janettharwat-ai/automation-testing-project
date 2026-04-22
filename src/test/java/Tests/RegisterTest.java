package Tests;

import Base.BaseTest;
import Pages.RegisterPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Epic("Authentication")
    @Feature("Registration Validation")
    @Description("Verify that validation message appears when username field is left empty")
    @Severity(SeverityLevel.CRITICAL)


    @Test
    public void registerWithoutUsername_shouldShowValidationError() {

        driver.get("https://eyouthlearning.com/ar/auth/register");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.enterEmail("Janet@gmail.com");
        registerPage.enterPhone("01012345678");
        registerPage.enterPassword("Janet123@");
        registerPage.enterConfirmPassword("Janet123@");

        registerPage.selectCountry("مصر");
        registerPage.selectGovernorate("الإسكندرية");
        registerPage.selectGender("انثى");

        registerPage.clickCreate();

        Assert.assertEquals(
                registerPage.getUsernameErrorMessage(),
                "الاسم مطلوب"
        );
    }
}