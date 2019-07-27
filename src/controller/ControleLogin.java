/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import view.TelaLogin;

/**
 *
 * @author banshee
 */
public class ControleLogin implements ActionListener {

    private RNLogin rNLogin;
    private TelaLogin telaLogin;

    public ControleLogin() {
        this.telaLogin = new TelaLogin();
        this.telaLogin.getjButtonEntrar().addActionListener(this);
        this.rNLogin = new RNLogin(telaLogin);
        this.telaLogin.setVisible(true);
        this.telaLogin.getjPasswordFieldSenha().addKeyListener(new java.awt.event.KeyAdapter() {
            
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    acesso();
                }
            }
        });
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaLogin.getjButtonEntrar()) {
            acesso();
        }
    }
    
    private void acesso() {
        this.rNLogin.acesso();
    }
    
}
