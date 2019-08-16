package model;

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
    Date data;
    float temperatura;
    float umidade;
    float luminosidade;

    public VariaveisAmbiente(Cultura cultura, float temperatura, float umidade, float luminosidade) {
        this.codCultura = cultura.getCodCultura();
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.luminosidade = luminosidade;
        
        Calendar calendario = Calendar.getInstance();
        this.data = calendario.getTime();
    }
    
    //Se faz necessário um cosntrutor sem parametros para a classe VariaveisAmbienteDao.
    public VariaveisAmbiente() {}
    
    public String getDataCompletaFormatada() {
        //Formata Data e Hora
        DateFormat dtHora = DateFormat.getDateTimeInstance();
        
        return dtHora.format(data);
    }
    
    public Date getDate() {
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

    public void setDate(Date data) {
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
    
    
    
}
