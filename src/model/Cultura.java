package model;

/**
<<<<<<< Updated upstream
 *
 * @author banshee
 */
public class Cultura {
=======
 * Classe Cultura.
 * Esta classe guarda os atributos e funções da entidade cultura.
 * 
 * @author Gustavo Rodrigues
 * @version 0.1
 * @since 0.1
 */
public class Cultura {
    /**
     * @param codCultura
     * @param nomeCultura
     * @param variedade
     * @param cicloEmDias
     * @param diasGerminacao
     * @param diasBercario
     * @param diasEngorda
     */
    int codCultura;
    String nomeCultura;
    String variedade;
    int cicloEmDias;
    int diasGerminacao;
    int diasBercario;
    int diasEngorda;

    
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
    
>>>>>>> Stashed changes
    
}
