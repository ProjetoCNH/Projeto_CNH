<%-- 
    Document   : resultadoconsultacnh
    Created on : 11/04/2023, 21:07:06
    Author     : alunos
--%>

<%@page import="model.CNH"%>
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
        <% CNH cnh = (CNH) request.getAttribute("cnh"); %>

        <table border ="1">
            <tr>
                <th>Número de Registro</th>
                <th>CPF</th>
                <th>Data de Emissão</th>
                <th>Validade</th>
                <th>Categoria</th>
                <th>Nome da Autoescola</th>
                <th>Orgão Emissor</th>
                <th>Pontos na Carteira</th>
            </tr>

            <tr>
                <td><% out.println(cnh.getNumregistro()); %></td>
                <td><% out.println(cnh.getCpf());%></td>
                <td><% out.println(cnh.getDtEmissao());%></td>
                <td><% out.println(cnh.getValidade()); %></td>
                <td><% out.println(cnh.getCategoria());%></td>
                <td><% out.println(cnh.getNomeAutoescola());%></td>
                <td><% out.println(cnh.getOrgEmissor());%></td>
                <td><% out.println(cnh.getPontosCarteira());%></td>
            </tr>
        </table>
    </center>
</body>
</html>
