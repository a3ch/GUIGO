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
     * @param login
     * @param senha
     */  
    private int id;
    private String login;
    private String senha;

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
    
}
