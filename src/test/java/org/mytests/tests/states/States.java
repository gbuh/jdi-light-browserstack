package org.mytests.tests.states;

import com.epam.jdi.light.elements.composite.WebPage;
import io.qameta.allure.Step;
import org.mytests.uiobjects.example.entities.User;
import org.mytests.uiobjects.example.site.SiteJdi;
import org.mytests.uiobjects.example.site.pages.KKRPage;

//import static org.mytests.uiobjects.example.site.SiteJdi.*;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static org.mytests.uiobjects.example.site.SiteJdi.homePage;
import static org.mytests.uiobjects.example.site.SiteJdi.loginForm;
import static org.mytests.uiobjects.example.site.SiteJdi.logout;
import static org.mytests.uiobjects.example.site.SiteJdi.userIcon;
import static org.mytests.uiobjects.example.site.SiteJdi.userName;
import static org.mytests.uiobjects.example.site.SiteKKR.kkrPage;

/**
 * Created by Roman_Iovlev on 3/1/2018.
 */
public class States {
    private static void onKKRSite() {
        if (!WebPage.getUrl().contains("https://qa.portaltest.kkr.com/"))
            kkrPage.open();
        getDriver().manage().window().maximize();
    }

    @Step
    public static void loginKKR() throws InterruptedException {
        onKKRSite();
        kkrPage.cookies.click();
        kkrPage.email.setValue("testuser_2");
        kkrPage.password.setValue("Test123@");
        kkrPage.loginBtn.click();
        kkrPage.logSpinner.waitFor(15).disappear();
        kkrPage.spinner.waitFor(15).disappear();
        kkrPage.download.click();
        Thread.sleep(5000);
    }

    private static void onSite() {
        if (!WebPage.getUrl().contains("https://jdi-testing.github.io/jdi-light/"))
            homePage.open();
    }

    @Step
    public static void shouldBeLoggedIn() {
        onSite();
        if (!userName.isDisplayed())
            login();
    }

    @Step
    public static void login() {
        userIcon.click();
        loginForm.submit(new User(), "enter");
    }

    @Step
    public static void shouldBeLoggedOut() {
        onSite();
        if (userName.isDisplayed())
            logout();
        if (loginForm.isDisplayed())
            userIcon.click();
    }

    @Step
    public static void logout() {
        if (!logout.isDisplayed())
            userIcon.click();
        logout.click();
    }
}
