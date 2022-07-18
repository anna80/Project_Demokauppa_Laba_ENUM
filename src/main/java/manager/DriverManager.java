package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    public static void open() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-extensions");
        setDriver(new ChromeDriver(options));
    }

    private static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            open();
        }
        return driver;
    }

    public static void closeDriver() {
        if ((driver != null)) {
            driver.close();
            driver.quit();
        }
    }
}
