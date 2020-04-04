package test.ui.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class YandexResultSearch {
//    private String searchingSelector = "//*[@class='serp-item')]";
    // Через точку почему то падает ошибка, хотел бы разобрать почему
    //    private String urlSelector = ".//div[contains(@class,'organic')]//a[contains(@class, 'organic__url')]";
    private String urlSelector = "//div[contains(@class,'organic')]//a[contains(@class, 'organic__url')]";

    private WebDriver driver;

    private List<WebElement> webSearchItem = new ArrayList();

    // По той же причине не смог сделать через список через map
//    private List<Map<String, Object>> result = new ArrayList<>();


    public YandexResultSearch(WebDriver driver, String searchString) {
        this.driver = driver;
        driver.get("https://yandex.ru/search/?text=" + searchString);
        webSearchItem = driver.findElements(By.xpath(urlSelector));
    }

    public YandexResultSearch(WebDriver driver) {
        this.driver = driver;
        webSearchItem = driver.findElements(By.xpath(urlSelector));
    }

//    public List<Map<String, Object>> getResult() {
//
//        for (WebElement res: webSearchItem) {
//            result.add(Map.of(
//               "WEB_ELEMENT", res,
//               "U", res.findElement(By.xpath(urlSelector)).getAttribute("href")
//            ));
//        }
//        return result;
//    }

    public List<WebElement> getSearchItem() {
        return webSearchItem;
    }
}
