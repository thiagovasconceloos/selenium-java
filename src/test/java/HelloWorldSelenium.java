import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {

	 
	
	
	
	@Test
	public void hello() {
		
		WebDriver browser = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		browser.navigate().to("htpp://localhost:8080/leiloes");
		browser.quit();
		
		
		
	}

}
