package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class CareersPage {

    WebDriver driver;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "career-our-location")
    WebElement locationButton;

    @FindBy(id = "location-slider")
    WebElement locationSlider;

    @FindBy(css = ".elementor-widget-wrap.e-swiper-container")
    WebElement careerContainer;

    @FindBy(xpath = "//a[normalize-space()='See all teams']")
    WebElement teamsButton;

    @FindBy(xpath = "//h3[normalize-space()='Quality Assurance']")
    WebElement qaButton;

    @FindBy(xpath = "//a[normalize-space()='See all QA jobs']")
    WebElement seeQaJobsButton;



    public void assertCareersPageTitle() {

        String expectedTitleC = "Insider Careers";
        String actualTitleC = driver.getTitle();
        Assert.assertEquals(actualTitleC, expectedTitleC);

    }

    public void locButtonC(){
        locationButton.isDisplayed();
    }

    public void locButtonS(){
        locationSlider.isDisplayed();
    }

    public void containerC(){
        careerContainer.isDisplayed();
    }

    public void waitMethodC() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) teamsButton));
    }

    public void clickTeamsButton(){
        teamsButton.click();
    }

    public void clickQaButton(){
        qaButton.click();
    }

    public void clickSeeQaButton(){
        seeQaJobsButton.click();
    }

    public void switchWindows(){
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String windowParentId = it.next();
        String windowChildId = it.next();
        driver.switchTo().window(windowChildId);
    }

    public void assertChildWindowsUrl(){
        String childWindowsUrl = Arrays.toString(driver.getCurrentUrl().split("useinsider/"));
        Assert.assertEquals(childWindowsUrl, "https://jobs.lever.co/");
        driver.close();
    }
}
