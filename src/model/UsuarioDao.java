package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Classe responsável pela troca de informações de objetos tipo Usuario com o banco de dados.
 * @author Gustavo Rodrigues
 * @version 0.1
 * @since 0.1
 */
public class UsuarioDao {
    /**
     * @param conexao Variável que irá guardar a conexão com o banco de dados até o programa ser finalizado.
     */
    private final Connection conexao;    
    
    /**
     * Método construtor.
     * Faz a conexão com o servidor.
     * @param conexao Variável que irá guardar a conexão com o banco de dados até o programa ser finalizado.
     */
    public UsuarioDao(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * Método de inserção de registros no banco de dados.
     * Verifica se já existe um usuário cadastrado com os mesmos parâmetros, caso exista, retorna uma mensagem de erro. 
     * @param usuario Objeto da classe Usuário que será usado para o registro no banco de dados.
     */
    public void inserir(Usuario usuario){

        if(!buscar(usuario)){
            String sql = "insert into TbUsuario (nomeUsuario, foneUsuario, emailUsuario, loginUsuario, senhaUsuario, tipoUsuario) values (?,?,?,?,?,?)";
            
            PreparedStatement pst;
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, usuario.getNome());
                pst.setString(2, usuario.getFone());
                pst.setString(3, usuario.getEmail());
                pst.setString(4, usuario.getLogin());
                pst.setString(5, usuario.getSenha());
                pst.setInt(6, usuario.getTipo());
                pst.execute();
                pst.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel inserir.");
                System.out.println(ex);
            } 
            JOptionPane.showMessageDialog(null, "Registro inserido com sucesso.");
        }
        else{
            JOptionPane.showMessageDialog(null, "Não foi possivel inserir. Usuario já cadastrada.");            
        } 
        
    }
    
    /**
     * Método de exclusão de registros no banco de dados.
     * Verifica se existe um usuário cadastrado com a mesma chave primária, caso exista, exclui do servidor, 
     * caso não exista, retorna uma mensagem de erro. 
     * @param usuario Objeto da classe Usuario que será excluído do banco de dados.
     */ 
    public boolean excluir(Usuario usuario) {
        
        String sql = "delete from TbUsuario where codUsuario = ?";
        boolean result = false;
                
        if(buscar(usuario)){
            try {
                PreparedStatement pst = conexao.prepareStatement(sql);
                pst.setInt(1, usuario.getId());
                result = pst.execute();
                pst.close();                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel excluir.");
                System.out.println(ex);
            }
            
        } else{
            JOptionPane.showMessageDialog(null, "Pessoa não cadastrada.");
        }
        
        return result;     
    }
    
    /**
     * Método de alteração de registros já cadastrados no banco de dados.
     * Verifica se já existe um usuário cadastrado com os mesmos parâmetros, caso exista, altera os dados,
     * caso não exista, retorna uma mensagem de erro. 
     * @param usuario Objeto da classe Usuario que será alterado no banco de dados.
     */   
    public void alterar(Usuario usuario) {
        String sql = "update TbUsuario set nomeUsuario = ? , loginUsuario = ?, senhaUsuario = ?, emailUsuario = ?, foneUsuario = ?, tipoUsuario = ? where codUsuario = ?";

        if(buscar(usuario)){
            try {
                PreparedStatement pst = conexao.prepareStatement(sql);
                pst.setString(1, usuario.getNome());
                pst.setString(2, usuario.getLogin());
                pst.setString(3, usuario.getSenha());
                pst.setString(4, usuario.getEmail());
                pst.setString(5, usuario.getFone());
                pst.setInt(6, usuario.getTipo());
                pst.setInt(7, usuario.getId());
                pst.execute();
                pst.close();                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel alterar.");
                System.out.println(ex);
            }
            
        } else{
            JOptionPane.showMessageDialog(null, "Pessoa não cadastrada.");
        } 
        
    }
    
    /**
     * Método de busca no banco de dados.
     * Verifica se existe um usuário cadastrado com os mesmos parâmetros passados, 
     * caso exista, cria um objeto réplica e envia um sinal booleano representando do seu código (True). 
     * @param usuario Objeto da classe Usuario que será usado para a busca no banco de dados.
     */ 
    private boolean buscar(Usuario usuario) {
      
        String sql = "select * from TbUsuario where codUsuario like ?";
        Usuario p = new Usuario();

        PreparedStatement pst;
        ResultSet rs;
        System.out.println("ID: " + usuario.getId());
        
        try {    
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, usuario.getId());
            rs = pst.executeQuery();
            while(rs.next()){      
                p.setId(rs.getInt("codUsuario"));
                p.setNome(rs.getString("nomeUsuario"));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel buscar.");
            System.out.println(ex);
        }
        
        return(p.getId()>0);
        
    }
    
    /**
     * Método de pesquisa no banco de dados.
     * Verifica se existe um usuário cadastrado com os mesmos parâmetros passados, 
     * caso exista, cria um objeto réplica e o envia completo para a rotina que requeriu. 
     * @param id Chave primária da classe Usuario que será usado para a pesquisa no banco de dados.
     */     
    public Usuario pesquisar(int id){
        String sql = "select * from TbUsuario where codUsuario = ?";
        Usuario usuario = new Usuario();

        PreparedStatement pst;
        ResultSet rs;
        
        try {    
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while(rs.next()){      
                usuario.setId(rs.getInt("codUsuario"));
                usuario.setNome(rs.getString("nomeUsuario"));
                usuario.setFone(rs.getString("foneUsuario"));
                usuario.setEmail(rs.getString("emailUsuario"));
                usuario.setLogin(rs.getString("loginUsuario"));
                usuario.setSenha(rs.getString("senhaUsuario"));
                usuario.setTipo(rs.getInt("tipoUsuario"));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel buscar.");
            System.out.println(ex);
        }
        
        return usuario;
    }
    
    /**
     * Método para extrair, em forma de lista, todos os registros do banco de dados.
     * Cria um ArrayList da classe Usuario, preenche com todos os registros do banco de dados e retorna à rotina que fez a requisição.
     * @return Um ArrayList da  classe Usuario preenchido com todos os registros da tabela TbUsuario.
     */    
    public ArrayList<Usuario> listar() {
        
        String sql = "select * from TbUsuario";
        
        ArrayList<Usuario> lista = new ArrayList<>();
        
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("codUsuario"));
                usuario.setNome(rs.getString("nomeUsuario"));
                usuario.setFone(rs.getString("foneUsuario"));
                usuario.setEmail(rs.getString("emailUsuario"));
                usuario.setLogin(rs.getString("loginUsuario"));
                usuario.setSenha(rs.getString("senhaUsuario"));
                usuario.setTipo(rs.getInt("tipoUsuario"));
                lista.add(usuario);
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
