package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage extends BasePage {

    private static final String PRODUCT_PAGE_URL = "http://kuopassa.net/litecart/en/rubber-ducks-c-1/blue-duck-p-4";
    public static final String PAGE_ID = "Product";

    private static final String PRODUCTS_COMPONENT = "//div[@id='box-popular-products']//div[contains(@class,'products')]";

    @FindBy(xpath = PRODUCTS_COMPONENT + "//div[contains(@class,'product')]")
    private List<WebElement> productsCards;

    @FindBy(xpath = PRODUCTS_COMPONENT + "//span[@class='price']")
    private List<WebElement> productsPriceList;

    @FindBy(xpath = "//*[@id='box-popular-products']/div/div[1]/div")
    private WebElement firstProduct;

    @FindBy(xpath = "//*[@id='box-popular-products']/div/div[1]/div/a/div[2]/div[1]")
    private WebElement productName;

    @FindBy(xpath = "//*[@id='box-popular-products']/div/div[1]/div/a/div[2]/div[3]/span")
    private WebElement productPrice;

    @FindBy(xpath = "//*[@id='box-product']/div[1]/div[3]/div[6]/form/div[2]/div/div[2]/button")
    private WebElement buttonAddCart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openProductPage() {
        driver.get(PRODUCT_PAGE_URL);
    }

    public void clickProduct(final int number) {
        WebElement productCard = productsCards.get(number-1);
        String productName = "Blue Duck";
        double productPrice = 20.0;
//        TextContext.setTextContext()
        productCard.click();
    }

    public void clickButtonAddCart() {
        buttonAddCart.click();
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
