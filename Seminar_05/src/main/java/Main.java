import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:/Users/pakho/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://ya.ru");
        WebElement searchBox = driver.findElement(By.id("text"));
        searchBox.sendKeys("GeekBrains");
        searchBox.submit();
        Thread.sleep(10000);
        driver.quit();
    }
}
