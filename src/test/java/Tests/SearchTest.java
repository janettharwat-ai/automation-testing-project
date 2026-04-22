package Tests;

import Pages.SearchPage;
import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Feature("Functionality")
    @Epic("Search")
    @Description("User enters keyword and presses enter to navigate to results page")
    @Severity(SeverityLevel.CRITICAL)


    @Test
    public void testValidSearchKeyword() {

        SearchPage searchPage = new SearchPage(driver);

        String keyword = "كيف تنضم إلى البنك";

        searchPage.search(keyword);

        Assert.assertTrue(
                searchPage.isSearchResultDisplayed(),
                " Search results are not displayed"
        );
    }
}