package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.ProgressBar;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.mytests.uiobjects.example.site.custom.MenuItem;
import org.openqa.selenium.WebElement;

@Url("/") @Title("Home Page")
public class KKRPage extends WebPage {
    @UI("#onetrust-accept-btn-handler") public static Button cookies;
    @UI("#email") public static TextField email;
    @UI("#password") public static TextField password;
    @UI("#login-btn") public static Button loginBtn;
    @UI("#login-btn mat-icon") public static ProgressBar logSpinner;
    @UI("mat-progress-bar.mat-progress-bar") public static ProgressBar spinner;
    @UI("#doc-download-btn-1") public static Button download;
    @UI(".sidebar-menu li") public static JList<MenuItem> menu;
}
