/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jogo.controller;

import br.com.jogo.model.Tabuleiro;

/**
 * Controlar jogadas realizadas pelos jogadores
 *
 * @author paulo
 */
public class JogadasController {
    
    private String vezDoJogador = "É sua vez - ";
    
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
        System.out.println("POSIÇÃO: "+pos+" - SIMBOLO: "+simbolo);
        
        String[] tab = tabuleiro.split(";");
        
        System.out.println("Antes de preencher --------------");
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Pos: "+i+" - Valor: "+tab[i]);
        }
        
        System.out.println("Depois de preencher ----------------");
        tab[pos] = simbolo;
        
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Pos: "+i+" - Valor: "+tab[i]);
        }
        
        System.out.println("O QUE VAI RETORNAR >>>>>>>>> ");
        int cont = 0;
        for(int i =0; i< tab.length; i++) {
            jogou += tab[i].trim()+" ;";
        }
        
        System.out.println("JOGOU >>>>>  "+jogou);
        return jogou;
    }

    int verificarQuemGanhou(String tabuNew, String s) {
        System.out.println("Simbolo verificar:"+s);
        String[] tabu = tabuNew.split(";");
        System.out.println(" ----- verificando ganhador ---- ");
        for(int i =0; i< tabu.length; i++) {
             System.out.println("Pos: "+i+" - Valor: "+tabu[i]);
        }
           
        System.out.println(tabu[0]);
        String simbolo = s+" ";
        System.out.println(simbolo);
 
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

        System.out.println("GANHOU ?? "+GANHOU);
        
        return GANHOU;
    }
}
