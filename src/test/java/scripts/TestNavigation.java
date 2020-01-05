package scripts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestNavigation {

    @Test
    public void testNavigation() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:1338");
        assertEquals(driver.getTitle(), "Target Web Pages");
        driver.findElement(By.linkText("Login")).click();
        assertEquals(driver.getTitle(), "Login Page");
        driver.quit();
    }
}
