package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import view.TelaLogin;

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
<<<<<<< Updated upstream
=======
     * @param telaDescanso
     * @param conexao
>>>>>>> Stashed changes
     */
    private RNLogin rNLogin;
    private TelaLogin telaLogin;

    /**
    * Método construtor.
    * Não recebe nenhum parâmetro, visto que é a primeira tela a ser executada.
    * Deve ser utilizado para instanciar um objeto da classe JFrame e monitorar os botões da mesma (telaLogin).
    */
    
    public ControleLogin() {
        this.telaLogin = new TelaLogin(); // Instancia a tela de Login e salva na variável "telaLogin".
        this.telaLogin.getjButtonEntrar().addActionListener(this); // Adiciona o botão "Cancelar" da tela de Login ao ActionListener.
        this.rNLogin = new RNLogin(telaLogin); // Passa a telaLogin para sua respectiva regra de negócio.
        this.telaLogin.setVisible(true); // Faz a telaLogin ficar visível ao usuário.
        this.telaLogin.getjPasswordFieldSenha().addKeyListener(new java.awt.event.KeyAdapter() { // Monitoramento do campo de senha com um objeto KeyAdapter.
            
            /**
             * Método keyPressed.
             * Deve ser utilizado para monitorar a tecla ENTER.
             * @param evt É a variável utilizada para guardar o evento.
             */
            
            public void keyPressed(java.awt.event.KeyEvent evt) { 
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    acesso();
                }
            }
        });
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
        if (e.getSource() == telaLogin.getjButtonEntrar()) {
            acesso();
        }
    }
    
    /**
     * Método acesso.
     * Ele é utilizado somente quando acontecem os eventos específico, neste caso o clique no botão "Entrar" ou na tecla ENTER. 
     */
    
    private void acesso() { 
        this.rNLogin.acesso(); 
        // Verifica se os dados inseridos pelo usuário estão corretos, de acordo com a regra de negócio.
        // Assim permitindo o seu login ao sistema.
    }                          
    
}
