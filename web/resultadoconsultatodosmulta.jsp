<%-- 
    Document   : resultadoconsultatodos
    Created on : 11/04/2023, 21:39:06
    Author     : alunos
--%>

<%@page import="java.util.List"%>
<%@page import="model.Multa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="design.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="cabec">
            <a href="index.html" style="float:left">Menu</a>
            <div class="subcabec">
                <button class="subcabecbtn">Funcionalidades</button>
                <div class="subcabec-cont">
                    <a href="CRUD_USUARIO.html">Usuario</a>
                    <a href="CRUD_MULTA.html">Multa</a>
                    <a href="CRUD_CNH.html">CNH</a>
                    <a href="CRUD_VEICULO.html">Veiculo</a>
                </div>
            </div>
        </div>
    <center>
        <BR><BR>
        <% List<Multa> lmu = (List<Multa>) request.getAttribute("lmu"); %>


        <% if (lmu.size() > 0) {
        %> <table border ="1">
            <tr>
                <th>Código da Infração</th>
                <th>Renavam:</th>
                <th>Número de registro</th>
                <th>Data infração</th>
                <th>Local da Multa</th>
                <th>Número de identificação de agente</th>
                <th>Pontos habilitação</th>
                <th>Valor da Multa</th>
                <th>Classificação da Multa</th>
                <th>Vencimento da Multa</th>
                <th>CPF:</th>
            </tr>
            <%
                for (Multa m : lmu) {
            %><tr>
                <td><% out.println(m.getCodInfra()); %></td>
                <td><% out.println(m.getRenavam()); %></td>
                <td><% out.println(m.getNumRegistro());%></td>
                <td><% out.println(m.getDataInfracao());%></td>
                <td><% out.println(m.getLocalMulta());%></td>
                <td><% out.println(m.getNumIdentificacaoAgente());%></td>
                <td><% out.println(m.getPontosHabilitacao());%></td>
                <td><% out.println(m.getValorMulta());%></td>
                <td><% out.println(m.getClassificacaoMulta());%></td>
                <td><% out.println(m.getDtVencimento());%></td>
                <td><% out.println(m.getCpf());%></td>
            </tr><%
                }
            %> </table> <%
                    } else
                        out.println("Consulta sem retorno...");%> 
    </center>
</body>
</html>
