package interations;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase {
    private WebElement draggable;
    private WebElement areaToDrop;
    private Actions actions;

    @BeforeMethod
    public void openDragAndDropUrl() {
        driver.get("http://seleniumui.moderntester.pl/droppable.php");
        draggable = driver.findElement(By.cssSelector("#draggable"));
        areaToDrop = driver.findElement(By.cssSelector("#droppable"));
        actions = new Actions(driver);
    }

    @Test
    public void shouldDragAndDropV1() {
        actions.dragAndDrop(draggable, areaToDrop)
                .perform();

        Assert.assertEquals(areaToDrop.getText(), "Dropped!");
    }

    @Test
    public void shouldDragAndDropV2() {
        actions.clickAndHold(draggable)
                .moveToElement(areaToDrop)
                .release()
                .perform();

        Assert.assertEquals(areaToDrop.getText(), "Dropped!");
    }

    @Test
    public void shouldDragAndDropV3() {
        actions.clickAndHold(draggable)
                .release(areaToDrop)
                .perform();

        Assert.assertEquals(areaToDrop.getText(), "Dropped!");
    }

    @Test
    public void shouldDragAndDropV4() {
        Point draggableLocation = draggable.getLocation();
        Point areaToDropLocation = areaToDrop.getLocation();

        Dimension areaToDropSize = areaToDrop.getSize();


        int xOffset = areaToDropLocation.x + areaToDropSize.width / 2 - draggableLocation.x;
        int yOffset = areaToDropLocation.y + areaToDropSize.height / 2 - draggableLocation.y;

        actions.dragAndDropBy(draggable, xOffset, yOffset)
                .perform();

        Assert.assertEquals(areaToDrop.getText(), "Dropped!");
    }

}
