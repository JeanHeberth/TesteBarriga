package Botao;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Botao {

    private WebDriver entrada;
    private WebDriver maximizaNavegador;

    @Test
    public void botaoCliqueMe() {


        // Driver do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
        // entrada = new ChromeDriver();

        // Driver Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
        entrada = new FirefoxDriver();

        entrada.manage().window().maximize();
        entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

        entrada.findElement(By.id("buttonSimple")).click();

        //Verificando se o botão foi clicado
        WebElement botaCliqueMe = entrada.findElement(By.id("buttonSimple"));
        botaCliqueMe.click();
        Assert.assertEquals("Obrigado!", botaCliqueMe.getAttribute("value"));
       // entrada.quit();
    }
}
