package org.livin.pages;

import org.livin.common.CommonUtils;
import org.livin.common.CucumberHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class Docs_Page extends CommonUtils {
    WebDriver driver = CucumberHooks.driver;
    By mainConcText = By.xpath("//div[text()='Main Concepts']");
    By advanceGuideText = By.xpath("//div[text()='Advanced Guides']");
    By subElementsMainCon = By.xpath("//div[text()='Main Concepts']//ancestor::button//following-sibling::ul");
    By subElementsAdvancedGuide = By.xpath("//div[text()='Advanced Guides']//ancestor::button//following-sibling::ul");

    public void clickMainConcept() {
        waitForTitleContains("Getting Started", 5);
        waitAndClick(mainConcText, 5);
    }

    public void clickAdvancedGuide() {
        scrollToElement(driver.findElement(advanceGuideText));
        waitAndClick(advanceGuideText, 5);
    }

    public void getSubElementsMainConcept() throws IOException {
        highlightELement(driver.findElement(subElementsMainCon));
        List<WebElement> elements = driver.findElement(subElementsMainCon).findElements(By.tagName("li"));
        writeFile("MainConcepts", getAllElementsTextInString(elements));
        unHighlightELement(driver.findElement(subElementsMainCon));
    }

    public void getvSubElementsAdvancedGuide() throws IOException {
        highlightELement(driver.findElement(subElementsAdvancedGuide));
        List<WebElement> elements = driver.findElement(subElementsAdvancedGuide).findElements(By.tagName("li"));
        writeFile("AdvancedGuide", getAllElementsTextInString(elements));
        unHighlightELement(driver.findElement(subElementsAdvancedGuide));
    }

    public String getAllElementsTextInString(List<WebElement> elements) {
        StringBuilder Value = new StringBuilder();
        for (WebElement i : elements) {
            Value.append(i.getText()).append("\n");
        }
        return Value.toString();
    }

}
