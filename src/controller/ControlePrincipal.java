package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.TelaPrincipal;
import view.DialogTelaCreditos;
import model.VariaveisAmbienteDao;
import model.VariaveisAmbiente;

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
     * @param tipo
     */
    private TelaPrincipal telaPrincipal;
    private DialogTelaCreditos telaCredito;
    private Connection conexao;
    private int tipo;
    
    private VariaveisAmbienteDao dao;
    private int umidade, luminosidade, temperatura, ph, o2Dissolvido, condutividade;
    private Random random;


    
    /**
     * Método construtor.
     * Este método cria uma instancia da TelaPrincipal() e armazena na variável local.
     * 
     * @version 0.1
     * @param tipo
     * @throws java.io.IOException
     * @since 0.1
     */

    public ControlePrincipal(int tipo, Connection conexao) throws IOException {
        telaPrincipal = new TelaPrincipal();
        
        this.conexao = conexao;
        this.tipo = tipo;
        this.verificarTipo();
        
        this.random = new Random();
        this.dao = new VariaveisAmbienteDao(this.conexao);
        
        // Teste da implementação de Threads
        new Thread(t1).start();
        
        /*
        telaPrincipal.getjButtonCadastrarCultura().addActionListener(this); // Escuta o botão de editar cultura da tela principal
        telaPrincipal.getjButtonEditarVariaveis().addActionListener(this); // Escuta o botão de editar variaveis da tela principal
        telaPrincipal.getjMenuCadastraUsuario().addActionListener(this); // Escuta o botão de cadastrar usuarios
        telaPrincipal.getjMenuEditaExcluiUsuario().addActionListener(this); // Escuta o botão de editar/excluir usuarios
        telaPrincipal.getjButtonSair().addActionListener(this);
        */
        telaPrincipal.getjMenuItemVariaveisAmbiente().addActionListener(this);
        telaPrincipal.getjMenuCultura().addActionListener(this); // Ecustar o botão de cadastros de culturas
        telaPrincipal.getjMenuUsuarios().addActionListener(this); // Escuta o botão de cadastros de usuario
        telaPrincipal.getjMenuSair().addActionListener(this); // Escuta o botão de sair
        telaPrincipal.getjMenuISobre().addActionListener(this); // Escuta o botão de sobre
    
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
            new ControleCadastroCultura(telaPrincipal, this.conexao);
        }
        // Cadastro usuario
        if (e.getSource() == telaPrincipal.getjMenuUsuarios()) {
            new ControleCadastroUsuario(telaPrincipal, this.conexao);
        }
        
        // Variaveis de Ambiente
        if (e.getSource() == telaPrincipal.getjMenuItemVariaveisAmbiente()) {
            new ControleVariaveisAmbiente(telaPrincipal, this.conexao);
        }
        
        // Sobre
        if (e.getSource() == telaPrincipal.getjMenuISobre()) {
            this.telaCredito = new DialogTelaCreditos(telaPrincipal, true);
            this.telaCredito.setLocationRelativeTo(telaCredito);
            this.telaCredito.setVisible(true);
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
        switch(tipo) {
            case 2:
                this.telaPrincipal.getjMenuUsuarios().hide();
                break;
            case 1:
                this.telaPrincipal.getjMenuCadastros().hide();
                break;
        }
    }
    
    // Teste da implementação de Threads
    private Runnable t1 = new Runnable() {
        @Override
        public void run() {
            try {
                VariaveisAmbiente va = new VariaveisAmbiente();
                while(true) {
                    //gera temperatura umidade e luminosidade 
                    temperatura = random.nextInt(100);
                    umidade = random.nextInt(100);
                    luminosidade =  random.nextInt(100);
                    ph = random.nextInt(15);
                    o2Dissolvido = random.nextInt(100);
                    condutividade = random.nextInt(100);
                    telaPrincipal.getjLabelTemperatura().setText(Integer.toString(temperatura) + ".0°C");
                    telaPrincipal.getjLabelUmidade().setText(Integer.toString(umidade) + ".0%");
                    telaPrincipal.getjLabelLuminosidade().setText(Integer.toString(luminosidade) + ".0%");
                    telaPrincipal.getjLabelPh().setText(Integer.toString(ph) + ".0");
                    telaPrincipal.getjLabelOD().setText(Integer.toString(o2Dissolvido) + ".0%");
                    telaPrincipal.getjLabelCondutividadeEletrica().setText(Integer.toString(condutividade) + ".0%");
                    va.setLuminosidade(luminosidade);
                    va.setTemperatura(temperatura);
                    va.setUmidade(umidade);
                    va.setPh(ph);
                    va.setOxigenioDissolvido(o2Dissolvido);
                    va.setCondutividadeEletrica(condutividade);
                    dao.inserir(va);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {}
        }
    };
    
}
