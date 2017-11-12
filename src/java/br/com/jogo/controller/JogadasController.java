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
     * Verificar se o local a jogar está preenchido
     * 
     * @param posicao a posicao a jogar
     * @param tab o tabuleiro
     * @return 
     */
    public boolean verificaLocalPreenchido(int posicao, Tabuleiro tab) {
        boolean valido = true;
        
        if (tab.getTabs().get(posicao).equals("X") || tab.getTabs().get(posicao).equals("O")) {
            valido = false;
        }
        
        return valido;
    }

    void verPreenchimentos(Tabuleiro tabu) {
        for (int i = 0; i < tabu.getTabs().size(); i++) {
            System.out.println("posicao: "+i+" - valor: "+tabu.getTabs().get(i));
        }
        System.out.println("-------------------------------------------_");
    }
}
