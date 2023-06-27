<%-- 
    Document   : resultadoatualizarveiculo
    Created on : 30/05/2023, 20:22:40
    Author     : alunos
--%>
<%@page import="model.Multa"%>
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

        <%Multa multa = (Multa) request.getAttribute("multa");%>
        <form name="formatualizarmulta" action="web_controller_multa" method="post" >
            <br><br>
            <center>
                <table>
                    <tr>
                        <th>
                            Atualizar Multa
                        </th>
                    </tr>
                    <tr> 
                        <td>
                            Código da Infração: <input type ="number" name="txtcodinfra"readonly value="<% out.print(multa.getCodInfra());%>"><BR>
                            Renavam: <input type ="number" name="txtrenavam"readonly value="<% out.print(multa.getRenavam());%>"><BR>
                            Número de registro: <input type = "number" name ="txtnumregistro"value="<% out.print(multa.getNumRegistro()); %>"><BR>
                            Data infração: <input type = "date" name ="txtdtinfracao"value="<% out.print(multa.getDataInfracao()); %>"><BR>
                            Local da Multa: <input type ="text" name="txtlocalmulta"value="<% out.print(multa.getLocalMulta()); %>"><BR>
                            Número de identificação de agente: <input type ="number" name="txtnumidentificacaoagente"value="<% out.print(multa.getNumIdentificacaoAgente()); %>"><BR>
                            Pontos habilitação: <input type ="number" name="txtpontoshabilitacao"value="<% out.print(multa.getPontosHabilitacao()); %>"><BR>
                            Valor da Multa: <input type ="number" name="txtvalormulta" step="0.01" value="<% out.print(multa.getValorMulta()); %>"><BR>
                            Classificação da Multa: <input type ="text" name="txtclassificacaomulta"value="<% out.print(multa.getClassificacaoMulta()); %>"><BR>
                            Vencimento da Multa: <input type ="date" name="txtvencimentomulta"value="<% out.print(multa.getDtVencimento()); %>"><BR>
                            CPF: <input type ="text" name="txtcpf"value="<% out.print(multa.getCpf());%>"><BR><BR>
                            <input type="submit" name="btnoperacao"  class="button" value="ATUALIZAR DADOS">
                        </td>
                    </tr>
                </table>
            </center>
        </form>
    </body>
</html>