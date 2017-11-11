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
    public boolean verificaLocalPreenchido(Tabuleiro tab, int posicao) {
        boolean preenchido = false;
        
        if (!tab.getTabs().get(posicao).isEmpty()) {
            preenchido = true;
        }
        
        return preenchido;
    }
}
