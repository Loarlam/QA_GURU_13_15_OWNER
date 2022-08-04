package tests;

import guru.qa.owner.config.WebDriverProvider;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class WebDriverTestBase {
    WebDriver driver;

    @BeforeEach
    public void beforeEachTests() {
        driver = new WebDriverProvider().get();
    }

    @AfterEach
    public void afterEachTests() {
        driver.quit();
    }
}
