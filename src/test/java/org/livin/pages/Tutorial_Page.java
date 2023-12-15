package org.livin.pages;

import org.livin.common.CommonUtils;
import org.livin.common.CucumberHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Tutorial_Page extends CommonUtils {
    WebDriver driver = CucumberHooks.driver;
    SoftAssert softassert = new SoftAssert();

    By mainheading = By.tagName("h2");
    By subheading = By.tagName("h3");

    static final String SELECTION_FONT = "700";
    static final String SELECTION_COLOR = "4px solid rgb(97, 218, 251)";




    public void scrollAndValidateTableFontNadColor() {
        waitForTitleContains("Tutorial", 5);

        List<WebElement> mainHeadings = driver.findElements(mainheading);
        for (WebElement i : mainHeadings) {
            AssertBoldAndSelectionColor(i);
        }

        List<WebElement> subHeadings = driver.findElements(subheading);
        for (WebElement i : subHeadings) {
            AssertBoldAndSelectionColor(i);
        }
        softassert.assertAll();
    }

    public void AssertBoldAndSelectionColor(WebElement ele) {
        scrollToElement(ele);
        String text = ele.getAttribute("id");
        WebElement selectElement = driver.findElement(By.xpath("//nav//a[contains(@href,'" + text + "')]"));
        String elementFont = selectElement.getCssValue("font-weight");
        String elementSelectionColor = selectElement.findElement(By.tagName("span")).getCssValue("border-left");
        softassert.assertEquals(elementFont, SELECTION_FONT, selectElement.getText() + " - Font is not Bold -> ");
        softassert.assertEquals(elementSelectionColor, SELECTION_COLOR, selectElement.getText() + " - is not highlighted in blue -> ");
    }
}
