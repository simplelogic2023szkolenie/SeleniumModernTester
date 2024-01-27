package interations;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {

    @Test
    public void shouldMoveSlider() {
        driver.get("http://seleniumui.moderntester.pl/slider.php");
        moveToValue(50);
        Assert.assertEquals(getSliderValue(), 50);

        moveToValue(30);
        Assert.assertEquals(getSliderValue(), 30);

        moveToValue(30);
        Assert.assertEquals(getSliderValue(), 30);

        moveToValue(20);
        Assert.assertEquals(getSliderValue(), 20);

    }

    public void moveToValue(int expectedValue) {
        int actualValue = getSliderValue();

        int repetitions = Math.abs(expectedValue - actualValue);

        for (int i = 0; i < repetitions; i++) {
            getHandle().sendKeys(expectedValue < actualValue ? Keys.ARROW_LEFT : Keys.ARROW_RIGHT);
        }
        Assert.assertEquals(getSliderValue(), expectedValue);

    }


    public WebElement getHandle() {
        return driver.findElement(By.cssSelector("#custom-handle"));
    }

    public int getSliderValue() {
        // String -> int
        // "25"   -> 25
        return Integer.parseInt(getHandle().getText());
    }
}
