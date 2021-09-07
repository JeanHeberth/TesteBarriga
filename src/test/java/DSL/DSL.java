package DSL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

    private WebDriver entrada;


    public DSL(WebDriver entrada) {
        this.entrada = entrada;
    }

    public void escreve(String id_campo, String texto) {
        entrada.findElement(By.id(id_campo)).sendKeys(texto);
    }

    public String obterValorCampo(String id_campo) {
        return entrada.findElement(By.id(id_campo)).getAttribute("value");
    }

    public void clicarRadio(String id) {
        entrada.findElement(By.id(id)).click();
    }

    public boolean isRadioMarcado(String id) {
        return entrada.findElement(By.id(id)).isSelected();
    }

    public void selecionarCombo(String id, String valor) {
        WebElement dropdownEscolaridade = entrada.findElement(By.id(id));
        Select combo = new Select(dropdownEscolaridade);
        combo.selectByVisibleText(valor);
    }

    public String ObterValorCombo(String id) {
        WebElement dropdownEscolaridade = entrada.findElement(By.id(id));
        Select combo = new Select(dropdownEscolaridade);
        return combo.getFirstSelectedOption().getText();
    }

    public void clicarBotao(String id) {
        entrada.findElement(By.id(id)).click();
    }

    public void clicarLink(String link) {
        entrada.findElement(By.id(link)).click();
    }

    public String obterTextoLink(By by) {
        return entrada.findElement(by).getText();
    }

    public String obterTextoLink(String id) {
        return obterTextoLink(By.id(id));
    }
}