package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "wt-cli-accept-all-btn")
    WebElement cookieButton;
    @FindBy(xpath = "//span[normalize-space()='More']")
    WebElement moreButton;

    @FindBy(css = "a[href='https://useinsider.com/careers/']")
    WebElement careersButton;


    public void clickCookieButton() {
        cookieButton.click();
    }

    public void assertLandingPageTitle() {

        String expectedTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Insider home page is opened");
        } else {
            System.out.println("Insider home page is not opened");
        }


    }

    public void clickMoreButton() {
        moreButton.click();
    }

    public void clickCareersButton() {
        careersButton.click();
    }

    public void waitMethodL() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#career-head-img")));
    }


}
