package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import view.TelaPrincipal;
import view.DialogTelaVariaveisAmbiente;

/**
 * Classe utilizada para criar a tela de controle das variáveis de ambiente.
 * Implementa a interface ActionListener para monitoramento dos objetos adicionados.
 * 
 * @author Caio Montenegro
 * @version 0.1
 * @since 0.1
 */

public class ControleVariaveisAmbiente implements ActionListener {
    /**
     * @param telaEditarVariaveisAmbiente
     * @param telaPrincipal
     */
    private DialogTelaVariaveisAmbiente telaVariaveisAmbiente;
    private TelaPrincipal telaPrincipal;
    private RNVariaveisAmbiente rNVariaveisAmbiente;
    
    private Connection conexao;
    
     /**
     * Método construtor.
     * Recebe um objeto da classe TelaPrincipal.
     * Deve ser utilizado para instanciar um objeto da classe JDialog e monitorar os botões da mesma (DialogEditarVariaveisAmbiente).
     * 
     * @param telaPrincipal É a tela principal já criada.
     */

    public ControleVariaveisAmbiente(TelaPrincipal telaPrincipal, Connection conexao) {
        this.telaPrincipal = telaPrincipal;
        this.conexao = conexao;
        this.telaVariaveisAmbiente = new DialogTelaVariaveisAmbiente(telaPrincipal, true);
        this.rNVariaveisAmbiente = new RNVariaveisAmbiente(telaVariaveisAmbiente, this.conexao);
        this.telaVariaveisAmbiente.getjButtonFechar().addActionListener(this);
        this.telaVariaveisAmbiente.setLocationRelativeTo(telaPrincipal);
        this.telaVariaveisAmbiente.setVisible(true);
    }
    
    /**
     * Método actionPerformed.
     * É onde o método da interface implementada à classe é utilizada.
     * Deve ser utilizado para monitorar o botão "Cancelar", que está presente na telaCadastroUsuario.
     * 
     * @param e É a variável utilizada para guardar o evento. 
     */    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaVariaveisAmbiente.getjButtonFechar()) {
            telaVariaveisAmbiente.dispose();
        }
    }
    
}
