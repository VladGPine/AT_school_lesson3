package test.ui.ru.market;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import test.ui.WebDriverSettings;
import test.ui.pageObject.MarketElectronicsPage;
import test.ui.pageObject.MarketMainPage;
import test.ui.pageObject.MarketPhonesPage;

import java.util.List;
import java.util.Map;

public class Tests extends WebDriverSettings {

    @Test
    public void testWithSteps() {
        MarketMainPage market = new MarketMainPage(driver);
        List<Map<String, Object>> categories = market.getCategories();

        Steps.checkCategory(driver, categories, "Электроника");
        Steps.goToElectronicsPage(market,"Электроника");

        MarketElectronicsPage electronics = new MarketElectronicsPage(driver);
        List<WebElement> electronicsCategories = electronics.getElectronicsCategoriesList();

        Steps.checkElectronicsCategory(driver, electronicsCategories,"Мобильные телефоны");
        Steps.goToPhonesPage(electronics,"Мобильные телефоны");

        MarketPhonesPage phones = new MarketPhonesPage(driver);

        Steps.checkingAppleFilter(driver, phones.getAppleFilter(), "Apple");
        Steps.activateAppleFilter(phones);
        Steps.checkingProductsAt1to10Pages(phones, "APPLE");
    }
}
