package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = "http://kuopassa.net/litecart/en/";
    public static final String PAGE_ID = "Home";

    @Override
    public void openPage() {
        driver.get(HOME_PAGE_URL);
    }

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchProduct;

    @FindBy(xpath = "//i[@class='fa fa-search fa-fw']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchProductVisible() {
        return searchProduct.isDisplayed();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void enterTextToSearchProduct(final String searchText) {
//        searchProduct.clear();
        searchProduct.sendKeys(searchText);
    }

}
