package DSL1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DSL {

    private WebDriver entrada;


    public DSL(WebDriver entrada) {
        this.entrada = entrada;
    }

    public void escrever(By id_campoEscrever, String texto) {
        entrada.findElement(id_campoEscrever).clear();
        entrada.findElement(id_campoEscrever).sendKeys(texto);
    }

    public void escrever(String id_campoEscrever, String texto) {
        escrever(By.id(id_campoEscrever), texto);
    }

    public String obtendoValorCampoEscrever(String id_campoEscrever) {
        return entrada.findElement(By.id(id_campoEscrever)).getAttribute("value");
    }

    public void campoSelecionar(String id_campoSelecionar) {
        entrada.findElement(By.id(id_campoSelecionar)).click();
    }

    public boolean obtendoValorCampoSelecionar(String id_campoSelecionar) {
        return entrada.findElement(By.id(id_campoSelecionar)).isSelected();
    }

    public void campoSelecionarDropDown(String id_campoSelecionar, String valor) {
        WebElement dropdown = entrada.findElement(By.id(id_campoSelecionar));
        Select combo = new Select(dropdown);
        combo.selectByVisibleText(valor);

    }

    public void deselecionarCombo(String id_campoSelecionar, String valor) {
        WebElement dropdown = entrada.findElement(By.id(id_campoSelecionar));
        Select combo = new Select(dropdown);
        combo.deselectByVisibleText(valor);
    }

    public String obtendoValorDoDropDown(String id_campoSelecionarValor) {
        WebElement dropdown = entrada.findElement(By.id(id_campoSelecionarValor));
        Select combo = new Select(dropdown);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> obtendoValoresDoDropDown(String id_campoSelecionarValor) {
        WebElement dropdown = entrada.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(dropdown);
        List<WebElement> selecionarTodasOpcoes = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for (WebElement opcao : selecionarTodasOpcoes) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    public void clicarBotao(String id_campoBotao) {
        entrada.findElement(By.id(id_campoBotao)).click();

    }

    public void clicarLink(String id_link) {
        entrada.findElement(By.linkText(id_link)).click();
    }

    public String obtendoTextoLink(By by) {
        return entrada.findElement(by).getText();
    }

    public String obtendoTextoLink(String id_link) {
        return obtendoTextoLink(By.id(id_link));
    }
}
