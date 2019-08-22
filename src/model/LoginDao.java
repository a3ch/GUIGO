package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * Classe responsável pela troca de informações de objetos tipo Login com o banco de dados.
 * @author Caio Montenegro
 * @version 0.1
 * @since 0.1
 */
public class LoginDao {
    /**
     * @param conexao
     */
    private Connection conexao;

    /**
     * Método construtor.
     * Faz a conexão com o servidor.
     * @param conexao Variável que irá guardar a conexão com o banco de dados até o programa ser finalizado.
     */
    public LoginDao(Connection conexao) {
        this.conexao = conexao;
    }
    
    /**
     * Classe que seleciona um usuário do banco de dados para atribuir a sessão.
     * @param usuario Variável com as informações da tentativa de login no sistema.
     * @return O usuário que corresponde às informações de login, caso exista.
     */
    public Usuario acesso(Usuario usuario){
        
        String sql = "select * from TbUsuario where loginUsuario like ? and senhaUsuario like ?";
        Usuario user = new Usuario();

        PreparedStatement pst;
        ResultSet rs;
        
        try {    
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario.getLogin());
            pst.setString(2, usuario.getSenha());
            rs = pst.executeQuery();
            while(rs.next()){      
                user.setId(rs.getInt("codUsuario"));
                user.setLogin(rs.getString("loginUsuario"));
                user.setSenha(rs.getString("senhaUsuario"));
                user.setTipo(rs.getInt("tipoUsuario"));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel buscar.");
            System.out.println(ex);
        }
        
        return user;
                
    }
    
}
