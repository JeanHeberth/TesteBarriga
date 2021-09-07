package CampoText;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextField {

    private WebDriver entrada;
    private WebDriver maximizaNavegador;


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

}
