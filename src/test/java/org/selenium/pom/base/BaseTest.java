package org.selenium.pom.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;

public class BaseTest {
    protected WebDriver driver;


    @BeforeEach
    public void startDriver() {
        String browser ="CHROME";
        driver = new DriverManager().initializeDriver(browser);
    }



    @AfterEach
    public void quitDriver() {
        driver.quit();
    }


}
