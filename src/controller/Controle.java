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
    private TelaEditarCultura editarCultura;
    private TelaLogin telaLogin;
    private TelaEditarVariaveisDeAmbiente telaEditarVariaveis;
    private TelaCadastro telaCadastro;
    
    
    public Controle() {
        // Instância a tela de login
        this.telaLogin = new TelaLogin();
        this.telaLogin.setVisible(true); // Ativa a visibilidade
        
        
        this.telaLogin.getjButtonEntrar().addActionListener(this); // Escutar o botão de login
        
        this.tela = new TelaPrincipal(); // Instância a tela principal
        this.tela.setVisible(false); // Deixa invisivel
        
        this.telaEditarVariaveis = new TelaEditarVariaveisDeAmbiente(); // Instância a tela editar variaveis de ambiente
        
        this.editarCultura = new TelaEditarCultura(); // Instância a tela de editar cultura
        

        this.tela.getjButtonEditarCultura().addActionListener(this); // Escuta o botão de editar cultura da tela principal
        this.tela.getjButtonEditarVariaveis().addActionListener(this); // Escuta o botão de editar variaveis da tela principal
        this.tela.getjMenuCadastraUsuario().addActionListener(this); // Escuta o botão de cadastrar usuarios
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.tela.getjButtonEditarCultura()) {
            popUpEditarCultura();
            this.tela.disable();
        }
        
        if (e.getSource() == this.editarCultura.getjButtonCancelar()) {
            this.editarCultura.dispose();
            this.tela.enable();
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
            this.telaCadastro = new TelaCadastro();
            this.telaCadastro.setVisible(true);
            this.telaCadastro.setLocationRelativeTo(tela);
            this.telaCadastro.setResizable(false);
        }
        
        
        if (e.getSource() == this.tela.getjButtonEditarVariaveis()) {
            this.popUpEditarVariaveis();
            this.tela.disable();
        }
        
        if (e.getSource() == this.telaEditarVariaveis.getjButtonCancelar()) {
            this.telaEditarVariaveis.dispose();
            this.tela.enable();
        }
        
    }
    
    private void escondeMenu() {
        
        this.tela.getjMenuBar().hide();
    }
   
     
    private void popUpEditarVariaveis() {
        
        this.telaEditarVariaveis.getjButtonCancelar().addActionListener(this);
        
        this.telaEditarVariaveis.setLocationRelativeTo(tela);
        this.telaEditarVariaveis.setVisible(true);
        this.telaEditarVariaveis.setResizable(false);
    }
    
    private void popUpEditarCultura() {
        
        this.editarCultura.getjButtonCancelar().addActionListener(this);
        
        this.editarCultura.setLocationRelativeTo(tela);
        this.editarCultura.setVisible(true);
        this.editarCultura.setResizable(false);
    }
    
    
}
