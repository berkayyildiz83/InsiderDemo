package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase extends BasePage {

    @Test
    public void OpenQAPage() throws Throwable {

        LandingPage lp = new LandingPage(driver);
        CareersPage cp = new CareersPage(driver);
        Actions act = new Actions(driver);

        //Landing Page
        lp.clickCookieButton();
        lp.assertLandingPageTitle();
        lp.clickMoreButton();
        lp.clickCareersButton();
        lp.waitMethodL();

        //Career Page
        cp.assertCareersPageTitle();
        cp.locButtonC();
        cp.locButtonS();
        cp.containerC();
        cp.waitMethodC();
        cp.jsScroll();
        cp.clickTeamsButton();
        cp.qaScroll();
        cp.clickQaButton();
        cp.clickSeeQaButton();


        //Dropdown seçim yapılması. POM özellikle kullanmadım, farklı teknik kullanmak açısından.
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@id='select2-filter-by-location-container']")).click();
        driver.findElement(By.xpath("//li[@class='select2-results__option'][.='Istanbul, Turkey']")).click();
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        act.moveToElement(driver.findElement(By.xpath("(//div[@class='position-location text-large'][contains(.,'Istanbul, Turkey')])[1]")));
        driver.findElement(By.xpath("(//div[@data-location=\"istanbul-turkey\"])[1]/div/a")).click();

        //Açılan sekmeye geçiş ve URL kontrolü
        cp.switchWindows();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Insider. logo']")));
        cp.assertChildWindowsUrl();

    }
}
