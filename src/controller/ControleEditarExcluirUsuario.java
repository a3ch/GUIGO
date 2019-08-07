package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaPrincipal;
import view.DialogTelaEditarExcluirUsuario;

/**
 * Classe utilizada para criar a tela de edição e exclusão de usuário.
 * Implementa a interface ActionListener para monitoramento dos objetos adicionados.
 *
 * @author Caio Montenegro
 * @version 0.1
 * @since 0.1
 */

public class ControleEditarExcluirUsuario implements ActionListener{
    /**
     * @param telaEditarExcluirUsuario
     * @param telaPrincipal
     */
    private DialogTelaEditarExcluirUsuario telaEditarExcluirUsuario;
    private TelaPrincipal telaPrincipal;
    /**
     * Método construtor.
     * Recebe um objeto da classe TelaPrincipal.
     * Deve ser utilizado para instanciar um objeto da classe JDialog e monitorar os botões da mesma (DialogTelaEditarExcluirUsuário).
     * 
     * @param telaPrincipal É a tela principal já criada.
     */
    public ControleEditarExcluirUsuario(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal; // Faz associação da TelaPrincipal recebida para o objeto que criado nessa classe.
        this.telaEditarExcluirUsuario = new DialogTelaEditarExcluirUsuario(telaPrincipal, true);
        this.telaEditarExcluirUsuario.getjButtonCancelar().addActionListener(this);
        this.telaEditarExcluirUsuario.setLocationRelativeTo(telaPrincipal);
        this.telaEditarExcluirUsuario.setVisible(true);
    }
    
    /**
    * Método actionPerformed.
    * É onde o método da interface implementada à classe é utilizada.
    * Deve ser utilizado para monitorar o botão "Cancelar", que está presente na telaEditarExcluirUsuario.
    * 
    * @param e É a variável utilizada para guardar o evento. 
    */   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaEditarExcluirUsuario.getjButtonCancelar()) {
            telaEditarExcluirUsuario.dispose();
        }
    }
    
}
