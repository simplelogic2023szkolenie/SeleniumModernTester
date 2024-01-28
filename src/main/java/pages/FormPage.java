package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage {

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(css = "#inputLastName3")
    private WebElement lastNameInput;

    @FindBy(css = "#inputEmail3")
    private WebElement emailInput;

    @FindBy(css = "#inputAge3")
    private WebElement ageInput;

    @FindBy(css = "#validator-message")
    private WebElement validationMsg;

    @FindBy(css = "#selectContinents")
    private WebElement selectContinents;

    @FindBy(css = "#selectSeleniumCommands")
    private WebElement selectSeleniumCommands;
    @FindBy(css = "#chooseFile")
    private WebElement fileInput;

    @FindBy(css = ".btn-primary")
    private WebElement submitButton;

    @FindBy(css = "[name='gridRadiosSex']")
    private List<WebElement> gendersRadios;

    @FindBy(css = "[name='gridRadiosExperience']")
    private List<WebElement> experientceRadios;

    @FindBy(css = "[name='gridCheckboxProfession']")
    private List<WebElement> professionsCheckboxes;

    public FormPage submitForm() {
        submitButton.click();
        return this;
    }

    public FormPage selectProfessions(int index) {
        professionsCheckboxes.get(index).click();
        return this;
    }

    public FormPage selectRandomExperiences() {
        getRandomElement(experientceRadios).click();
        return this;
    }

    public FormPage selectAllSeleniumCommands() {
        List<WebElement> allSeleniumOptions = new Select(selectSeleniumCommands).getOptions();

        for (WebElement option : allSeleniumOptions) {
            option.click();
        }
        return this;
    }

    public FormPage selectAllSeleniumCommandsV2() {
        int quantityOfOptions = new Select(selectSeleniumCommands).getOptions().size();

        for (int i = 0; i < quantityOfOptions; i++) {
            selectSeleniumCommand(i);
        }
        return this;
    }

    public FormPage selectSeleniumCommand(String seleniumCommand) {
        new Select(selectSeleniumCommands).selectByValue(seleniumCommand);
        return this;
    }

    public FormPage selectSeleniumCommand(int index) {
        new Select(selectSeleniumCommands).selectByIndex(index);
        return this;
    }

    public FormPage uploadFile(File file) {
        fileInput.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormPage selectContinent(String continent) {
        new Select(selectContinents).selectByValue(continent);
        return this;
    }

    public FormPage selectRandomGender() {
        getRandomElement(gendersRadios).click();
        return this;
    }

    public FormPage setFirstName(String firstName) {
        this.firstNameInput.sendKeys(firstName);
        return this;
    }

    public FormPage setLastName(String lastName) {
        this.lastNameInput.sendKeys(lastName);
        return this;
    }

    public FormPage setEmail(String email) {
        this.emailInput.sendKeys(email);
        return this;
    }

    public FormPage setAge(String age) {
        this.ageInput.sendKeys(age);
        return this;
    }

    public String getValidationMsg() {
        return validationMsg.getText();
    }

    private WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        int randomListIndex = rnd.nextInt(elements.size());
        return elements.get(randomListIndex);
    }


}
