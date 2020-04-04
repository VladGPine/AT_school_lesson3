package test.ui.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoogleResultSearch {

    private String selectorSearchItem = "//div[@class='g']";
    private String selectorUrl = ".//div[@class='r']/a[@href]";
    private String selectorNamePage = ".//div[@class='r']/a[@href]/h3";
    private String selectorDescription = ".//div[@class='s']";

    private WebDriver driver;
    private List<WebElement> webSearchItem = new ArrayList();
    private List<Map<String, Object>> collectResult = new ArrayList();

    public GoogleResultSearch(WebDriver driver, String search) {
        this.driver = driver;
        driver.get("https://www.google.ru/search?q=" + search);
        webSearchItem = driver.findElements(By.xpath(selectorSearchItem));
    }

    public GoogleResultSearch(WebDriver driver) {
        this.driver = driver;
        webSearchItem = driver.findElements(By.xpath(selectorSearchItem));
    }

    public List<Map<String, Object>> getCollectResult() {
        for (WebElement result: webSearchItem) {
            collectResult.add(Map.of(
                    "WEB_ELEMENT", result,
                    "URL", result.findElement(By.xpath(selectorUrl)).getAttribute("href"),
                    "NAME_PAGE", result.findElement(By.xpath(selectorNamePage)).getText(),
                    "DESCRIPTION", result.findElement(By.xpath(selectorDescription)).getText()
            ));
        }
        return collectResult;
    }

    public boolean goFindPage(String namePage) {
        WebElement pageLink = (WebElement) collectResult.stream()
                .filter(x -> x.get("NAME_PAGE").toString().contains(namePage))
                .findFirst()
                .get()
                .get("WEB_ELEMENT");

        pageLink.findElement(By.xpath(selectorNamePage)).click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (String tab: tabs) {
            driver.switchTo().window(tab);
            if (driver.getTitle().contains(namePage))
                return true;
        }
        return false;
    }
}