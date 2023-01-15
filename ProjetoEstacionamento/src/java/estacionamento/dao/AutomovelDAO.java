package estacionamento.dao;

import estacionamento.entidades.Automovel;
import estacionamento.entidades.AutomovelType;
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
public class AutomovelDAO extends DAO<Automovel>{

    public AutomovelDAO() throws SQLException{
        super();
    }
    
    @Override
    public void salvar(Automovel obj) throws SQLException {
        String sql = "INSERT INTO automovel (placa, estacionado, cliente_id, tipo) " + "VALUES( ?, ?, ?, ? );";
        
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getPlaca() );
        stmt.setBoolean(2, obj.isEstacionado());    
        stmt.setInt(3, obj.getCliente().getId());
        stmt.setString(4, obj.getTipo().name());
        
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void alterar(Automovel obj) throws SQLException {
        String sql = "UPDATE automovel set placa = ?, estacionado = ?, ciente_id=?, tipo=? WHERE id = ?;";
        
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getPlaca() );
        stmt.setBoolean(2, obj.isEstacionado());    
        stmt.setInt(3, obj.getCliente().getId());
        stmt.setString(4, obj.getTipo().name());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Automovel obj) throws SQLException {
        String sql = "DELETE FROM automovel WHERE id = ?;";
    
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setLong( 1, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Automovel> listarTodos() throws SQLException {   
       List<Automovel> lista = new ArrayList<>();
        String sql = "SELECT * FROM automovel;";
        ClienteDAO daoC = new ClienteDAO();
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {

            Automovel automovel = new Automovel();
            automovel.setId( rs.getInt( "id" ) );
            automovel.setPlaca( rs.getString( "placa" ) );
            automovel.setEstacionado(Boolean.parseBoolean(rs.getString( "estacionado" )));
            try{
                automovel.setCliente(daoC.obterPorId(rs.getInt("cliente_id")));
            }catch(Exception ex){
                System.out.println(ex);
            }
            automovel.setTipo(AutomovelType.valueOf(rs.getString("tipo")));
            System.out.println(automovel);
            //cliente.setAutomovel(rs.getInt("automovel_id"));
            //cliente.setAutomovel(rs.get);

            lista.add( automovel );
        }

        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public Automovel obterPorId(int id) throws SQLException {
        String sql = "SELECT * FROM automovel WHERE id=?;";
        ClienteDAO daoC = new ClienteDAO();
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        Automovel automovel = null;
        
        if ( rs.next() ) {

            automovel = new Automovel();
            automovel.setId( rs.getInt( "id" ) );
            automovel.setPlaca( rs.getString( "placa" ) );
            automovel.setEstacionado(Boolean.parseBoolean(rs.getString( "estacionado" )));
            try{
                automovel.setCliente(daoC.obterPorId(rs.getInt("cliente_id")));
            }catch(Exception ex){
                System.out.println(ex);
            }
            automovel.setTipo(AutomovelType.valueOf(rs.getString("tipo")));
            
            //cliente.setAutomovel(rs.getInt("automovel_id"));
            //cliente.setAutomovel(rs.get);
        }

        rs.close();
        stmt.close();
        return automovel;
    }
    
    public Automovel obterPorId(long id) throws SQLException {
        String sql = "SELECT * FROM automovel WHERE id=?;";
        ClienteDAO daoC = new ClienteDAO();
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        
        Automovel automovel = null;
        
        if ( rs.next() ) {

            automovel = new Automovel();
            automovel.setId( rs.getInt( "id" ) );
            automovel.setPlaca( rs.getString( "placa" ) );
            automovel.setEstacionado(Boolean.parseBoolean(rs.getString( "estacionado" )));
            try{
                automovel.setCliente(daoC.obterPorId(rs.getInt("cliente_id")));
            }catch(Exception ex){
                System.out.println(ex);
            }
            automovel.setTipo(AutomovelType.valueOf(rs.getString("tipo")));
            
            //cliente.setAutomovel(rs.getInt("automovel_id"));
            //cliente.setAutomovel(rs.get);
        }

        rs.close();
        stmt.close();
        return automovel;
    }
    
    public List<Automovel> listarTodosPorId(int idCliente) throws SQLException {   
       List<Automovel> lista = new ArrayList<>();
        String sql = "SELECT * FROM automovel WHERE cliente_id=?;";
        ClienteDAO daoC = new ClienteDAO();
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt(1, idCliente);
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {

            Automovel automovel = new Automovel();
            automovel.setId( rs.getInt( "id" ) );
            automovel.setPlaca( rs.getString( "placa" ) );
            if(Integer.parseInt(rs.getString("estacionado"))!=0){
                automovel.setEstacionado(true);
            }else{
                automovel.setEstacionado(false);
            }

            try{
                automovel.setCliente(daoC.obterPorId(rs.getInt("cliente_id")));
            }catch(Exception ex){
                System.out.println(ex);
            }
            automovel.setTipo(AutomovelType.valueOf(rs.getString("tipo")));
            System.out.println(automovel);
            //cliente.setAutomovel(rs.getInt("automovel_id"));
            //cliente.setAutomovel(rs.get);

            lista.add( automovel );
        }

        rs.close();
        stmt.close();
        
        return lista;
    }
    
}
