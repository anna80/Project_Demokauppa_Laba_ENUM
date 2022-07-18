package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver = DriverManager.getDriver();

    public BasePage getPage(String page) {

        switch (page) {
            case HomePage.PAGE_ID:
                return new HomePage(this.driver);
            case ShoppingCartPage.PAGE_ID:
                return new ShoppingCartPage(this.driver);
            case SignInPage.PAGE_ID:
                return new SignInPage(this.driver);
            case ProductPage.PAGE_ID:
                return new ProductPage(this.driver);
        }
        return null;
    }
}


