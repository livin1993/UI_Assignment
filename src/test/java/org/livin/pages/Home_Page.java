package org.livin.pages;

import org.livin.common.CommonUtils;
import org.openqa.selenium.By;

public class Home_Page extends CommonUtils {
    By docsTab = By.xpath("//a[text()='Docs']");
    By tutorialTab = By.xpath("//a[text()='Tutorial']");


    public void clickDocsTab() {
        waitAndClick(docsTab, 5);
    }

    public void clickTutorialTab() {
        waitAndClick(tutorialTab, 5);
    }


}
