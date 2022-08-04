/*
./gradlew clean test -Dlaunch=localLaunch -DbrowserName=FIREFOX
*/

package guru.qa.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${launch}.properties"})
public interface WebDriverConfig extends Config {

    @Key("browserName")
    Browser getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserUrl")
    @DefaultValue("https://qa.guru/")
    String getBrowserUrl();

    @DefaultValue("1920x1080")
    String getBrowserResolution();

    @DefaultValue("0x0")
    String getBrowserPosition();
}
