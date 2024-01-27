package basic;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest extends TestBase {

    @Test
    public void shouldPrintMountainsFromTable() {
        driver.get("http://seleniumui.moderntester.pl/table.php");
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        for (WebElement row : rows) {
            int height = Integer.parseInt(row.findElement(By.xpath("./td[4]")).getText());

            if (height > 4000) {
                String peak = row.findElements(By.cssSelector("td")).get(0).getText();
                String range = row.findElement(By.xpath("./td[2]")).getText();
                String country = row.findElement(By.xpath("./td[3]")).getText();
                System.out.println(peak + " " + range + " " + country + " " + height);
            }
        }

    }
}
