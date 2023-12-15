package org.livin.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class CommonUtils {
     WebDriver driver = CucumberHooks.driver;

    public void highlightELement(WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '3px solid red'", ele);
    }

    public void unHighlightELement(WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = ''", ele);
    }

    public void scrollToElement(WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ele);
    }

    public void waitAndClick(By ele, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(ele))).click();
    }

    public void waitForTitleContains(String text, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.titleContains(text));
    }

    public void writeFile(String fileName, String value) throws IOException {
        File file = new File("src/test/resources/outputFile/" + fileName + ".txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
