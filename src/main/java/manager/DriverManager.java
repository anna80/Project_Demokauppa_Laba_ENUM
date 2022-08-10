package manager;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;

public class DriverManager {
    private static WebDriver driver;

    public DriverManager() {
    }

    //    @Before
    public static void setup() {
        String parameter;
        if (System.getProperty("Browser") == null) {
            parameter = "chrome";
        } else {
            parameter = System.getProperty("Browser");
        }
        switch (parameter) {
            case "chrome":
                chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("--disable-extensions");
                setDriver(new ChromeDriver(options));
                break;
            case "firefox":
                firefoxdriver().setup();
                FirefoxOptions optionsFire = new FirefoxOptions();
                optionsFire.addArguments("start-maximized");
                optionsFire.addArguments("--disable-extensions");
                setDriver(new FirefoxDriver(optionsFire));
                break;
        }
    }

    private static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            setup();
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
