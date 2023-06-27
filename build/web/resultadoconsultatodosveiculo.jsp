<%-- 
    Document   : resultadoconsultatodosveiculo
    Created on : 31 de mai. de 2023, 11:12:29
    Author     : renat
--%>

<%@page import="java.util.List"%>
<%@page import="model.Veiculo"%>
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
        <% List<Veiculo> lveiculo = (List<Veiculo>) request.getAttribute("lveiculo"); %>


        <% if (lveiculo.size() > 0) {
        %> <table border ="1">
            <tr>
                <th>Renavam</th>
                <th>Placa</th>
                <th>Ano</th>
                <th>Modelo</th>
                <th>Tipo</th>
                <th>Chassi</th>
                <th>Cor</th>
                <th>Crv</th>
                <th>Combustivel</th>
                <th>Categoria</th>
                <th>CPF:</th>
            </tr>
            <%
                for (Veiculo v : lveiculo) {
            %><tr>
                <td><% out.println(v.getRenavam()); %></td>
                <td><% out.println(v.getPlaca()); %></td>
                <td><% out.println(v.getAno());%></td>
                <td><% out.println(v.getModelo());%></td>
                <td><% out.println(v.getTipo());%></td>
                <td><% out.println(v.getChassi());%></td>
                <td><% out.println(v.getCor());%></td>
                <td><% out.println(v.getCrv());%></td>
                <td><% out.println(v.getCombustivel());%></td>
                <td><% out.println(v.getCategoria());%></td>
                <td><% out.println(v.getCpf());%></td>
            </tr><%
                }
            %> </table> <%
                    } else
                        out.println("Consulta sem retorno...");%> 
    </center>
</body>
</html>
