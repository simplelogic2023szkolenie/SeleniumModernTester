package basic.form;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class FPopFormTest extends TestBase {
    File file;
    FormPage formPage;

    @BeforeMethod
    public void testSetup() {
        driver.get("http://seleniumui.moderntester.pl/form.php");
        file = new File("src/main/resources/someFile.txt");
        formPage = new FormPage(driver);
    }

    @Test
    public void shouldFillFormWithSuccess() {
        formPage.setFirstName("Jan")
                .setLastName("Kowalski")
                .setEmail("j.k23@wp.pl")
                .setAge("23")
                .selectRandomGender()
                .selectProfessions(1)
                .selectRandomExperiences()
                .selectContinent("europe")
                .selectSeleniumCommand("browser-commands")
                .selectSeleniumCommand("switch-commands")
                .uploadFile(file)
                .submitForm();

        Assert.assertEquals(formPage.getValidationMsg(), "Form send with success");
    }

    @Test
    public void shouldFillFormWithSuccessV2() {
        // tylko informacyjnie -> wg mnie to jest zly zapis
        Assert.assertEquals(
                formPage.setFirstName("Jan")
                        .setLastName("Kowalski")
                        .setEmail("j.k23@wp.pl")
                        .setAge("23")
                        .selectRandomGender()
                        .selectProfessions(1)
                        .selectRandomExperiences()
                        .selectContinent("europe")
                        .selectSeleniumCommand("browser-commands")
                        .selectSeleniumCommand("switch-commands")
                        .uploadFile(file)
                        .submitForm()
                        .getValidationMsg(), "Form send with success");
    }
}
