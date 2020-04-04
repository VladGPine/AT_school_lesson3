package test.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    protected WebDriver driver;

    @BeforeEach
    private void startTest() {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--window-size=1920, 1200");
//        options.setCapability("Site key", "6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI");
//        options.setCapability("Secret key","6LeIxAcTAAAAAGG-vFI1TnRWxMZNFuojJ4WifJWe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterEach
    private void stopTest() {
        driver.quit();
    }
}
