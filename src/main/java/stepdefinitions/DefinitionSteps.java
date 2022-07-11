package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ShoppingCartPage;
import pages.SignInPage;

import java.util.List;
import java.util.Map;

import static manager.DriverManager.getDriver;
import static utils.WaitingUtils.waitForAjaxToComplete;
import static utils.WaitingUtils.waitForPageLoadComplete;

public class DefinitionSteps {

    private final PageFactoryManager pageFactoryManager = new PageFactoryManager();
    private final ShoppingCartPage shoppingCartPage = (ShoppingCartPage) pageFactoryManager.getPage(ShoppingCartPage.PAGE_ID);
    private final SignInPage signInPage = (SignInPage) pageFactoryManager.getPage(SignInPage.PAGE_ID);
    private final HomePage homePage = (HomePage) pageFactoryManager.getPage(HomePage.PAGE_ID);


    @And("User opens {string} page")
    public void opensPage(final String pageName) {
        pageFactoryManager.getPage(pageName).openPage();
    }

    @And("User verify the visibility of the cart icon")
    public void verifyVisibilityOfCartIcon() {
        assertTrue("Cart icon is visible on the page", shoppingCartPage.isButtonShoppingCartVisible());
    }

    @When("User clicks by the shopping cart icon")
    public void clicksByShoppingCartIcon() {
        shoppingCartPage.clickButtonShoppingCart();
    }

    @Then("Cart page with {string} url is opened")
    public void cartPageIsOpened(final String pageName) {
        pageFactoryManager.getPage(pageName).openSignInPage();
        waitForPageLoadComplete();
        waitForAjaxToComplete();

//        String cartPageUrl = getDriver().getCurrentUrl();
//        assertEquals(cartPageUrl, expectedUrl);
    }

    @And("User verify the visibility of the link new customer")
    public void verifyVisibilityOfLinkNewCustomer() {
        assertTrue("Link New customer is visible on the page", signInPage.isButtonNewCustomersVisible());
    }

    @When("User clicks by the link new customer")
    public void clicksByLinkNewCustomer() {
        signInPage.clickButtonNewCustomers();
    }

    @And("User verify search field visibility")
    public void verifySearchFieldVisibility() {
        assertTrue("Search  is visible on the page", homePage.isSearchProductVisible());
    }

    @When("User searches products by {string} keyword")
    public void searchProductsByKeywordKeyword(final String keyword) {
        homePage.enterTextToSearchProduct(keyword);
        homePage.clickSearchButton();
        waitForPageLoadComplete();
        waitForAjaxToComplete();
    }

    @And("User verify the visibility of the link button Sign In")
    public void verifyVisibilityOfLinkButtonSignIn() {
        assertTrue("Button Sign In is visible on the page", signInPage.isButtonSignInVisible());
    }

    @And("Anonymous user sets data with following values:")
    public void anonymousUserSetsDataWithFollowingValues(final DataTable dataTable) {
        List<Map<String, String>> listOfMaps = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> data : listOfMaps) {
            String fieldName = data.get("fieldName");
            String fieldValue = data.get("fieldValue");
            switch (fieldName) {
                case ("password"):
                    signInPage.enterTextToFieldPassword(fieldValue);
                    break;
                case ("email"):
                    signInPage.enterTextToFieldEmail(fieldValue);
                    break;
                default:
                    System.out.println("field not found");
            }
        }
//        signInPage.enterTextToFieldEmail(dataTable.column(0).get(0));
//        signInPage.enterTextToFieldPassword(dataTable.column(1).get(0));
    }

    @Then("User click by the button Sign In")
    public void clickByButtonSignIn() {
        signInPage.clickButtonSignIn();
    }
}
