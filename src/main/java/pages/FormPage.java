package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormPage {

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(css = "#selectContinents")
    private WebElement continentsSelect;

    @FindBy(css = "[name='gridCheckboxProfession']")
    private List<WebElement> professionCheckboxes;

    @FindBy(css = "#validator-message")
    private WebElement validationLbl;

    public void setFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }

    public void selectContinent(String continentValue){
        new Select(continentsSelect).selectByValue(continentValue);
    }

    public void selectProfessions(int index){
        professionCheckboxes.get(index).click();
    }

    public String getValidationMsg(){
        return validationLbl.getText();
    }


}
