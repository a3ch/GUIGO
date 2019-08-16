package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Rodrigues
 */
public class VariaveisAmbienteDao {
    private final Connection conexao;    

    public VariaveisAmbienteDao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void inserir(VariaveisAmbiente va){

        if(!buscar(va)){
            String sql = "insert into TbDataRealTime (codCultura,data,temperatura,umidade,luminosidade) values (?,?,?,?,?)";
        
            PreparedStatement pst;
            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, va.getCodCultura());
                pst.setDate(2, (Date) va.getDate()); // O objeto java.util.Date não é compatível com java.sql.Date, por isso o cast "(Date)"
                pst.setFloat(3, va.getTemperatura());
                pst.setFloat(4, va.getUmidade());
                pst.setFloat(5, va.getLuminosidade());
                pst.execute();
                pst.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel inserir.");
                System.out.println(ex);
            } 
            JOptionPane.showMessageDialog(null, "Registro inserido com sucesso."); // Podemos omitir os avisos para esse Dao tranquilamente
        }
        else{
            JOptionPane.showMessageDialog(null, "Não foi possivel inserir. Registro já cadastrado.");            
        }
    }
    
    // Busca no Banco de Dados pelo campo de DATA.
    private boolean buscar(VariaveisAmbiente va) {
      
        String sql = "select * from TbDataRealTime where data like ?";
        VariaveisAmbiente vaBusca = new VariaveisAmbiente();

        PreparedStatement pst;
        ResultSet rs;
        
        try {    
            pst = conexao.prepareStatement(sql);
            pst.setDate(1,(Date)va.getDate());
            rs = pst.executeQuery();
            while(rs.next()){      
                vaBusca.setCodCultura(rs.getInt("codCultura"));
                vaBusca.setTemperatura(rs.getFloat("temperatura"));
                vaBusca.setUmidade(rs.getFloat("umidade"));
                vaBusca.setLuminosidade(rs.getFloat("luminosidade"));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel buscar.");
            System.out.println(ex);
        }
        
        return(vaBusca.getCodCultura()>0);
    }
    
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
        
    public ArrayList<VariaveisAmbiente> listar() {
        
        String sql = "select * from TbRealTimeData order by codCultura, data";
        
        ArrayList<VariaveisAmbiente> lista = new ArrayList<>();
        
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                VariaveisAmbiente va = new VariaveisAmbiente();
                va.setCodCultura(rs.getInt("codCultura"));
                va.setDate(rs.getDate("data"));
                va.setTemperatura(rs.getFloat("temperatura"));
                va.setUmidade(rs.getFloat("umidade"));
                va.setLuminosidade(rs.getFloat("luminosidade"));
                lista.add(va);
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar.");
            System.out.println(ex);
        }
        
        return lista;    
        
    }
        
}
