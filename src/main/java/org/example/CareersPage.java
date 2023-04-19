package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='See all teams']")));
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



        String[] childWindowsUrl = driver.getCurrentUrl().split("useinsider/");
        System.out.println(childWindowsUrl[0]);
        Assert.assertEquals(childWindowsUrl[0], "https://jobs.lever.co/");
        driver.close();
    }

    public void jsScroll() throws InterruptedException {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);

    }

    public void qaScroll() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.querySelector(\"img[src='https://useinsider.com/assets/media/2021/03/qa.png']\").scrollIntoView()");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='https://useinsider.com/assets/media/2021/03/qa.png']")));

    }
}
