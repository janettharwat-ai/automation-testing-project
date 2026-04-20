package Tests;

import Base.BaseTest;
import Pages.FooterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class FooterTest extends BaseTest {

    private void switchToNewTab() {
        new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.getWindowHandles().size() > 1);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    @Test
    public void verifyFacebookLink() {

        driver.get("https://eyouthlearning.com/ar");

        FooterPage footer = new FooterPage(driver);
        String mainTab = driver.getWindowHandle();

        footer.clickFacebook();
        switchToNewTab();

       Assert.assertTrue(driver.getCurrentUrl().contains("facebook.com"));

        driver.close();
        driver.switchTo().window(mainTab);
    }


    @Test
    public void verifyLinkedInLink() {

        driver.get("https://eyouthlearning.com/ar");

        FooterPage footer = new FooterPage(driver);
        String mainTab = driver.getWindowHandle();

        footer.clickLinkedIn();
        switchToNewTab();

        Assert.assertTrue(driver.getCurrentUrl().contains("linkedin.com"));

        driver.close();
        driver.switchTo().window(mainTab);
    }
}
