package test;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomUtils {
    @Attachment
    public static byte[] getScreenshot(WebDriver driver) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("src/main/resources/pic.png"));
            return Files.readAllBytes(Paths.get("src/main/resources/", "pic.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
