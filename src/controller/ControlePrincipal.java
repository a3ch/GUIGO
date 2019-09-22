package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.TelaPrincipal;
import model.VariaveisAmbienteDao;
import model.VariaveisAmbiente;

/**
 * Classe utilizada para criar a tela principal.
 * Implementa a interface ActionListener para monitoramento dos objetos adicionados.
 * Faz a simulação dos microcontroladores utilizando threads.
 * 
 * @author Caio Montenegro
 * @version 0.1
 * @since 0.1
 */

public class ControlePrincipal implements ActionListener {
    /**
     * @param telaPrincipal Variável que armazena a Tela Principal da sessão atual.
     * @param conexao Variável que armazena a conexão com o banco de dados da sessão atual.
     * @param tipo Um número inteiro que serve para identificar o tipo de usuário que fez o login. 
     * Essa variável não deveria ser controlada nessa classe, além disso, em últimas análises, ela acabou perdendo o sentido.
     * 
     * @param dao Variável que permite leitura e gravação de dados em instâncias do tipo VariaveisAmbiente.
     * Neste caso, está sendo acessada nessa classe por conta das threads implementadas também aqui.
     * 
     * @param umidade Variável int para armazenar um valor de umidade fictício gerado pela thread.
     * @param luminosidade Variável int para armazenar um valor de luminosidade fictício gerado pela thread.
     * @param temperatura Variável int para armazenar um valor de temperatura fictício gerado pela thread.
     * @param ph Variável int para armazenar um valor de ph fictício gerado pela thread.
     * @param o2Dissolvido Variável int para armazenar um valor de O2 dissolvido fictício gerado pela thread.
     * @param contutividade Variável int para armazenar um valor de condutividade fictício gerado pela thread.
     * 
     * @param random Variável do tipo Random utilizada para retornar, aleatoriamente, os dados fictícios gerados pela thread.
     */
    private TelaPrincipal telaPrincipal;
    private Connection conexao;
    private int tipo;
    
    private VariaveisAmbienteDao dao;
    private float umidade, luminosidade, temperatura, ph, o2Dissolvido, condutividade;
    private Random random;
    
    /**
     * Método construtor.
     * Este método cria uma instancia da TelaPrincipal() e armazena na variável local.
     * 
     * @version 0.1
     * @param tipo Recebe o tipo de usuário proveniente do login usado na sessão atual.
     * @throws java.io.IOException Nesse método, é o comando responsável por sinalizar se a conexão com o banco de dados ainda está ativa.
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
        
        telaPrincipal.getjMenuItemVariaveisAmbiente().addActionListener(this);
        telaPrincipal.getjMenuCultura().addActionListener(this); // Escuta o botão de cadastros de culturas
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

        //Sair
        if (e.getSource() == telaPrincipal.getjMenuSair()) {
            System.exit(0);
        }   
    }
    
    /**
     * Método verificarTipo.
     * É utilizado para mostrar ou esconder funcionalidades de acordo com o tipo de usuário.
     */
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
  
    /**
     * Teste da implementação de Threads.
     * Essa thread (for) vai gerar 100 registros da classe VariaveisAmbientede, com intervalos de 1 segundo.
     * Esses registros serão exibidos na "área de trabalho" do programa (temperatura, umidade, luminosidade, ph, O2 dissolvido e CE) e ao mesmo tempo serão registrados no banco de dados.
     */    
    private Runnable t1 = new Runnable() {
        @Override
        public void run() {
            try {
                VariaveisAmbiente va = new VariaveisAmbiente();
            
                for(int i = 0; i < 100; i++) {
                    temperatura = random.nextInt(100);
                    umidade = random.nextInt(100);
                    luminosidade =  random.nextInt(100);
                    ph = random.nextInt(15);
                    o2Dissolvido = random.nextInt(100);
                    condutividade = random.nextInt(100);
                    telaPrincipal.getjLabelTemperatura().setText(Float.toString(temperatura) + "°C");
                    telaPrincipal.getjLabelUmidade().setText(Float.toString(umidade) + "%");
                    telaPrincipal.getjLabelLuminosidade().setText(Float.toString(luminosidade) + "%");
                    telaPrincipal.getjLabelPh().setText(Float.toString(ph));
                    telaPrincipal.getjLabelOD().setText(Float.toString(o2Dissolvido) + "%");
                    telaPrincipal.getjLabelCondutividadeEletrica().setText(Float.toString(condutividade) + "%");
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
