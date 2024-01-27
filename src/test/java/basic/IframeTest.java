package basic;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IframeTest extends TestBase {

    @Test
    public void shouldFillFormInIframe(){
        driver.get("http://automation-practice.emilos.pl/iframes.php");

        driver.switchTo().frame("iframe1");
        driver.findElement(By.cssSelector("#inputFirstName3")).clear();
        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys("Jan");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("iframe2");
        driver.findElement(By.cssSelector("#inputLogin")).sendKeys("Jan");
    }
}
