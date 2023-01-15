package estacionamento.controladores;

import estacionamento.dao.ClienteDAO;
import estacionamento.dao.UsuarioDAO;
import estacionamento.entidades.Cliente;
import estacionamento.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuario"})
public class UsuarioServlet extends HttpServlet {
    private UsuarioDAO dao;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {


        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher dispatcher = null;
        String acao = request.getParameter("acao") != null ? request.getParameter("acao") : "null";

        switch (acao) {
            case "inserir":  
                criarUsuario(request, response, dispatcher);
                break;
            case "deletar":
                deletarUsuario(request, response, dispatcher);
                break;
            case "atualizar":
                atualizarUsuario(request, response, dispatcher);
                break;
            case "preparar":
                prepararUsuario(request, response, dispatcher);
                break;
            case "listar":
                listar(request, response, dispatcher);
            default:
                dispatcher = request.getRequestDispatcher("index.jsp");
                break;
        }
        if(dispatcher != null){
            dispatcher.forward(request, response);
        }
    
    }
    private void criarUsuario(HttpServletRequest request, HttpServletResponse response,
            RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
         
        dao = new UsuarioDAO();
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Usuario c = new Usuario();
        c.setLogin(login);
        c.setSenha(senha);
        dao.salvar(c);

        Usuario usuario = dao.obterPorLoginSenha(login, senha);
        response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                Jsonb jb = JsonbBuilder.create();
                

        try ( PrintWriter out = response.getWriter() ) {
                    out.print( jb.toJson( usuario )  );
        }

        
        dispatcher = request.getRequestDispatcher("index.jsp");
        //dispatcher.forward(request, response);

    }
    
    private void atualizarUsuario(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException {
        
        
        dispatcher = request.getRequestDispatcher("pages/HealthProfessionals/Teams.jsp");
        dispatcher.forward(request, response);
    }
    
    private void deletarUsuario(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException {

    }

    private void prepararUsuario(HttpServletRequest request, HttpServletResponse response, RequestDispatcher dispatcher) throws ServletException, IOException {
        
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
    
    private void listar(HttpServletRequest request, HttpServletResponse response,
            RequestDispatcher dispatcher) throws ServletException, IOException, SQLException {
        dao = new UsuarioDAO();
        ClienteDAO daoC = new ClienteDAO();
        Cliente cliente = null;
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        int idUsuario;
        String result;

        Usuario c = new Usuario();
        try{
           idUsuario = dao.obterPorLoginSenha(login, senha).getID(); 
           cliente = daoC.obterPorIDUsuario(idUsuario);
           result = String.valueOf(cliente.getId());
        }catch(Exception ex){
           result = "0";
        }
        
        
        
        
        
        
        response.setContentType("text/html;charset=UTF-8");
                

        try ( PrintWriter out = response.getWriter() ) {
                    out.print( result );
                }
        //System.out.println(cliente);
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
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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