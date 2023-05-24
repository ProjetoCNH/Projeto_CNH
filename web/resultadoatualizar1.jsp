<%-- 
    Document   : resultadoatualizar1
    Created on : 18/04/2023, 21:42:43
    Author     : alunos
--%>

<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Atualizar</h2>
        <% Produto produto = (Produto) request.getAttribute("produto"); %>
        
        <form name="formatualizar2" action="web_controller" method="post">
            ID................................: <input type="text" name="txtid" readonly value="<% out.println(produto.getId()); %>"><BR>
            Descrição....................: <input type="text" name="txtdescricao" value="<% out.println(produto.getDescricao()); %>"><BR>
            Preço...........................: <input type="text" name="txtpreco" value="<% out.println(produto.getPreco()); %>"><BR>
            Cor..............................: <input type="text" name="txtcor" value="<% out.println(produto.getCor()); %>"><BR>
            Quantidade.................: <input type="text" name="txtquantidade" value="<% out.println(produto.getQuantidade()); %>"><BR>
            Nome Fornecedor......: <input type="text" name="txtnomeFornecedor" value="<% out.println(produto.getNomeFornecedor()); %>"><BR>
            Número de Parcelas...: <input type="text" name="txtnParcelas" value="<% out.println(produto.getNParcelas()); %>"><BR>
            Marca.........................: <input type="text" name="txtmarca" value="<% out.println(produto.getMarca()); %>"><BR>
            <input type="submit" name="btnoperacao" value="ATUALIZAR DADOS">
        </form>
        
    </body>
</html>
