/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import view.*;

/**
 *
 * @author banshee
 */
public class Controle implements ActionListener {
    
    private TelaPrincipal tela;
    private TelaLogin telaLogin;
    private DialogTelaCadastroCultura telaCadastroCultura;
    
    
    public Controle() {
        // Instância a tela de login
        this.telaLogin = new TelaLogin();
        this.telaLogin.setVisible(true); // Ativa a visibilidade
        this.telaLogin.getjButtonEntrar().addActionListener(this); // Escutar o botão de login
        
        
        
        this.tela = new TelaPrincipal(); // Instância a tela principal
        this.tela.setVisible(false); // Deixa invisivel
                
        

        this.tela.getjButtonEditarCultura().addActionListener(this); // Escuta o botão de editar cultura da tela principal
        this.tela.getjButtonEditarVariaveis().addActionListener(this); // Escuta o botão de editar variaveis da tela principal
        this.tela.getjMenuCadastraUsuario().addActionListener(this); // Escuta o botão de cadastrar usuarios
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.tela.getjButtonEditarCultura()) {
            telaCadastroCultura = new DialogTelaCadastroCultura(tela, true);
            telaCadastroCultura.getjButtonCancelar().addActionListener(this);
            telaCadastroCultura.setLocationRelativeTo(tela);
            telaCadastroCultura.show();
        }
        
        if (e.getSource() == this.telaLogin.getjButtonEntrar()) {
            String admin = new String();
            admin = "admin";
            
            this.telaLogin.setVisible(false);
            this.tela.setVisible(true);
            //System.out.println(this.telaLogin.getjPasswordFieldSenha().getText());
            if (!admin.equals(this.telaLogin.getjTextFieldUsuario().getText())) {
                this.escondeMenu();
            }
        }
        
        if (e.getSource() == this.tela.getjMenuCadastraUsuario()) {
            
        }
        
        if (e.getSource() == this.telaCadastroCultura.getjButtonCancelar()) {
            this.telaCadastroCultura.setVisible(false);
        }
        
        

        
    }
    
    private void escondeMenu() {
        
        this.tela.getjMenuBar().hide();
    }
   
}
