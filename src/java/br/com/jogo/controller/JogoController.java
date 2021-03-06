/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jogo.controller;

import br.com.jogo.model.Tabuleiro;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paulo
 */
public class JogoController extends HttpServlet {
    
    private final String INICIAR_JOGO = " ; ; ; ; ; ; ; ; ; ;";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //iniciando o jogo
        String urlPath = request.getServletPath();
        if (urlPath.equals("/JogoController")) {

            String jogador1 = request.getParameter("jogador1");
            String jogador2 = request.getParameter("jogador2");

            Tabuleiro tabuleiro = new Tabuleiro();
            tabuleiro.setJogadador1(jogador1);
            tabuleiro.setJogadador2(jogador2);
            tabuleiro.setEmpates(0);
            tabuleiro.setVitoriasX(0);
            tabuleiro.setVitoriasY(0);
            tabuleiro.setJogador(tabuleiro.getJ1_X()); // Setando o X pois ele que sempe começara.

            HttpSession session = request.getSession(true);
            session.setAttribute("tabuleiro", tabuleiro);
            tabuleiro.setTabuleiro(INICIAR_JOGO);

            Tabuleiro t = (Tabuleiro) session.getAttribute("tabuleiro");

            //chamando a tabela inicial
            response.sendRedirect("jogador.jsp");
        }
        
        //comencando o jogo novamente
        if (urlPath.equals("/JogoController/comecarNovamente")) {
            
            
            Tabuleiro tab = (Tabuleiro) request.getSession().getAttribute("tabuleiro");
            tab.setGanhador("");
            tab.setTabuleiro(INICIAR_JOGO);
            tab.setJogador(tab.getJ1_X()); // Setando o X pois ele que sempe começara.
            
            request.getSession().setAttribute("tabuleiro", tab);
            response.sendRedirect("/JogoDaVelha/jogador.jsp");
        }
        
        if (urlPath.equals("/JogoController/jogar")) {

            String[] arrPosicao = (String[]) request.getParameterValues("posicao");
            String[] arrSimbolo = (String[]) request.getParameterValues("simbolo");

            int pos = Integer.parseInt(arrPosicao[0]);
            String simbolo = arrSimbolo[0];

            Tabuleiro tabu = (Tabuleiro) request.getSession().getAttribute("tabuleiro");

            boolean valido = new JogadasController().verificaLocalPreenchido(pos, tabu.getTabuleiro());
            
            if (valido) {
                String tabuNew = new JogadasController().efetuarJogada(pos, simbolo, tabu.getTabuleiro());
                /**
                 * 1 - alguem ganhou
                 * 0 - ninguem ganhou ainda
                 * 3 - deu nega
                 */
                int ganhador = new JogadasController().verificarQuemGanhou(tabuNew, simbolo);
                
                String nomeGanhador = "";
                int ganhouX = tabu.getVitoriasX();
                int ganhouY = tabu.getVitoriasY();
                int empate = tabu.getEmpates();
                
                if (ganhador == 1) {
                    // X GANHOU
                    if (simbolo.equals(tabu.getJ1_X())) {
                         ganhouX++;
                         nomeGanhador = "Parabéns "+tabu.getJogadador1()+", você venceu!";
                    }
                    // O GANHOU
                    if (simbolo.equals(tabu.getJ2_O())) {
                        ganhouY++;
                        nomeGanhador = "Parabéns "+tabu.getJogadador2()+", você venceu!";
                    }
                }
                
                ganhador = new JogadasController().verificarNenhumVencedor(tabuNew, simbolo);
                //Quer dizer que não houve ganhadores...
                if (ganhador == 3) {
                    empate++;
                    nomeGanhador = "Ninguém venceu :( ... Começe novamente!";                 
                }
                
                tabu.setEmpates(empate);
                tabu.setVitoriasX(ganhouX);
                tabu.setVitoriasY(ganhouY);
                tabu.setGanhador(nomeGanhador);
                tabu.setTabuleiro(tabuNew);
                
                if (simbolo.equals("X")) { // VEZ DO O
                    tabu.setJogador("O");
                    request.getSession().setAttribute("tabuleiro", tabu);
                }
                if (simbolo.equals("O")) { // VEZ DO X
                    tabu.setJogador("X");
                    request.getSession().setAttribute("tabuleiro", tabu);
                }
                
                response.sendRedirect("/");
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
