package org.livin.common;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHooks {
    public static WebDriver driver;

    @Before
    public void startDriver() {
        System.setProperty("driver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://legacy.reactjs.org/ ");
        driver.manage().window().maximize();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

}
