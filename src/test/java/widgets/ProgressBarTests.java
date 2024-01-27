package widgets;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProgressBarTests extends TestBase {

    @Test
    public void shouldWaitForProgressBar(){
        driver.get("http://seleniumui.moderntester.pl/progressbar.php");

        String text = driver.findElement(By.xpath("//div[.='Complete!']")).getText();

        Assert.assertEquals(text, "Complete!");
    }
    @Test
    public void shouldWaitForProgressBarV1(){
        driver.get("http://seleniumui.moderntester.pl/progressbar.php");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String text = driver.findElement(By.xpath("//div[.='Complete!']")).getText();

        Assert.assertEquals(text, "Complete!");
    }

    @Test
    public void shouldWaitForProgressBarV2(){
        driver.get("http://seleniumui.moderntester.pl/progressbar.php");

        // implicitlyWait nigdy nie konfigurujemy bezpośrednio w teście tylko ustawiamy raz w TestBase
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String text = driver.findElement(By.xpath("//div[.='Complete!']")).getText();

        Assert.assertEquals(text, "Complete!");
    }

    @Test
    public void shouldWaitForProgressBarV3(){
        driver.get("http://seleniumui.moderntester.pl/progressbar.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String text = driver.findElement(By.xpath("//div[.='iuhasdiuyhasdiuhasdiuhasd!']")).getText();

        Assert.assertEquals(text, "Complete!");
    }

    @Test
    public void shouldWaitForProgressBarV4(){
        driver.get("http://seleniumui.moderntester.pl/progressbar.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".progress-label"), "Complete!"));
    }
}
