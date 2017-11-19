/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jogo.controller;

/**
 * Controlar jogadas realizadas pelos jogadores
 *
 * @author paulo
 */
public class JogadasController {
    
    private final String vezDoJogador = "É sua vez - ";
    
    /**
    * 1 - alguem ganhou
    * 0 - ninguem ganhou ainda
    */
    private int GANHOU = 0; //Começar com 3 pois ninguem ganhou ainda
    
    /**
     * Verificar se o local a jogar está preenchido
     * 
     * @param posicao a posicao a jogar
     * @param tab o tabuleiro
     * @return 
     */
    public boolean verificaLocalPreenchido(int posicao, String tab) {
        boolean valido = true;
        
        String tabu[] = tab.split(";");
        
        if (tabu[posicao].equals("X") || tabu[posicao].equals("O")) {
            valido = false;
        }
        
        return valido;
    }
    
    /**
     * Efetua as jogadas
     * 
     * @param pos
     * @param simbolo
     * @param tabuleiro
     * @return 
     */
    public String efetuarJogada(int pos, String simbolo, String tabuleiro) {
        String jogou = ""; 
        String[] tab = tabuleiro.split(";");
        tab[pos] = simbolo;

        for(int i =0; i< tab.length; i++) {
            jogou += tab[i].trim()+" ;";
        }

        return jogou;
    }
    
    /**
     * Verificando quem ganhou a jogada
     * 
     * @param tabuNew
     * @param s
     * @return 
     */
    int verificarQuemGanhou(String tabuNew, String s) {
        String[] tabu = tabuNew.split(";");
        String simbolo = s+" ";
    
        if (tabu[0].equals(simbolo) && tabu[1].equals(simbolo) && tabu[2].equals(simbolo)) {
            GANHOU = 1;
        }
        //verificando 2 linha
        if (tabu[3].equals(simbolo) && tabu[4].equals(simbolo) && tabu[5].equals(simbolo)) {
            GANHOU = 1;
        }
        //verificando 3 linha
        if (tabu[6].equals(simbolo) && tabu[7].equals(simbolo) && tabu[8].equals(simbolo)) {
            GANHOU = 1;
        }
        //////////////////////////
        //verificando na horizontal
        //1 coluna
        if (tabu[0].equals(simbolo) && tabu[3].equals(simbolo) && tabu[6].equals(simbolo)) {
            GANHOU = 1;
        }
        //2 coluna
        if (tabu[1].equals(simbolo) && tabu[4].equals(simbolo) && tabu[7].equals(simbolo)) {
            GANHOU = 1;
        }
        //3 coluna
        if (tabu[2].equals(simbolo) && tabu[5].equals(simbolo) && tabu[8].equals(simbolo)) {
            GANHOU = 1;
        }
        
        //////////////////////////
        // verificando na diagonal
        if (tabu[0].equals(simbolo) && tabu[4].equals(simbolo) && tabu[8].equals(simbolo)) {
            GANHOU = 1;
        }
        //3 coluna
        if (tabu[2].equals(simbolo) && tabu[4].equals(simbolo) && tabu[6].equals(simbolo)) {
            GANHOU = 1;
        }
    
        return GANHOU;
    }
    
    /**
     * Verificar se o jogo deu Nega (ninguem venceu)
     * 
     * @param tabuNew
     * @param s
     * @return 
     */
    public int verificarNenhumVencedor(String tabuNew, String s) {
         String[] tabu = tabuNew.split(";");
         
         if (!tabu[0].equals(" ") 
            && !tabu[1].equals(" ") 
            && !tabu[2].equals(" ") 
            && !tabu[3].equals(" ")
            && !tabu[4].equals(" ")
            && !tabu[5].equals(" ")
            && !tabu[6].equals(" ")
            && !tabu[7].equals(" ")
            && !tabu[8].equals(" ")) {

             GANHOU = 3;
         }
         
         return GANHOU;
    }
}
