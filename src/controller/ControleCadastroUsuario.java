/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaPrincipal;
import view.DialogTelaCadastroUsuario;

/**
 *
 * @author banshee
 */
public class ControleCadastroUsuario implements ActionListener {

    private DialogTelaCadastroUsuario telaCadastroUsuario;
    private TelaPrincipal telaPrincipal;

    public ControleCadastroUsuario(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.telaCadastroUsuario = new DialogTelaCadastroUsuario(telaPrincipal, true);
        this.telaCadastroUsuario.getjButtonCancelar().addActionListener(this);
        this.telaCadastroUsuario.setLocationRelativeTo(telaPrincipal);
        this.telaCadastroUsuario.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadastroUsuario.getjButtonCancelar()) {
            telaCadastroUsuario.dispose();
        }
    }
    
}
