/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jogo.model;

import java.io.Serializable;
/**
 * Tabuleiro para controlar o Jogo
 * 
 * @author paulo
 */
public class Tabuleiro implements Serializable {
    
    public String tabuleiro;
    private String jogadador1;
    private String jogadador2;
    private String j1_X = "X";
    private String j2_O = "O";
    private String jogador;
    private String ganhador;
    private int empates;
    private int vitoriasX;
    private int vitoriasY;
    
    public String getTabs() {
        return tabuleiro;
    }

    public void setTabs(String tabuleiro) {
        this.tabuleiro = tabuleiro;
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

    public String getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(String tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public String getGanhador() {
        return ganhador;
    }

    public void setGanhador(String ganhador) {
        this.ganhador = ganhador;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getVitoriasX() {
        return vitoriasX;
    }

    public void setVitoriasX(int vitoriasX) {
        this.vitoriasX = vitoriasX;
    }

    public int getVitoriasY() {
        return vitoriasY;
    }

    public void setVitoriasY(int vitoriasY) {
        this.vitoriasY = vitoriasY;
    }
    
    @Override
    public String toString() {
        return "Tabeuleiro{" + "tabs=" + tabuleiro + ", jogadador1=" + jogadador1 + ", jogadador2=" + jogadador2 + ", j1_X=" + j1_X + ", j2_O=" + j2_O + '}';
    }
}
