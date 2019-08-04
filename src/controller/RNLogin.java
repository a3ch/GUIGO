package controller;

import javax.swing.JOptionPane;
import view.TelaLogin;
import view.TelaPrincipal;
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
    private TelaLogin telaLogin;
    
    /**
     * Faz associação da TelaPrincipal recebida para o objeto que criado nessa classe. 
     * @param telaLogin Objeto de tela que foi instanciado em ControleLogin.
     */    
    public RNLogin(TelaLogin telaLogin) {
        this.telaLogin = telaLogin;
    }
    
    /**
     * Método Construtor.
     * Esse método cria uma instancia do objeto usuário, somente se o campo de usuário e senha forem validados pelo DAO.
     */
    public void acesso() {
        Usuario usuario = new Usuario();
        usuario.setLogin(telaLogin.getjTextFieldUsuario().getText());
        usuario.setSenha(telaLogin.getjPasswordFieldSenha().getText());
        
        if (usuario.getLogin().equals("admin")) {
            ControlePrincipal cp = new ControlePrincipal();
            this.telaLogin.dispose();
        } else {
            JOptionPane.showMessageDialog(telaLogin, "Acesso Negado");
        }
    }
}
