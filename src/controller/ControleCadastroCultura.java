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
     * @param rNCultura
     * @param conexao
     */
    private DialogTelaCadastroCultura telaCadastroCultura;
    private TelaPrincipal telaPrincipal;
    /**
     * Método construtor.
     * Recebe um objeto da classe TelaPrincipal.
     * 
     * Deve ser utilizado para instanciar um objeto da classe JDialog e monitorar os botões da mesma (DialogTelaCadastroCultura).
     * 
     * Cria um objeto representando a regra de negócio da classe cultura (RNCadastroCultura), enviando a própria tela e a conexão ao banco de dados. 
     * @param telaPrincipal É a tela principal já criada.
<<<<<<< Updated upstream
=======
     * @param conexao Conexão atual com o sservidor.
>>>>>>> Stashed changes
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
     * Deve ser utilizado para monitorar o botão "Fechar", "Salvar", "Limpar", "Editar" e "Excluir", que está presente na telaCadastroCultura.
     * 
     * @param e É a variável utilizada para guardar o evento. 
     */
    
    @Override
    public void actionPerformed(ActionEvent e) {
<<<<<<< Updated upstream
        if (e.getSource() == telaCadastroCultura.getjButtonCancelar()) { // Se o botão "Cancelar" for pressionado,
            this.telaCadastroCultura.dispose(); 						 // Exclui a telaCadastroCultura.
        }
=======
        if (e.getSource() == telaCadastroCultura.getjButtonFechar()) { // Se o botão "Cancelar" for pressionado,
            this.telaCadastroCultura.dispose(); 		       // Exclui a telaCadastroCultura.
        }

        if (e.getSource() == telaCadastroCultura.getjButtonSalvar()) {
            this.salvar();
        }

        if (e.getSource() == telaCadastroCultura.getjButtonNovo()) {
            this.novo();
        }

        if (e.getSource() == telaCadastroCultura.getjButtonLimpar()) {
            this.limpar();
        }
        
        if (e.getSource() == telaCadastroCultura.getjButtonEditar()) {
            this.editar();
        }
        
        if (e.getSource() == telaCadastroCultura.getjButtonExcluir()) {
            this.excluir();
        }
    }
    /**
     * Chama o método excluir da regra de negócio.
     * Disponível apenas via botão (ActionPerformed).
     */
    private void excluir() {
        this.rNCultura.excluir();
    }
    /**
     * Chama o método limpar (campos) da regra de negócio.
     * Disponível apenas via botão (ActionPerformed).
     */
    private void limpar() {
        this.rNCultura.limpar();
    }
    /**
     * Chama o método editar da regra de negócio.
     * Disponível apenas via botão (ActionPerformed).
     */
    private void editar() {
        this.rNCultura.editar();
    }
    /**
     * Chama o método novo da regra de negócio.
     * Disponível apenas via botão (ActionPerformed).
     */
    private void novo() {
        this.rNCultura.novo();
    }
    /**
     * Chama o método salvar da regra de negócio.
     * Disponível apenas via botão (ActionPerformed).
     */
    private void salvar() {
        this.rNCultura.salvar();
>>>>>>> Stashed changes
    }
    
}
