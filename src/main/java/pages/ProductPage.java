package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utils.WaitingUtils.waitForAjaxToComplete;
import static utils.WaitingUtils.waitForPageLoadComplete;

public class ProductPage extends BasePage {

    private static final String PRODUCT_PAGE_URL = "http://kuopassa.net/litecart/en/rubber-ducks-c-1/blue-duck-p-4";
    public static final String PAGE_ID = "Product";

    private static final String PRODUCTS_COMPONENT = "//div[@id='box-popular-products']//div[contains(@class,'products')]";

    @FindBy(xpath = PRODUCTS_COMPONENT + "//div[contains(@class,'product')]")
    private List<WebElement> productsCards;

    @FindBy(xpath = PRODUCTS_COMPONENT + "//span[@class='price']")
    private List<WebElement> productsPriceList;

    @FindBy(xpath = "//[@id='box-popular-products']/div/div[1]/div/a/div[2]/div[3]/span")
    private WebElement productPrice;

    @FindBy(xpath = "//button[@name='add_cart_product']")
    private WebElement buttonAddCart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openProductPage() {
        driver.get(PRODUCT_PAGE_URL);
    }

    public void clickProduct(int productName) {
        WebElement productCard = productsCards.get(productName);
        productCard.click();
        waitForPageLoadComplete();
    }

    public String getProductName(int productNumber) {
        return productsCards.get(productNumber)
                .findElement(By.xpath("//*[@id='box-popular-products']/div/div[1]/div/a/div[2]/div[1]"))
                .getText();
    }

    public void clickButtonAddCart() {
        buttonAddCart.click();
        waitForPageLoadComplete();
        waitForAjaxToComplete();
    }

    public List<WebElement> getProductsCards() {
        return productsCards;
    }

    public List<Double> getProductsPriceList() {
        return productsPriceList.stream()
                .map(WebElement::getText)
                .map(t -> t.replace("€", "").trim())
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
