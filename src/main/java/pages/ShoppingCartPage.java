package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.WaitingUtils.waitForAjaxToComplete;
import static utils.WaitingUtils.waitForPageLoadComplete;

public class ShoppingCartPage extends BasePage{

    private static final String SHOPPING_PAGE_URL = "http://kuopassa.net/litecart/en/checkout";
    public static final String PAGE_ID = "ShoppingCart";

    @FindBy(xpath = "//*[@id='cart']/a/div")
    private WebElement buttonShoppingCart;

    @FindBy(xpath = "//*[@id='box-checkout-cart']/div/table/tbody/tr/td[2]")
    private List<WebElement> cartItems;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openShoppingCartPage() {
        driver.get(SHOPPING_PAGE_URL);
    }

    public boolean isButtonShoppingCartVisible(){
        return buttonShoppingCart.isDisplayed();
    }

    public void clickButtonShoppingCart(){
        buttonShoppingCart.click();
        waitForPageLoadComplete();
        waitForAjaxToComplete();
    }

    public List<WebElement> getCartProductsList() {
        waitForPageLoadComplete();
        waitForAjaxToComplete();
        return cartItems;
    }
}
