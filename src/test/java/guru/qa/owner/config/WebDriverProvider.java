package guru.qa.owner.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {
    DesiredCapabilities capabilitie;
    RemoteWebDriver remoteWebDriver;
    private final WebDriverConfig config;

    public WebDriverProvider() {
        config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createDriver();
        driver.get(config.getBrowserUrl());
        return driver;
    }

    public WebDriver createDriver() {
        capabilitie = new DesiredCapabilities();

        if (config.getBrowserRemoteValue()) {
            switch (config.getBrowser()) {
                case CHROME: {
                    remoteWebDriver = new RemoteWebDriver(config.getBrowserRemoteUrl(), new ChromeOptions());
                    capabilitie.setVersion(config.getBrowserVersion());
                    return remoteWebDriver;
                }
                case FIREFOX: {
                    remoteWebDriver = new RemoteWebDriver(config.getBrowserRemoteUrl(), new FirefoxOptions());
                    capabilitie.setVersion(config.getBrowserVersion());
                    return remoteWebDriver;
                }
                default: {
                    throw new RuntimeException("No such driver");
                }
            }
        } else {
            switch (config.getBrowser()) {
                case CHROME: {
                    WebDriverManager.chromedriver().setup();
                    capabilitie.setVersion(config.getBrowserVersion());
                    return new ChromeDriver();
                }
                case FIREFOX: {
                    WebDriverManager.firefoxdriver().setup();
                    capabilitie.setVersion(config.getBrowserVersion());
                    return new FirefoxDriver();
                }
                default: {
                    throw new RuntimeException("No such driver");
                }
            }
        }
    }
}
