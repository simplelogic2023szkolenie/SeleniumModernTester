package basic;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {
    @Test
    public void shouldAcceptAlert() {
        driver.get("http://seleniumui.moderntester.pl/alerts.php");
        driver.findElement(By.cssSelector("#simple-alert")).click();

        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.findElement(By.cssSelector("#simple-alert-label")).getText(),
                "OK button pressed");

    }

    @Test
    public void shouldFillPromptAlert() {
        driver.get("http://seleniumui.moderntester.pl/alerts.php");
        driver.findElement(By.cssSelector("#prompt-alert")).click();

        driver.switchTo().alert().sendKeys("Jan");
        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.findElement(By.cssSelector("#confirm-label")).getText(),
                "Hello Jan! How are you today?");

    }

    @Test
    public void shouldDismissAlert() {
        driver.get("http://seleniumui.moderntester.pl/alerts.php");
        driver.findElement(By.cssSelector("#confirm-alert")).click();

        driver.switchTo().alert().dismiss();

        Assert.assertEquals(driver.findElement(By.cssSelector("#confirm-label")).getText(),
                "You pressed Cancel!");

    }
}
