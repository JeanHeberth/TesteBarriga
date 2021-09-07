package UtilizacaoBeforeEAfter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteBefore {


    private WebDriver entrada;


    @Before
    public void inicializa() {
        // Driver do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
        entrada = new ChromeDriver();

        // Driver Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
        // entrada = new FirefoxDriver();

        entrada.manage().window().maximize();
        entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    }


    @Test
    public void validarNomeObrigatorio() {
        entrada.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = entrada.switchTo().alert();
        Assert.assertEquals("Nome eh obrigatorio", alert.getText());

    }

    @Test
    public void validarSobrenomeObrigatorio() {
        entrada.findElement(By.id("elementosForm:nome")).sendKeys("Jean");
        entrada.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = entrada.switchTo().alert();
        Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());

    }

    @Test
    public void validarCampoSexo() {
        entrada.findElement(By.id("elementosForm:nome")).sendKeys("Jean Heberth");
        entrada.findElement(By.id("elementosForm:sobrenome")).sendKeys("Souza Vieira");
        entrada.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = entrada.switchTo().alert();
        Assert.assertEquals("Sexo eh obrigatorio", alert.getText());

    }

    @Test
    public void validarComidaVegetariana() {
        entrada.findElement(By.id("elementosForm:nome")).sendKeys("Jean Heberth");
        entrada.findElement(By.id("elementosForm:sobrenome")).sendKeys("Souza Vieira");
        entrada.findElement(By.id("elementosForm:sexo:0")).click();
        entrada.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        entrada.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        entrada.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = entrada.switchTo().alert();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());

    }


    @Test
    public void validarCampoEsporte() {
        entrada.findElement(By.id("elementosForm:nome")).sendKeys("Jean Heberth");
        entrada.findElement(By.id("elementosForm:sobrenome")).sendKeys("Souza Vieira");
        entrada.findElement(By.id("elementosForm:sexo:0")).click();
        entrada.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        Select combo = new Select(entrada.findElement(By.id("elementosForm:esportes")));
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");
        entrada.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = entrada.switchTo().alert();
        Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());

    }

    @After
    public void finaliza() {
        entrada.quit();

    }
}

