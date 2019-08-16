/*
 * Essa classe serve apenas para o teste das classes criadas.
 * Mais abaixo se encontra um teste para visualização do campo DATA de um registro de Variaveis de Ambiente.
 */
package model;

/**
 *
 * @author Gustavo Rodrigues
 */
public class Main {
    public static void main(String args[]) {
        Cultura c = new Cultura(01, "Alface", "Roxo", 60, 7, 20, 30);
        
        VariaveisAmbiente va = new VariaveisAmbiente(c, 30, 40, 80);
        
        System.out.println(va.getDataCompletaFormatada());
        
        
    }
}
