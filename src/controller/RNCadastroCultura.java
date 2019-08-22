package controller;

<<<<<<< Updated upstream
=======
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cultura;
import view.DialogTelaCadastroCultura;
import model.CulturaDao;
import model.Usuario;

>>>>>>> Stashed changes
/**
 * Classe utilizada para descrever a regra de negócio do cadastro de culturas, aplicando restrições.
 * 
 * @author Caio Montenegro
 * @version 0.1
 * @since 0.1
 */
public class RNCadastroCultura {
<<<<<<< Updated upstream
    
=======
    /**
     * @param telaCadastroCultura
     * @param dao
     * @param conexao
     * 
     * @param novo
     * @param id
     */
    private DialogTelaCadastroCultura telaCadastroCultura;
    private CulturaDao dao;
    private Connection conexao;
    
    private boolean novo = true;
    private int id = 0;
    
    /**
     * Método Construtor.
     * Gerencia os campos da tela e lista os registros do banco de dados.
     * 
     * @param telaCadastroCultura Tela que será aplicada as regras de negócio.
     * @param conexao Conexão atual com o servidor.
     */
    
    public RNCadastroCultura(DialogTelaCadastroCultura telaCadastroCultura, Connection conexao) {
        this.telaCadastroCultura = telaCadastroCultura;
        this.conexao = conexao;
        this.dao = new CulturaDao(this.conexao);
        this.gerenciarCampos();
        this.listar();
    }
    
    /**
     * Regra para listagem das culturas cadastradas.
     * Serve para mostrar os registros das culturas cadastradas na tela, assim que a mesma é aberta.
     * Chama o método "listaDados", enviando um objeto de ArrayList do "CulturaDao", com todos os registros.
     */
    
    private void listar() {
        listaDados(dao.listar());
    }
    
    /**
     * Regra para salvaguardar uma nova cultura.
     * Verifica se todos os campos foram preenchidos antes de salvar.
     */
    
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
    /**
     * Regra para edição de um registro selecionado.
     * Verifica se há algum item selecionado, caso exista, disponibiliza a edição.
     * Verifica se existe algum registro igual no banco de dados antes de confirmar a edição, caso exista, não insere.
     */
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
    
    /**
     * Método responsável por listar, na tela, as culturas já registradas no banco de dados.
     * @param listaCulturas O array de registros puxado do banco de dados.
     */
    
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
    /**
     * Adiciona um registro na tabela da tela de cadastro de cultura instanciada.
     * @param objects Tipo genérico para inserção na tela.
     */
    private void adicionaTabela(Object... objects){
        this.telaCadastroCultura.getModelo().addRow(objects);
    }
    
    /**
     * Limpa a tabela da tela de cadastro de cultura instanciada.
     */
    private void limpaTabela(){
        int linhas = this.telaCadastroCultura.getModelo().getRowCount();
        for(int i=0;i<linhas;i++){
            this.telaCadastroCultura.getModelo().removeRow(0);
        }
    }
    /**
     * Limpa os campos da tela de cadastro de cultura instanciada.
     */
    public void limpar() {
        this.telaCadastroCultura.limpar();
    }
    /**
     * Confirma se os campos atendem à regra de negócio.
     * @return Verdadeiro, pois essa é a única função do método.
     */
    private boolean validaCampos() {
        return true;
    }
    /**
     * Deixa um campo disponível para uso.
     */
    private void gerenciarCampos() {
        this.telaCadastroCultura.gerenciarCampos();
    }
    /**
     * Deixa um botão disponível para uso.
     */
    private void gerenciarBotoes() {
        this.telaCadastroCultura.gerenciarBotoes();
    }
>>>>>>> Stashed changes
}
