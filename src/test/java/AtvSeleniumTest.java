import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AtvSeleniumTest {

    private WebDriver driver;


    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        driver = new ChromeDriver();
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
    public void testImageSearch() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com/?cc=br");

        // Encontrar o botão de pesquisa de imagens
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("images"))).click();

        // Verificar se a página de pesquisa de imagens foi carregada
        assertTrue(driver.getCurrentUrl().contains("https://www.bing.com/images/feed?form=Z9LH"));
        driver.quit();

    }

    @Test
    public void testImageSearchFunctionality() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com/?cc=br");

        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("images"))).click();

        driver.get(driver.getCurrentUrl());
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Gatinhos Fofos");
        searchBox.submit();

        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("Gatinhos Fofos"));
        driver.quit();
    }

    @Test
    public void testVideoSearch() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com/?cc=br");

        // Encontrar o botão de pesquisa de videos
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("video"))).click();
        // imagesButton.click();

        // Verificar se a página de pesquisa de imagens foi carregada
        assertTrue(driver.getCurrentUrl().contains("https://www.bing.com/?scope=video&nr=1&form=Z9LH1"));
        driver.quit();

    }

    @Test
    public void testNewsSearch() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com/?cc=br");

        // Encontrar o botão de pesquisa de notiticias
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("news"))).click();

        assertTrue(driver.getCurrentUrl().contains("https://www.bing.com/news/search?q=Fatos+Principais&nvaug=%5bNewsVertical+Category%3d%22rt_MaxClass%22%5d&FORM=Z9LH3"));
        driver.quit();

    }

    @Test
    public void testVideoSearchFunctionality() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com/?cc=br");

        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("video"))).click();

        driver.get(driver.getCurrentUrl());
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Trailer GTA 6");
        searchBox.submit();

        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("Trailer GTA 6"));
        driver.quit();
    }

    @Test
    public void testMaps() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com/?cc=br");

        // Encontrar o botão de pesquisa de imagens
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("local"))).click();
        // mapsButton.click();

        // Verificar se a página de pesquisa de imagens foi carregada
        assertTrue(driver.getCurrentUrl().contains("https://www.bing.com/maps?FORM=Z9LH2&cp=-8.05855%7E-34.885025&lvl=11.0"));        
        driver.quit();
    }

    @Test
    public void testElementNotPresent() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Navegar até uma página (por exemplo, o Bing)
        driver.get("https://www.bing.com/?cc=br");

        // Verificar se um elemento específico (por exemplo, com ID "elemento_inexistente") não está presente
        boolean elementoExistente = false;
        try {

            // Tentar encontrar o elemento
            WebElement element = driver.findElement(By.id("elemento_teste"));
            elementoExistente=true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            // Se o elemento não for encontrado, retorna falso
            elementoExistente = false;
        }

        assertFalse(elementoExistente);
        driver.quit();

    }

    

    @After
    public void tearDown() {
        // Fechar o navegador após cada teste
        if (driver != null) {
            driver.quit();
        }
    }


}
