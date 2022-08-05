/*
./gradlew clean test -Dlaunch=localLaunch -DbrowserName=FIREFOX
*/

package guru.qa.owner.config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({"classpath:${launch}.properties"})
public interface WebDriverConfig extends Config {

    @Key("browserName")
    @DefaultValue("chrome")
    Browser getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserUrl")
    @DefaultValue("https://qa.guru/")
    String getBrowserUrl();

    @Key("browserRemoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub/")
    URL getBrowserRemoteUrl();

    @Key("browserIsRemote")
    Boolean getBrowserRemoteValue();
}
