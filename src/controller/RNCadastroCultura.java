/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cultura;
import view.DialogTelaCadastroCultura;
import model.CulturaDao;
import model.Usuario;
/**
 *
 * @author banshee
 */
public class RNCadastroCultura {
    private DialogTelaCadastroCultura telaCadastroCultura;
    private CulturaDao dao;
    private Connection conexao;
    
    private boolean novo = true;
    private int id = 0;
    
    
    
    public RNCadastroCultura(DialogTelaCadastroCultura telaCadastroCultura, Connection conexao) {
        this.telaCadastroCultura = telaCadastroCultura;
        this.conexao = conexao;
        this.dao = new CulturaDao(this.conexao);
        this.gerenciarCampos();
        this.listar();
    }
    
    private void listar() {
        listaDados(dao.listar());
    }
    
    public void salvar() {
        if (validaCampos()) {
            Cultura c = new Cultura();
            c.setNomeCultura(this.telaCadastroCultura.getjTextFieldNome().getText());
            c.setVariedade(this.telaCadastroCultura.getjTextFieldVariedade().getText());
            c.setCicloEmDias(Integer.parseInt(this.telaCadastroCultura.getjTextFieldCiclo().getText()));
            c.setDiasGerminacao(Integer.parseInt(this.telaCadastroCultura.getjTextFieldCamaraGerminacao().getText()));
            c.setDiasBercario(Integer.parseInt(this.telaCadastroCultura.getjTextFieldBercario().getText()));
            c.setDiasEngorda(Integer.parseInt(this.telaCadastroCultura.getjTextFieldEngorda().getText()));
            
            if (this.novo) {
                this.dao.inserir(c);
            } else {
                c.setCodCultura(this.id);
                this.dao.alterar(c);
            }
            
            this.gerenciarBotoes();
            this.gerenciarCampos();
            this.listar();
            this.limpar();
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void novo() {
        this.novo = true;
        this.gerenciarBotoes();
        this.gerenciarCampos();
        this.limpar();
    }
    
    public void excluir() {
        int item = this.telaCadastroCultura.getjTableCulturas().getSelectedRow();
        if(item>=0){
            if(JOptionPane.showConfirmDialog(this.telaCadastroCultura, "Deseja realmente excluir?", "Confirmação de exclusão", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
                Cultura cultura = new Cultura();
                cultura.setCodCultura((int)this.telaCadastroCultura.getModelo().getValueAt(item, 0));
                if(dao.excluir(cultura)){
                    this.telaCadastroCultura.getModelo().removeRow(item);                
                }
                this.limpar();
                this.listar();
            } 
        } else{
            JOptionPane.showMessageDialog(this.telaCadastroCultura, "Selecione um item");
        }
    }
    
    public void editar() {
        int item = this.telaCadastroCultura.getjTableCulturas().getSelectedRow();
        if(item>=0){
            this.id = (int)this.telaCadastroCultura.getModelo().getValueAt(item, 0);
            Cultura c = dao.pesquisar(this.id);
            this.telaCadastroCultura.getjTextFieldNome().setText(c.getNomeCultura());
            this.telaCadastroCultura.getjTextFieldVariedade().setText(c.getVariedade());
            this.telaCadastroCultura.getjTextFieldCiclo().setText(Integer.toString(c.getCicloEmDias()));
            this.telaCadastroCultura.getjTextFieldCamaraGerminacao().setText(Integer.toString(c.getDiasGerminacao()));
            this.telaCadastroCultura.getjTextFieldEngorda().setText(Integer.toString(c.getDiasEngorda()));
            this.telaCadastroCultura.getjTextFieldBercario().setText(Integer.toString(c.getDiasBercario()));
            
            this.gerenciarCampos();
            this.gerenciarBotoes();
            this.novo = false;
        } else{
            JOptionPane.showMessageDialog(this.telaCadastroCultura, "Selecione um item");
        } 
    }
    
    private void listaDados(ArrayList<Cultura> listaCulturas) {
     limpaTabela();
     for(int i=0;i<listaCulturas.size();i++){
            adicionaTabela(listaCulturas.get(i).getCodCultura(),
                           listaCulturas.get(i).getNomeCultura(),
                           listaCulturas.get(i).getVariedade(),
                           listaCulturas.get(i).getCicloEmDias(),
                           listaCulturas.get(i).getDiasGerminacao(),
                           listaCulturas.get(i).getDiasBercario(),
                           listaCulturas.get(i).getDiasEngorda());
        }      
    }
    
    private void adicionaTabela(Object... objects){
        this.telaCadastroCultura.getModelo().addRow(objects);
    }
    
    private void limpaTabela(){
        int linhas = this.telaCadastroCultura.getModelo().getRowCount();
        for(int i=0;i<linhas;i++){
            this.telaCadastroCultura.getModelo().removeRow(0);
        }
    }
    
    public void limpar() {
        this.telaCadastroCultura.limpar();
    }
    
    private boolean validaCampos() {
        return true;
    }
    
    private void gerenciarCampos() {
        this.telaCadastroCultura.gerenciarCampos();
    }
    
    private void gerenciarBotoes() {
        this.telaCadastroCultura.gerenciarBotoes();
    }
}
