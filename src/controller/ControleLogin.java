package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexao;
import view.TelaDescanso;
import view.DialogTelaLogin;

/**
 * Classe utilizada para criar a tela de login.
 * Implementa a interface ActionListener para monitoramento dos objetos adicionados.
 * 
 * @author Caio Montenegro
 * @version 0.1
 * @since 0.1
 */

public class ControleLogin implements ActionListener {
    /**
     * @param rNLogin
     * @param telaLogin
     * @param telaDescanso
     */
    private RNLogin rNLogin;
    private DialogTelaLogin telaLogin;
    private TelaDescanso telaDescanso;
    private Connection conexao;

    /**
    * Método construtor.
    * Não recebe nenhum parâmetro, visto que é a primeira tela a ser executada.
    * Deve ser utilizado para instanciar um objeto da classe JFrame e monitorar os botões da mesma (telaLogin).
    * @throws java.io.IOException
    */
    
    public ControleLogin() throws IOException {
        this.telaDescanso = new TelaDescanso();
        this.conexao = Conexao.getConexao();

        this.telaDescanso.getjMenuLogin().addActionListener(this); 
        this.telaLogin = new DialogTelaLogin(telaDescanso, true); // Instancia a tela de Login e salva na variável "telaLogin".
        this.telaLogin.setLocationRelativeTo(telaDescanso);
        this.telaLogin.getjButtonEntrar().addActionListener(this); // Adiciona o botão "Cancelar" da tela de Login ao ActionListener.
        this.rNLogin = new RNLogin(telaLogin, telaDescanso, conexao); // Passa a telaLogin para sua respectiva regra de negócio.

        this.telaLogin.getjPasswordFieldSenha().addKeyListener(new java.awt.event.KeyAdapter() { // Monitoramento do campo de senha com um objeto KeyAdapter.
            
            /**
             * Método keyPressed.
             * Deve ser utilizado para monitorar a tecla ENTER.
             * @param evt É a variável utilizada para guardar o evento.
             */
            
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) { 
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        acesso();
                    } catch (IOException ex) {
                        Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        this.telaDescanso.setVisible(true);
       
        this.telaLogin.setVisible(true); // Faz a telaLogin ficar visível ao usuário.
     
                
        
    }
     
    /**
    * Método actionPerformed.
    * É onde o método da interface implementada à classe é utilizada.
    * Deve ser utilizado para monitorar o botão "Entrar", que está presente na telaLogin.
    * 
    * @param e É a variável utilizada para guardar o evento. 
    */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == telaDescanso.getjMenuLogin()) {
            this.telaLogin.setVisible(true);
        }
        
        if (e.getSource() == telaLogin.getjButtonEntrar()) {
            try {
                acesso();
            } catch (IOException ex) {
                Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Método acesso.
     * Ele é utilizado somente quando acontecem os eventos específico, neste caso o clique no botão "Entrar" ou na tecla ENTER. 
     */
    
    private void acesso() throws IOException { 
        this.rNLogin.acesso(); 
        // Verifica se os dados inseridos pelo usuário estão corretos, de acordo com a regra de negócio.
        // Assim permitindo o seu login ao sistema.
    }                          
    
}
