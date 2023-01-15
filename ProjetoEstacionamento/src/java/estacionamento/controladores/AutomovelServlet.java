/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package estacionamento.controladores;

import estacionamento.dao.AutomovelDAO;
import estacionamento.dao.ClienteDAO;
import estacionamento.dao.EstacionamentoDAO;
import estacionamento.dao.UsuarioDAO;
import estacionamento.entidades.Automovel;
import estacionamento.entidades.AutomovelType;
import estacionamento.entidades.Cliente;
import estacionamento.entidades.Estacionamento;
import estacionamento.entidades.Usuario;
import estacionamento.servicos.ClienteService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
@WebServlet(name = "AutomovelServlet", urlPatterns = {"/automovel"})
public class AutomovelServlet extends HttpServlet {
    private AutomovelDAO dao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("Entrou Servlet");
        RequestDispatcher dispatcher = null;
        String acao = request.getParameter("acao") != null ? request.getParameter("acao") : "null";

        switch (acao) {
            case "inserir":
                criarAutomovel(request, response, dispatcher);
                break;
            case "deletar":
                deletarAutomovel(request, response, dispatcher);
                break;
            case "atualizar":
                atualizarAutomovel(request, response, dispatcher);
                break;
            case "preparar":
                prepararAutomovel(request, response, dispatcher);
                break;
            case "listar":
                listarTodosPorCliente(request, response, dispatcher);
                break;
            default:
                dispatcher = request.getRequestDispatcher("index.jsp");
                break;
        }
        if(dispatcher != null){
            dispatcher.forward(request, response);
        }
    }
    
    private void criarAutomovel(HttpServletRequest request, HttpServletResponse response,
            RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
         
        dao = new AutomovelDAO();
        ClienteDAO daoC = new ClienteDAO();
        
        String placa = request.getParameter("placa");
        Boolean estacionado = Boolean.valueOf(request.getParameter("estacionado"));
        AutomovelType tipo = AutomovelType.valueOf(request.getParameter("tipo"));
        Cliente c = daoC.obterPorId(Integer.parseInt(request.getParameter("idCliente")));
        
        Automovel a = new Automovel();
        
        a.setPlaca(placa);
        a.setEstacionado(estacionado);
        a.setTipo(tipo);
        a.setCliente(c);
        System.out.println(request.getParameter("estacionado"));
        System.out.println(a.isEstacionado());
        dao.salvar(a);

        
        dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }
    
    private void atualizarAutomovel(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        dao = new AutomovelDAO();
        long id = Long.valueOf(request.getParameter("id"));
        System.out.println(id);
        String placa = request.getParameter("placa");
        System.out.println(placa);
        Boolean estacionado = Boolean.valueOf(request.getParameter("estacionado"));
        AutomovelType tipo = AutomovelType.valueOf(request.getParameter("tipo"));
        
        
        Automovel e = dao.obterPorId(id);
        e.setPlaca(placa);
        e.setEstacionado(estacionado);
        e.setTipo(tipo);
        dao.alterar(e);

        
        dispatcher = request.getRequestDispatcher(
                        "/src/pages/estacionamento.jsp" );
    }
    
    private void deletarAutomovel(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        AutomovelDAO dao = new AutomovelDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Automovel a = new Automovel();
        a.setId(id);
        dao.excluir(a);
        dispatcher = request.getRequestDispatcher("index.jsp");
    }

    private void prepararAutomovel(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        AutomovelDAO dao = new AutomovelDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Automovel a = dao.obterPorId(id);

        response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                Jsonb jb = JsonbBuilder.create();
                
        System.out.println(a.getPlaca());
        try ( PrintWriter out = response.getWriter() ) {
                    out.print( jb.toJson( a )  );
        }

        
        dispatcher = request.getRequestDispatcher("index.jsp");
    }
    
    private void listarTodosPorCliente(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        AutomovelDAO dao = new AutomovelDAO();
        int id = Integer.parseInt(request.getParameter("idCliente"));
        List<Automovel> lista = dao.listarTodosPorId(id);

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
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
