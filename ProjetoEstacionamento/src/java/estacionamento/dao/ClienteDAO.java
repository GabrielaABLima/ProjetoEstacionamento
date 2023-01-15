/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamento.dao;

import estacionamento.entidades.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabi
 */
public class ClienteDAO extends DAO<Cliente> {
    public ClienteDAO() throws SQLException {
        super();
    }

    @Override
    public void salvar(Cliente obj) throws SQLException {
        String sql = "INSERT INTO cliente ( nome, cartaMotorista, usuario_id ) " + "VALUES( ?, ?, ? );";
        
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getNome() );
        stmt.setInt( 2, obj.getCartaMotorista());    
        stmt.setInt(3, obj.getID());
        
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void alterar(Cliente obj) throws SQLException {
        String sql = "UPDATE cliente set nome = ?, cartaMotorista = ?, usuario_id=? WHERE id = ?;";
        
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getNome() );
        stmt.setInt( 2, obj.getCartaMotorista());
        stmt.setInt(3, obj.getID());
        stmt.setInt(4, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Cliente obj) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id = ?;";
    
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt( 1, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Cliente> listarTodos() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {

            Cliente cliente = new Cliente();
            cliente.setId( rs.getInt( "id" ) );
            cliente.setNome( rs.getString( "nome" ) );
            cliente.setCartaMotorista(Integer.parseInt(rs.getString( "cartaMotorista" )));
            cliente.setID(rs.getInt("usuario_id"));
            //cliente.setAutomovel(rs.getInt("automovel_id"));
            //cliente.setAutomovel(rs.get);

            lista.add( cliente );
        }

        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public Cliente obterPorId(int id) throws SQLException {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt( 1, id );
        
        ResultSet rs = stmt.executeQuery();
        
        if ( rs.next() ) {
            cliente = new Cliente();
            cliente.setId( rs.getInt( "id" ) );
            cliente.setNome( rs.getString( "nome" ) );
            cliente.setCartaMotorista(Integer.parseInt(rs.getString( "cartaMotorista" )));
            cliente.setID(rs.getInt("usuario_id"));
            //cliente.setAutomovel(rs.get);
        }

        rs.close();
        stmt.close();
        
        return cliente;
    }
    
    public Cliente obterPorIDUsuario(int id) throws SQLException{
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE usuario_id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt( 1, id );
        
        ResultSet rs = stmt.executeQuery();
        
        if ( rs.next() ) {
            cliente = new Cliente();
            cliente.setId( rs.getInt( "id" ) );
            cliente.setNome( rs.getString( "nome" ) );
            cliente.setCartaMotorista(Integer.parseInt(rs.getString( "cartaMotorista" )));
            cliente.setID(rs.getInt("usuario_id"));
            //cliente.setAutomovel(rs.get);
        }

        rs.close();
        stmt.close();
        System.out.println(cliente.toString());
        return cliente;
    }
    
}
