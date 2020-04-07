package test.ui.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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

    public WebDriver getDriver() {
        return driver;
    }

    private void wait(int s){
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Boolean isElementPresented() {
        Boolean elementCondition = false;
        try {
            elementCondition = driver.findElement(By.xpath(showMoreButtonSelector)).isDisplayed();
        } catch (NoSuchElementException e) {
            return elementCondition;
        }
        return elementCondition;
    }

    // Хотелось бы разобрать как обрабатывать момент, когда кнопка "показать еще" больше не отображается.

    public void showAllPhones() {
        for (int i = 1; i < 10; i++) {
            if (isElementPresented()) {
                showMoreButton = driver.findElement(By.xpath(showMoreButtonSelector));
                showMoreButton.click();
                wait(5000);
            }
//            System.out.println(i);
        }
    }
}
