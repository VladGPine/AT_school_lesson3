package test.ui.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MarketElectronicsPage {
    protected WebDriver driver;

    String electronicsCategorySelector = "//*[@data-autotest-id='subItems']//*[@data-zone-name='link']//a[@href]";
//    String urlSelector = ".//a[@href]";

    List<WebElement> electronicsCategoriesList = new ArrayList<>();
//    List<Map<String, Object>> electronicsCategories = new ArrayList<>();

    public MarketElectronicsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getElectronicsCategoriesList() {
        electronicsCategoriesList = driver.findElements(By.xpath(electronicsCategorySelector));
        return electronicsCategoriesList;
    }

//    public List<Map<String, Object>> getElectronicsCategories() {
//        for (WebElement cat: electronicsCategoriesList) {
//            electronicsCategories.add(Map.of(
//               "WEB_ELEMENT", cat,
//               "URL", cat.findElement(By.xpath(urlSelector)).getAttribute("href"),
//               "TEXT", cat.findElement(By.xpath(urlSelector)).getText()
//            ));
//        }
//        return electronicsCategories;
//    }

    public void goToPhonesPage(String electronicsCategory) {
        WebElement categoryLink = (WebElement) electronicsCategoriesList.stream()
                .filter(cat -> cat.getText().equals(electronicsCategory))
                .findFirst().get();

        categoryLink.click();
    }
}
