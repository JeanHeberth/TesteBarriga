import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCampoTreinamento {

    private WebDriver abrirNavegador;
    private WebDriver maximizaNavegador;

    private WebDriver entrada;


    @Test
    public void testeTreinamento() {

        // Driver do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
        // abrirNavegador = new ChromeDriver();


        // Driver Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
        abrirNavegador = new FirefoxDriver();


        abrirNavegador.manage().window().maximize();
        abrirNavegador.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");






    }

}
