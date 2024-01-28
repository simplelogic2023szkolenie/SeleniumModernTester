package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class MountainRowComponent {
    public MountainRowComponent(WebElement parent) {
        PageFactory.initElements(new DefaultElementLocatorFactory(parent), this);
    }

    @FindBy(css="th")
    private WebElement rank;

    @FindBy(xpath="./td[1]")
    private WebElement peak;

    @FindBy(xpath="./td[2]")
    private WebElement range;

    @FindBy(xpath="./td[3]")
    private WebElement country;

    @FindBy(xpath="./td[4]")
    private WebElement height;

    public String getRank(){
        return rank.getText();
    }

    public String getPeak(){
        return peak.getText();
    }

    public String getRange(){
        return range.getText();
    }

    public String getCountry(){
        return country.getText();
    }

    public int getHeight(){
        return Integer.parseInt(height.getText());
    }

    @Override
    public String toString() {
        return "MountainRowPage{" +
                "rank=" + getRank() +
                ", peak=" + getPeak() +
                ", range=" + getRange() +
                ", country=" + getCountry() +
                ", height=" + getHeight() +
                '}';
    }
}
