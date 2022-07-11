package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    private static final String SIGN_IN_PAGE_URL = "http://kuopassa.net/litecart/en/create_account";
    public static final String PAGE_ID = "SignIn";

    public void openSignInPage() {
        driver.get(SIGN_IN_PAGE_URL);
    }

    @FindBy(xpath = "//p[@class='text-center']")
    private WebElement buttonNewCustomers;

    @FindBy(xpath = "//*[@id=\"box-account-login\"]/form/div[2]/div/input")
    private WebElement fieldPassword;

    @FindBy(xpath = "//*[@id=\"box-account-login\"]/form/div[1]/div/input")
    private WebElement fieldEmail;

    @FindBy(xpath = "//*[@id=\"box-account-login\"]/form/div[3]/button")
    private WebElement buttonSignIn;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isButtonNewCustomersVisible(){
        return buttonNewCustomers.isDisplayed();
    }
    public void clickButtonNewCustomers() {
        buttonNewCustomers.click();
    }

    public void enterTextToFieldPassword(final String searchText) {
        fieldPassword.clear();
        fieldPassword.sendKeys(searchText);
    }

    public void enterTextToFieldEmail(final String searchText) {
        fieldEmail.clear();
        fieldEmail.sendKeys(searchText);
    }

    public boolean isButtonSignInVisible(){
        return buttonSignIn.isDisplayed();
    }
    public void clickButtonSignIn() {
        buttonSignIn.click();
    }
}

