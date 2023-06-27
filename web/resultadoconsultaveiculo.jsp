<%-- 
    Document   : resultadoconsultaveiculo
    Created on : 31 de mai. de 2023, 10:58:20
    Author     : renat
--%>
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
        <% Veiculo veiculo = (Veiculo) request.getAttribute("veiculo"); %>

        <table border ="1">
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
                <th>CPF</th>
            </tr>

            <tr>
                <td><% out.println(veiculo.getRenavam()); %></td>
                <td><% out.println(veiculo.getPlaca()); %></td>
                <td><% out.println(veiculo.getAno());%></td>
                <td><% out.println(veiculo.getModelo());%></td>
                <td><% out.println(veiculo.getTipo());%></td>
                <td><% out.println(veiculo.getChassi());%></td>
                <td><% out.println(veiculo.getCor());%></td>
                <td><% out.println(veiculo.getCrv());%></td>
                <td><% out.println(veiculo.getCombustivel());%></td>
                <td><% out.println(veiculo.getCategoria());%></td>
                <td><% out.println(veiculo.getCpf());%></td>
            </tr>
        </table>
    </center>
</body>
</html>

