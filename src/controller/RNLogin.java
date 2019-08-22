package controller;

import javax.swing.JOptionPane;
import view.TelaLogin;
import view.TelaPrincipal;
import model.Usuario;

/**
 * Classe utilizada para descrever a regra de negócio do login, aplicando restrições.
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
     * Método Construtor.
     * Faz associação da TelaPrincipal recebida para o objeto que criado nessa classe. 
     * @param telaLogin Objeto de tela que foi instanciado em ControleLogin.
     */    
    public RNLogin(TelaLogin telaLogin) {
        this.telaLogin = telaLogin;
    }
    
    /**
     * Método de Acesso.
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
<<<<<<< Updated upstream
=======
        }*/
    }
    
    /**
     * Método que verifica se os campos inseridos estão vazios.
     * Retorna um sinal booleano para permitir ou negar acesso ao BD.
     * @return Verdadeiro caso haja algum caractere digitado, falso caso os campos estiverem vazios. 
     */
    
    private boolean validaCampos() {
        if (this.telaLogin.getjTextFieldUsuario().getText().equals("")) {
            return false;
        } else if (this.telaLogin.getjPasswordFieldSenha().getText().equals("")) {
            return false;
        } else {
            return true;
>>>>>>> Stashed changes
        }
    }
}
