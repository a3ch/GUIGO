package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaPrincipal;
import view.DialogTelaCadastroCultura;

/**
 * Classe utilizada para criar a tela de cadastro de cultura.
 * Implementa a interface ActionListener para monitoramento dos objetos adicionados.
 * 
 * @author Caio Montenegro
 * @version 0.1
 * @since 0.1
 */

public class ControleCadastroCultura implements ActionListener{
    /**
     * @param telaCadastroCultura
     * @param telaPrincipal
     */
    private DialogTelaCadastroCultura telaCadastroCultura;
    private TelaPrincipal telaPrincipal;
    /**
     * Método construtor.
     * Recebe um objeto da classe TelaPrincipal.
     * Deve ser utilizado para instanciar um objeto da classe JDialog e monitorar os botões da mesma (DialogTelaCadastroCultura).
     * 
     * @param telaPrincipal É a tela principal já criada.
     */
    public ControleCadastroCultura(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal; 											// Cria associação da TelaPrincipal, para o novo objeto a ser criado. 
        this.telaCadastroCultura = new DialogTelaCadastroCultura(telaPrincipal, true);  // Instancia a nova tela relativa a TelaPrincipal. 
        this.telaCadastroCultura.getjButtonCancelar().addActionListener(this); 			// Adiciona o botão "Cancelar" da nova tela ao ActionListener.
        this.telaCadastroCultura.setLocationRelativeTo(telaPrincipal); 					// Define a localização da tela relativa à mãe (TelaPrincipal).
        this.telaCadastroCultura.setVisible(true); 										// Faz a telaCadastroCultura ficar visível ao usuário.
    }
    
    /**
     * Método actionPerformed.
     * É onde o método da interface implementada à classe é utilizada.
     * Deve ser utilizado para monitorar o botão "Cancelar", que está presente na telaCadastroCultura.
     * 
     * @param e É a variável utilizada para guardar o evento. 
     */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadastroCultura.getjButtonCancelar()) { // Se o botão "Cancelar" for pressionado,
            this.telaCadastroCultura.dispose(); 						 // Exclui a telaCadastroCultura.
        }
    }
    
}
