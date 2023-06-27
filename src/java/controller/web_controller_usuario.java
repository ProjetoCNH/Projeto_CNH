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
import model.Usuario;
import model.UsuarioDAO;

/**
 *
 * @author alunos
 */
@WebServlet(name = "web_controller_usuario", urlPatterns = {"/web_controller_usuario"})
public class web_controller_usuario extends HttpServlet {

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
                Usuario u = new Usuario();
                u.setDtNascimento(request.getParameter("txtdtnasc"));
                u.setCpf(request.getParameter("txtcpf"));
                u.setEndereco(request.getParameter("txtendereco"));
                u.setNome(request.getParameter("txtnome"));
                u.setFiliacao(request.getParameter("txtfiliacao"));
                u.setTelefone(request.getParameter("txttel"));
                UsuarioDAO udao = new UsuarioDAO();
                try {
                    udao.cadastrar(u);
                    message = "Cadastrado com sucesso!";
                    request.setAttribute("message", message);
                    
                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("DELETAR")) {
                Usuario u = new Usuario();
                u.setCpf(request.getParameter("txtcpf"));
                UsuarioDAO udao = new UsuarioDAO();
                try {
                    udao.delete(u);
                    message = "Deletado com Sucesso!";
                    
                    request.setAttribute("message", message);
                    
                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);


                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            }  else if (op.equals("ATUALIZAR")) {
                Usuario u = new Usuario();
                u.setCpf(request.getParameter("txtcpf"));
                UsuarioDAO udao = new UsuarioDAO();

                try {
                    u = udao.select(u);

                    request.setAttribute("usuario", u);

                    request.getRequestDispatcher("resultadoatualizarusuario.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            }
            else if (op.equals("ATUALIZAR DADOS")) {

                Usuario u = new Usuario();

                u.setCpf(request.getParameter("txtcpf"));
                u.setNome(request.getParameter("txtnome"));
                u.setDtNascimento(request.getParameter("txtdtnasc"));
                u.setFiliacao(request.getParameter("txtfiliacao"));
                u.setTelefone(request.getParameter("txttel"));
                u.setEndereco(request.getParameter("txtendereco"));
                
                UsuarioDAO udao = new UsuarioDAO();
                try {
                    udao.update(u);
                    message = "Atualizado com Sucesso!";
                    
                    request.setAttribute("message", message);
                    
                    request.getRequestDispatcher("resultadogeral.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("CONSULTAR POR ID")) {
                Usuario u = new Usuario();
                u.setCpf(request.getParameter("txtcpf"));
                UsuarioDAO udao = new UsuarioDAO();

                try {
                    u = udao.select(u);

                    request.setAttribute("usuario", u);

                    request.getRequestDispatcher("resultadoconsultausuario.jsp").forward(request, response);

                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("CONSULTAR TODOS")) {
                try {
                    UsuarioDAO udao = new UsuarioDAO();
                    List<Usuario> lu = udao.selectall();

                    request.setAttribute("lu", lu);

                    request.getRequestDispatcher("resultadoconsultatodosusuario.jsp").forward(request, response);

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
