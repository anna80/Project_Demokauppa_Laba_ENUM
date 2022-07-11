package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static manager.DriverManager.closeDriver;
import static manager.DriverManager.open;

public class Hooks {
    @Before
    public void testsSetUp() {
        open();
    }

    @After
    public void tearDown() {
        closeDriver();
    }
}
