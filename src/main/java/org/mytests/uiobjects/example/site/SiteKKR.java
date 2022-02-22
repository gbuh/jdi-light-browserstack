package org.mytests.uiobjects.example.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import org.mytests.uiobjects.example.site.pages.KKRPage;

@JSite("https://qa.portaltest.kkr.com/")
public class SiteKKR {
    public static KKRPage kkrPage;
}
