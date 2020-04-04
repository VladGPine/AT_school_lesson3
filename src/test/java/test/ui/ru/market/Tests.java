package test.ui.ru.market;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import test.ui.WebDriverSettings;
import test.ui.pageObject.MarketElectronicsPage;
import test.ui.pageObject.MarketMainPage;

import java.util.List;
import java.util.Map;

public class Tests extends WebDriverSettings {

    @Test
    public void testWithSteps() {
        MarketMainPage market = new MarketMainPage(driver);
        List<Map<String, Object>> categories = market.getCategories();

        Steps.checkCategory(categories, "Электроника");
        Steps.goToElectronicsPage(market,"Электроника");

        MarketElectronicsPage electronics = new MarketElectronicsPage(driver);
        List<WebElement> electronicsCategories = electronics.getElectronicsCategoriesList();

        Steps.checkElectronicsCategory(electronicsCategories,"Мобильные телефоны");
        Steps.goToPhonesPage(electronics,"Мобильные телефоны");
    }
}
