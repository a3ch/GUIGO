/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gustavo Rodrigues
 */
public class Cultura {
    int codCultura;
    String nomeCultura;
    String variedade;
    int cicloEmDias;
    int diasGerminacao;
    int diasBercario;
    int diasEngorda;

    public Cultura(int codCultura, String nomeCultura, String variedade, int cicloEmDias, int diasGerminacao, int diasBercario, int diasEngorda) {
        this.codCultura = codCultura;
        this.nomeCultura = nomeCultura;
        this.variedade = variedade;
        this.cicloEmDias = cicloEmDias;
        this.diasGerminacao = diasGerminacao;
        this.diasBercario = diasBercario;
        this.diasEngorda = diasEngorda;
    }
    
    //Se faz necessário um cosntrutor sem parametros para a classe CulturaDao.
    public Cultura(){}

    public int getCodCultura() {
        return codCultura;
    }

    public void setCodCultura(int codCultura) {
        this.codCultura = codCultura;
    }

    public String getNomeCultura() {
        return nomeCultura;
    }

    public void setNomeCultura(String nomeCultura) {
        this.nomeCultura = nomeCultura;
    }

    public String getVariedade() {
        return variedade;
    }

    public void setVariedade(String variedade) {
        this.variedade = variedade;
    }

    public int getCicloEmDias() {
        return cicloEmDias;
    }

    public void setCicloEmDias(int cicloEmDias) {
        this.cicloEmDias = cicloEmDias;
    }

    public int getDiasGerminacao() {
        return diasGerminacao;
    }

    public void setDiasGerminacao(int diasGerminacao) {
        this.diasGerminacao = diasGerminacao;
    }

    public int getDiasBercario() {
        return diasBercario;
    }

    public void setDiasBercario(int diasBercario) {
        this.diasBercario = diasBercario;
    }

    public int getDiasEngorda() {
        return diasEngorda;
    }

    public void setDiasEngorda(int diasEngorda) {
        this.diasEngorda = diasEngorda;
    }
    
    
}
