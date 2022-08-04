package guru.qa.owner.config;

import org.aeonbits.owner.Config;
import java.net.URL;

public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub/")
    URL getRemoteUrl();
}
