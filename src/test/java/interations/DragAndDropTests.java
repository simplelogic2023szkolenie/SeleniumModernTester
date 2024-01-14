package interations;

import base.TestBase;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase {
    @BeforeMethod
    public void openDragAndDropUrl(){
        driver.get("http://seleniumui.moderntester.pl/droppable.php");
    }

    @Test
    public void shouldDragAndDropV1(){
        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
        WebElement areaToDrop = driver.findElement(By.cssSelector("#droppable"));


        Actions actions = new Actions(driver);

        actions.clickAndHold(draggable)
                .moveToElement(areaToDrop)
                .release()
                .perform();

        Assert.assertEquals(areaToDrop.getText(),"Dropped!");
    }

}
