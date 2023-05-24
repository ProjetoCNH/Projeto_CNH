<%-- 
    Document   : resultadoconsultatodos
    Created on : 11/04/2023, 21:39:06
    Author     : alunos
--%>

<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% List<Produto> lpc = (List<Produto>) request.getAttribute("lpc"); %>

         
        <% if (lpc.size() > 0) {
        %> <table border ="1">
            <tr>
                <th>ID</th>
                <th>Descrição</th>
                <th>Preço</th>
                <th>Cor</th>
                <th>Quantidade</th>
                <th>Nome do Fornecedor</th>
                <th>Número de Parcelas</th>
                <th>Marca</th>
            </tr>
            <%
                for (Produto p : lpc) {
            %><tr>
                <td><% out.println(p.getId()); %></td>
                <td><% out.println(p.getDescricao()); %></td>
                <td><% out.println(p.getPreco());%></td>
                <td><% out.println(p.getCor());%></td>
                <td><% out.println(p.getQuantidade());%></td>
                <td><% out.println(p.getNomeFornecedor());%></td>
                <td><% out.println(p.getNParcelas());%></td>
                <td><% out.println(p.getMarca());%></td>
            </tr><%
                    }
                %> </table> <%
                } else
                    out.println("Consulta sem retorno...");%> 
    </body>
</html>
