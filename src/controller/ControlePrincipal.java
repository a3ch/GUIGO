package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.TelaPrincipal;

/**
 * Classe utilizada para criar a tela principal.
 * Implementa a interface ActionListener para monitoramento dos objetos adicionados.
 * 
 * @author Caio Montenegro
 * @version 0.1
 * @since 0.1
 */

public class ControlePrincipal implements ActionListener {
    /**
     * @param telaPrincipal
     */
    private TelaPrincipal telaPrincipal;
    private String tipo;
    
    /**
     * Método construtor.
     * Este método cria uma instancia da TelaPrincipal() e armazena na variável local.
     * 
     * @version 0.1
     * @param tipo
     * @throws java.io.IOException
     * @since 0.1
     */

    public ControlePrincipal(String tipo) throws IOException {
        telaPrincipal = new TelaPrincipal();
        
        this.tipo = tipo;
        this.verificarTipo();
        
        // Teste da implementação de Threads
        new Thread(t1).start();
        
        /*
        telaPrincipal.getjButtonCadastrarCultura().addActionListener(this); // Escuta o botão de editar cultura da tela principal
        telaPrincipal.getjButtonEditarVariaveis().addActionListener(this); // Escuta o botão de editar variaveis da tela principal
        telaPrincipal.getjMenuCadastraUsuario().addActionListener(this); // Escuta o botão de cadastrar usuarios
        telaPrincipal.getjMenuEditaExcluiUsuario().addActionListener(this); // Escuta o botão de editar/excluir usuarios
        telaPrincipal.getjButtonSair().addActionListener(this);
        */
        telaPrincipal.getjMenuCultura().addActionListener(this); // Ecustar o botão de cadastros de culturas
        telaPrincipal.getjMenuUsuarios().addActionListener(this); // Escuta o botão de cadastros de usuario
        telaPrincipal.getjMenuSair().addActionListener(this); // Escuta o botão de sair
    
        telaPrincipal.setVisible(true);

    }
    
    /**
    * Método actionPerformed.
    * É onde o método da interface implementada à classe é utilizada.
    * Deve ser utilizado para monitorar os botões "Cadastrar", "Excluir", "Editar", "Sair", "Editar ou excluir usuário" que está presente na telaPrincipal.
    * 
    * @param e É a variável utilizada para guardar o evento. 
    */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Cadastro cultura
        if (e.getSource() == telaPrincipal.getjMenuCultura()) {
            new ControleCadastroCultura(telaPrincipal);
        }
        // Cadastro usuario
        if (e.getSource() == telaPrincipal.getjMenuUsuarios()) {
            new ControleCadastroUsuario(telaPrincipal);
        }
        /*
        //Excluir
        if (e.getSource() == telaPrincipal.getjButtonExlcuirCultura()) {
            
        }
        
        //Editar
        if (e.getSource() == telaPrincipal.getjMenuEditaExcluiUsuario()) {
            ControleEditarExcluirUsuario cdeu = new ControleEditarExcluirUsuario(telaPrincipal);
        }
        // Editar ou excluir usuário
        if (e.getSource() == telaPrincipal.getjButtonEditarVariaveis()) {
            ControleVariaveisAmbiente cva = new ControleVariaveisAmbiente(telaPrincipal);
        }
        */
        //Sair
        if (e.getSource() == telaPrincipal.getjMenuSair()) {
            System.exit(0);
        }
        
    }
    
    private void verificarTipo() {
        if (tipo.equals("tec")) {
            this.telaPrincipal.getjMenu1().setText("Tecnico");
            this.telaPrincipal.getjMenuUsuarios().hide();
        }
        
        if (tipo.equals("op")) {
            this.telaPrincipal.getjMenu1().hide();
        }
    }
    
    // Teste da implementação de Threads
    private Runnable t1 = new Runnable() {
        @Override
        public void run() {
            try {
                for(int i = 0; i < 100; i++) {
                    telaPrincipal.getjLabelTest().setText(Integer.toString(i));
                    Thread.sleep(1000);
                }
            } catch (Exception e) {}
        }
    };
    
}
