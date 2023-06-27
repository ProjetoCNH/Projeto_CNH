<%-- 
    Document   : resultadoatualizarveiculo
    Created on : 30/05/2023, 20:22:40
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

        <%Usuario usuario = (Usuario) request.getAttribute("usuario");%>
        <form name="formatualizausuario" action="web_controller_usuario" method="post" >
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
                            CPF: <input type ="text" name="txtcpf"readonly value="<% out.print(usuario.getCpf());%>"><BR>
                            Data de Nascimento: <input type ="date" name="txtdtnasc"readonly value="<% out.print(usuario.getDtNascimento());%>"><BR>
                            Endereco: <input type = "text" name ="txtendereco"value="<% out.print(usuario.getEndereco()); %>"><BR>
                            Nome: <input type = "text" name ="txtnome"value="<% out.print(usuario.getNome()); %>"><BR>
                            Filiacao: <input type ="text" name="txtfiliacao"value="<% out.print(usuario.getFiliacao()); %>"><BR>
                            Telefone: <input type ="text" name="txttel"value="<% out.print(usuario.getTelefone());%>"><BR><BR>
                            <input type="submit" name="btnoperacao" class="button" value="ATUALIZAR DADOS">
                        </td>
                    </tr>
                </table>
            </center>
        </form>
    </body>
</html>