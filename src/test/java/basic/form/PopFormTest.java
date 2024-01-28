package basic.form;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class PopFormTest extends TestBase {
    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("http://seleniumui.moderntester.pl/form.php");
        File file = new File("src/main/resources/someFile.txt");

        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Jan");
        formPage.setLastName("Kowalski");
        formPage.setEmail("j.k23@wp.pl");
        formPage.setAge("23");
        formPage.selectRandomGender();
        formPage.selectProfessions(1);
        formPage.selectRandomkExperiences();
        formPage.selectContinent("europe");
        formPage.selectSeleniumCommand("browser-commands");
        formPage.selectSeleniumCommand("switch-commands");
        formPage.uploadFile(file);
        formPage.submitForm();

        Assert.assertEquals(formPage.getValidationMsg(), "Form send with success");
    }
}
