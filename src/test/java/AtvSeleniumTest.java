import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @Test
    public void testSearchFunctionality() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bing.com/?cc=br");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Teste de Software");
        searchBox.submit();

        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("Teste de Software"));
        driver.quit();
    }

    @Test
    public void testMouseHover() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bing.com/?cc=br");
        WebElement elementToHover = driver.findElement(By.id("sb_form_q"));
        
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        
        assertTrue(elementToHover.isDisplayed());
        driver.quit();
    }

    @Test
    public void testSignInFunctionality() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com/?cc=br");

        // Encontrar o link "Entrar"
        WebElement signInLink = driver.findElement(By.id("id_l"));
        signInLink.click();

        // Verificar se a página de login foi carregada
        assertTrue(driver.getCurrentUrl().contains("https://login.live.com/"));
    }

}
