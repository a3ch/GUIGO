package controller;

import javax.swing.JOptionPane;
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
    
    /**
     * Faz associação da TelaPrincipal recebida para o objeto que criado nessa classe. 
     * @param telaLogin Objeto de tela que foi instanciado em ControleLogin.
     */    
    public RNLogin(DialogTelaLogin telaLogin, TelaDescanso telaDescanso) {
        this.telaLogin = telaLogin;
        this.telaDescanso = telaDescanso;
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
            this.telaDescanso.dispose();
            ControlePrincipal cp = new ControlePrincipal();
            this.telaLogin.dispose();
        } else {
            JOptionPane.showMessageDialog(telaLogin, "Acesso Negado");
        }
    }
}
