package browser;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox implements WebDriverProvider {

    public Firefox() {
        super();
    }

    @Override
    public WebDriver createDriver(final DesiredCapabilities capabilities) {
        WebDriverManager.firefoxdriver().setup();

        return new FirefoxDriver(getFirefoxOptions().merge(capabilities));
    }

    public static FirefoxOptions getFirefoxOptions() {
        final FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-web-security");
        firefoxOptions.addArguments("--allow-running-insecure-content");

        final FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("pageLoadStrategy", "normal");

        firefoxOptions.setCapability(FirefoxDriver.PROFILE, profile);

        return firefoxOptions;
    }
}
