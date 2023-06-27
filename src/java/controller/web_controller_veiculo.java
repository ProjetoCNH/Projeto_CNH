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
import model.Veiculo;
import model.VeiculoDAO;

/**
 *
 * @author alunos
 */
@WebServlet(name = "web_controller_veiculo", urlPatterns = {"/web_controller_veiculo"})
public class web_controller_veiculo extends HttpServlet {

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
                Veiculo v = new Veiculo();
                v.setPlaca(request.getParameter("txtplaca"));
                v.setAno(request.getParameter("txtano"));
                v.setModelo(request.getParameter("txtmodelo"));
                v.setTipo(request.getParameter("txttipo"));
                v.setChassi(request.getParameter("txtchassi"));
                v.setCor(request.getParameter("txtcor"));
                v.setCrv(request.getParameter("txtcrv"));
                v.setCombustivel(request.getParameter("txtcombustivel"));
                v.setCategoria(request.getParameter("txtcategoria"));
                v.setCpf(request.getParameter("txtcpf"));
                VeiculoDAO vdao = new VeiculoDAO();
                try {
                    vdao.cadastrar(v);
                    message = "Cadastrado com sucesso!";
                    request.setAttribute("message", message);

                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("DELETAR")) {
                Veiculo v = new Veiculo();
                v.setRenavam(parseInt(request.getParameter("txtrenavam")));
                VeiculoDAO vdao = new VeiculoDAO();
                try {
                    vdao.delete(v);
                    message = "Deletado com Sucesso!";

                    request.setAttribute("message", message);

                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("ATUALIZAR")) {
                Veiculo v = new Veiculo();
                v.setRenavam(Integer.parseInt(request.getParameter("txtrenavam")));
                VeiculoDAO vdao = new VeiculoDAO();

                try {
                    v = vdao.select(v);

                    request.setAttribute("veiculo", v);

                    request.getRequestDispatcher("resultadoatualizarveiculo.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("ATUALIZAR DADOS")) {

                Veiculo v = new Veiculo();
                v.setRenavam(Integer.parseInt(request.getParameter("txtrenavam")));
                v.setPlaca(request.getParameter("txtplaca"));
                v.setAno(request.getParameter("txtano"));
                v.setModelo(request.getParameter("txtmodelo"));
                v.setTipo(request.getParameter("txttipo"));
                v.setChassi(request.getParameter("txtchassi"));
                v.setCor(request.getParameter("txtcor"));
                v.setCrv(request.getParameter("txtcrv"));
                v.setCombustivel(request.getParameter("txtcombustivel"));
                v.setCategoria(request.getParameter("txtcategoria"));
                v.setCpf(request.getParameter("txtcpf"));
                VeiculoDAO vdao = new VeiculoDAO();
                try {
                    vdao.update(v);
                    message = "Atualizado com Sucesso!";

                    request.setAttribute("message", message);

                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("CONSULTAR POR ID")) {
                Veiculo v = new Veiculo();
                v.setRenavam(parseInt(request.getParameter("txtrenavam")));
                VeiculoDAO vdao = new VeiculoDAO();

                try {
                    v = vdao.select(v);

                    request.setAttribute("veiculo", v);

                    request.getRequestDispatcher("resultadoconsultaveiculo.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("CONSULTAR TODOS")) {
                try {
                    VeiculoDAO vdao = new VeiculoDAO();
                    List<Veiculo> lveiculo = vdao.selectall();

                    request.setAttribute("lveiculo", lveiculo);

                    request.getRequestDispatcher("resultadoconsultatodosveiculo.jsp").forward(request, response);

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
