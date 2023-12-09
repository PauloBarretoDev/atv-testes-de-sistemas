import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AtvSelenium {
    public static void main(String[] args) {
         WebDriver driver = new ChromeDriver();

         driver.get("https://www.selenium.dev/selenium/web/web-form.html");

         driver.getTitle();
    }
}
