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
    private RNCadastroUsuario rRUsuario;
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
        this.telaCadastroUsuario.setLocationRelativeTo(telaPrincipal); // Define a localização da tela relativa à mãe (TelaPrincipal).
        this.telaCadastroUsuario.getjButtonFechar().addActionListener(this); // Adiciona o botão "Fechar" da nova tela ao ActionListener. 
        this.telaCadastroUsuario.getjButtonNovo().addActionListener(this);
        this.telaCadastroUsuario.getjButtonSalvar().addActionListener(this);
        this.telaCadastroUsuario.getjButtonLimpar().addActionListener(this);
        this.telaCadastroUsuario.getjButtonEditar().addActionListener(this);
        this.telaCadastroUsuario.getjButtonExcluir().addActionListener(this);
        
        this.rRUsuario = new RNCadastroUsuario(telaCadastroUsuario);
        
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
        // Fechar
        if (e.getSource() == telaCadastroUsuario.getjButtonFechar()) { // Se o botão "Fechar" for pressionado,
            telaCadastroUsuario.dispose(); // Exclui a telaCadastroCultura.
        }
        
        // Novo
        if (e.getSource() == telaCadastroUsuario.getjButtonNovo()) {
            this.novo();
        }
        
        // Limpar
        if (e.getSource() == telaCadastroUsuario.getjButtonLimpar()) {
            this.limpar();
        }
        
        // Salvar
        if(e.getSource() == telaCadastroUsuario.getjButtonSalvar()) {
            this.salvar();
        }
        
    }
    
    
    private void salvar() {
        this.rRUsuario.salvar();
    }
    
    private void limpar() {
        this.rRUsuario.limpar();
    }
    
    private void novo() {
        this.rRUsuario.novo();
    }
}
