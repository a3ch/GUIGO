/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;
import view.DialogTelaCadastroUsuario;
import model.UsuarioDao;
/**
 *
 * @author banshee
 */
public class RNCadastroUsuario {
    private DialogTelaCadastroUsuario telaCadastroUsuario;
    private UsuarioDao dao;
    private Connection conexao;
    
    private boolean novo = true;
    private int id = 0;
    
    /**
     *
     * @param telaCadastroUsuario
     */
    public RNCadastroUsuario(DialogTelaCadastroUsuario telaCadastroUsuario, Connection conexao) {
        this.telaCadastroUsuario = telaCadastroUsuario;
        this.conexao = conexao;
        this.dao = new UsuarioDao(conexao);
        this.listar();
        this.gerenciarCampos();
        
    }
    
    private void listar() {
        listaDados(dao.listar());
    }
    
    public void salvar() {
        
        if (validaCampos()) {
            Usuario u = new Usuario();
            u.setEmail(this.telaCadastroUsuario.getjTextFieldEmail().getText());
            u.setNome(this.telaCadastroUsuario.getjTextFieldNome().getText());
            u.setFone(this.telaCadastroUsuario.getjFormattedTextFieldFone().getText());
            u.setLogin(this.telaCadastroUsuario.getjTextFieldLogin().getText());
            u.setTipo(this.telaCadastroUsuario.getjComboBoxTipo().getSelectedIndex() + 1);
            u.setSenha(this.telaCadastroUsuario.getjPasswordFieldSenha().getText());
            
            if (this.novo) {
                this.dao.inserir(u);
            } else {
                u.setId(this.id);
                this.dao.alterar(u);
            }
            
            this.gerenciarBotoes();
            this.gerenciarCampos();
            this.listar();
            this.limpar();
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!","Erro",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public boolean validaCampos() {
        if (this.telaCadastroUsuario.getjTextFieldNome().getText().equals("")) {
            return false;
        } else if (this.telaCadastroUsuario.getjTextFieldEmail().getText().equals("")) {
            return false;
        } else if (this.telaCadastroUsuario.getjTextFieldLogin().getText().equals("")) {
            return false;
        } else if (this.telaCadastroUsuario.getjPasswordFieldSenha().getText().equals("")) {
            return false;
        } else if (this.telaCadastroUsuario.getjFormattedTextFieldFone().getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }
    
    public void excluir() {
        int item = this.telaCadastroUsuario.getjTableUsuario().getSelectedRow();
        if(item>=0){
            if(JOptionPane.showConfirmDialog(this.telaCadastroUsuario, "Deseja realmente excluir?", "Confirmação de exclusão", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
                Usuario usuario = new Usuario();
                usuario.setId((int)this.telaCadastroUsuario.getModelo().getValueAt(item, 0));
                if(dao.excluir(usuario)){
                    this.telaCadastroUsuario.getModelo().removeRow(item);                
                }
                this.limpar();
                this.listar();
            } 
        } else{
            JOptionPane.showMessageDialog(this.telaCadastroUsuario, "Selecione um item");
        }
    }
    
    public void editar() {
        int item = this.telaCadastroUsuario.getjTableUsuario().getSelectedRow();
        if(item>=0){
            this.id = (int)this.telaCadastroUsuario.getModelo().getValueAt(item, 0);
            Usuario p = dao.pesquisar(this.id);
            this.telaCadastroUsuario.getjTextFieldNome().setText(p.getNome());
            this.telaCadastroUsuario.getjTextFieldEmail().setText(p.getEmail());
            this.telaCadastroUsuario.getjTextFieldLogin().setText(p.getLogin());
            this.telaCadastroUsuario.getjPasswordFieldSenha().setText(p.getSenha());
            this.telaCadastroUsuario.getjFormattedTextFieldFone().setText(p.getFone());
            this.telaCadastroUsuario.getjComboBoxTipo().setSelectedIndex(p.getTipo() - 1);
            this.gerenciarCampos();
            this.gerenciarBotoes();
            this.novo = false;
        } else{
            JOptionPane.showMessageDialog(this.telaCadastroUsuario, "Selecione um item");
        } 
    }
    
    public void novo() {
        this.novo = true;
        this.gerenciarBotoes();
        this.gerenciarCampos();
        this.limpar();
    }
    
    private void listaDados(ArrayList<Usuario> listaPessoas) {
     limpaTabela();
     for(int i=0;i<listaPessoas.size();i++){
            adicionaTabela(listaPessoas.get(i).getId(),
                           listaPessoas.get(i).getNome(),
                           listaPessoas.get(i).getLogin(),
                           listaPessoas.get(i).getEmail(),
                           listaPessoas.get(i).getSenha(),
                           listaPessoas.get(i).getFone(),
                           listaPessoas.get(i).getTipo());
        }      
    }
    
    private void adicionaTabela(Object... objects){
        this.telaCadastroUsuario.getModelo().addRow(objects);
    }
    
    private void limpaTabela(){
        int linhas = this.telaCadastroUsuario.getModelo().getRowCount();
        for(int i=0;i<linhas;i++){
            this.telaCadastroUsuario.getModelo().removeRow(0);
        }
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
