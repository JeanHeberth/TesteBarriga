package Prompt;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertPrompt {
    private WebDriver entrada;
    private WebDriver maximizaNavegador;



    @Test
    public void alertPrompt() {
        // Driver do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
        entrada = new ChromeDriver();

        // Driver Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
      // entrada = new FirefoxDriver();

        entrada.manage().window().maximize();
        entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

        entrada.findElement(By.id("prompt")).click();

        Alert alert = entrada.switchTo().alert();
        Assert.assertEquals("Digite um numero", alert.getText());
        alert.sendKeys("33");
        alert.accept();
        Assert.assertEquals("Era 33?", alert.getText());
        alert.accept();
        Assert.assertEquals(":D", alert.getText());
        alert.accept();


    }
}
