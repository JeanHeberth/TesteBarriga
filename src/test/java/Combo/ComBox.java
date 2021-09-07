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

public class ComBox {

    private WebDriver entrada;
    private WebDriver maximizaNavegador;

    @Test
    @Ignore
    public void combobox() {


        // Driver do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
        // entrada = new ChromeDriver();

        // Driver Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
        entrada = new FirefoxDriver();

        entrada.manage().window().maximize();
        entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

        WebElement dropdownEscolaridade = entrada.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(dropdownEscolaridade);
        combo.selectByVisibleText("Mestrado");
        //combo.selectByValue("doutorado");
        //combo.selectByIndex(2);
        // dropdownEscolaridade.findElement(By.xpath("//option[.='Superior']")).click();
        Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());

        entrada.quit();
    }

    @Test
    @Ignore
    public void comboboxLista() {

        // Driver do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
        // entrada = new ChromeDriver();

        // Driver Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
        entrada = new FirefoxDriver();

        entrada.manage().window().maximize();
        entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

        WebElement dropdownEscolaridade = entrada.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(dropdownEscolaridade);
        List<WebElement> options = combo.getOptions();
        Assert.assertEquals(8, options.size());

        boolean encontrou = false;

        for (WebElement option : options) {
            if (option.getText().equals("Mestrado")) {
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);

        entrada.quit();
    }

    /*
     * { WebElement dropdownEscolaridade =
     * entrada.findElement(By.id("elementosForm:escolaridade"));
     * dropdownEscolaridade.findElement(By.xpath("//option[.='Superior']")).click();
     * } { WebElement dropdownEsportes =
     * entrada.findElement(By.id("elementosForm:esportes"));
     * dropdownEsportes.findElement(By.xpath("//option[.='Karate']")).click(); }
     */
}
