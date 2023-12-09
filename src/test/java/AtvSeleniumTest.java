import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AtvSeleniumTest {
    
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
    }

    @Test
    public void helloSelenium(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bing.com/?cc=br");
        String currentUrl = driver.getCurrentUrl();
        String expected = "https://www.bing.com/?cc=br";

        assertEquals(expected, currentUrl);
		driver.quit();
    }
}
