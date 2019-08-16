/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.DialogTelaCadastroUsuario;
/**
 *
 * @author banshee
 */
public class RNCadastroUsuario {
    private DialogTelaCadastroUsuario telaCadastroUsuario;
    
    private boolean novo = true;
    private int id = 0;
    
    /**
     *
     * @param telaCadastroUsuario
     */
    public RNCadastroUsuario(DialogTelaCadastroUsuario telaCadastroUsuario) {
        this.telaCadastroUsuario = telaCadastroUsuario;
        this.gerenciarCampos();
    }
    
    public void salvar() {
        this.gerenciarBotoes();
        this.gerenciarCampos();
        this.limpar();
    }
    
    public void novo() {
        this.novo = true;
        this.gerenciarBotoes();
        this.gerenciarCampos();
        this.limpar();
    }
    
    public void limpar() {
        this.telaCadastroUsuario.limpar();
    }
    
    private void gerenciarCampos() {
        this.telaCadastroUsuario.gerenciarCampos();
    }
    
    private void gerenciarBotoes() {
        this.telaCadastroUsuario.gerenciarBotoes();
    }
}
