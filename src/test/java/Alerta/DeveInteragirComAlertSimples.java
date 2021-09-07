package Alerta;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DeveInteragirComAlertSimples {


    private WebDriver entrada;
    private WebDriver maximizaNavegador;

    @Test
    public void InteragirAlert() {

        // Driver do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
        // entrada = new ChromeDriver();

        // Driver Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
        entrada = new FirefoxDriver();

        entrada.manage().window().maximize();
        entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");


        // Função para interagir com alert da página.
        entrada.findElement(By.id("alert")).click();
        Alert alert = entrada.switchTo().alert();
        String textoAlerta = alert.getText();
        Assert.assertEquals("Alert Simples", textoAlerta);
        alert.accept();
        entrada.findElement(By.id("elementosForm:nome")).sendKeys("Jean Heberth Souza Vieira0");


    }
}
