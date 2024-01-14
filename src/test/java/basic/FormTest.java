package basic;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class FormTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess(){
        driver.get("http://seleniumui.moderntester.pl/form.php");

        WebElement firstNameInput= driver.findElement(By.cssSelector("#inputFirstName3"));
        firstNameInput.sendKeys("Jan");

        driver.findElement(By.cssSelector("#inputLastName3")).sendKeys("Kowalski");
        driver.findElement(By.cssSelector("#inputEmail3")).sendKeys("j.k@w.pl");
        driver.findElement(By.cssSelector("#inputAge3")).sendKeys("45");

        List<WebElement> genders = driver.findElements(By.cssSelector("[name='gridRadiosSex']"));
        genders.get(0).click();

        driver.findElements(By.cssSelector("[name='gridRadiosExperience']")).get(0).click();


        List<WebElement> professions = driver.findElements(By.cssSelector("[name='gridCheckboxProfession']"));
        Assert.assertFalse(professions.isEmpty());

        for (WebElement profession : professions) {
            profession.click();
        }


        Select continentsSelect = new Select(driver.findElement(By.cssSelector("#selectContinents")));
        continentsSelect.selectByValue("europe");




        driver.findElement(By.cssSelector(".btn-primary")).click();
        String msg = driver.findElement(By.cssSelector("#validator-message")).getText();
        Assert.assertEquals(msg, "Form send with success");
    }





    // tutaj przykład jak uzywać losowanie elementów z listy
    @Test
    public void shouldSelectRandomGender(){
        driver.get("http://seleniumui.moderntester.pl/form.php");
        List<WebElement> genders = driver.findElements(By.cssSelector("[name='gridRadiosSex']"));

        Random random = new Random();
        // random.nextInt(10) -> losuje liczby zakresu 0-9

        // zapis w 1 linijce
        genders.get(random.nextInt(genders.size())).click();

        // zapis rozbity:
        int randomIndex = random.nextInt(genders.size()); // losowanie 0-2 (bo są genders.size()=3)

        WebElement randomGender = genders.get(randomIndex);

        randomGender.click();
    }





}
