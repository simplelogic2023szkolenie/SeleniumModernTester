package basic;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class IframeTest extends TestBase {

    @Test
    public void shouldFillFormInIframe() {
        driver.get("http://automation-practice.emilos.pl/iframes.php");

        driver.switchTo().frame("iframe1");
        driver.findElement(By.cssSelector("#inputFirstName3")).clear();
        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys("Jan");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("iframe2");
        driver.findElement(By.cssSelector("#inputLogin")).sendKeys("Jan");
    }

    @Test
    public void shouldFillFormInIframeWithFunctionalInterface() {
        // link do filmu o lambdach i interfejsach funcyjnych
        // https://www.youtube.com/watch?v=tj5sLSFjVj4

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.get("http://automation-practice.emilos.pl/iframes.php");


        executeInFrame("iframe1", () -> {
            driver.findElement(By.cssSelector("#inputFirstName3")).clear();
            driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys("Jan");
        });

        executeInFrame("iframe2", () -> {
            driver.findElement(By.cssSelector("#inputLogin")).sendKeys("Jan");
        });


//        executeInFrame(Arrays.asList("iframeA", "iframeB", "iframeC"), () -> {
//            driver.findElement(By.cssSelector("#inputLogin")).sendKeys("Jan");
//            driver.findElement(By.cssSelector("#password")).sendKeys("asdasd");
//            driver.findElement(By.cssSelector("#loginBtn")).click();
//        });
    }

    public void executeInFrame(String frameName, Runnable runnable) {
        driver.switchTo().frame(frameName);

        runnable.run();

        driver.switchTo().defaultContent();
    }

    public void executeInFrame(List<String> frameNames, Runnable runnable) {
        for (String frameName : frameNames) {
            driver.switchTo().frame(frameName);
        }

        runnable.run();

        driver.switchTo().defaultContent();
    }
}
