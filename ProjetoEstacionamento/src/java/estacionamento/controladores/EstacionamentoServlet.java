/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package estacionamento.controladores;

import estacionamento.dao.AutomovelDAO;
import estacionamento.dao.ClienteDAO;
import estacionamento.dao.EstacionamentoDAO;
import estacionamento.entidades.Automovel;
import estacionamento.entidades.AutomovelType;
import estacionamento.entidades.Cliente;
import estacionamento.entidades.Estacionamento;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabi
 */
@WebServlet(name = "EstacionamentoServlet", urlPatterns = {"/estacionamento"})
public class EstacionamentoServlet extends HttpServlet {
    private EstacionamentoDAO dao;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("Entrou Servlet");
        RequestDispatcher dispatcher = null;
        String acao = request.getParameter("acao") != null ? request.getParameter("acao") : "null";

        switch (acao) {
            case "inserir":
                criarEstacionamento(request, response, dispatcher);
                break;
            case "deletar":
                deletarEstacionamento(request, response, dispatcher);
                break;
            case "atualizar":
                atualizarEstacionamento(request, response, dispatcher);
                break;
            case "preparar":
                prepararEstacionamento(request, response, dispatcher);
                break;
            case "listar":
                listarTodos(request, response, dispatcher);
                break;
            default:
                dispatcher = request.getRequestDispatcher("index.jsp");
                break;
        }
        if(dispatcher != null){
            dispatcher.forward(request, response);
        }
    }
    
    private void criarEstacionamento(HttpServletRequest request, HttpServletResponse response,
            RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        
        dao = new EstacionamentoDAO();
        
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String cnpj = request.getParameter("cnpj");
        int vagas = Integer.valueOf(request.getParameter("vagas"));
        
        Estacionamento e = new Estacionamento();
        
        e.setNome(nome);
        e.setEndereco(endereco);
        e.setCnpj(cnpj);
        e.setVagas(vagas);
        dao.salvar(e);

        
        dispatcher = request.getRequestDispatcher(
                        "/src/pages/estacionamento.jsp" );

    }
    
    private void atualizarEstacionamento(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        dao = new EstacionamentoDAO();
        long id = Long.valueOf(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String cnpj = request.getParameter("cnpj");
        int vagas = Integer.valueOf(request.getParameter("vagas"));
        
        Estacionamento e = new Estacionamento();
        e = dao.obterPorId(id);
        e.setNome(nome);
        e.setEndereco(endereco);
        e.setCnpj(cnpj);
        e.setVagas(vagas);
        dao.alterar(e);

        
        dispatcher = request.getRequestDispatcher(
                        "/src/pages/estacionamento.jsp" );
    }
    
    private void deletarEstacionamento(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        EstacionamentoDAO dao = new EstacionamentoDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Estacionamento a = new Estacionamento();
        a.setId(id);
        dao.excluir(a);
        dispatcher = request.getRequestDispatcher("index.jsp");
    }

    private void prepararEstacionamento(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        EstacionamentoDAO dao = new EstacionamentoDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Estacionamento a = dao.obterPorId(id);

        response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                Jsonb jb = JsonbBuilder.create();
                

        try ( PrintWriter out = response.getWriter() ) {
                    out.print( jb.toJson( a )  );
        }

        
        dispatcher = request.getRequestDispatcher("index.jsp");
    }

    private void listarTodos(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        EstacionamentoDAO dao = new EstacionamentoDAO();
        List<Estacionamento> lista = dao.listarTodos();
        response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                Jsonb jb = JsonbBuilder.create();
                

        try ( PrintWriter out = response.getWriter() ) {
                    out.print( jb.toJson( lista )  );
        }

        
        dispatcher = request.getRequestDispatcher("index.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EstacionamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EstacionamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
