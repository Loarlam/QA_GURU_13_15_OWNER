package tests;

import guru.qa.owner.config.WebDriverProvider;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
    private WebDriver driver = new WebDriverProvider().get();

    @Test
    public void testGithubTitle() {
        String title = driver.getTitle();
        assertEquals(title, "GitHub: Where the world builds software · GitHub");
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }
}
