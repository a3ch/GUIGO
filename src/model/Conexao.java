/**
 * Essa classe eu apenas copiei do projeto de Rafael com BD.
 * Certamente vai precisar de modificações.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    
    private static Connection conexao;  
    
    public static Connection getConexao(){
       
            if(conexao == null){
                try {
                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/GUIGO","root","");
                } catch(SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro de Conexão!");
                    throw new RuntimeException(e);
                } 
            }
            return conexao;
        
    }
    
}
