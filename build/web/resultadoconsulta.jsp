<%-- 
    Document   : resultadoconsulta
    Created on : 11/04/2023, 21:07:06
    Author     : alunos
--%>

<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD</title>
    </head>
    <body>
        <% Produto produto = (Produto) request.getAttribute("produto"); %>
        
        <table border ="1">
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
            
        <tr>
                <td><% out.println(produto.getId()); %></td>
                <td><% out.println(produto.getDescricao()); %></td>
                <td><% out.println(produto.getPreco());%></td>
                <td><% out.println(produto.getCor());%></td>
                <td><% out.println(produto.getQuantidade());%></td>
                <td><% out.println(produto.getNomeFornecedor());%></td>
                <td><% out.println(produto.getNParcelas());%></td>
                <td><% out.println(produto.getMarca());%></td>
        </tr>
        </table>
    </body>
</html>
