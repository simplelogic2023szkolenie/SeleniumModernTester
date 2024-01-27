package basic;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTests extends TestBase {

//    @Override
//    public boolean isHeadless(){
//        // uwawaga to ustawienie powoduje ze te testy lecą
//        // w trybie headless
//        return true;
//    }

    @BeforeMethod
    public void openAlertsPage() {
        driver.get("http://seleniumui.moderntester.pl/alerts.php");
    }

    @Test
    public void shouldAcceptAlert() {
        driver.findElement(By.cssSelector("#simple-alert")).click();

        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.findElement(By.cssSelector("#simple-alert-label")).getText(),
                "OK button pressed");

    }

    @Test
    public void shouldFillPromptAlert() {
        driver.findElement(By.cssSelector("#prompt-alert")).click();

        driver.switchTo().alert().sendKeys("Jan");
        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.findElement(By.cssSelector("#confirm-label")).getText(),
                "Hello Jan! How are you today?");

    }


    @Test
    public void shouldDismissAlert() {
        driver.findElement(By.cssSelector("#confirm-alert")).click();

        driver.switchTo().alert().dismiss();

        Assert.assertEquals(driver.findElement(By.cssSelector("#confirm-label")).getText(),
                "You pressed Cancel!");

    }

    @Test
    public void shouldWaitForAlert(){
        driver.findElement(By.cssSelector("#delayed-alert")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();


        WebElement alertLbl = driver.findElement(By.cssSelector("#delayed-alert-label"));
        Assert.assertEquals(alertLbl.getText(), "OK button pressed");
    }

    @Test
    public void shouldWaitForAlertv2(){
        driver.findElement(By.cssSelector("#delayed-alert")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();


        WebElement alertLbl = driver.findElement(By.cssSelector("#delayed-alert-label"));
        Assert.assertEquals(alertLbl.getText(), "OK button pressed");
    }
}
