package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginDao {
    
    private Connection conexao;

    public LoginDao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
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
