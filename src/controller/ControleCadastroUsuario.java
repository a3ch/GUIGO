package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaPrincipal;
import view.DialogTelaCadastroUsuario;

/**
 * Classe utilizada para criar a tela de cadastro de usuário.
 * Implementa a interface ActionListener para monitoramento dos objetos adicionados.
 * 
 * @author Caio Montenegro
 * @version 0.1
 * @since 0.1
 */

public class ControleCadastroUsuario implements ActionListener {
    /**
     * @param telaCadastroUsuario
     * @param telaPrincipal
     */
    private DialogTelaCadastroUsuario telaCadastroUsuario;
    private TelaPrincipal telaPrincipal;
     /**
     * Método construtor.
     * Recebe um objeto da classe TelaPrincipal.
     * Deve ser utilizado para instanciar um objeto da classe JDialog e monitorar os botões da mesma (DialogTelaCadastroUsuario).
     * 
     * @param telaPrincipal É a tela principal já criada.
     */

    public ControleCadastroUsuario(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal; // Faz associação da TelaPrincipal recebida para o objeto que criado nessa classe.
        this.telaCadastroUsuario = new DialogTelaCadastroUsuario(telaPrincipal, true); // Instancia a nova tela relativa a TelaPrincipal.
        this.telaCadastroUsuario.getjButtonCancelar().addActionListener(this); // Adiciona o botão "Cancelar" da nova tela ao ActionListener. 
        this.telaCadastroUsuario.setLocationRelativeTo(telaPrincipal); // Define a localização da tela relativa à mãe (TelaPrincipal).
        this.telaCadastroUsuario.setVisible(true); // Faz a telaCadastroCultura ficar visível ao usuário.
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
        if (e.getSource() == telaCadastroUsuario.getjButtonCancelar()) { // Se o botão "Cancelar" for pressionado,
            telaCadastroUsuario.dispose(); // Exclui a telaCadastroCultura.
        }
    }
    
}
