package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Timestamp;

/**
 *
 * @author Gustavo Rodrigues
 */
public class VariaveisAmbienteDao {
    private final Connection conexao; 
    private Date d;
    private Timestamp ts;

    public VariaveisAmbienteDao(Connection conexao) {
        this.conexao = conexao;
        
    }
    
    public void inserir(VariaveisAmbiente va){

        if(!buscar(va)){
            String sql = "insert into TbDataRealTime (dataRT,temperatura,umidade,luminosidade) values (?,?,?,?)";
        
            PreparedStatement pst;
            try {
                d = new Date(System.currentTimeMillis());
                ts = new Timestamp(d.getTime());
                pst = conexao.prepareStatement(sql);
                pst.setTimestamp(1, ts);
                pst.setFloat(2, va.getTemperatura());
                pst.setFloat(3, va.getUmidade());
                pst.setFloat(4, va.getLuminosidade());
                pst.execute();
                pst.close();
            } catch (SQLException ex) {
                //System.out.println("Não foi possivel inserir.");
                System.out.println(ex);
            }
            //System.out.println("Registro inserido com sucesso.");
             // Podemos omitir os avisos para esse Dao tranquilamente
        }
        else{
            //System.out.println("Não foi possivel inserir. Registro já cadastrado.");            
        }
    }
    
    // Busca no Banco de Dados pelo campo de DATA.
    
    private boolean buscar(VariaveisAmbiente va) {
      
        String sql = "select * from TbDataRealTime where dataRT like ?";
        VariaveisAmbiente vaBusca = new VariaveisAmbiente();

        PreparedStatement pst;
        ResultSet rs;
        
        try {    
            pst = conexao.prepareStatement(sql);
            pst.setTimestamp(1, va.getDate());
            rs = pst.executeQuery();
            while(rs.next()){      
                vaBusca.setDate(rs.getTimestamp("dataRT"));
                vaBusca.setTemperatura(rs.getFloat("temperatura"));
                vaBusca.setUmidade(rs.getFloat("umidade"));
                vaBusca.setLuminosidade(rs.getFloat("luminosidade"));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Não foi possivel buscar.");
            System.out.println(ex);
        }
        
        return(vaBusca.getCodCultura()>0);
    }
    /*
    // Pesquisa por DATA e por codCultura. Lembrar de fazer o cast do java.util.Date para o java.sql.Date antes de enviar o parâmetro para pesquisa.
    public VariaveisAmbiente pesquisar(Date data, int codCultura){
        String sql = "select * from TbCultura where data = ? and codCultura = ?"; // Não sei se esse comando em sql funciona.
        VariaveisAmbiente vaPesquisa = new VariaveisAmbiente();

        PreparedStatement pst;
        ResultSet rs;
        
        try {    
            pst = conexao.prepareStatement(sql);
            pst.setDate(1, data);
            pst.setInt(2, codCultura);
            rs = pst.executeQuery();
            while(rs.next()){      
                vaPesquisa.setCodCultura(rs.getInt("codCultura"));
                vaPesquisa.setDate((Date) rs.getDate("data")); // Convertendo de volta para java.util.Date.
                vaPesquisa.setTemperatura(rs.getFloat("temperatura"));
                vaPesquisa.setUmidade(rs.getFloat("umidade"));        
                vaPesquisa.setLuminosidade(rs.getFloat("luminosidade"));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel buscar.");
            System.out.println(ex);
        }
        
        return vaPesquisa;
    }
    */    
    public ArrayList<VariaveisAmbiente> listar() {
        
        String sql = "select * from TbDataRealTime order by dataRT desc limit 1";
        
        ArrayList<VariaveisAmbiente> lista = new ArrayList<>();
        
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                VariaveisAmbiente va = new VariaveisAmbiente();
                va.setDate(rs.getTimestamp("dataRT"));
                va.setTemperatura(rs.getFloat("temperatura"));
                va.setUmidade(rs.getFloat("umidade"));
                va.setLuminosidade(rs.getFloat("luminosidade"));
                lista.add(va);
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return lista;    
        
    }
        
}
