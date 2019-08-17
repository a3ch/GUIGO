package controller;

import java.sql.Connection;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.LoginDao;
import view.DialogTelaLogin;
import view.TelaDescanso;
import model.Usuario;

/**
 * Classe utilizada para descrever a regra de negócio do login
 * Serve para aplicar restrições na hora do Login
 * 
 * @author Caio Montenegro
 * @version 0.1
 * @since 0.1
 */

public class RNLogin {
    /**
     * @param telaLogin
     */
    private DialogTelaLogin telaLogin;
    private TelaDescanso telaDescanso;
    
    private Connection conexao;
    
    private LoginDao loginDao;
    
    /**
     * Faz associação da TelaPrincipal recebida para o objeto que criado nessa classe. 
     * @param telaLogin Objeto de tela que foi instanciado em ControleLogin.
     * @param telaDescanso
     * @param conexao
     */    
    public RNLogin(DialogTelaLogin telaLogin, TelaDescanso telaDescanso, Connection conexao) {
        this.telaLogin = telaLogin;
        this.telaDescanso = telaDescanso;   
        this.conexao = conexao;
        this.loginDao = new LoginDao(conexao);
    }
    
    /**
     * Método Construtor.
     * Esse método cria uma instancia do objeto usuário, somente se o campo de usuário e senha forem validados pelo DAO.
     * @throws java.io.IOException
     */
    public void acesso() throws IOException {
        
        if (validaCampos()) {
            Usuario usuario = new Usuario();
            usuario.setLogin(telaLogin.getjTextFieldUsuario().getText());
            usuario.setSenha(telaLogin.getjPasswordFieldSenha().getText());

            Usuario user = this.loginDao.acesso(usuario);

            if(user.getId() > 0){
                this.telaLogin.dispose();
                this.telaDescanso.dispose();
                //ControlePrincipal cp = new ControlePrincipal(conexao);
                new ControlePrincipal(user.getTipo(), this.conexao);
            } else{
                JOptionPane.showMessageDialog(this.telaLogin, "Acesso Negado"); 
            }
        } else {
            JOptionPane.showMessageDialog(this.telaLogin, "Preencha todos os campos");
        }
        /*
        if (usuario.getLogin().equals("admin")) {
            this.telaDescanso.dispose();
            new ControlePrincipal(usuario.getLogin().toString());
            this.telaLogin.dispose();
            
        } else if(usuario.getLogin().equals("tec")) {
            this.telaDescanso.dispose();
            new ControlePrincipal(usuario.getLogin().toString());
            this.telaLogin.dispose();
        } else if(usuario.getLogin().equals("op")){
            this.telaDescanso.dispose();
            new ControlePrincipal(usuario.getLogin().toString());
            this.telaLogin.dispose();
        } else {
            JOptionPane.showMessageDialog(telaLogin, "Acesso Negado");
        }*/
    }
    
    private boolean validaCampos() {
        if (this.telaLogin.getjTextFieldUsuario().getText().equals("")) {
            return false;
        } else if (this.telaLogin.getjPasswordFieldSenha().getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }
}
