/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package estacionamento.controladores;

import estacionamento.dao.AutomovelDAO;
import estacionamento.dao.ClienteDAO;
import estacionamento.dao.ReservaDAO;
import estacionamento.entidades.Automovel;
import estacionamento.entidades.AutomovelType;
import estacionamento.entidades.Cliente;
import estacionamento.entidades.Reserva;
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
@WebServlet(name = "ReservaServlet", urlPatterns = {"/reserva"})
public class ReservaServlet extends HttpServlet {

    private ReservaDAO dao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("Entrou Servlet");
        RequestDispatcher dispatcher = null;
        String acao = request.getParameter("acao") != null ? request.getParameter("acao") : "null";

        switch (acao) {
            case "inserir":
                criar(request, response, dispatcher);
                break;
            case "deletar":
                deletar(request, response, dispatcher);
                break;
            case "atualizar":
                atualizar(request, response, dispatcher);
                break;
            case "preparar":
                preparar(request, response, dispatcher);
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
    
    private void criar(HttpServletRequest request, HttpServletResponse response,
            RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
         
        dao = new ReservaDAO();
        
        String cliente = request.getParameter("cliente");
        String estacionamento = request.getParameter("estacionamento");
        String data = request.getParameter("data");

        
        Reserva a = new Reserva();
        
        a.setCliente(cliente);
        a.setEstacionamento(estacionamento);
        a.setData(data);
        
        dao.salvar(a);

        
        dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }
    
    private void atualizar(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        dao = new ReservaDAO();
        long id = Long.valueOf(request.getParameter("id"));
        String cliente = request.getParameter("cliente");
        String estacionamento = request.getParameter("estacionamento");
        String data = request.getParameter("data");

        
        Reserva a = dao.obterPorId(id);
        
        a.setCliente(cliente);
        a.setEstacionamento(estacionamento);
        a.setData(data);

        dao.alterar(a);

        
        dispatcher = request.getRequestDispatcher(
                        "/src/pages/estacionamento.jsp" );
    }
    
    private void deletar(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        dao = new ReservaDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Reserva a = dao.obterPorId(id);
        dao.excluir(a);
        dispatcher = request.getRequestDispatcher("index.jsp");
    }

    private void preparar(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        dao = new ReservaDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Reserva a = dao.obterPorId(id);

        response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                Jsonb jb = JsonbBuilder.create();
                
        try ( PrintWriter out = response.getWriter() ) {
                    out.print( jb.toJson( a )  );
        }

        
        dispatcher = request.getRequestDispatcher("index.jsp");
    }
    
    private void listarTodos(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        dao = new ReservaDAO();
        List<Reserva> lista = dao.listarTodos();

        response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                Jsonb jb = JsonbBuilder.create();
                

        try ( PrintWriter out = response.getWriter() ) {
                    out.print( jb.toJson( lista )  );
        }

        
        dispatcher = request.getRequestDispatcher("index.jsp");
    }
    
    private void listarTodosPorCliente(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        ReservaDAO dao = new ReservaDAO();
        String cliente = request.getParameter("cliente");
        List<Reserva> lista = dao.listarTodosPorCliente(cliente);

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
            Logger.getLogger(ReservaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ReservaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
