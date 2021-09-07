package Combo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ComboMultiplo {

    private WebDriver entrada;
    private WebDriver maximizaNavegador;


    @Test
    @Ignore
    public void comboboxMultiplo() {

        // Driver do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
        // entrada = new ChromeDriver();

        // Driver Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
        entrada = new FirefoxDriver();

        entrada.manage().window().maximize();
        entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

        WebElement dropdownEscolaridade = entrada.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(dropdownEscolaridade);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");

        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3, allSelectedOptions.size());


        // Função para deslecionar o campo
        combo.deselectByVisibleText("Corrida");
        allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(2, allSelectedOptions.size());

        entrada.quit();
    }
}
