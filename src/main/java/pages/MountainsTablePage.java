package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MountainsTablePage {
    public MountainsTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> rows;

//   jak coś tutaj opcja tej metody zapisana w 1 linijce z steam
//    public List<MountainRowComponent> getMountains() {
//        return rows.stream().map(MountainRowComponent::new).collect(Collectors.toList());
//    }

    public List<MountainRowComponent> getMountains() {
        List<MountainRowComponent> rowPages = new ArrayList<>();

        for (WebElement row : rows) {
            rowPages.add(new MountainRowComponent(row));
        }
        return rowPages;
    }

    public void printMountainHigherThan(int expectedHeight) {
        for (MountainRowComponent mountain : getMountains()) {
            if (mountain.getHeight() > expectedHeight) {
                System.out.println(mountain);
            }
        }
    }
}
