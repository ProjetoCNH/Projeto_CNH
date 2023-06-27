<%-- 
    Document   : resultadoatualizarcnh
    Created on : 30/05/2023, 20:06:27
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

    <% CNH cnh = (CNH) request.getAttribute("cnh"); %>

    <form name="formatualizarcnh" action="web_controller_cnh" method="post" >
        <br><br>
        <center>
            <table>
                <tr>
                    <th>
                        Atualizar CNH
                    </th>
                </tr>
                <tr> 
                    <td>
                        Número de Registro: <input type ="text" name="txtnumregistro" readonly value="<% out.println(cnh.getNumregistro()); %>"><BR>
                        CPF: <input type ="text" name="txtcpf" value="<% out.println(cnh.getCpf()); %>"><BR>
                        Data de Emissão: <input type = "date" name ="txtdtemissao" value="<% out.println(cnh.getDtEmissao()); %>"><BR>
                        Validade: <input type = "date" name ="txtvalidade" value="<% out.println(cnh.getValidade()); %>"><BR>
                        Categoria: <input type ="text" name="txtcategoria" value="<% out.println(cnh.getCategoria()); %>"><BR>
                        Nome da Autoescola: <input type ="text" name="txtnomeautoescola" value="<% out.println(cnh.getNomeAutoescola()); %>"><BR>
                        Orgão Emissor: <input type ="text" name="txtorgemissor" value="<% out.println(cnh.getOrgEmissor()); %>"><BR>
                        Pontos na Carteira: <input type ="text" name="txtpontoscarteira" value="<% out.println(cnh.getPontosCarteira());%>"><BR><BR>

                        <input type="submit" name="btnoperacao" class="button" value="ATUALIZAR DADOS">
                    </td>
                </tr>
            </table>
        </center>
    </form>
</body>
</html>
