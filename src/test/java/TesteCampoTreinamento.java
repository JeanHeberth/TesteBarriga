import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCampoTreinamento {

	private WebDriver entrada;
	private WebDriver maximizaNavegador;

	@Test
	@Ignore
	public void testeTreinamento() {

		// Driver do google
		System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
		// abrirNavegador = new ChromeDriver();

		// Driver Firefox
		System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
		entrada = new FirefoxDriver();

		entrada.manage().window().maximize();
		entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

	}

	@Test
	public void testeTxtField() {

		// Driver do google
		System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
		// entrada = new ChromeDriver();

		// Driver Firefox
		System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
		entrada = new FirefoxDriver();

		entrada.manage().window().maximize();
		entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

		entrada.findElement(By.id("elementosForm:nome")).sendKeys("Jean Heberth");
		Assert.assertEquals("Jean Heberth", entrada.findElement(By.id("elementosForm:nome")).getAttribute("value"));

		entrada.findElement(By.id("elementosForm:sobrenome")).sendKeys("Souza Vieira");
		Assert.assertEquals("Souza Vieira", entrada.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));

	}

	@Test
	@Ignore
	public void testeTxtArea() {

		// Driver do google
		System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
		// entrada = new ChromeDriver();

		// Driver Firefox
		System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
		entrada = new FirefoxDriver();

		entrada.manage().window().maximize();
		entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

		entrada.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste");
		Assert.assertEquals("Teste", entrada.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

	}

	@Test
	@Ignore
	public void RadioButton() {

		// Driver do google
		System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
		// entrada = new ChromeDriver();

		// Driver Firefox
		System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
		entrada = new FirefoxDriver();

		entrada.manage().window().maximize();
		entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

		entrada.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(entrada.findElement(By.id("elementosForm:sexo:0")).isSelected());

	}

	@Test
	@Ignore
	public void checkbox() {

		// Driver do google
		System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
		// entrada = new ChromeDriver();

		// Driver Firefox
		System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
		entrada = new FirefoxDriver();

		entrada.manage().window().maximize();
		entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

		entrada.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(entrada.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

		entrada.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		Assert.assertTrue(entrada.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());

		entrada.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Assert.assertTrue(entrada.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());

	}
}

/*
 * { WebElement dropdownEscolaridade =
 * entrada.findElement(By.id("elementosForm:escolaridade"));
 * dropdownEscolaridade.findElement(By.xpath("//option[.='Superior']")).click();
 * } { WebElement dropdownEsportes =
 * entrada.findElement(By.id("elementosForm:esportes"));
 * dropdownEsportes.findElement(By.xpath("//option[.='Karate']")).click(); }
 */

// entrada.quit();