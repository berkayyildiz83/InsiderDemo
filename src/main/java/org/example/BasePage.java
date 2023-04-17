package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BasePage {
    public WebDriver driver;

    public String dataPath = "tools/data.properties";

    @BeforeTest
    public WebDriver InitializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
                dataPath);
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.get(prop.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("~~~~~~ FIREFOX ICIN TESTLER BAŞLADI ~~~~~");


        } else if (browserName.equals("chrome")) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.get(prop.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("~~~~~~ CHROME ICIN TESTLER BAŞLADI ~~~~~");

        }
    return driver;

    }


    @AfterTest
    public void teardown() {
        driver.quit();
    }
}