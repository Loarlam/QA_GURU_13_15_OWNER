package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest extends WebDriverTestBase {
    @Test
    public void testGithubTitle() {
        String title = driver.getTitle();
        assertEquals("Курсы тестировщиков - онлайн-обучение тестировщиков ПО и QA с нуля", title);
    }
}
