/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jogo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Tabuleiro para controlar o Jogo
 * 
 * @author paulo
 */
public class Tabuleiro implements Serializable {
    
    private List<String> tabs = new ArrayList<>(10);
    private String jogadador1;
    private String jogadador2;
    private String j1_X = "X";
    private String j2_O = "O";
    private String jogador;

    
    public Tabuleiro() {
        tabs.add(0, " ");
        tabs.add(1, " ");
        tabs.add(2, " ");
        tabs.add(3, " ");
        tabs.add(4, " ");
        tabs.add(5, " ");
        tabs.add(6, " ");
        tabs.add(7, " ");
        tabs.add(8, " ");
        tabs.add(9, " ");
    }

    public List<String> getTabs() {
        return tabs;
    }

    public void setTabs(List<String> tabs) {
        this.tabs = tabs;
    }

    public String getJogadador1() {
        return jogadador1;
    }

    public void setJogadador1(String jogadador1) {
        this.jogadador1 = jogadador1;
    }

    public String getJogadador2() {
        return jogadador2;
    }

    public void setJogadador2(String jogadador2) {
        this.jogadador2 = jogadador2;
    }

    public String getJ1_X() {
        return j1_X;
    }

    public void setJ1_X(String j1_X) {
        this.j1_X = j1_X;
    }

    public String getJ2_O() {
        return j2_O;
    }

    public void setJ2_O(String j2_O) {
        this.j2_O = j2_O;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }
    
    @Override
    public String toString() {
        return "Tabeuleiro{" + "tabs=" + tabs + ", jogadador1=" + jogadador1 + ", jogadador2=" + jogadador2 + ", j1_X=" + j1_X + ", j2_O=" + j2_O + '}';
    }
}
