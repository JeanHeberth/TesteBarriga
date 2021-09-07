package TesteDeCadastro;

import CampoTreinamentoPage.CampoTreinamentoPage;
import DSL1.DSL;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TesteCadastroDSL {

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
    }


    @Test
    public void campoNome() {

        dsl.escrever("elementosForm:nome", "JeanTeste");
        Assert.assertEquals("JeanTeste", dsl.obtendoValorCampoEscrever("elementosForm:nome"));
    }

    @Test
    public void campoSobreNome() {
        dsl.escrever("elementosForm:sobrenome", "Souza Vieira");
        Assert.assertEquals("Souza Vieira", dsl.obtendoValorCampoEscrever("elementosForm:sobrenome"));
    }

    @Test
    public void campoSexo() {
        dsl.campoSelecionar("elementosForm:sexo:0");
        Assert.assertTrue(dsl.obtendoValorCampoSelecionar("elementosForm:sexo:0"));
    }

    @Test
    public void campoComida() {
        dsl.campoSelecionar("elementosForm:comidaFavorita:0");
        dsl.campoSelecionar("elementosForm:ComidaFavorita:1");
        dsl.campoSelecionar("elementosForm:ComidaFavorita:3");
        Assert.assertTrue(dsl.obtendoValorCampoSelecionar("elementosForm:comidaFavorita:0"));
        Assert.assertTrue(dsl.obtendoValorCampoSelecionar("elementosForm:comidaFavorita:1"));
        Assert.assertTrue(dsl.obtendoValorCampoSelecionar("elementosForm:comidaFavorita:3"));
    }

    @Test
    public void campoEscolaridade() {
        dsl.campoSelecionarDropDown("elementosForm:escolaridade", "Superior");
        Assert.assertEquals("Superior", dsl.obtendoValorDoDropDown("elementosForm:escolaridade"));

    }

    @Test
    public void campoEsporte() {
        dsl.campoSelecionarDropDown("elementosForm:esportes", "Natacao");
        dsl.campoSelecionarDropDown("elementosForm:esportes", "Futebol");
        dsl.campoSelecionarDropDown("elementosForm:esportes", "Corrida");

        List<String> opcoesMarcadas = dsl.obtendoValoresDoDropDown("elementosForm:esportes");
        Assert.assertEquals(3, opcoesMarcadas.size());

        dsl.deselecionarCombo("elementosForm:esportes","Corrida");
        opcoesMarcadas = dsl.obtendoValoresDoDropDown("elementosForm:esportes");
        Assert.assertEquals(2, opcoesMarcadas.size());
        Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));
    }

    @Test
    public void campoBotao() {
        dsl.clicarBotao("buttonSimple");
        WebElement botao = entrada.findElement(By.id("buttonSimple"));
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));

    }

    @Test
    public void campoLink() {
        dsl.clicarLink("Voltar");
        Assert.assertEquals("Voltou!", dsl.obtendoTextoLink("resultado"));
    }

    @Test
    public void buscarTextoNaPagina() {
        Assert.assertEquals("Campo de Treinamento", dsl.obtendoTextoLink(By.tagName("h3")));
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                dsl.obtendoTextoLink(By.className("facilAchar")));
    }

    @Test
    public void textoDuplo(){
        dsl.escrever("elementosForm:nome", "JeanTeste");
        Assert.assertEquals("JeanTeste", dsl.obtendoValorCampoEscrever("elementosForm:nome"));
        dsl.escrever("elementosForm:nome", "JeanTeste1");
        Assert.assertEquals("JeanTeste1", dsl.obtendoValorCampoEscrever("elementosForm:nome"));
    }

//    @After
//    public void finalize() throws Exception {
//        entrada.quit();
//    }

}




