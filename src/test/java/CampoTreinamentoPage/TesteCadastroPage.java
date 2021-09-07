package CampoTreinamentoPage;

import DSL1.DSL;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastroPage {

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
    public void testeCadastro() {
        page.setNome("Jean Heberth");
        page.setSobreNome("Souza Vieira");
        page.setSexoMasculino();
        page.setComidaPizza();
        page.setEscolaridade("Mestrado");
        page.setEsporte("Natacao");
        page.cadastrar();


        Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
        Assert.assertTrue(page.obterNomeCadastro().endsWith("Jean Heberth"));
        Assert.assertEquals("Sobrenome: Souza Vieira", page.obterSobreNomeCadastrado());
        Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastrado());
        Assert.assertEquals("Comida: Pizza", page.obterComidaCadastrada());
        Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastrada());
        Assert.assertEquals("Esportes: Natacao", page.obterEsporteCadastrado());


    }


    @Test
    public void validarNomeObrigatorio() {

        page.cadastrar();
        Alert alert = entrada.switchTo().alert();
        Assert.assertEquals("Nome eh obrigatorio", alert.getText());

    }

    @Test
    public void validarSobrenomeObrigatorio() {

        page.setNome("João");
        page.cadastrar();
        Alert alert = entrada.switchTo().alert();
        Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());

    }

    @Test
    public void validarCampoSexo() {


        page.setNome("Jean Heberth");
        page.setSobreNome("Souza Vieira");
        page.cadastrar();
        Alert alert = entrada.switchTo().alert();
        Assert.assertEquals("Sexo eh obrigatorio", alert.getText());

    }

    @Test
    public void validarComidaVegetariana() {


        page.setNome("Jean Heberth");
        page.setSobreNome("Souza Vieira");
        page.setSexoMasculino();
        page.setComidaCarne();
        page.setComidaVegetariano();
        page.cadastrar();
        Alert alert = entrada.switchTo().alert();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());

    }


    @Test
    public void validarCampoEsporte() {

        page.setNome("Jean Heberth");
        page.setSobreNome("Souza Vieira");
        page.setSexoMasculino();
        page.setComidaCarne();
        page.setComidaPizza();
        page.setComidaFrango();
        page.setEsporte("Natacao", "O que eh esporte?");
        page.cadastrar();
        Alert alert = entrada.switchTo().alert();
        Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());

    }


    @After
    public void finalize() {
        entrada.quit();
    }
}

