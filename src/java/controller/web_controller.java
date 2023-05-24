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
import model.Produto;
import model.ProdutoDAO;

/**
 *
 * @author alunos
 */
@WebServlet(name = "web_controller", urlPatterns = {"/web_controller"})
public class web_controller extends HttpServlet {

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
                Produto p = new Produto();
                p.setDescricao(request.getParameter("txtdescricao"));
                p.setPreco(Double.parseDouble(request.getParameter("txtpreco")));
                p.setCor(request.getParameter("txtcor"));
                p.setQuantidade(Integer.parseInt(request.getParameter("txtquantidade")));
                p.setNomeFornecedor(request.getParameter("txtnomeFornecedor"));
                p.setNParcelas(Integer.parseInt(request.getParameter("txtnParcelas")));
                p.setMarca(request.getParameter("txtmarca"));
                ProdutoDAO pdao = new ProdutoDAO();
                try {
                    pdao.cadastrar(p);
                    message = "Cadastrado com sucesso!";
                    request.setAttribute("message", message);
                    
                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("DELETAR")) {
                Produto pd = new Produto();
                pd.setId(parseInt(request.getParameter("txtid")));
                ProdutoDAO pddao = new ProdutoDAO();
                try {
                    pddao.delete(pd);
                    message = "Deletado com Sucesso!";
                    
                    request.setAttribute("message", message);
                    
                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);


                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            }  else if (op.equals("ATUALIZAR")) {
                Produto pr = new Produto();
                pr.setId(parseInt(request.getParameter("txtid")));
                ProdutoDAO prdao = new ProdutoDAO();

                try {
                    pr = prdao.select(pr);

                    request.setAttribute("produto", pr);

                    request.getRequestDispatcher("resultadoatualizar1.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            }
            else if (op.equals("ATUALIZAR DADOS")) {

                Produto pu = new Produto();

                pu.setDescricao(request.getParameter("txtdescricao"));
                pu.setPreco(Double.parseDouble(request.getParameter("txtpreco")));
                pu.setId(parseInt(request.getParameter("txtid")));
                pu.setCor(request.getParameter("txtcor"));
                pu.setQuantidade(Integer.parseInt(request.getParameter("txtquantidade")));
                pu.setNomeFornecedor(request.getParameter("txtnomeFornecedor"));
                pu.setNParcelas(Integer.parseInt(request.getParameter("txtnParcelas")));
                pu.setMarca(request.getParameter("txtmarca"));
                ProdutoDAO pudao = new ProdutoDAO();
                try {
                    pudao.update(pu);
                    message = "Atualizado com Sucesso!";
                    
                    request.setAttribute("message", message);
                    
                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("CONSULTAR POR ID")) {
                Produto pr = new Produto();
                pr.setId(parseInt(request.getParameter("txtid")));
                ProdutoDAO prdao = new ProdutoDAO();

                try {
                    pr = prdao.select(pr);

                    request.setAttribute("produto", pr);

                    request.getRequestDispatcher("resultadoconsulta.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("CONSULTAR TODOS")) {
                try {
                    ProdutoDAO pctdao = new ProdutoDAO();
                    List<Produto> lpc = pctdao.selectall();

                    request.setAttribute("lpc", lpc);

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
