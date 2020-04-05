package test.ui.ru.yandex;

import org.junit.jupiter.api.Test;
import test.ui.WebDriverSettings;
import test.ui.pageObject.YandexResultSearch;

public class Tests extends WebDriverSettings {

    @Test
    public void gladiolusTest() {
        YandexResultSearch page = new YandexResultSearch(driver, "гладиолус");
        Steps.checkingWikiLink(page, "wiki");
    }
}
