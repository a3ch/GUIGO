package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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
    private RNCadastroCultura rNCultura;
    private Connection conexao;
    /**
     * Método construtor.
     * Recebe um objeto da classe TelaPrincipal.
     * Deve ser utilizado para instanciar um objeto da classe JDialog e monitorar os botões da mesma (DialogTelaCadastroCultura).
     * 
     * @param telaPrincipal É a tela principal já criada.
     * @param conexao
     */
    public ControleCadastroCultura(TelaPrincipal telaPrincipal, Connection conexao) {
        this.telaPrincipal = telaPrincipal; 											// Cria associação da TelaPrincipal, para o novo objeto a ser criado. 
        this.conexao = conexao;
        this.telaCadastroCultura = new DialogTelaCadastroCultura(telaPrincipal, true);  // Instancia a nova tela relativa a TelaPrincipal. 
        this.telaCadastroCultura.setLocationRelativeTo(telaPrincipal); 					// Define a localização da tela relativa à mãe (TelaPrincipal).        

        this.telaCadastroCultura.getjButtonFechar().addActionListener(this); 			// Adiciona o botão "Fechar" da nova tela ao ActionListener.
        this.telaCadastroCultura.getjButtonLimpar().addActionListener(this); // Adiciona o botão "Limpar" da nova tela ao ActionListener.
        this.telaCadastroCultura.getjButtonNovo().addActionListener(this);   // Adiciona o botão "Novo" da nova tela ao ActionListener.
        this.telaCadastroCultura.getjButtonSalvar().addActionListener(this); // Adiciona o botão "Salvar" da nova tela ao ActionListener.
        this.telaCadastroCultura.getjButtonExcluir().addActionListener(this);// Adiciona o botão "Excluir" da nova tela ao ActionListener. 
        this.telaCadastroCultura.getjButtonEditar().addActionListener(this); // Adiciona o botão "Editar" da nova tela ao ActionListener.
        
        this.rNCultura = new RNCadastroCultura(telaCadastroCultura, this.conexao);
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
        // Fechar
        if (e.getSource() == telaCadastroCultura.getjButtonFechar()) { // Se o botão "Cancelar" for pressionado,
            this.telaCadastroCultura.dispose(); 						 // Exclui a telaCadastroCultura.
        }
        
        // Salvar
        if (e.getSource() == telaCadastroCultura.getjButtonSalvar()) {
            this.salvar();
        }
        
        // Novo
        if (e.getSource() == telaCadastroCultura.getjButtonNovo()) {
            this.novo();
        }
        
        // Limpar
        if (e.getSource() == telaCadastroCultura.getjButtonLimpar()) {
            this.limpar();
        }
        
        // Editar
        if (e.getSource() == telaCadastroCultura.getjButtonEditar()) {
            this.editar();
        }
        
        // Excluir 
        if (e.getSource() == telaCadastroCultura.getjButtonExcluir()) {
            this.excluir();
        }
    }
    
    private void excluir() {
        this.rNCultura.excluir();
    }
    
    private void limpar() {
        this.rNCultura.limpar();
    }
    
    private void editar() {
        this.rNCultura.editar();
    }
    
    private void novo() {
        this.rNCultura.novo();
    }
    
    private void salvar() {
        this.rNCultura.salvar();
    }
    
}
