package Alerta;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertaConfirma {

    private WebDriver entrada;
    private WebDriver maximizaNavegador;


    @Test
    public void AlertaOk() {


        // Driver do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
         entrada = new ChromeDriver();

        // Driver Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
//        entrada = new FirefoxDriver();

        entrada.manage().window().maximize();
        entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

        entrada.findElement(By.id("confirm")).click();
        Alert alert = entrada.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alert.getText());
        alert.accept();
        Assert.assertEquals("Confirmado", alert.getText());
        alert.dismiss(); // Ou alert.accept(); Não intervere.


        entrada.findElement(By.id("confirm")).click();
        alert = entrada.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alert.getText());
        alert.dismiss();
        Assert.assertEquals("Negado", alert.getText());
        alert.accept();
    }
}
