 package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    /**
     * Método construtor.
     * Este método cria uma instancia da TelaPrincipal() e armazena na variável local.
     * 
     * @version 0.1
     * @since 0.1
     */

    public ControlePrincipal() {
        telaPrincipal = new TelaPrincipal();
        telaPrincipal.setVisible(true);
        
        telaPrincipal.getjButtonCadastrarCultura().addActionListener(this); // Escuta o botão de editar cultura da tela principal
        telaPrincipal.getjButtonEditarVariaveis().addActionListener(this); // Escuta o botão de editar variaveis da tela principal
        telaPrincipal.getjMenuCadastraUsuario().addActionListener(this); // Escuta o botão de cadastrar usuarios
        telaPrincipal.getjMenuEditaExcluiUsuario().addActionListener(this); // Escuta o botão de editar/excluir usuarios
        telaPrincipal.getjButtonSair().addActionListener(this);
        
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
        // Cadastrar
        if (e.getSource() == telaPrincipal.getjButtonCadastrarCultura()) {
            ControleCadastroCultura ccc = new ControleCadastroCultura(telaPrincipal);
        }
        //Excluir
        if (e.getSource() == telaPrincipal.getjButtonExlcuirCultura()) {
            
        }
        //Cadastrar
        if (e.getSource() == telaPrincipal.getjMenuCadastraUsuario()) {
            ControleCadastroUsuario ccu = new ControleCadastroUsuario(telaPrincipal);
        }
        //Editar
        if (e.getSource() == telaPrincipal.getjMenuEditaExcluiUsuario()) {
            ControleEditarExcluirUsuario cdeu = new ControleEditarExcluirUsuario(telaPrincipal);
        }
        // Editar ou excluir usuário
        if (e.getSource() == telaPrincipal.getjButtonEditarVariaveis()) {
            ControleVariaveisAmbiente cva = new ControleVariaveisAmbiente(telaPrincipal);
        }
        //Sair
        if (e.getSource() == telaPrincipal.getjButtonSair()) {
            System.exit(0);
        }
        
    }
    
}
