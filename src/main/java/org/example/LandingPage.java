package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
 WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "wt-cli-accept-all-btn")
    WebElement cookieButton;


    public void clickCookieButton(){
        cookieButton.click();
    }


    /*public  assertLandingPageTitle(){

        String expectedTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Insider home page is opened");
        } else {
            System.out.println("Insider home page is not opened");
        }*/

    }


