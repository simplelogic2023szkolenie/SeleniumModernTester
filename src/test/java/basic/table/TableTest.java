package basic.table;

import base.TestBase;
import org.testng.annotations.Test;
import pages.MountainsTablePage;

public class TableTest extends TestBase {

    @Test
    public void shouldPrintMountainsFromTable() {
        driver.get("http://seleniumui.moderntester.pl/table.php");

        new MountainsTablePage(driver).printMountainHigherThan(4000);
    }
}
