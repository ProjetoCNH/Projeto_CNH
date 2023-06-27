<%-- 
    Document   : resultadoatualizarveiculo
    Created on : 30/05/2023, 20:22:40
    Author     : alunos
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
        <%Veiculo veiculo = (Veiculo) request.getAttribute("veiculo");%>
        <form name="formatualizarveiculo" action="web_controller_veiculo" method="post" >
            <br><br>
            <center>
                <table>
                    <tr>
                        <th>
                            Atualizar Usuario
                        </th>
                    </tr>
                    <tr> 
                        <td>
                            Renavam: <input type ="text" name="txtrenavam"readonly value="<% out.println(veiculo.getRenavam());%>"><BR>
                            Placa: <input type = "text" name ="txtplaca" maxlength="10" value="<% out.println(veiculo.getPlaca()); %>"><BR>
                            Ano: <input type = "text" name ="txtano " maxlength="4"value="<% out.println(veiculo.getAno()); %>"><BR>
                            Modelo: <input type ="text" name="txtmodelo" maxlength="50" value="<% out.println(veiculo.getModelo()); %>"><BR>
                            Tipo: <input type ="text" name="txttipo" maxlength="50" value="<% out.println(veiculo.getTipo()); %>"><BR>
                            Chassi: <input type ="text" name="txtchassi" maxlength="17" value="<% out.println(veiculo.getChassi()); %>"><BR>
                            Cor: <input type ="text" name="txtcor" maxlength="20" value="<% out.println(veiculo.getCor()); %>"><BR>
                            Crv: <input type ="text" name="txtcrv" maxlength="80" value="<% out.println(veiculo.getCrv()); %>"><BR>
                            Combustivel: <input type ="text" name="txtcombustivel" maxlength="20"value="<% out.println(veiculo.getCombustivel()); %>"><BR>
                            Categoria: <input type ="text" name="txtcategoria" maxlength="30"value="<% out.println(veiculo.getCategoria()); %>"><BR>
                            Cpf: <input type ="text" name="txtcpf" maxlength="14" value="<% out.println(veiculo.getCpf());%>"><BR><BR>
                            <input type="submit" name="btnoperacao" class="button" value="ATUALIZAR DADOS">
                        </td>
                    </tr>
                </table>
            </center>
        </form>
    </body>
</html>