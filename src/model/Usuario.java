package model;

/**
 * Classe Usuário.
 * Esta classe guarda os atributos e funções da entidade usuário.
 * 
 * @author Caio Montenegro
 * @version 0.1
 * @since 0.1
 */

public class Usuario {
    /**
     * @param id
     * @param tipo
     * @param login
     * @param senha
     */  
    private int id;
    private int tipo;
    private String login;
    private String senha;
    private String fone;
    private String email;
    private String nome;

    /**
     * Exibe a identificação do usuário.
     * 
     * @return Retorna o atributo id do objeto usuário.
     */
    public int getId() {
        return id;
    }
    /**
     * Envia um código para atribuir a um objeto usuário.
     * 
     * @param id Este servirá para identificar um usuário de forma exclusiva.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Exibe nome de usuário de um dado usuário.
     * 
     * @return Retorna o nome de usuário de um objeto usuário.
     */
    public String getLogin() {
        return login;
    }
    /**
     * Envia um nome de usuário para atribuir a um objeto usuário.
     * 
     * @param login Este servirá como primeiro campo necessário para realizar um login.
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * Exibe a senha do usuário.
     * 
     * @return Retorna uma string senha de um objeto usuário.
     */
    public String getSenha() {
        return senha;
    }
    /**
     * Envia a senha para atribuir a um objeto usuário.
     * 
     * @param senha Esta servirá como campo confidencial do usuário para garantir a integridade dos seus dados.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    /**
     * Exibe o tipo do usuário.
     * 
     * @return Retorna um int tipo de um objeto usuário.
     */
    public int getTipo() {
        return tipo;
    }
    /**
     * Envia o tipo para atribuir a um objeto usuário.
     * 
     * @param tipo Esta servirá para identificar qual é o nivel do usuario.
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
