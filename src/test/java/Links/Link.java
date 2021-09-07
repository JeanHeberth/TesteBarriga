package Links;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Link {

    private WebDriver entrada;
    private WebDriver maximizaNavegador;


    @Test
    @Ignore
    public void clicarNoLink() {

        // Driver do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
        // entrada = new ChromeDriver();

        // Driver Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
        entrada = new FirefoxDriver();

        entrada.manage().window().maximize();
        entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

        entrada.findElement(By.linkText("Voltar")).click();

        //Verificando se a mensagem foi exibida corretamente.

        Assert.assertEquals("Voltou!",entrada.findElement(By.id("resultado")).getText());
        //Assert.fail();


    }
}
