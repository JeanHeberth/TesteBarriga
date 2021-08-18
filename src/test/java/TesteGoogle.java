import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {

	private  WebDriver navegadorGoogle;
	private  WebDriver navegadorFirefox;


	@Test
	public void teste() {

		// Driver Firefox
		System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
		navegadorFirefox = new FirefoxDriver();

		// Driver do google
		//System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
		//navegadorGoogle = new ChromeDriver();
		navegadorFirefox.manage().window().maximize();
		navegadorFirefox.get("http://www.google.com");
		Assert.assertEquals("Google", navegadorFirefox.getTitle());


		navegadorFirefox.quit();
	}




}

