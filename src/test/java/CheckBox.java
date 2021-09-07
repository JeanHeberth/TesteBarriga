import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBox {

    private WebDriver entrada;
    private WebDriver maximizaNavegador;

    @Test
    @Ignore
    public void checkbox() {

        // Driver do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
        // entrada = new ChromeDriver();

        // Driver Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
        entrada = new FirefoxDriver();

        entrada.manage().window().maximize();
        entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

        entrada.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        Assert.assertTrue(entrada.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

        entrada.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        Assert.assertTrue(entrada.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());

        entrada.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        Assert.assertTrue(entrada.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());

    }

}
