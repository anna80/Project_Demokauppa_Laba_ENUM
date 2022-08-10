package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static manager.DriverManager.*;

public class Hooks {
    @Before
    public void testsSetUp() {
        setup();
    }

    @After
    public void tearDown() {
        closeDriver();
    }
}
