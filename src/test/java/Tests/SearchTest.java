package Tests;

import Pages.SearchPage;
import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

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