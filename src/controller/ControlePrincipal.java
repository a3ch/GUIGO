/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaPrincipal;

/**
 *
 * @author banshee
 */
public class ControlePrincipal implements ActionListener {
    private TelaPrincipal telaPrincipal;

    public ControlePrincipal() {
        telaPrincipal = new TelaPrincipal();
        telaPrincipal.setVisible(true);
        
        telaPrincipal.getjButtonCadastrarCultura().addActionListener(this); // Escuta o botão de editar cultura da tela principal
        telaPrincipal.getjButtonEditarVariaveis().addActionListener(this); // Escuta o botão de editar variaveis da tela principal
        telaPrincipal.getjMenuCadastraUsuario().addActionListener(this); // Escuta o botão de cadastrar usuarios
        telaPrincipal.getjMenuEditaExcluiUsuario().addActionListener(this); // Escuta o botão de editar/excluir usuarios
        telaPrincipal.getjButtonSair().addActionListener(this);
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getjButtonCadastrarCultura()) {
            ControleCadastroCultura ccc = new ControleCadastroCultura(telaPrincipal);
        }
        
        if (e.getSource() == telaPrincipal.getjButtonExlcuirCultura()) {
            
        }
        
        if (e.getSource() == telaPrincipal.getjMenuCadastraUsuario()) {
            ControleCadastroUsuario ccu = new ControleCadastroUsuario(telaPrincipal);
        }
        
        if (e.getSource() == telaPrincipal.getjMenuEditaExcluiUsuario()) {
            ControleEditarExcluirUsuario cdeu = new ControleEditarExcluirUsuario(telaPrincipal);
        }
        
        if (e.getSource() == telaPrincipal.getjButtonEditarVariaveis()) {
            ControleVariaveisAmbiente cva = new ControleVariaveisAmbiente(telaPrincipal);
        }
        
        if (e.getSource() == telaPrincipal.getjButtonSair()) {
            System.exit(0);
        }
        
    }
    
}
