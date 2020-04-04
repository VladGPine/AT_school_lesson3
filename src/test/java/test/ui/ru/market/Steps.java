package test.ui.ru.market;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import test.ui.pageObject.MarketElectronicsPage;
import test.ui.pageObject.MarketMainPage;

import java.util.List;
import java.util.Map;

public class Steps {

    @Step("Проверка наличия раздела {text}")
    public static void checkCategory(List<Map<String, Object>> categoryListMap, String text) {
        Assert.assertTrue(categoryListMap.stream()
                .anyMatch(category -> category.get("TEXT").toString().contains(text)));
    }

    @Step("Переход по ссылке с текстом {text}")
    public static void goToElectronicsPage(MarketMainPage market, String text) {
        market.goToCategoryPage(text);
    }

    @Step("Проверка наличия раздела {text}")
    public static void checkElectronicsCategory(List<WebElement> electronicsCategories, String text) {
        Assert.assertTrue(electronicsCategories.stream()
                .anyMatch(category -> category.getText().equals(text)));
    }

    @Step("Переход по ссылке с текстом {text}")
    public static void goToPhonesPage(MarketElectronicsPage electronics, String text) {
        electronics.goToPhonesPage(text);
    }

}
