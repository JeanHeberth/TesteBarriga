package TesteCadastroComPage;

import CampoTreinamentoPage.CampoTreinamentoPage;
import DSL1.DSL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class TesteCadastroDSLComPage {

    private WebDriver entrada;
    private DSL dsl;
    private CampoTreinamentoPage page;


    @Before
    public void inicialize() {
        // Driver do google
        System.setProperty("webdriver.chrome.driver", "D:\\Documentos\\DriversTestes\\chromedriver.exe");
        entrada = new ChromeDriver();

        // Driver Firefox
        System.setProperty("webdriver.gecko.driver", "D:\\Documentos\\DriversTestes\\geckodriver.exe");
        // entrada = new FirefoxDriver();

        entrada.manage().window().maximize();
        entrada.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

        dsl = new DSL(entrada);
        page = new CampoTreinamentoPage(entrada);
    }


    @Test
    public void cadastrarUsuario() {
        page.setNome("Jean Heberth");
        page.setSobreNome("Souza Vieira");
        page.setSexoMasculino();
        page.setComidaPizza();
        page.setEscolaridade("Mestrado");
        page.setEsporte("Natacao");
        page.cadastrar();


    }


}




