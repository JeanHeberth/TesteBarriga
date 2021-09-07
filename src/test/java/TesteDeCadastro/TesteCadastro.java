package TesteDeCadastro;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {

    private WebDriver entrada;
    private WebDriver maximizaNavegador;


    @Test
    @Ignore
    public void testeCadastro() {

        // Driver do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
        entrada = new ChromeDriver();

        // Driver Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
        // entrada = new FirefoxDriver();

        entrada.manage().window().maximize();
        entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

        entrada.findElement(By.id("elementosForm:nome")).sendKeys("Jean Heberth");
        entrada.findElement(By.id("elementosForm:sobrenome")).sendKeys("Souza Vieira");
        entrada.findElement(By.id("elementosForm:sexo:0")).click();
        entrada.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        entrada.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        entrada.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        WebElement dropDownEscolaridade = entrada.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(dropDownEscolaridade);
        combo.selectByVisibleText("Superior");
        WebElement dropDownEsporte = entrada.findElement(By.id("elementosForm:esportes"));
        Select comboEsportes = new Select(dropDownEsporte);
        comboEsportes.selectByVisibleText("Corrida");
        entrada.findElement(By.id("elementosForm:sugestoes")).sendKeys("Testando o cadastro");
        entrada.findElement(By.id("elementosForm:cadastrar")).click();


        Assert.assertTrue(entrada.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assert.assertTrue(entrada.findElement(By.id("descNome")).getText().endsWith("Jean Heberth"));
        Assert.assertTrue(entrada.findElement(By.id("descSobrenome")).getText().endsWith("Souza Vieira"));
        Assert.assertTrue(entrada.findElement(By.id("descSexo")).getText().endsWith("Masculino"));
        Assert.assertTrue(entrada.findElement(By.id("descComida")).getText().endsWith("Carne Frango Pizza"));
        Assert.assertTrue(entrada.findElement(By.id("descEscolaridade")).getText().endsWith("superior"));
        Assert.assertTrue(entrada.findElement(By.id("descEsportes")).getText().endsWith("Corrida"));
        Assert.assertTrue(entrada.findElement(By.id("descSugestoes")).getText().endsWith("Testando o cadastro"));

    }



}

