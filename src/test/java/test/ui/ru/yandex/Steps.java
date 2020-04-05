package test.ui.ru.yandex;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import test.ui.pageObject.YandexResultSearch;

import java.util.List;

public class Steps {

    @Step("Проверка наличия ссылки на википедию")
    public static void checkingWikiLink(YandexResultSearch page, String searchingString) {
        List<WebElement> result = page.getSearchItem();

        Assert.assertTrue("Url not found",
                result.stream().anyMatch(url -> url.getAttribute("href").contains(searchingString)));
    }
}
