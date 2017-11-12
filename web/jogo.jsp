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
            %>
            
            <input type="hidden" name="simbolo" id="simbolo" value="<% out.print(tabuleiro.getJogador()); %>"/>
            
            <div class="col-sm-3 text-center">
                <h4>
                    <%
                        out.println("Jogador 1 - " + tabuleiro.getJogadador1());
                        out.println("<p>");
                        out.println("<p>");
                        out.println("Símbolo - " + tabuleiro.getJ1_X());
                    %>
                </h4>
            </div>

            <div class="col-sm-6 text-center">
                <h1>Jogo da Velha</h1>
                <div class="col-sm-12 text-center">
                    <div class="row text-center tabu">
                        <div class="col-sm-2 linha" id="1" onclick="jogar(this);">
                            <% if (tabuleiro.getTabs() != null) {
                                    out.println(tabuleiro.getTabs().get(1));
                                }
                            %>
                        </div>
                        <div class="col-sm-2 linha" id="2" onclick="jogar(this);">
                            <% if (tabuleiro.getTabs() != null) {
                                    out.println(tabuleiro.getTabs().get(2));
                                }
                            %>
                        </div>
                        <div class="col-sm-2 linha" id="3" onclick="jogar(this);">
                            <% if (tabuleiro.getTabs() != null) {
                                    out.println(tabuleiro.getTabs().get(3));
                                }
                            %>
                        </div>
                    </div>
                    <div class="row text-center tabu">
                        <div class="col-sm-2 linha" id="4" onclick="jogar(this);">
                            <% if (tabuleiro.getTabs() != null) {
                                    out.println(tabuleiro.getTabs().get(4));
                                }
                            %>
                        </div>
                        <div class="col-sm-2 linha" id="5" onclick="jogar(this);">
                            <% if (tabuleiro.getTabs() != null) {
                                    out.println(tabuleiro.getTabs().get(5));
                                }
                            %>
                        </div>
                        <div class="col-sm-2 linha" id="6" onclick="jogar(this);">
                            <% if (tabuleiro.getTabs() != null) {
                                    out.println(tabuleiro.getTabs().get(6));
                                }
                            %>
                        </div>
                    </div>
                    <div class="row text-center tabu">
                        <div class="col-sm-2 linha" id="7" onclick="jogar(this);">
                            <% if (tabuleiro.getTabs() != null) {
                                    out.println(tabuleiro.getTabs().get(7));
                                }
                            %>
                        </div>
                        <div class="col-sm-2 linha" id="8" onclick="jogar(this);">
                            <% if (tabuleiro.getTabs() != null) {
                                    out.println(tabuleiro.getTabs().get(8));
                                }
                            %>
                        </div>
                        <div class="col-sm-2 linha" id="9"  onclick="jogar(this);">
                            <% if (tabuleiro.getTabs() != null) {
                                   out.println(tabuleiro.getTabs().get(9));
                                }
                            %>
                        </div>
                    </div>
                            <h4>É sua vez - <b><% out.println(tabuleiro.getJogador()); %> </b></h4>
                </div>
            </div>
            <div class="col-sm-3 text-center">
                <h4>
                    <%
                        out.println("Jogador 2 - " + tabuleiro.getJogadador2());
                        out.println("<p>");
                        out.println("<p>");
                        out.println("Símbolo - " + tabuleiro.getJ2_O());
                    %>
                </h4>
            </div>
        </div>
    </body>

    <script type="text/javascript">

        function jogar(evento) {
            var id = evento.id;
            console.log("id > ",id);
            var simbolo = $("#simbolo").val().trim();
            console.log("simbolo jogado: ",simbolo);

            $.ajax({
                type: "POST",
                url: "JogoController/jogar",
                data: { 	
		       posicao: id,
		       simbolo: simbolo
		},
                success: function (result) {
                    console.log("successo ao jogar...");
                }
            });
        }

    </script>
</html>
