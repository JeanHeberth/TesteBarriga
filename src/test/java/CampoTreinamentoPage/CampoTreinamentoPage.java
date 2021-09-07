package CampoTreinamentoPage;

import DSL1.DSL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

    private DSL dsl;

    public CampoTreinamentoPage(WebDriver entrada) {
        this.dsl = new DSL(entrada);
    }

    public void setNome(String nome) {
        dsl.escrever("elementosForm:nome", nome);
    }

    public void setSobreNome(String sobreNome) {
        dsl.escrever("elementosForm:sobrenome", sobreNome);
    }

    public void setSexoFeminino() {
        dsl.campoSelecionar("elementosForm:sexo:1");
    }

    public void setSexoMasculino() {
        dsl.campoSelecionar("elementosForm:sexo:0");
    }

    public void setComidaCarne() {
        dsl.campoSelecionar("elementosForm:comidaFavorita:0");
    }

    public void setComidaFrango() {
        dsl.campoSelecionar("elementosForm:comidaFavorita:1");
    }

    public void setComidaPizza() {
        dsl.campoSelecionar("elementosForm:comidaFavorita:2");
    }

    public void setComidaVegetariano() {
        dsl.campoSelecionar("elementosForm:comidaFavorita:3");
    }

    public void setEscolaridade(String escolherEscolaridade) {
        dsl.campoSelecionarDropDown("elementosForm:escolaridade", escolherEscolaridade);
    }

    public void setEsporte(String... escolherEsportes) {
        for(String escolherEsporte: escolherEsportes)
        dsl.campoSelecionarDropDown("elementosForm:esportes", escolherEsporte);
    }

    public void cadastrar() {
        dsl.clicarBotao("elementosForm:cadastrar");
    }

    public String obterResultadoCadastro() {
        return dsl.obtendoTextoLink("resultado");
    }

    public String obterNomeCadastro() {
        return dsl.obtendoTextoLink("descNome");
    }

    public String obterSobreNomeCadastrado() {
        return dsl.obtendoTextoLink("descSobrenome");
    }

    public String obterSexoCadastrado() {
        return dsl.obtendoTextoLink("descSexo");
    }

    public String obterComidaCadastrada() {
        return dsl.obtendoTextoLink("descComida");
    }

    public String obterEscolaridadeCadastrada() {
        return dsl.obtendoTextoLink("descEscolaridade");
    }

    public String obterEsporteCadastrado() {
        return dsl.obtendoTextoLink("descEsportes");
    }
}
