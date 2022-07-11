package manager;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HomePage;
import pages.ShoppingCartPage;
import pages.SignInPage;

public class PageFactoryManager {

    WebDriver driver = DriverManager.getDriver();

    public BasePage getPage(String page) {

        switch (page) {
            case HomePage.PAGE_ID:
                return new HomePage(this.driver);
            case SignInPage.PAGE_ID:
                return new SignInPage(this.driver);
            case ShoppingCartPage.PAGE_ID:
                return new ShoppingCartPage(this.driver);
        }
        return null;
    }
}

//    public HomePage getHomePage() {
//        return new HomePage(driver);
//    }
//
//    public SignInPage getSignInPage() {
//        return new SignInPage(driver);
//    }
//
//    public ShoppingCartPage getShoppingCartPage() {
//        return new ShoppingCartPage(driver);
//    }

