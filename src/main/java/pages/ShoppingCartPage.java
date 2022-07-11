package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

    private static final String SHOPPING_PAGE_URL = "http://kuopassa.net/litecart/en/checkout";
    public static final String PAGE_ID = "ShoppingCart";

    @FindBy(xpath = "//div[@class='title']")
    private WebElement buttonShoppingCart;

    public void openShoppingPage() {
        driver.get(SHOPPING_PAGE_URL);
    }

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isButtonShoppingCartVisible(){
        return buttonShoppingCart.isDisplayed();
    }

    public void clickButtonShoppingCart(){
        buttonShoppingCart.click();
    }
}
