package unit;

import autodiscoverheal.cache.Cache;
import autodiscoverheal.cache.CacheManager;
import autodiscoverheal.cache.ItemNotInCacheException;
import autodiscoverheal.cache.NoCacheException;
import org.junit.Test;

import static org.junit.Assert.*;
import static autodiscoverheal.locators.SeleniumLocatorUtils.*;
import static framework.utils.DriverManager.*;

/**
 *   Verify that locators can be cached, retrieved, and used in place of literals in selenium tests
 */
public class TestCachedLocators {

    @Test
    public void verifyStoringLocators() {
        Cache cache = CacheManager.getInstance("locators");
        assertEquals(cache.getId(), "locators");
        cache.add("url", "http://127.0.0.1:1338");
        cache.add("homePageTitle", "Target Web Pages");
        cache.add("homePageNavigateLogin", "link:=Login");
        cache.add("loginPageTitle", "Login Page");
        cache.add("loginPageEmail", "id:=email");
        cache.add("loginPagePassword", "id:=pwd");
        cache.add("loginPageRememberMe", "xpath:=//input[@type='checkbox']");
        cache.add("loginPageSubmit", "xpath:=//button[contains(.,'Submit')]");
        cache.serializeCache();
    }

    @Test
    public void verifyCanGetLocators() throws NoCacheException, ItemNotInCacheException {
        Cache cache = CacheManager.getInstance("locators");
        assertEquals(cache.getId(), "locators");
        cache.deSerialize();
        System.out.println(cache.get("url"));
        System.out.println(cache.get("homePageTitle"));
        System.out.println(cache.get("loginPageSubmit"));
    }

    @Test
    public void verifyCachedLocatorsSeleniumTest() throws NoCacheException, ItemNotInCacheException {
        Cache cache = CacheManager.getInstance("locators");
        assertEquals(cache.getId(), "locators");
        cache.deSerialize();
    }

    @Test
    public void verifySeleniumTest() throws Exception {
        CacheManager.getInstance("locators");
        getDriver().get(CacheManager.get("url"));
        assertEquals(getDriver().getTitle(), CacheManager.get("homePageTitle"));
        getLocator("homePageNavigateLogin").click();
        assertEquals(getDriver().getTitle(), CacheManager.get("loginPageTitle"));
        getLocator("loginPageEmail").sendKeys("scottsteele@aol.com");
        getLocator("loginPagePassword").sendKeys("MyPassword");
        getLocator("loginPageRememberMe").click();
        getLocator("loginPageSubmit").click();
        assertEquals(getDriver().getTitle(), CacheManager.get("homePageTitle"));
        getDriver().quit();
    }
}