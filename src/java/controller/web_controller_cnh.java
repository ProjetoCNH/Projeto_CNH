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
import model.CNH;
import model.CNHDAO;

/**
 *
 * @author alunos
 */
@WebServlet(name = "web_controller_cnh", urlPatterns = {"/web_controller_cnh"})
public class web_controller_cnh extends HttpServlet {

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
                CNH c = new CNH();
                c.setValidade(request.getParameter("txtvalidade"));
                c.setDtEmissao(request.getParameter("txtdtemissao"));
                c.setCpf(request.getParameter("txtcpf"));
                c.setCategoria(request.getParameter("txtcategoria"));
                c.setNomeAutoescola(request.getParameter("txtnomeautoescola"));
                c.setOrgEmissor(request.getParameter("txtorgemissor"));
                c.setPontosCarteira(Integer.parseInt(request.getParameter("txtpontoscarteira")));
                CNHDAO cdao = new CNHDAO();
                try {
                    cdao.cadastrar(c);
                    message = "Cadastrado com sucesso!";
                    request.setAttribute("message", message);
                    
                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("DELETAR")) {
                CNH c = new CNH();
                c.setNumregistro(parseInt(request.getParameter("txtnumregistro")));
                CNHDAO cdao = new CNHDAO();
                try {
                    cdao.delete(c);
                    message = "Deletado com Sucesso!";
                    
                    request.setAttribute("message", message);
                    
                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);


                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            }  else if (op.equals("ATUALIZAR")) {
                CNH c = new CNH();
                c.setNumregistro(Integer.parseInt(request.getParameter("txtnumregistro")));
                CNHDAO cdao = new CNHDAO();

                try {
                    c = cdao.select(c);

                    request.setAttribute("cnh", c);

                    request.getRequestDispatcher("resultadoatualizarcnh.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            }
            else if (op.equals("ATUALIZAR DADOS")) {

                CNH c = new CNH();

                c.setNumregistro(Integer.parseInt(request.getParameter("txtnumregistro")));
                c.setValidade(request.getParameter("txtvalidade"));
                c.setDtEmissao(request.getParameter("txtdtemissao"));
                c.setCpf(request.getParameter("txtcpf"));
                c.setCategoria(request.getParameter("txtcategoria"));
                c.setNomeAutoescola(request.getParameter("txtnomeautoescola"));
                c.setOrgEmissor(request.getParameter("txtorgemissor"));
                c.setPontosCarteira(Integer.parseInt(request.getParameter("txtpontoscarteira")));
                CNHDAO cdao = new CNHDAO();
                try {
                    cdao.update(c);
                    message = "Atualizado com Sucesso!";
                    
                    request.setAttribute("message", message);
                    
                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("CONSULTAR POR ID")) {
                CNH c = new CNH();
                c.setNumregistro(Integer.parseInt(request.getParameter("txtnumregistro")));
                CNHDAO cdao = new CNHDAO();

                try {
                    c = cdao.select(c);

                    request.setAttribute("cnh", c);

                    request.getRequestDispatcher("resultadoconsultacnh.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("CONSULTAR TODOS")) {
                try {
                    CNHDAO cdao = new CNHDAO();
                    List<CNH> lcnh = cdao.selectall();

                    request.setAttribute("lcnh", lcnh);

                    request.getRequestDispatcher("resultadoconsultatodoscnh.jsp").forward(request, response);

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
