package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        // to zadziała bo od czerwca 2023, selenium ma wbudowanych
        // webdrivermamanger -> automatycznie pobiera drivery do przegladarek
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
