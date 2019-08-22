package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Classe responsável pela troca de informações de objetos tipo Cultura com o banco de dados.
 * @author Gustavo Rodrigues
 * @version 0.1
 * @since 0.1
 */
public class CulturaDao {
    /**
     * @param conexao Variável que irá guardar a conexão com o banco de dados até o programa ser finalizado.
     */
    private final Connection conexao;    
    /**
     * Método construtor.
     * Faz a conexão com o servidor.
     * @param conexao Variável que irá guardar a conexão com o banco de dados até o programa ser finalizado.
     */
    public CulturaDao(Connection conexao) {
        this.conexao = conexao;
    }
    /**
     * Método de inserção de registros no banco de dados.
     * Verifica se já existe uma cultura cadastrada com os mesmos parâmetros, caso exista, retorna uma mensagem de erro. 
     * @param cultura Objeto da classe Cultura que será usado para o registro no banco de dados.
     */    
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
    /**
     * Método de exclusão de registros no banco de dados.
     * Verifica se existe uma cultura cadastrada com a mesma chave primária, caso exista, exclui do servidor, 
     * caso não exista, retorna uma mensagem de erro. 
     * @param cultura Objeto da classe Cultura que será excluído do banco de dados.
     */   
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
    /**
     * Método de alteração de registros já cadastrados no banco de dados.
     * Verifica se já existe uma cultura cadastrada com os mesmos parâmetros, caso exista, altera os dados,
     * caso não exista, retorna uma mensagem de erro. 
     * @param cultura Objeto da classe Cultura que será alterado no banco de dados.
     */    
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
    /**
     * Método de busca no banco de dados.
     * Verifica se existe uma cultura cadastrada com os mesmos parâmetros passados, 
     * caso exista, cria um objeto réplica e envia um sinal booleano representando do seu código (True). 
     * @param cultura Objeto da classe Cultura que será usado para a busca no banco de dados.
     */ 
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
    /**
     * Método de pesquisa no banco de dados.
     * Verifica se existe uma cultura cadastrada com os mesmos parâmetros passados, 
     * caso exista, cria um objeto réplica e o envia completo para a rotina que requeriu. 
     * @param codCultura Chave primária da classe Cultura que será usado para a pesquisa no banco de dados.
     */     
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
    /**
     * Método para extrair, em forma de lista, todos os registros do banco de dados.
     * Cria um ArrayList da classe Cultura, preenche com todos os registros do banco de dados e retorna à rotina que fez a requisição.
     * @return Um ArrayList da  classe Cultura preenchido com todos os registros da tabela TbCulturas.
     */    
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
