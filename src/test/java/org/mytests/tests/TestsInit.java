package org.mytests.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.get.DriverData;
import com.epam.jdi.light.settings.JDISettings;
import org.mytests.uiobjects.example.site.SiteJdi;
import org.mytests.uiobjects.example.site.SiteKKR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.light.settings.WebSettings.useDriver;

public interface TestsInit {
        String AUTOMATE_USERNAME = "iharlipko1";
        String AUTOMATE_KEY = "uwyMBwpzmsp2Zwo5yDTW";
        String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    static void updateFirefoxOptions(FirefoxOptions cap) {
        FirefoxProfile profile = new FirefoxProfile();
        DriverData.setUp("Set FirefoxProfile", () -> {
            profile.setAssumeUntrustedCertificateIssuer(false);
            profile.setPreference("browser.download.dir", DRIVER.downloadsFolder);
            profile.setPreference("print.always_print_silent", "true");
            profile.setPreference("print.show_print_progress", "false");
            profile.setPreference("browser.startup.homepage", "about:blank");
            profile.setPreference("startup.homepage_welcome_url", "about:blank");
            profile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
            profile.setPreference("network.http.phishy-userpass-length", 255);
            //
            profile.setPreference("browser.download.folderList", 1);
            profile.setPreference("browser.download.manager.showWhenStarting", false);
            profile.setPreference("browser.download.manager.focusWhenStarting", false);
            profile.setPreference("browser.download.useDownloadDir", true);
            profile.setPreference("browser.helperApps.alwaysAsk.force", false);
            profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
            profile.setPreference("browser.download.manager.closeWhenDone", true);
            profile.setPreference("browser.download.manager.showAlertOnComplete", false);
            profile.setPreference("browser.download.manager.useWindow", false);
            profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf;application/xls;text/csv;text/plain;application/octet-stream");

        });
        DriverData.setUp("Firefox: Firefox Profile", () -> {
            cap.setProfile(profile);
        });
        JDISettings.DRIVER.capabilities.firefox.forEach((property, value) -> {
            DriverData.setupCapability(cap, property, value);
        });
    }

    @BeforeSuite(alwaysRun = true)
    static void setUp() throws MalformedURLException {
        DriverData.FIREFOX_OPTIONS = TestsInit::updateFirefoxOptions;
//        DRIVER.capabilities.chrome.put("browserName", "Chrome");
//        DRIVER.capabilities.safari.put("browserName", "iPhone");
//        DRIVER.capabilities.safari.put("device", "iPhone 11");
//        DRIVER.capabilities.safari.put("realMobile", "true");
//        DRIVER.capabilities.safari.put("os_version", "13");
//        DRIVER.capabilities.safari.put("name", "BStack iOS Sample Test");
//        System.setProperty("USERNAME", "iharlipko1");
//        System.setProperty("ACCESS_KEY", "uwyMBwpzmsp2Zwo5yDTW");
//        DRIVER.capabilities.common.put("browserName", "Chrome");
//        DRIVER.capabilities.common.put("resolution", "1920x1080");
//        DRIVER.capabilities.common.put("browser_version", "latest");
//        DRIVER.capabilities.common.put("browserstack.use_w3c", "true");
//        DriverData.FIREFOX_OPTIONS = TestsInit::updateFirefoxOptions;


//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("browser.download.folderList", 1);
//        profile.setPreference("browser.download.manager.showWhenStarting", false);
//        profile.setPreference("browser.download.manager.focusWhenStarting", false);
//        profile.setPreference("browser.download.useDownloadDir", true);
//        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
//        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
//        profile.setPreference("browser.download.manager.closeWhenDone", true);
//        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
//        profile.setPreference("browser.download.manager.useWindow", false);
//        // You will need to find the content-type of your app and set it here.
//        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("browser", "Firefox");
//        caps.setCapability("browser_version", "latest");
//        caps.setCapability("os", "Windows");
//        caps.setCapability("os_version", "10");
//        caps.setCapability("name", "Bstack-[Java] Sample file download");
//        caps.setCapability(FirefoxDriver.PROFILE, profile);
//
//        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
//        driver.get("https://qa.portaltest.kkr.com/");
//        getDriver(useDriver(() -> new RemoteWebDriver(new URL(URL), caps)));
        openSite(SiteKKR.class);
        logger.info("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
        WebDriverFactory.quit();
    }
}
