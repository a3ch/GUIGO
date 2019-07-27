/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaPrincipal;
import view.DialogTelaEditarExcluirUsuario;

/**
 *
 * @author banshee
 */
public class ControleEditarExcluirUsuario implements ActionListener{

    private DialogTelaEditarExcluirUsuario telaEditarExcluirUsuario;
    private TelaPrincipal telaPrincipal;

    public ControleEditarExcluirUsuario(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.telaEditarExcluirUsuario = new DialogTelaEditarExcluirUsuario(telaPrincipal, true);
        this.telaEditarExcluirUsuario.getjButtonCancelar().addActionListener(this);
        this.telaEditarExcluirUsuario.setLocationRelativeTo(telaPrincipal);
        this.telaEditarExcluirUsuario.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaEditarExcluirUsuario.getjButtonCancelar()) {
            telaEditarExcluirUsuario.dispose();
        }
    }
    
}
