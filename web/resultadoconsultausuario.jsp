<%-- 
    Document   : resultadoconsulta
    Created on : 11/04/2023, 21:07:06
    Author     : alunos
--%>

<%@page import="model.Usuario"%>
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
        <% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>

        <table border ="1">
            <tr>
                <th>CPF:</th>
                <th>Data de Nascimento:</th>
                <th>Endereco:</th>
                <th>Nome:</th>
                <th>Filiacao:</th>
                <th>Telefone:</th>

            </tr>

            <tr>
                <td><% out.println(usuario.getCpf()); %></td>
                <td><% out.println(usuario.getDtNascimento()); %></td>
                <td><% out.println(usuario.getEndereco());%></td>
                <td><% out.println(usuario.getNome());%></td>
                <td><% out.println(usuario.getFiliacao());%></td>
                <td><% out.println(usuario.getTelefone());%></td>
            </tr>
        </table>
    </center>
</body>
</html>