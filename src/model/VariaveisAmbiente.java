package model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Gustavo Rodrigues
 */
public class VariaveisAmbiente {
    /* 
    Acredito que erramos no diagrama do banco de dados.
    1 Registro das variáveis de ambiente pode ter apenas uma cultura como identificador.
    Ao invés disso colocamos N para M. Criando uma tabela de relacionamento sem necessidade e sem uso prático.
    Precisamos apenas de um campo em "variáveis de ambiente" que represente o "código da cultura" do mesmo registro.
    */
    
    int codCultura;
    Timestamp data;
    float temperatura;
    float umidade;
    float luminosidade;
    float ph;
    float oxigenioDissolvido;
    float condutividadeEletrica;

    public VariaveisAmbiente(Cultura cultura, float temperatura, float umidade, float luminosidade, Timestamp data, float ph, float oxigenioDissolvido, float condutividadeEletrica) {
        this.codCultura = cultura.getCodCultura();
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.luminosidade = luminosidade;
        this.ph = ph;
        this.oxigenioDissolvido = oxigenioDissolvido;
        this.condutividadeEletrica = condutividadeEletrica;
        this.data = data;
    }
    
    //Se faz necessário um cosntrutor sem parametros para a classe VariaveisAmbienteDao.
    public VariaveisAmbiente() {}
    
    public String getDataCompletaFormatada() {
        //Formata Data e Hora
        DateFormat dtHora = DateFormat.getDateTimeInstance();
        
        return dtHora.format(data);
    }
    
    public Timestamp getDate() {
        return data;
    }

    public int getCodCultura() {
        return codCultura;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public float getUmidade() {
        return umidade;
    }

    public float getLuminosidade() {
        return luminosidade;
    }

    public void setCodCultura(int codCultura) {
        this.codCultura = codCultura;
    }

    public void setDate(Timestamp data) {
        this.data = data;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public void setUmidade(float umidade) {
        this.umidade = umidade;
    }

    public void setLuminosidade(float luminosidade) {
        this.luminosidade = luminosidade;
    }

    public float getPh() {
        return ph;
    }

    public void setPh(float ph) {
        this.ph = ph;
    }

    public float getOxigenioDissolvido() {
        return oxigenioDissolvido;
    }

    public void setOxigenioDissolvido(float oxigenioDissolvido) {
        this.oxigenioDissolvido = oxigenioDissolvido;
    }

    public float getCondutividadeEletrica() {
        return condutividadeEletrica;
    }

    public void setCondutividadeEletrica(float condutividadeEletrica) {
        this.condutividadeEletrica = condutividadeEletrica;
    }
    
    
    
}
