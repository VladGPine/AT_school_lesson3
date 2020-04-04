package test.ui.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MarketMainPage {
    protected WebDriver driver;
    protected String url = "https://market.yandex.ru/";
    String categorySelector = "//*[@data-zone-name='category-link']";
    String urlSelector = ".//a[@href]";
    String textSelector = ".//a[@href]//span";
    String electronicsLink = ".//*[text()='Электроника']/ancestor::a[@href]";

    List<WebElement> categoryList;
    List<Map<String, Object>> categories = new ArrayList<>();

    public MarketMainPage(WebDriver driver) {
        this.driver = driver;
        driver.get(url);
    }

    public List<WebElement> getCategoryList() {
        categoryList = driver.findElements(By.xpath(categorySelector));
        return categoryList;
    }

    public List<Map<String, Object>> getCategories() {
        this.getCategoryList();
        for (WebElement cat: categoryList) {
            categories.add(Map.of(
                    "WEB_ELEMENT", cat,
                    "URL", cat.findElement(By.xpath(urlSelector)).getAttribute("href"),
                    "TEXT", cat.findElement(By.xpath(textSelector)).getText()
            ));
        }
        return categories;
    }

    public void goToCategoryPage(String category) {
        WebElement categoryLink = (WebElement) categories.stream()
                .filter(cat -> cat.get("TEXT").toString().contains(category))
                .findFirst().get().get("WEB_ELEMENT");

        categoryLink.findElement(By.xpath(urlSelector)).click();
    }
}
