package CampoTreinamentoPage;

import DSL1.DSL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@RunWith(Parameterized.class)
public class TesteRegraCadastro {

    private WebDriver entrada;
    private CampoTreinamentoPage page;
    private DSL dsl;

    @Parameterized.Parameter
    public String nome;
    @Parameterized.Parameter(value = 1)
    public String sobreNome;
    @Parameterized.Parameter(value = 2)
    public String sexo;
    @Parameterized.Parameter(value = 3)
    public List<String> comidas;
    @Parameterized.Parameter(value = 4)
    public String[] esportes;
    @Parameterized.Parameter(value = 5)
    public String msg;

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

    @Parameterized.Parameters
    public static Collection<Object[]> getCollections() {
        return Arrays.asList(new Object[][]{
                        {"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
                        {"Jean Heberth", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
                        {"Jean Heberth", "Souza Vieira", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
                        {"Jean Heberth", "Souza Vieira", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
                        {"Jean Heberth", "Souza Vieira", "Masculino", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}

                }
        );
    }

    @Test
    public void validarRegra() {


        page.setNome(nome);
        page.setSobreNome(sobreNome);
        if (sexo.equals("Masculino"))page.setSexoMasculino();
        if (sexo.equals("Feminino"))page.setSexoFeminino();
        if (comidas.contains("Carne")) page.setComidaCarne();
        if (comidas.contains("Pizza")) page.setComidaPizza();
        if (comidas.contains("Frango")) page.setComidaFrango();
        page.setEsporte(esportes);
        page.cadastrar();
        System.out.println(msg);
    }

    @After
    public void finalize() throws Exception {
        entrada.quit();
    }
}
