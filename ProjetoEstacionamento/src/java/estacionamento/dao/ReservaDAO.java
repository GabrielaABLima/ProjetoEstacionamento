/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamento.dao;

import estacionamento.entidades.Automovel;
import estacionamento.entidades.AutomovelType;
import estacionamento.entidades.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO extends DAO<Reserva>{
    public ReservaDAO() throws SQLException{
        super();
    }
    
    @Override
    public void salvar(Reserva obj) throws SQLException {
        String sql = "INSERT INTO reserva (estacionamento, data, cliente) " + "VALUES( ?, ?, ? );";
        
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getEstacionamento());
        stmt.setString(2, obj.getData());    
        stmt.setString(3, obj.getCliente());
        
        
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void alterar(Reserva obj) throws SQLException {
        String sql = "UPDATE reserva set estacionamento = ?, data = ?, cliente=? WHERE id = ?;";
        
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getEstacionamento());
        stmt.setString(2, obj.getData());    
        stmt.setString(3, obj.getCliente());
        stmt.setLong(4, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Reserva obj) throws SQLException {
        String sql = "DELETE FROM reserva WHERE id = ?;";
    
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setLong( 1, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Reserva> listarTodos() throws SQLException {   
       List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reserva;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {

            Reserva reserva = new Reserva();
            reserva.setId( rs.getLong( "id" ) );
            reserva.setEstacionamento(rs.getString( "estacionamento" ) );
            reserva.setCliente(rs.getString( "cliente" ));
            reserva.setData(rs.getString("data"));
            

            lista.add( reserva );
        }

        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public Reserva obterPorId(int id) throws SQLException {
        String sql = "SELECT * FROM reserva WHERE id=?;";
        
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        Reserva reserva = null;
        
        if ( rs.next() ) {

            reserva = new Reserva();
            reserva.setId( rs.getLong( "id" ) );
            reserva.setEstacionamento(rs.getString( "estacionamento" ) );
            reserva.setCliente(rs.getString( "cliente" ));
            reserva.setData(rs.getString("data"));

        }

        rs.close();
        stmt.close();
        return reserva;
    }
    
    public Reserva obterPorId(long id) throws SQLException {
        String sql = "SELECT * FROM reserva WHERE id=?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        
        Reserva reserva = null;
        
        if ( rs.next() ) {

            reserva = new Reserva();
            reserva.setId( rs.getLong( "id" ) );
            reserva.setEstacionamento(rs.getString( "estacionamento" ) );
            reserva.setCliente(rs.getString( "cliente" ));
            reserva.setData(rs.getString("data"));
        }

        rs.close();
        stmt.close();
        return reserva;
    }
    
    public List<Reserva> listarTodosPorCliente(String cliente) throws SQLException {   
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE cliente=?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString(1, cliente);
        ResultSet rs = stmt.executeQuery();
        Reserva reserva = null;
        while ( rs.next() ) {

            reserva = new Reserva();
            reserva.setId( rs.getLong( "id" ) );
            reserva.setEstacionamento(rs.getString( "estacionamento" ) );
            reserva.setCliente(rs.getString( "cliente" ));
            reserva.setData(rs.getString("data"));

            lista.add( reserva );
        }

        rs.close();
        stmt.close();
        
        return lista;
    }
    
    
}
