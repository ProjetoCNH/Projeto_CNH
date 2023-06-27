/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Multa;
import model.MultaDAO;

/**
 *
 * @author alunos
 */
@WebServlet(name = "web_controller_multa", urlPatterns = {"/web_controller_multa"})
public class web_controller_multa extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String op = request.getParameter("btnoperacao");

            String message = "Operação não realizada.";

            if (op.equals("CADASTRAR")) {
                Multa m = new Multa();
                m.setRenavam(Integer.parseInt(request.getParameter("txtrenavam")));
                m.setNumRegistro(Integer.parseInt(request.getParameter("txtnumregistro")));
                m.setDataInfracao(request.getParameter("txtdtinfracao"));
                m.setLocalMulta(request.getParameter("txtlocalmulta"));
                m.setNumIdentificacaoAgente(Integer.parseInt(request.getParameter("txtnumidentificacaoagente")));
                m.setPontosHabilitacao(Integer.parseInt(request.getParameter("txtpontoshabilitacao")));
                m.setValorMulta(Double.parseDouble(request.getParameter("txtvalormulta")));
                m.setClassificacaoMulta(request.getParameter("txtclassificacaomulta"));
                m.setDtVencimento(request.getParameter("txtvencimentomulta"));
                m.setCpf(request.getParameter("txtcpf"));
                
                MultaDAO mdao = new MultaDAO();
                try {
                    mdao.cadastrar(m);
                    message = "Cadastrado com sucesso!";
                    request.setAttribute("message", message);
                    
                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("DELETAR")) {
                Multa m = new Multa();
                m.setCodInfra(Integer.parseInt(request.getParameter("txtcodinfra")));
                MultaDAO mdao = new MultaDAO();
                try {
                    mdao.delete(m);
                    message = "Deletado com Sucesso!";
                    
                    request.setAttribute("message", message);
                    
                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);


                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            }  else if (op.equals("ATUALIZAR")) {
                Multa m = new Multa();
                m.setCodInfra(Integer.parseInt(request.getParameter("txtcodinfra")));
                MultaDAO mdao = new MultaDAO();

                try {
                    m = mdao.select(m);

                    request.setAttribute("multa", m);

                    request.getRequestDispatcher("resultadoatualizar1.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            }
            else if (op.equals("ATUALIZAR DADOS")) {

                Multa m = new Multa();

                m.setCodInfra(Integer.parseInt(request.getParameter("txtcodinfra")));
                m.setRenavam(Integer.parseInt(request.getParameter("txtrenavam")));
                m.setNumRegistro(Integer.parseInt(request.getParameter("txtnumregistro")));
                m.setDataInfracao(request.getParameter("txtdtinfracao"));
                m.setLocalMulta(request.getParameter("txtlocalmulta"));
                m.setNumIdentificacaoAgente(Integer.parseInt(request.getParameter("txtnumidentificacaoagente")));
                m.setPontosHabilitacao(Integer.parseInt(request.getParameter("txtpontoshabilitacao")));
                m.setValorMulta(Integer.parseInt(request.getParameter("txtvalormulta")));
                m.setClassificacaoMulta(request.getParameter("txtclassificacaomulta"));
                m.setDtVencimento(request.getParameter("txtvencimentomulta"));
                m.setCpf(request.getParameter("txtcpf"));
                
                MultaDAO mdao = new MultaDAO();
                try {
                    mdao.update(m);
                    message = "Atualizado com Sucesso!";
                    
                    request.setAttribute("message", message);
                    
                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("CONSULTAR POR ID")) {
                Multa m = new Multa();
                m.setCodInfra(Integer.parseInt(request.getParameter("txtcodinfra")));
                MultaDAO mdao = new MultaDAO();

                try {
                    m = mdao.select(m);

                    request.setAttribute("multa", m);

                    request.getRequestDispatcher("resultadoconsulta.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("CONSULTAR TODOS")) {
                try {
                    MultaDAO mdao = new MultaDAO();
                    List<Multa> lmu = mdao.selectall();

                    request.setAttribute("lmu", lmu);

                    request.getRequestDispatcher("resultadoconsultatodos.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
