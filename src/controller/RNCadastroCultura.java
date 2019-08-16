/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import view.DialogTelaCadastroCultura;
/**
 *
 * @author banshee
 */
public class RNCadastroCultura {
    private DialogTelaCadastroCultura telaCadastroCultura;
    
    private boolean novo = true;
    private int id = 0;
    
    public RNCadastroCultura(DialogTelaCadastroCultura telaCadastroCultura) {
        this.telaCadastroCultura = telaCadastroCultura;
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
        this.telaCadastroCultura.limpar();
    }
    
    private void gerenciarCampos() {
        this.telaCadastroCultura.gerenciarCampos();
    }
    
    private void gerenciarBotoes() {
        this.telaCadastroCultura.gerenciarBotoes();
    }
}
