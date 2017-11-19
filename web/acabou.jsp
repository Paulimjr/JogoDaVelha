<%-- 
    Document   : acabou
    Created on : 19/11/2017, 18:24:36
    Author     : paulo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vencedor do Jogo!</title>
    </head>
    <body>
        <%
            String nomeGanhador = (String) request.getSession().getAttribute("nomeGanhador");
            if (nomeGanhador == null) {
                nomeGanhador = "Erro ao ganhar o Jogo...";
            }
        %>
    <center><h1><% out.println(nomeGanhador);%></h1></center>
    <br>
    <br>
    <a href="/JogoDaVelha">Começar Novamente...</a>
</body>
</html>
