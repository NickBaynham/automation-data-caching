package scripts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class TestLogin {

    @Test
    public void testLogin() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:1338");
        assertEquals(driver.getTitle(), "Target Web Pages");
        driver.findElement(By.linkText("Login")).click();
        assertEquals(driver.getTitle(), "Login Page");
        driver.findElement(By.id("email")).sendKeys("scottsteele@aol.com");
        driver.findElement(By.id("pwd")).sendKeys("MyPassword");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
        assertEquals(driver.getTitle(), "Target Web Pages");
        driver.quit();
    }
}
