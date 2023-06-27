<%-- 
    Document   : resultadoconsultatodos
    Created on : 11/04/2023, 21:39:06
    Author     : alunos
--%>

<%@page import="java.util.List"%>
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
        <% List<Usuario> lu = (List<Usuario>) request.getAttribute("lu"); %>


        <% if (lu.size() > 0) {
        %> <table border ="1">
            <tr>
                <th>CPF:</th>
                <th>Data de Nascimento:</th>
                <th>Endereco:</th>
                <th>Nome:</th>
                <th>Filiacao:</th>
                <th>Telefone:</th>
            </tr>
            <%
                for (Usuario u : lu) {
            %><tr>
                <td><% out.println(u.getCpf()); %></td>
                <td><% out.println(u.getDtNascimento()); %></td>
                <td><% out.println(u.getEndereco());%></td>
                <td><% out.println(u.getNome());%></td>
                <td><% out.println(u.getFiliacao());%></td>
                <td><% out.println(u.getTelefone());%></td>
            </tr><%
                }
            %> </table> <%
                    } else
                        out.println("Consulta sem retorno...");%> 
    </center>
</body>
</html>
