package test.ui.ru.market;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import test.ui.pageObject.MarketElectronicsPage;
import test.ui.pageObject.MarketMainPage;
import test.ui.pageObject.MarketPhonesPage;

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

    @Step("Проверка наличия фильтра {brandName}")
    public static void checkingAppleFilter(WebElement filter, String brandName) {
        Assert.assertEquals(filter.getText(), brandName);
    }

    @Step("Устанавливаем фильтр по Производителю Apple")
    public static void activateAppleFilter(MarketPhonesPage phones) {
        phones.activateAppleFilter();

    }

    @Step("Показываем все страницы с телефонами {brandName} с 1 по 10, если есть")
    public static void checkingProductsAt1to10Pages(MarketPhonesPage phones,
                                                    String brandName) {
        phones.showAllPhones();
        List<Map<String, Object>> products = phones.getProductsListMap();
//        System.out.println(products.size());
//        for (Map<String, Object> map : products) {
//            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                String key = entry.getKey();
//                Object value = entry.getValue();
//                System.out.println(key + ": " + value);
//            }
//        }
        Assert.assertTrue(products.stream()
                .allMatch(phone -> phone.get("BRAND_NAME").toString().equals(brandName)));
    }

}
