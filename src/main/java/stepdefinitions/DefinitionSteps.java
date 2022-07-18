package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.ProductPage;
import pages.ShoppingCartPage;
import pages.SignInPage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static utils.WaitingUtils.waitForAjaxToComplete;
import static utils.WaitingUtils.waitForPageLoadComplete;

public class DefinitionSteps {

    private final PageFactoryManager pageFactoryManager = new PageFactoryManager();
    private final ProductPage productPage = (ProductPage) pageFactoryManager.getPage(ProductPage.PAGE_ID);
    private final ShoppingCartPage shoppingCartPage = (ShoppingCartPage) pageFactoryManager.getPage(ShoppingCartPage.PAGE_ID);
    private final SignInPage signInPage = (SignInPage) pageFactoryManager.getPage(SignInPage.PAGE_ID);
    private final HomePage homePage = (HomePage) pageFactoryManager.getPage(HomePage.PAGE_ID);


    @And("User opens {string} page")
    public void opensPage(final String pageName) {
        pageFactoryManager.getPage(pageName).openPage();
        waitForPageLoadComplete();
        waitForAjaxToComplete();
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
        pageFactoryManager.getPage(pageName).openShoppingCartPage();
        waitForPageLoadComplete();
        waitForAjaxToComplete();
    }

    @And("User verify the visibility of the link new customer")
    public void verifyVisibilityOfLinkNewCustomer() {
        assertTrue("Link New customer is visible on the page", signInPage.isButtonNewCustomersVisible());
    }

    @Then("Sign page with {string} url is opened")
    public void signPageWithSignInUrlIsOpened(final String pageName) {
        pageFactoryManager.getPage(pageName).openSignInPage();
    }

    @When("User clicks by the link new customer")
    public void clicksByLinkNewCustomer() {
        signInPage.clickButtonNewCustomers();
    }

    @And("User verify search field visibility")
    public void verifySearchFieldVisibility() {
        assertTrue("Search  is visible on the page", homePage.isSearchProductVisible());
        waitForPageLoadComplete();
    }

    @When("User searches products by {string} keyword")
    public void searchProductsByKeyword(final String keyword) {
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
    }

    @Then("User click by the button Sign In")
    public void clickByButtonSignIn() {
        signInPage.clickButtonSignIn();
    }

    @And("User verify the visibility list of the {int} products")
    public void verifyVisibilityListOfProducts(final int productsCount) {
        List<WebElement> products = productPage.getProductsCards();
        assertEquals(products.size(), productsCount);
    }

    @Then("User checks that there are products with a price of {double}")
    public void checkThatThereAreProductsWithAPriceOf(final double expectedPrice) {
        List<Double> prices = productPage.getProductsPriceList();
        List<Double> filteredPrices = prices.stream()
                .filter(p->p.equals(expectedPrice)).collect(Collectors.toList());
        assertTrue(filteredPrices.size() >= 2);
    }

    @When("User clicks on the {int} product")
    public void userClicksOnProduct(final int productNumber) {
        productPage.clickProduct(productNumber);
        waitForPageLoadComplete();
    }

    @And("User clicks 'Add to cart' button")
    public void userClicksAddToCartButton() {
        productPage.clickButtonAddCart();
        waitForPageLoadComplete();
    }

    @And("User verifies that the product is added to the cart")
    public void verifyThatTheProductIsInTheCart() {
        List<WebElement> cartProductsList = shoppingCartPage.getCartProductsList();
//        String name = TextContext.get()
//        assertEquals(name, cartProductsList);
    }
}
