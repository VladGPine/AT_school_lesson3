package test.ui.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MarketPhonesPage {
    protected WebDriver driver;

    String appleFilterSelector = "//*[text()='Производитель']/ancestor::*[@data-zone-name='search-filter']//*[text()='Apple']";
    String productSelector = "//*[contains(@class,'n-snippet-cell2_type_product')]";
    String brandNameSelector = ".//div[@class='n-snippet-cell2__brand-name']";
    String showMoreButtonSelector = "//*[contains(@class, 'pager-more__button')]";

    WebElement showMoreButton;
    WebElement appleFilter;
    List<WebElement> productsList = new ArrayList<>();
    List<Map<String, Object>> productsListMap = new ArrayList<>();


    public MarketPhonesPage(WebDriver driver) {
        this.driver = driver;
        appleFilter = driver.findElement(By.xpath(appleFilterSelector));
    }

    public WebElement getAppleFilter() {
        return appleFilter;
    }

    public void activateAppleFilter() {
        appleFilter.click();
        wait(4000);
    }

    public List<Map<String, Object>> getProductsListMap() {
        productsList = driver.findElements(By.xpath(productSelector));
        for (WebElement element: productsList) {
            productsListMap.add(Map.of(
                    "WEB_ELEMENT", element,
                    "BRAND_NAME", element.findElement(By.xpath(brandNameSelector)).getText()
            ));
        }
        return productsListMap;
    }

    private void wait(int s){
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Не совсем понимаю в чем ошибка...
    // Пробовал и через цикл делать, тоже самое, тест валится (
    // Хотелось бы разобрать как обрабатывать момент, когда кнопка "показать еще" больше не отображается.

//    public void showAllPhones() {
//        int i = 1;
//
//        while (i < 10) {
//            if (driver.findElements(By.xpath(showMoreButtonSelector)).size() > 0) {
//                showMoreButton = driver.findElement(By.xpath(showMoreButtonSelector));
//                showMoreButton.click();
//                wait(5000);
//            }
//            i++;
//        }
//    }
}
