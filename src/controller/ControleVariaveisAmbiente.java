/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaPrincipal;
import view.DialogEditarVariaveisAmbiente;

/**
 *
 * @author banshee
 */
public class ControleVariaveisAmbiente implements ActionListener {

    private DialogEditarVariaveisAmbiente telaEditarVariaveisAmbiente;
    private TelaPrincipal telaPrincipal;

    public ControleVariaveisAmbiente(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.telaEditarVariaveisAmbiente = new DialogEditarVariaveisAmbiente(telaPrincipal, true);
        this.telaEditarVariaveisAmbiente.getjButtonCancelar().addActionListener(this);
        this.telaEditarVariaveisAmbiente.setLocationRelativeTo(telaPrincipal);
        this.telaEditarVariaveisAmbiente.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaEditarVariaveisAmbiente.getjButtonCancelar()) {
            telaEditarVariaveisAmbiente.dispose();
        }
    }
    
}
