package Links;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BuscarTextos {


    private WebDriver entrada;
    private WebDriver maximizaNavegador;


    @Test
    public void buscarTextosNaPagina() {

        // Driver do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
        // entrada = new ChromeDriver();

        // Driver Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
        entrada = new FirefoxDriver();

        entrada.manage().window().maximize();
        entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

        // Buscar para trazer textos dentro da página em um local específico.
//        System.out.println(entrada.findElement(By.tagName("body")).getText()
//                .contains("Campo de Treinamento"));

      //  Assert.assertEquals("Campo de Treinamento", entrada.findElement(By.tagName("h3")).getText());

        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                entrada.findElement(By.className("facilAchar")).getText());


    }
}
