/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import javax.swing.JOptionPane;
import view.TelaLogin;
import view.TelaPrincipal;
import model.Usuario;

/**
 *
 * @author banshee
 */
public class RNLogin {
    private TelaLogin telaLogin;

    public RNLogin(TelaLogin telaLogin) {
        this.telaLogin = telaLogin;
    }
    
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
