package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase extends BasePage {


    @Test
    public void OpenQAPage() throws Throwable {

        LandingPage lp = new LandingPage(driver);
        lp.clickCookieButton();

        //lp.assertLandingPageTitle;
        driver.findElement(By.xpath("//span[normalize-space()='More']")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("a[href='https://useinsider.com/careers/']")).click();
        String careerPageTitle = driver.getTitle();
        System.out.println(careerPageTitle);
        Assert.assertEquals(careerPageTitle, "Insider Careers");
        driver.findElement(By.id("career-our-location")).isDisplayed();
        driver.findElement(By.id("location-slider")).isDisplayed();
        driver.findElement(By.cssSelector(".elementor-widget-wrap.e-swiper-container")).isDisplayed();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[normalize-space()='See all teams']")).click();
        driver.findElement(By.xpath("//h3[normalize-space()='Quality Assurance']")).click();







        driver.close();



    }
}
