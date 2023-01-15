/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamento.dao;


import estacionamento.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabi
 */
public class UsuarioDAO extends DAO<Usuario>{
    public UsuarioDAO() throws SQLException {
        super();
    }

    @Override
    public void salvar(Usuario obj) throws SQLException {
        String sql = "INSERT INTO usuario ( login, senha) " + "VALUES( ?, ? );";
        
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getLogin() );
        stmt.setString( 2, obj.getSenha());
        
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void alterar(Usuario obj) throws SQLException {
        String sql = "UPDATE usuario set login = ?, senha = ? WHERE id = ?;";
        
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getLogin() );
        stmt.setString( 2, obj.getSenha());
        stmt.setInt(3, obj.getID());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Usuario obj) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ?;";
    
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt( 1, obj.getID() );
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Usuario> listarTodos() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {

            Usuario usuario = new Usuario();
            usuario.setID( rs.getInt( "id" ) );
            usuario.setLogin( rs.getString( "login" ) );
            usuario.setSenha(rs.getString( "senha" ));
            //cliente.setAutomovel(rs.get);

            lista.add( usuario );
        }

        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public Usuario obterPorId(int id) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt( 1, id );
        
        ResultSet rs = stmt.executeQuery();
        
        if ( rs.next() ) {
            usuario = new Usuario();
            usuario.setID( rs.getInt( "id" ) );
            usuario.setLogin( rs.getString( "login" ) );
            usuario.setSenha(rs.getString("senha"));
        }

        rs.close();
        stmt.close();
        
        return usuario;
    }
    
    public Usuario obterPorLoginSenha(String login, String senha) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE login=? AND senha=?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, login );
        stmt.setString(2, senha);
        
        ResultSet rs = stmt.executeQuery();
        
        if ( rs.next() ) {
            usuario = new Usuario();
            usuario.setID( rs.getInt( "id" ) );
            usuario.setLogin( rs.getString( "login" ) );
            usuario.setSenha(rs.getString("senha"));
        }

        rs.close();
        stmt.close();
        
        return usuario;
    }
    
    
}
