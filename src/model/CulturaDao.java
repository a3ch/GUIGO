package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
/**
 *
 * @author Gustavo Rodrigues
 */
public class CulturaDao {
    private final Connection conexao;    

    public CulturaDao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void inserir(Cultura cultura){

        if(!buscar(cultura)){
            String sql = "insert into TbCulturas (nomeCultura,variedade,cicloEmDias,diasGerminacao,diasBercario,diasEngorda) values (?,?,?,?,?,?)";
        
            PreparedStatement pst;
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, cultura.getNomeCultura());
                pst.setString(2, cultura.getVariedade());
                pst.setInt(3, cultura.getCicloEmDias());
                pst.setInt(4, cultura.getDiasGerminacao());
                pst.setInt(5, cultura.getDiasBercario());
                pst.setInt(6, cultura.getDiasEngorda());
                pst.execute();
                pst.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel inserir.");
                System.out.println(ex);
            } 
            JOptionPane.showMessageDialog(null, "Registro inserido com sucesso.");
        }
        else{
            JOptionPane.showMessageDialog(null, "Não foi possivel inserir. Cultura já cadastrada.");            
        } 
        
    }
    
    public boolean excluir(Cultura cultura) {
        
        String sql = "delete from TbCulturas where codCultura = ?";
        boolean result = false;
                
        if(buscar(cultura)){
            try {
                PreparedStatement pst = conexao.prepareStatement(sql);
                pst.setInt(1, cultura.getCodCultura());
                result = pst.execute();
                pst.close();                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel excluir.");
                System.out.println(ex);
            }
            
        } else{
            JOptionPane.showMessageDialog(null, "Cultura não cadastrada.");
        }
        
        return result;     
        
    }
    
    public void alterar(Cultura cultura) {
        String sql = "update TbCulturas set nomeCultura = ? , variedade = ?, cicloEmDias = ?, diasGerminacao = ?, diasBercario = ?, diasEngorda = ? where codCultura = ?";

        if(buscar(cultura)){
            try {
                PreparedStatement pst = conexao.prepareStatement(sql);
                pst.setString(1, cultura.getNomeCultura());
                pst.setString(2, cultura.getVariedade());
                pst.setInt(3, cultura.getCicloEmDias());
                pst.setInt(4, cultura.getDiasGerminacao());
                pst.setInt(5, cultura.getDiasBercario());
                pst.setInt(6, cultura.getDiasEngorda());
                pst.setInt(7, cultura.getCodCultura());
                pst.execute();
                pst.close();                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel alterar.");
                System.out.println(ex);
            }
            
        } else{
            JOptionPane.showMessageDialog(null, "Cultura não cadastrada.");
        } 
        
    }
    
    private boolean buscar(Cultura cultura) {
      
        String sql = "select * from TbCulturas where codCultura like ?";
        Cultura culturaBusca = new Cultura();

        PreparedStatement pst;
        ResultSet rs;
        
        try {    
            pst = conexao.prepareStatement(sql);
            pst.setInt(1,cultura.getCodCultura());
            rs = pst.executeQuery();
            while(rs.next()){      
                culturaBusca.setCodCultura(rs.getInt("codCultura"));
                culturaBusca.setNomeCultura(rs.getString("nomeCultura"));
                culturaBusca.setVariedade(rs.getString("variedade"));
                culturaBusca.setCicloEmDias(rs.getInt("cicloEmDias"));
                culturaBusca.setDiasGerminacao(rs.getInt("diasGerminacao"));
                culturaBusca.setDiasBercario(rs.getInt("diasBercario"));
                culturaBusca.setDiasEngorda(rs.getInt("diasEngorda"));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel buscar.");
            System.out.println(ex);
        }
        
        return(culturaBusca.getCodCultura()>0);
    }
    
    public Cultura pesquisar(int codCultura){
        String sql = "select * from TbCulturas where codCultura = ?";
        Cultura cultura = new Cultura();

        PreparedStatement pst;
        ResultSet rs;
        
        try {    
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, codCultura);
            rs = pst.executeQuery();
            while(rs.next()){      
                cultura.setCodCultura(rs.getInt("codCultura"));
                cultura.setNomeCultura(rs.getString("nomeCultura"));
                cultura.setVariedade(rs.getString("variedade"));
                cultura.setCicloEmDias(rs.getInt("cicloEmDias"));                
                cultura.setDiasGerminacao(rs.getInt("diasGerminacao"));
                cultura.setDiasBercario(rs.getInt("diasBercario"));
                cultura.setDiasEngorda(rs.getInt("diasEngorda"));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel buscar.");
            System.out.println(ex);
        }
        
        return cultura;
    }
    
    public ArrayList<Cultura> listar() {
        
        String sql = "select * from TbCulturas order by codCultura";
        
        ArrayList<Cultura> lista = new ArrayList<>();
        
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                Cultura cultura = new Cultura();
                cultura.setCodCultura(rs.getInt("codCultura"));
                cultura.setNomeCultura(rs.getString("nomeCultura"));
                cultura.setVariedade(rs.getString("variedade"));
                cultura.setCicloEmDias(rs.getInt("cicloEmDias"));
                cultura.setDiasGerminacao(rs.getInt("diasGerminacao"));
                cultura.setDiasBercario(rs.getInt("diasBercario"));
                cultura.setDiasEngorda(rs.getInt("diasEngorda"));
                lista.add(cultura);
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
