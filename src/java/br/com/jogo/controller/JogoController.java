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
            tabuleiro.setJogador(tabuleiro.getJ1_X());
            System.out.println("Iniciar em: "+tabuleiro.getJogador());
            HttpSession session = request.getSession(true);
            session.setAttribute("tabuleiro", tabuleiro);
            
            Tabuleiro t = (Tabuleiro) session.getAttribute("tabuleiro");
            
            System.out.println("Jogador 1: "+t.getJogadador1());
            System.out.println("Jogador 2: "+t.getJogadador2());
            //chamando a tabela inicial
            response.sendRedirect("jogo.jsp");
        }
        
        if (urlPath.equals("/JogoController/jogar")) {
            
            String[] arrPosicao = (String[]) request.getParameterValues("posicao");
            String[] arrSimbolo = (String[]) request.getParameterValues("simbolo");
            
            int pos = Integer.parseInt(arrPosicao[0]);
            System.out.println("posicao jogada: "+pos); //mostra a posicao jogada
            String simbolo = arrSimbolo[0];
            System.out.println("Simbolo: "+simbolo); // mostra o simbolo jogado
            
            Tabuleiro tabu = (Tabuleiro) request.getSession().getAttribute("tabuleiro");
            boolean valido = new JogadasController().verificaLocalPreenchido(pos, tabu);
            if (valido) {
                tabu.getTabs().add(pos, simbolo);
                
                if (simbolo.equals("X")) { // VEZ DO O 
                    tabu.setJogador("O");
                }
                if (simbolo.equals("O")) { // VEZ DO X
                    tabu.setJogador("X");
                } 
                
                new JogadasController().verPreenchimentos(tabu);
                request.getSession().setAttribute("tabuleiro", tabu);
                request.getRequestDispatcher("/").forward(request, response);
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
