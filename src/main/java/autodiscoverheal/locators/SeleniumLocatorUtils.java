package autodiscoverheal.locators;

import autodiscoverheal.cache.*;
import org.openqa.selenium.*;
import static framework.utils.DriverManager.*;

public class SeleniumLocatorUtils {

    public static WebElement getLocator(String key) throws Exception {
        CacheManager.getInstance("locators");
        String locator = "";
        locator = CacheManager.get(key);

        if (! locator.isEmpty() && locator.contains("=")) {
            String[] locatorInstructions = locator.split(":=");
            switch (locatorInstructions[0]) {
                case "css": return getDriver().findElement(By.cssSelector(locatorInstructions[1]));
                case "xpath": return getDriver().findElement(By.xpath(locatorInstructions[1]));
                case "id": return getDriver().findElement(By.id(locatorInstructions[1]));
                case "link": return getDriver().findElement(By.linkText(locatorInstructions[1]));
                default: throw new ItemNotInCacheException(key);
            }
        }
        throw new Exception("Invalid Locator in Cache: " + locator);
    }
}
