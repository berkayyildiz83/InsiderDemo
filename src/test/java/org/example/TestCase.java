package org.example;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestCase extends BasePage {


    @Test
    public void OpenQAPage() throws Throwable {

        LandingPage lp = new LandingPage(driver);
        CareersPage cp = new CareersPage(driver);

        lp.clickCookieButton();
        lp.assertLandingPageTitle();
        lp.clickMoreButton();
        lp.clickCareersButton();
        lp.waitMethodL();

        cp.assertCareersPageTitle();
        cp.locButtonC();
        cp.locButtonS();
        cp.containerC();
        cp.waitMethodC();
        cp.clickTeamsButton();
        cp.clickQaButton();
        cp.clickSeeQaButton();

        driver.findElement(By.cssSelector("span[title='All']")).click();
        driver.findElement(By.cssSelector("span[title='Istanbul, Turkey']")).click();
        driver.findElement(By.xpath("(//div[@data-location='istanbul-turkey'])[1]/div/a"));

        cp.switchWindows();
        cp.assertChildWindowsUrl();

    }
}
