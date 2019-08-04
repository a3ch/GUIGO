package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaPrincipal;
import view.DialogEditarVariaveisAmbiente;

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
    private DialogEditarVariaveisAmbiente telaEditarVariaveisAmbiente;
    private TelaPrincipal telaPrincipal;
    
     /**
     * Método construtor.
     * Recebe um objeto da classe TelaPrincipal.
     * Deve ser utilizado para instanciar um objeto da classe JDialog e monitorar os botões da mesma (DialogEditarVariaveisAmbiente).
     * 
     * @param telaPrincipal É a tela principal já criada.
     */

    public ControleVariaveisAmbiente(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.telaEditarVariaveisAmbiente = new DialogEditarVariaveisAmbiente(telaPrincipal, true);
        this.telaEditarVariaveisAmbiente.getjButtonCancelar().addActionListener(this);
        this.telaEditarVariaveisAmbiente.setLocationRelativeTo(telaPrincipal);
        this.telaEditarVariaveisAmbiente.setVisible(true);
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
        if (e.getSource() == telaEditarVariaveisAmbiente.getjButtonCancelar()) {
            telaEditarVariaveisAmbiente.dispose();
        }
    }
    
}
