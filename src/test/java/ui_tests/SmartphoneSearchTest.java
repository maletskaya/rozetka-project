package ui_tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SamsungGalaxyS5Page;
import pages.SearchPage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SmartphoneSearchTest extends TestBase {

    HomePage homePage = new HomePage();

    SamsungGalaxyS5Page samsungGalaxyS5Page = new SamsungGalaxyS5Page();

    SearchPage searchPage = new SearchPage();

    @Test
    public void setUpPreconditions() {

        homePage.open(TestData.ROZETKA_URL);

        assertTrue(homePage.isOpened(TestData.ROZETKA_URL));

    }


    @Test(dependsOnMethods = {"setUpPreconditions"}, enabled = true)

    public void testSearchSmartphoneAndVerifyCharacteristics() {

        homePage.searchProduct(TestData.SAMSUNG_G900H_GALAXY_S5);

        assertEquals(searchPage.verifyProductLink(), TestData.SAMSUNG_G900H_GALAXY_S5);

        searchPage.openProductLink();

        assertTrue(samsungGalaxyS5Page.verifyProductContent().getText().contains(TestData.SAMSUNG_PROCESSOR));

    }

}
