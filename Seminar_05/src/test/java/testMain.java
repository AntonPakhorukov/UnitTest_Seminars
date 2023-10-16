import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testMain {
    @Test
    void testIntegrationFindSiteByName() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/pakho/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ya.ru");
        WebElement searchBox = driver.findElement(By.id("text"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();


        List<WebElement> elements = driver.findElements(By.cssSelector("li"));
        boolean findElement = false;
        for (WebElement element : elements) {
            System.out.println(element);
            if(element.getText().contains("selenium.dev")) {
                findElement = true;
                break;
            }
        }
        assertTrue(findElement);
        driver.quit();
    }

    @Test
    void testIntegrationAutorisation() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/pakho/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://saucedemo.com/");
        WebElement login = driver.findElement(By.id("user-name"));
        login.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();

        WebElement product = driver.findElement(By.className("title"));
        String productText = product.getText();
        driver.quit();
        assertEquals("Products", productText);
    }
}
