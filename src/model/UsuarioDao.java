/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author banshee
 */
public class UsuarioDao {
    
    private final Connection conexao;

    public UsuarioDao(Connection conexao) {
        this.conexao = conexao;
    }

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
