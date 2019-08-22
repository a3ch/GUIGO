package controller;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;
import view.DialogTelaCadastroUsuario;
import model.UsuarioDao;

/**
 * Classe utilizada para descrever a regra de negócio do cadastro de usuários, aplicando restrições.
 * 
 * @author Caio Montenegro
 * @version 0.1
 * @since 0.1
 */
public class RNCadastroUsuario {
    /**
     * @param telaCadastroUsuario
     * @param dao
     * @param conexao
     * 
     * @param novo
     * @param id
     */
    private DialogTelaCadastroUsuario telaCadastroUsuario;
    private UsuarioDao dao;
    private Connection conexao;
    
    private boolean novo = true;
    private int id = 0;
    
    /**
     * Método Construtor.
     * Gerencia os campos da tela e lista os registros do banco de dados.
     * 
     * @param telaCadastroUsuario Tela que será aplicada as regras de negócio.
     * @param conexao Conexão atual com o servidor.
     */
    public RNCadastroUsuario(DialogTelaCadastroUsuario telaCadastroUsuario, Connection conexao) {
        this.telaCadastroUsuario = telaCadastroUsuario;
        this.conexao = conexao;
        this.dao = new UsuarioDao(conexao);
        this.listar();
        this.gerenciarCampos();
        
    }
    
    /**
     * Regra para listagem das usuários cadastrados.
     * Serve para mostrar os registros dos usuários na tela, assim que a mesma é aberta.
     * Chama o método "listaDados", enviando um objeto de ArrayList do "UsuarioDao", com todos os registros.
     */
    
    private void listar() {
        listaDados(dao.listar());
    }
    /**
     * Regra para salvaguardar um novo usuário.
     * Verifica se todos os campos foram preenchidos antes de salvar.
     */
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
    
    /**
     * Regra de preparação para adicionar novo registro.
     * Conversa com o objeto de Tela, disponibiliza botões e campos e limpa os mesmos para inserção se novos dados.
     */    
    public void novo() {
        this.novo = true;
        this.gerenciarBotoes();
        this.gerenciarCampos();
        this.limpar();
    }
    
    /**
     * Regra para exclusão de um registro selecionado.
     * Verifica se há algum item selecionado, caso exista, exclui após a confirmação.
     */
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
    
    /**
     * Regra para edição de um registro selecionado.
     * Verifica se há algum item selecionado, caso exista, disponibiliza a edição.
     * Verifica se existe algum registro igual no banco de dados antes de confirmar a edição, caso exista, não insere.
     */
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
    
    /**
     * Método responsável por listar, na tela, os usuários já registradas no banco de dados.
     * @param listaPessoas O array de registros puxado do banco de dados.
     */
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
    /**
     * Adiciona um registro na tabela da tela de cadastro de cultura instanciada.
     * @param objects Tipo genérico para inserção na tela.
     */
    private void adicionaTabela(Object... objects){
        this.telaCadastroUsuario.getModelo().addRow(objects);
    }
    /**
     * Limpa a tabela da tela de cadastro de cultura instanciada.
     */
    private void limpaTabela(){
        int linhas = this.telaCadastroUsuario.getModelo().getRowCount();
        for(int i=0;i<linhas;i++){
            this.telaCadastroUsuario.getModelo().removeRow(0);
        }
    }
    /**
     * Limpa os campos da tela de cadastro de cultura instanciada.
     */
    public void limpar() {
        this.telaCadastroUsuario.limpar();
    }
    
    /**
     * Método que verifica se os campos inseridos estão vazios.
     * Retorna um sinal booleano para permitir ou negar acesso ao BD.
     * @return Verdadeiro caso haja algum caractere digitado, falso caso os campos estiverem vazios. 
     */
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
    /**
     * Deixa um campo disponível para uso.
     */
    private void gerenciarCampos() {
        this.telaCadastroUsuario.gerenciarCampos();
    }
    /**
     * Deixa um botão disponível para uso.
     */
    private void gerenciarBotoes() {
        this.telaCadastroUsuario.gerenciarBotoes();
    }
}
