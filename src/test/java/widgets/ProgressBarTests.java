package widgets;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProgressBarTests extends TestBase {
    WebDriverWait wait;

    @BeforeMethod
    public void testSetup() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://seleniumui.moderntester.pl/progressbar.php");
    }

    @Test
    public void shouldWaitForProgressBar() {
        String text = driver.findElement(By.xpath("//div[.='Complete!']")).getText();

        Assert.assertEquals(text, "Complete!");
    }

    @Test
    public void shouldWaitForProgressBarV1() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String text = driver.findElement(By.xpath("//div[.='Complete!']")).getText();

        Assert.assertEquals(text, "Complete!");
    }

    @Test
    public void shouldWaitForProgressBarV2() {
        // implicitlyWait nigdy nie konfigurujemy bezpośrednio w teście tylko ustawiamy raz w TestBase
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String text = driver.findElement(By.xpath("//div[.='Complete!']")).getText();

        Assert.assertEquals(text, "Complete!");
    }

    @Test
    public void shouldWaitForProgressBarV3() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String text = driver.findElement(By.xpath("//div[.='iuhasdiuyhasdiuhasdiuhasd!']")).getText();

        Assert.assertEquals(text, "Complete!");
    }

    @Test
    public void shouldWaitForProgressBarV4() {
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".progress-label"), "Complete!"));
    }

    @Test
    public void shouldWaitForProgressBarV5() {
        wait.until(ExpectedConditions.attributeContains(By.cssSelector(".ui-progressbar-value"), "class", "ui-progressbar-complete"));
    }

    @Test
    public void shouldWaitForProgressBarV6() {
        wait.until(d -> d.findElement(By.cssSelector(".ui-progressbar-value")).getAttribute("class").contains("complete"));

        Assert.assertEquals(driver.findElement(By.cssSelector(".progress-label")).getText(), "Complete!");
    }
}
