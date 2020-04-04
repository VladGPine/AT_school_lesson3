package test.ui.ru.open;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import test.ui.WebDriverSettings;
import test.ui.pageObject.YandexResultSearch;

import java.util.List;

//import org.junit.jupiter.api.Assertions;

public class Tests extends WebDriverSettings {

    @Test
    public void gladiolusTest() {
        YandexResultSearch page = new YandexResultSearch(driver, "гладиолус");
        List<WebElement> result = page.getSearchItem();

        Assert.assertTrue("Url not found",
                result.stream().anyMatch(url -> url.getAttribute("href").contains("wiki")));

        System.out.println(result.size());
    }
}
