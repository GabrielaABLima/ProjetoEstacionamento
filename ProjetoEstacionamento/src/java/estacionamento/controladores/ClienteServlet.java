/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package estacionamento.controladores;

import estacionamento.dao.ClienteDAO;
import estacionamento.dao.UsuarioDAO;
import estacionamento.entidades.Automovel;
import estacionamento.entidades.Cliente;
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
@WebServlet(name = "ClienteServlet", urlPatterns = {"/cliente"})
public class ClienteServlet extends HttpServlet {
    private ClienteDAO dao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("Entrou Servlet");
        RequestDispatcher dispatcher = null;
        String acao = request.getParameter("acao") != null ? request.getParameter("acao") : "null";

        switch (acao) {
            case "inserir":
                System.out.println("Entrou switch inserir");
                criarCliente(request, response, dispatcher);
                break;
            case "deletar":
                deletarCliente(request, response, dispatcher);
                break;
            case "atualizar":
                atualizarCliente(request, response, dispatcher);
                break;
            case "preparar":
                prepararCliente(request, response, dispatcher);
                break;
            case "logar":
                logarCliente(request, response, dispatcher);
            default:
                dispatcher = request.getRequestDispatcher("index.jsp");
                break;
        }
        if(dispatcher != null){
            dispatcher.forward(request, response);
        }
    }
    
    private void criarCliente(HttpServletRequest request, HttpServletResponse response,
            RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
         
        dao = new ClienteDAO();
        System.out.println("Entrou funcaio criarCliente");
        
        String nome = request.getParameter("nome");
        int cartaMotorista = 0;
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        try{
            cartaMotorista = Integer.parseInt(request.getParameter("cartaMotorista"));
            
        }catch(Exception e){
            
        }
        System.out.println(cartaMotorista);
        System.out.println(idUsuario);
        
        Cliente c = new Cliente();
        
        c.setNome(nome);
        c.setCartaMotorista(cartaMotorista);
        c.setID(idUsuario);
        dao.salvar(c);
        System.out.println(c.toString());
        
        dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }
    
    private void atualizarCliente(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException {
        
        
        dispatcher = request.getRequestDispatcher("pages/HealthProfessionals/Teams.jsp");
        dispatcher.forward(request, response);
    }
    
    private void deletarCliente(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException {

    }

    private void prepararCliente(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException {
        
        /*
        Jsonb jb = JsonbBuilder.create();
        
        //teamsService = new TeamsService();
        long id = Long.parseLong(request.getParameter( "id" ));
        //ultimoId = id;
        //Teams team = teamsService.findById( id );
        //team.setColaborators(null);
        if(team != null){
            
            System.out.println(team.getLider());
            PrintWriter out = response.getWriter();  
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            System.out.println(jb.toJson(team));
            out.print( jb.toJson(team) );
        }*/

                //return team;
    }

    private void logarCliente(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        dao = new ClienteDAO();
        System.out.println("Entrou logar Cliente");
        Cliente cliente = dao.obterPorIDUsuario(Integer.parseInt(request.getParameter("idUsuario")));
        
        response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                Jsonb jb = JsonbBuilder.create();
                

        try ( PrintWriter out = response.getWriter() ) {
                    out.print( jb.toJson( cliente )  );
                }
        System.out.println(cliente);
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
