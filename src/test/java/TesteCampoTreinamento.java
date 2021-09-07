import DSL.DSL;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TesteCampoTreinamento {

    private WebDriver entrada;
    private WebDriver maximizaNavegador;
    private DSL dsl;

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

        dsl = new DSL(entrada);
    }


    @Test
    public void testeTxtField() {

        dsl.escreve("elementosForm:nome", "Jean Heberth");
        Assert.assertEquals("Jean Heberth", dsl.obterValorCampo("elementosForm:nome"));

    }


    @Test
    public void testeTxtArea() {

        dsl.escreve("elementosForm:sugestoes", "Teste");
        Assert.assertEquals("Teste", dsl.obterValorCampo("elementosForm:sugestoes"));

    }

    @Test
    public void RadioButton() {
        dsl.clicarRadio("elementosForm:sexo:0");
        Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));

    }

    @Test
    public void checkbox() {
        dsl.clicarRadio("elementosForm:comidaFavorita:2");
        Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));

    }

    @Test
    public void combobox() {

        dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
        Assert.assertEquals("Mestrado", dsl.ObterValorCombo("elementosForm:escolaridade"));
    }


//    @Test
//    public void comboboxLista() {
//        WebElement dropdownEscolaridade = entrada.findElement(By.id("elementosForm:escolaridade"));
//        Select combo = new Select(dropdownEscolaridade);
//        List<WebElement> options = combo.getOptions();
//        Assert.assertEquals(8, options.size());
//
//        boolean encontrou = false;
//
//        for (WebElement option : options) {
//            if (option.getText().equals("Mestrado")) {
//                encontrou = true;
//                break;
//            }
//        }
//        Assert.assertTrue(encontrou);
//    }


    // Selecionando vários elementos dentro de um comboBox
    @Test
    public void comboboxMultiplo() {
        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
        dsl.selecionarCombo("elementosForm:esportes", "Corrida");
        dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");


        WebElement dropdownEscolaridade = entrada.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(dropdownEscolaridade);

        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3, allSelectedOptions.size());

        combo.deselectByVisibleText("Corrida");
        allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(2, allSelectedOptions.size());


    }

    public void deveInteragirComBotoes() {
        dsl.clicarBotao("buttonSimple");

        WebElement botao = entrada.findElement(By.id("buttonSimple"));
        botao.click();
    }

    public void clicarNoLink() {
        dsl.clicarLink("Voltar");
        Assert.assertEquals("Voltou!", dsl.obterTextoLink("resultado"));
    }

    public void buscarTextosNaPagina() {
        Assert.assertEquals("Campo de Treinamento", dsl.obterTextoLink(By.tagName("h3")));

        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
             dsl.obterTextoLink(By.className("facilAchar")));
    }

    @After
    public void finalize() throws Exception {
        entrada.quit();
    }
}













