<%-- 
    Document   : jogo
    Created on : 11/11/2017, 15:16:25
    Author     : paulo
--%>
<%@page import="br.com.jogo.model.Tabuleiro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jogo da Velha</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body style="background-color: #f6f6f6 !important;">
        <style>
            h1,h2,h3,h4,h5,h6,.h1,.h2,.h3,.h4,.h5,.h6 {
                font-family:'Source Sans Pro',sans-serif;
            }
            * {
                font-family:'Source Sans Pro',sans-serif;
            }
            #text-bem-vindo {
                margin-top: 35px !important;
            }
            .linha{
                background-color: #fefefe;
                height:80px;
                border:solid 1px;
                color:#000;
                text-align: center;
                font-family: verdana;
                font-size: 56px;
                font-weight: 900;
            }
            .tabu {
                cursor: pointer !important;
            }
        </style>
        <br>
        <div class="container-fluid">
            <%
                Tabuleiro tabuleiro = (Tabuleiro) request.getSession().getAttribute("tabuleiro");
                String [] tabu = tabuleiro.getTabuleiro().split(";");
                System.out.println("TABUUU: "+tabuleiro.getGanhador());
            %>
            
            <input type="hidden" name="simbolo" id="simbolo" value="<% out.print(tabuleiro.getJogador()); %>"/>
            <%  if (tabuleiro.getGanhador() != null && !tabuleiro.getGanhador().isEmpty()) {                    
                out.print("<div class='row-fluid text-center' id='d_vencedor'>");
                if (tabuleiro.getGanhador() != null && !tabuleiro.getGanhador().isEmpty()) {
                    out.print("<h2> "+tabuleiro.getGanhador()+"</h2>");
                }
                out.print("</div>");
                }
             %>
            <input type="hidden" name="vencedor" id="vencedor" value="<% out.print(tabuleiro.getGanhador()); %>"/>
            
            <div class="col-sm-3 text-center">
                <br>
                <br> 
                <br>
                <h4>
                    <%
                        out.println("Jogador 1 - " + tabuleiro.getJogadador1());
                        out.println("<p>");
                        out.println("<p>");
                        out.println("Símbolo - " + tabuleiro.getJ1_X());
                    %>
                </h4>
                <br>
                 <h4>
                    <%
                        out.println("Jogador 2 - " + tabuleiro.getJogadador2());
                        out.println("<p>");
                        out.println("<p>");
                        out.println("Símbolo - " + tabuleiro.getJ2_O());
                    %>
                </h4>
            </div>

            <div class="col-sm-6 text-center">
                <h1>Jogo da Velha</h1>
                <div class="col-sm-12 text-center">
                    <div class="row text-center tabu">
                        <div class="col-sm-2 linha" id="0" onclick="jogar(this);">
                            <% if (tabuleiro.getTabuleiro() != null) {
                                    out.println(tabu[0].toString());
                                }
                            %>
                        </div>
                        <div class="col-sm-2 linha" id="1" onclick="jogar(this);">
                             <% if (tabuleiro.getTabuleiro() != null) {
                                    out.println(tabu[1].toString());
                                }
                            %>
                        </div>
                        <div class="col-sm-2 linha" id="2" onclick="jogar(this);">
                            <% if (tabuleiro.getTabuleiro() != null) {
                                    out.println(tabu[2].toString());
                                }
                            %>
                        </div>
                    </div>
                    <div class="row text-center tabu">
                        <div class="col-sm-2 linha" id="3" onclick="jogar(this);">
                             <% if (tabuleiro.getTabuleiro() != null) {
                                    out.println(tabu[3].toString());
                                }
                            %>
                        </div>
                        <div class="col-sm-2 linha" id="4" onclick="jogar(this);">
                            <% if (tabuleiro.getTabuleiro() != null) {
                                    out.println(tabu[4].toString());
                                }
                            %>
                        </div>
                        <div class="col-sm-2 linha" id="5" onclick="jogar(this);">
                            <% if (tabuleiro.getTabuleiro() != null) {
                                    out.println(tabu[5].toString());
                                }
                            %>
                        </div>
                    </div>
                    <div class="row text-center tabu">
                        <div class="col-sm-2 linha" id="6" onclick="jogar(this);">
                            <% if (tabuleiro.getTabuleiro() != null) {
                                    out.println(tabu[6].toString());
                                }
                            %>
                        </div>
                        <div class="col-sm-2 linha" id="7" onclick="jogar(this);">
                             <% if (tabuleiro.getTabuleiro() != null) {
                                    out.println(tabu[7].toString());
                                }
                            %>
                        </div>
                        <div class="col-sm-2 linha" id="8"  onclick="jogar(this);">
                            <% if (tabuleiro.getTabuleiro() != null) {
                                    out.println(tabu[8].toString());
                                }
                            %>
                        </div>
                    </div>
                            <h4>É sua vez - <b><% out.println(tabuleiro.getJogador()); %> </b></h4>
                            <br>
                            <form action="JogoController/comecarNovamente" method="POST">
                                <button class="btn btn-primary" type="submit" value="Começar Novamente">Começar Novamente</button>
                            </form>
                            <br>
                            <a href="/JogoDaVelha">Escolher jogadores novamente.</a>
                </div>
            </div>
        </div>
    </body>

    <script type="text/javascript">

        function jogar(evento) { 
            var id = evento.id;
            var simbolo = $("#simbolo").val().trim();

            $.ajax({
                type: "POST",
                url: "JogoController/jogar",
                data: { 	
		       posicao: id,
		       simbolo: simbolo
		},
                success: function (result) {
                    console.log(result);
                    $('.container-fluid').load('jogador.jsp'); // carregar a página a cada jogada efetuada.       
                }
            });   
        }
        
    </script>
</html>
