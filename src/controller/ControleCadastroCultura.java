/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaPrincipal;
import view.DialogTelaCadastroCultura;

/**
 *
 * @author banshee
 */
public class ControleCadastroCultura implements ActionListener{

    private DialogTelaCadastroCultura telaCadastroCultura;
    private TelaPrincipal telaPrincipal;

    public ControleCadastroCultura(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.telaCadastroCultura = new DialogTelaCadastroCultura(telaPrincipal, true);
        this.telaCadastroCultura.getjButtonCancelar().addActionListener(this);
        this.telaCadastroCultura.setLocationRelativeTo(telaPrincipal);
        this.telaCadastroCultura.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadastroCultura.getjButtonCancelar()) {
            this.telaCadastroCultura.dispose();
        }
    }
    
}
