package basic.form;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

public class PopFormTest extends TestBase {
    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("http://seleniumui.moderntester.pl/form.php");

        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Jan");

        formPage.selectContinent("europe");
        formPage.selectProfessions(1);


        Assert.assertEquals(formPage.getValidationMsg(), "Form send with success");
    }
}
