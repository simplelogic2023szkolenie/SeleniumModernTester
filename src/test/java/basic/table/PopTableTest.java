package basic.table;

import base.TestBase;
import org.testng.annotations.Test;
import pages.MountainsTablePage;

public class PopTableTest extends TestBase {

    @Test
    public void printMountainsFromTableTest() {
        driver.get("http://seleniumui.moderntester.pl/table.php");

        new MountainsTablePage(driver).printMountainHigherThan(4000);
    }
}
